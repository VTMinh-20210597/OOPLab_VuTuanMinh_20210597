import java.util.Scanner;
import java.util.Scanner;

public class Ex225 {
    public static void main(String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        double strNum1 = sc.nextDouble();
        double strNum2 = sc.nextDouble();

        double sum = strNum1 + strNum2;
        double difference = strNum1 - strNum2;
        double product = strNum1 * strNum2;
        double quotient = strNum1 / strNum2; 

        System.out.println(sum);
        System.out.println(difference);
        System.out.println(product);
        System.out.println(quotient);

    }
}
