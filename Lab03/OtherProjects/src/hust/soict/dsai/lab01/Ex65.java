package hust.soict.dsai.lab01;

import java.util.Scanner;


public class Ex65 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Double [] list_N;

        list_N = new Double[N + 1];

        for(int i = 1; i <= N; ++i)
        {
            list_N[i] = sc.nextDouble();
        }

        for(int i = 1; i <= N; ++i)
        {
            double smallest = (1e9 + 7);
            int pos = 0;
            for(int j = i; j <= N; ++j)
            {
                if(smallest > list_N[j])
                {
                    smallest = list_N[j];
                    pos = j;
                }

                
            }
            System.out.println(smallest);
            double temp = list_N[pos];
            list_N[pos] = list_N[i];
            list_N[i] = temp;

        }

        double Total = 0;

        for(int i = 1; i <= N; ++i)
        {
            System.out.print(list_N[i] + " ");
            Total += list_N[i];
        }

        System.out.println();

        System.out.println(Total);
        System.out.println(Total/N);




    }
}
