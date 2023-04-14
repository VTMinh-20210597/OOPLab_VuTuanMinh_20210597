import java.util.Scanner;

public class second_degree_equation_with_one_variable 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double delta = b*b - 4 * a * c;

        if(delta == 0)
        {
            System.out.println(-b/(2*a));
        }
        else if (delta > 0)
        {
            System.out.println((-b + Math.sqrt(delta))/(2 * a));
            System.out.println((-b - Math.sqrt(delta))/(2 * a));
        }
        else
        {
            System.out.println("No root");
        }
        
    }
}
