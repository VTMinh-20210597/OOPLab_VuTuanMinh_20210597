package hust.soict.dsai.lab01;
import java.util.Scanner;

public class Ex64 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int Checker = 0;

        while(1 - Checker == 1)
        {
            Checker = 0;

            String month = sc.next();
            int year = sc.nextInt();


            if(month.equals("Jan") || month.equals("Jan.") || month.equals("January") || month.equals("1"))
            {
                Checker = 1;
                System.out.println("31");
            }

            if(month.equals("Feb") || month.equals("Feb.") || month.equals("February") || month.equals("2"))
            {
                Checker = 1;
                if(year % 100 == 0)
                {
                    if(year % 400 == 0) System.out.println("29");
                    else System.out.println("28");
                }
                else
                {
                    if(year % 4 == 0) System.out.println("29");
                    else System.out.println("28");
                }
            }

            if(month.equals("Mar") || month.equals("Mar.") || month.equals("March") || month.equals("3"))
            {
                Checker = 1;
                System.out.println("31");
            }

            if(month.equals("Apr") || month.equals("Apr.") || month.equals("April") || month.equals("4"))
            {
                Checker = 1;
                System.out.println("30");
            }

            if(month.equals("May") || month.equals("5"))
            {
                Checker = 1;
                System.out.println("31");
            }

            if(month.equals("Jun") || month.equals("June") || month.equals("6"))
            {
                Checker = 1;
                System.out.println("30");
            }

            if(month.equals("Jul") || month.equals("July") || month.equals("7"))
            {
                Checker = 1;
                System.out.println("31");
            }

            if(month.equals("Aug") || month.equals("Aug.") || month.equals("August") || month.equals("8"))
            {
                Checker = 1;
                System.out.println("31");
            }

            if(month.equals("Sep") || month.equals("Sept.") || month.equals("September") || month.equals("9"))
            {
                Checker = 1;
                System.out.println("30");
            }

            if(month.equals("Oct") || month.equals("Oct.") || month.equals("October") || month.equals("10"))
            {
                Checker = 1;
                System.out.println("31");
            }

            if(month.equals("Nov") || month.equals("Nov.") || month.equals("November") || month.equals("11"))
            {
                Checker = 1;
                System.out.println("30");
            }

            if(month.equals("Dec") || month.equals("Dec.") || month.equals("December") || month.equals("12"))
            {
                Checker = 1;
                System.out.println("31");
            }

            if(Checker == 0) System.out.println("There is no month or year like this, enter again");
        }
    }
}