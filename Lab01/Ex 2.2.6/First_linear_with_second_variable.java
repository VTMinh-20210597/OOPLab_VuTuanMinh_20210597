import java.util.Scanner;

public class First_linear_with_second_variable {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        double a11 = sc.nextDouble();
        double a12 = sc.nextDouble();
        double b1 = sc.nextDouble();
        double a21 = sc.nextDouble();
        double a22 = sc.nextDouble();
        double b2 = sc.nextDouble();

        double D = a11 * a22 - a21*a12;
        double D1 = b1*a22 - b2*a12;
        double D2 = a11*b2 - a21*b1;

        System.out.println(D1/D);
        System.out.println(D2/D);

    }
}
