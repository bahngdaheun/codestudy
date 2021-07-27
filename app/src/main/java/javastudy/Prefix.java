package javastudy;

public class Prefix {

  public static void main(String[] args) {
    int i = 5;
    while(i--!=0) {
      System.out.println(i);//4, 3, 2, 1, 0 출력
    }

    System.out.println();
    i = 5;

    while(--i!=0) {
      System.out.println(i);//4, 3, 2, 1 출력
    }
  }
}
