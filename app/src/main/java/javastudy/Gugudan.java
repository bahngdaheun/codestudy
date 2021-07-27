package javastudy;

import java.util.Scanner;

public class Gugudan {

  public static void main(String[] args) {
    System.out.print("2 ~ 9 중에 숫자 1개를 입력해 주세요: ");
    Scanner sc = new Scanner(System.in);
    String tmp = sc.nextLine();
    int num = Integer.parseInt(tmp);

    for(int j=1; j<10; j++) {
      System.out.println(num+" * " +j+" = "+num*j);
      sc.close();
    }
  }
}
