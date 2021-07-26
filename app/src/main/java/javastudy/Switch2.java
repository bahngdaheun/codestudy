package javastudy;

import java.util.Scanner;

public class Switch2 {
  public static void main(String[] args) {
    System.out.print("주민번호를 예시와 같이 입력하세요(예)123456-3890123): ");
    Scanner sc = new Scanner(System.in);
    String no = sc.nextLine();
    char gender = no.charAt(7);

    switch(gender) {
      case '1': case '3':
        switch(gender) {
          case '1':
            System.out.println("당신은 2000년도 전에 출생한 남자입니다.");
            break;
          case '3':
            System.out.println("당신은 2000년도 이후에 출생한 남자입니다.");
        }
        break;

      case '2': case '4':
        switch(gender) {
          case '2':
            System.out.println("당신은 2000년도 전에 출생한 여자입니다.");
            break;
          case '4':
            System.out.println("당신은 2000년도 이후에 출생한 여자입니다.");
        }
        break;

      default:
        System.out.println("다시 입력해 주세요.");
    }
    sc.close();
  }
}
