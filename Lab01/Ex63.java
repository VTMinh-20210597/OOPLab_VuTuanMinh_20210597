import java.util.Scanner;

public class Ex63 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int Step = n;

        for(int i = 1; i <= n; ++i)
        {
            for(int j = 1; j <= 2 * n + 3; ++j)
            {
                if(j >= Step + 1 && j <= 2 * n - Step + 1)
                {
                    System.out.print("*");
                }
                else System.out.print(" ");
            }

            System.out.print("\n");

            Step -= 1;
        }

    }
}
