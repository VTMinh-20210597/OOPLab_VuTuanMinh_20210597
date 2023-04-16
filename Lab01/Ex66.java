import java.util.Scanner;

public class Ex66 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        int matrix1[][] = new int[R][C];
        int matrix2[][] = new int[R][C];
        int sum[][] = new int[R][C];

        for(int i = 0; i < R; ++i)
        {
            for(int j = 0; j < C; ++j)
            {
                matrix1[i][j] = sc.nextInt();
            }
        
        }

        for(int i = 0; i < R; ++i)
        {
            for(int j = 0; j < C; ++j)
            {
                matrix2[i][j] = sc.nextInt();
            }
        
        }

        for(int i = 0; i < R; ++i)
        {
            for(int j = 0; j < C; ++j)
            {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        
        }

        for(int i = 0; i < R; ++i)
        {
            for(int j = 0; j < C; ++j)
            {
                System.out.print(sum[i][j] + " ");
            }

            System.out.println();
        
        }

    }
    
}
