package com.noriteo.delinori.member.controller;

import com.noriteo.delinori.member.dto.UploadResponseDTO;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@Log4j2
public class UploadController {

    @GetMapping("/upload")
    public void uploadGET(){
    }

    @ResponseBody//메소드 리턴 타입이 JSON으로 처리
    @PostMapping("/upload")
    public List<UploadResponseDTO> uploadPost(MultipartFile[] uploadFiles) throws Exception {
        //upload.jsp에 쓴 uploadFiles로 해야 파일을 받아옴
        log.info("--------");

//        Arrays.stream(uploadFiles).forEach(multipartFile -> {
//            log.info(multipartFile);
//        });//업로드할 파일을 펼쳐서 반복문으로 돌리면서 등록

        if(uploadFiles != null && uploadFiles.length > 0){
            List<UploadResponseDTO> uploadedList=new ArrayList<>();

            for(MultipartFile multipartFile: uploadFiles){
                try {
                    uploadedList.add(uploadProcess(multipartFile));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }//for
            return uploadedList;
        }//end
        return null;
    }

    private UploadResponseDTO uploadProcess(MultipartFile multipartFile) throws Exception{
        String uploadPath="C:\\upload";//파일 복사해서 넣을 위치

        String folderName=makeFolder(uploadPath);//업로드한 파일을 폴더를 만들어서 추가
        //2021\\09\\07이란 폴더 이름을 받음
        //파일이 저장될 경로

//        log.info(multipartFile.getContentType());//파일 종류(확장자)
//        log.info(multipartFile.getOriginalFilename());//파일명
//        log.info(multipartFile.getSize());//파일 크기
//        log.info("----------");

        String fileName=multipartFile.getOriginalFilename();//원래 파일 이름
        String uuid=UUID.randomUUID().toString();
        String originalFileName=fileName;

        fileName=uuid+"_"+fileName;//중복 없게 만드는 메소드

        File savedFile=new File(uploadPath+File.separator+folderName, fileName);//복사한 파일 넣을 위치, 파일 이름
        //날짜로 만들어진 폴더 안에 업로드한 파일이 올라감


            FileCopyUtils.copy(multipartFile.getBytes(), savedFile);//파일 복사

        //썸네일 처리: 이미지일 때만
        String mimeType=multipartFile.getContentType();
        boolean checkImage=mimeType.startsWith("image");
        if(checkImage){//파일의 타입명이 image로 시작한다면
            File thumbnailFile=new File(uploadPath+File.separator+folderName, "s_"+fileName);
            Thumbnailator.createThumbnail(savedFile, thumbnailFile, 100, 100);
            //원본 파일, 썸네일로 만들 파일, 파일의 크기
        }
        return UploadResponseDTO.builder()
                .uuid(uuid)
                .uploadPath(folderName.replace(File.separator,"/"))//파일 경로명을 맥과 윈도우 모두 /로 나오게
                .fileName(originalFileName)
                .image(checkImage)
                .build();
    }

    private String makeFolder(String uploadPath){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String str=simpleDateFormat.format(date);
        String folderName=str.replace("-", File.separator);
        //윈도우에서 \\를 넣어 줌(연월일로 폴더 경로 설정: 2021\\09\\07)
        File uploadFolder=new File(uploadPath, folderName);//파일 업로드할 때 폴더를 만들어 줌
        if(uploadFolder.exists() == false){//만약 폴더가 없다면
            uploadFolder.mkdirs();//폴더를 자동으로 생성
        }
        return folderName;
    }

    @GetMapping("/viewFile")
    @ResponseBody
    public ResponseEntity<byte[]> viewFile(@RequestParam("file") String fileName) throws Exception{
        //이미지 조회, 다운로드하는 코드
        //파라미터는 file로 보내는데 받을 때는 fileName으로 받음: 변수명이 달라도 가져올 수 있음

        //C:\\upload\\2021/09/08/1.jpg 이렇게 경로가 들어옴: \\ / 섞여도 자바 버전이 6 이상부터는 괜찮음
        File file=new File("C:\\upload"+File.separator+fileName);
        //파일 있는지 확인
        log.info(file);//화면에 업로드된 결과 나옴
        ResponseEntity<byte[]> result=null;
        byte[] data=FileCopyUtils.copyToByteArray(file);//바이트 배열로 바꿔 줌
        String mimeType=Files.probeContentType(file.toPath());//여기에 맞는 적절한 mime 타입(파일 확장명)이 나옴
        log.info("mimeType: "+mimeType);

        result=ResponseEntity.ok().header("Content-Type", mimeType).body(data);
        //ok: 200 코드, 정상적인 응답이라고 메세지를 만들어 줌

        return  result;
    }

    @GetMapping("/downFile")
    public ResponseEntity<byte[]> download(@RequestParam("file") String fileName) throws Exception{
        File file=new File("C:\\upload"+File.separator+fileName);
        String originalFileName=fileName.substring(fileName.indexOf("_")+1);
        //_까지 자름: substring은 괄호 안에 적은 숫자 앞까지 자름, indexOf는 적은 문자가 있는 위치의 값을 반환

        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-type", "application/octet-stream");
        //다양한 종류의 파일을 처리
        headers.add("Content-Disposition","attachment; filename="
                +new String(originalFileName.getBytes(StandardCharsets.UTF_8), "ISO-8859-1"));
        //다운로드한 파일의 이름을 원래 이름으로 변경: 이걸 안 하면 URL 경로명을 파일 이름으로 사용

        byte[] data=FileCopyUtils.copyToByteArray(file);//파일 주면 바이트 배열을 생성
        return ResponseEntity.ok().headers(headers).body(data);
    }

    @PostMapping("/removeFile")
    public ResponseEntity<String> removeFile(@RequestBody Map<String, String> data) throws Exception{
        File file=new File("C:\\upload"+File.separator+data.get("fileName"));
        boolean checkImage=Files.probeContentType(file.toPath()).startsWith("image");
        //이미지 파일이면 파일 삭제
        file.delete();//파일 삭제

        if(checkImage){
            File thumbnail=new File(file.getParent(), "s_"+file.getName());
            //상위 폴더 이름에 s_ 붙은 게 썸네일 파일 이름
            log.info(thumbnail);
            thumbnail.delete();//썸네일 파일 삭제
        }
        return ResponseEntity.ok().body("deleted");
   }

}
