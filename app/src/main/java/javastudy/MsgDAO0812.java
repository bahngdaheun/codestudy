package kr.go.practice1.dao;

import kr.go.practice1.dto.MsgDTO;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
public enum MsgDAO {

    INSTANCE;

    private static final String SQL_INSERT="insert into tbl_msg (who, whom, content) values(?,?,?)";
    private static final String SQL_LIST="select mno, who, whom, if(who=?,'R','S') kind, content," +
            "regdate,opendate from tbl_msg where whom=? or" +
            "who=? order by who asc, whom asc, mno desc;";

    public void insert(MsgDTO msgDTO) throws RuntimeException {
        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {
                preparedStatement=connection.prepareStatement(SQL_INSERT);
                preparedStatement.setString(1, msgDTO.getWho());
                preparedStatement.setString(2, msgDTO.getWhom());
                preparedStatement.setString(3,msgDTO.getContent());

                int count= preparedStatement.executeUpdate();
                log.info("count: "+count);
            }
        }.makeAll();
    }

    public Map<String, List<MsgDTO>> selectList(String user) throws RuntimeException {
    Map<String, List<MsgDTO>> listMap=new HashMap<>();
    listMap.put("R", new ArrayList<>());
    listMap.put("S", new ArrayList<>());

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {
                preparedStatement=connection.prepareStatement(SQL_LIST);
                preparedStatement.setString(1,user);
                preparedStatement.setString(2,user);
                preparedStatement.setString(3,user);
                resultSet= preparedStatement.executeQuery();

                log.info(resultSet);
                while (resultSet.next()){
                    String kind = resultSet.getString(4);
                    List<MsgDTO> targetList=listMap.get(kind);
                    targetList.add(MsgDTO.builder()
                            .mno(resultSet.getLong(1))
                            .who(resultSet.getString(2))
                            .whom(resultSet.getString(3))
                            .content(resultSet.getString(5))
                            .regdate(resultSet.getTimestamp(6))
                            .opendate(resultSet.getTimestamp(7)).build());
                }
            }
        }.makeAll();
        return listMap;
    }

}
