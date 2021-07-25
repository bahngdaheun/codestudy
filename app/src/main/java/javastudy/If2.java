package javastudy;

import java.util.Scanner;

public class If2 {

  public static void main(String[] args) {
    System.out.print("1 ~ 6 중에 하나를 입력하세요: ");
    Scanner sc = new Scanner(System.in);
    String tmp = sc.nextLine();
    int user = Integer.parseInt(tmp);
    int com = (int)(Math.random()*6)+1;

    System.out.println("당신은 " + user + "입니다.");
    System.out.println("컴퓨터는 " + com + "입니다.");
    int gap = user - com;

    if(gap > 0) {
      System.out.println("당신이 이겼습니다.");
    } else if(gap < 0) {
      System.out.println("당신이 졌습니다.");
    } else {
      System.out.println("비겼습니다.");
    }
    sc.close();
  }
}
