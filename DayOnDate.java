import java.util.Scanner;
class DayOnDate
{
    public static void main(String[] args)
    {
        int[] days= {31,28,31,30,31,30,31,31,30,31,30,31};//Storing all the days in the months
        String[] week={"sunday","Monday", "Tuesday","Wednesday","Thursday","Friday","Saturday"};
        int leap,ordinary,odd2=0;
        Scanner sc= new Scanner(System.in);
        try{
            System.out.println("Enter day: ");
            int day= sc.nextInt();
            System.out.println("Enter month: ");
            int mon= sc.nextInt();
            System.out.println("Enter year: ");
            int year= sc.nextInt();

            int year1=year;
            int odd=day;
            int odd1=0;
            int cent;

            for ( cent=0 ; cent<year; cent=(cent+100) )
            {
                if((cent%400)== 0)
                {
                    odd1=0;
                }
                else
                odd1= odd1+ 5;
            }
            cent=cent-100;
            year=year-cent-1;  
            leap = year/4;      
            ordinary= year-leap;   
            for(int i=1; i<mon; i++)
            {
                odd2= odd2+ days[i];
            }
            odd= odd + odd1 +odd2+ ordinary+ leap*2; 
            odd= odd%7;
            System.out.println("The day on "+day+"/"+mon+"/"+year1+" : "+week[odd]);   
        
            }catch(Exception e){
            System.out.println("Invalid inputs!");
        }
        
        }
}