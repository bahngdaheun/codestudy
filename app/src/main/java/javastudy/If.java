package javastudy;

import java.util.Scanner;

public class If {

  public static void main(String[] args) {
    System.out.print("점수를 입력해 주세요: ");
    Scanner sc = new Scanner(System.in);
    String tmp = sc.nextLine();
    int score = Integer.parseInt(tmp);
    if(score > 60) 
      System.out.println("합격입니다.\n축하드립니다.");//if문에 속한 문장
    System.out.println("합격입니다.");//if문 결과와 상관없이 항상 출력
    System.out.println("축하드립니다.");//if문 결과와 상관없이 항상 출력

    System.out.println();
    System.out.print("숫자를 입력해 주세요: ");
    String tmp2 = sc.nextLine();
    int num = Integer.parseInt(tmp2);
    char sign='0';
    if (num > 0) {//양수일 때
      sign = '+';
    } else//0이거나 음수일 때
      sign = ' ';
    System.out.printf("입력한 숫자는 %c%d입니다.", sign, num);
    sc.close();
  }
}