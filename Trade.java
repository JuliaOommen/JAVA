import java.util.Scanner;
public class Trade
{
    public static int findMaxProfit(int[] prices) 
    {
        int firstbuy = Integer.MAX_VALUE;
        int firstsell = 0;
        int secondbuy = Integer.MAX_VALUE;
        int secondsell = 0;

        for (int i = 0; i < prices.length; i++) 
        {
            int price = prices[i];
        
            if (price < firstbuy) 
            {
                firstbuy = price;
            }
            int tempfirstsell=price-firstbuy;
            if (tempfirstsell>firstsell) 
            {
                firstsell=tempfirstsell;
            }
            int tempsecondbuy=price-firstsell;
            if (tempsecondbuy < secondbuy) {
                secondbuy = tempsecondbuy;
            }
        
            int tempsecondsell = price - secondbuy;
            if (tempsecondsell > secondsell) {
                secondsell = tempsecondsell;
            }
        }

        return secondsell;
    }

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number (minimum 2) of stock prices: ");
        int n=sc.nextInt();
        if(n>=2)
        {
            int[] a=new int[n];
            System.out.println("Enter the stock prices: ");
            for(int i=0; i<n; i++)
            {
                a[i]=sc.nextInt();
            }
            System.out.println("Max Profit for prices1: " + findMaxProfit(a));
        }
        else
        {
            System.out.println("Minimum of 2 stock prices is required!");
        }
    }
}