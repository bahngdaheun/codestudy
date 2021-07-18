package javastudy;

public class Variable {

  public static void main(String[] args) {
    float f = 1.23456f;
    System.out.println(f);
    //System.out.printf("f = %014.10", f);
    System.out.printf("f = %014.10f\n", f);
    System.out.printf("f = %14.10f\n", f);

    double d = 1.0e100;
    float f2 = (float)d;
    System.out.println(f2);

    double d2 = 1.0e-50;
    float f3 = (float)d2;
    System.out.println(f3);
  }

}
