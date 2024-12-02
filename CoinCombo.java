import java.util.Scanner;
public class CoinCombo 
{
    static class CoinWorker extends Thread 
    {
        private int[] coins;
        private int start, end;
        private int sum;
        private int[] dp;

        public CoinWorker(int[] coins,int start,int end,int sum,int[] dp) 
        {
            this.coins=coins;
            this.start=start;
            this.end=end;
            this.sum=sum;
            this.dp=dp;
        }

        public void run() 
        {
            for (int i=start; i<end; i++)
            {
                for (int j=coins[i]; j<=sum; j++)
                {
                    synchronized (dp) 
                    { 
                        dp[j]+=dp[j-coins[i]];
                    }
                }
            }
        }
    }

    public static int countWays(int[] coins, int n, int sum, int numThreads) throws InterruptedException 
    {
        int[] dp=new int[sum+1];
        dp[0]=1; //Base case: One way to make sum 0 

        //Divide coins among threads
        int step=(n+numThreads-1)/numThreads; //Divide coins into nearly equal ranges
        Thread[] threads=new Thread[numThreads];

        for (int t=0; t<numThreads; t++) 
        {
            int start=t*step;
            int end=Math.min(start+step, n);
            if(start<end) 
            { 
                threads[t] = new CoinWorker(coins, start, end, sum, dp);
                threads[t].start();
            }
        }
        for (int i=0; i<threads.length; i++) 
        {
            if (threads[i]!=null)
            {
                threads[i].join();
            }
        }
        return dp[sum];
    }
    public static void main(String[] args) throws InterruptedException 
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of coins: ");
        int n=sc.nextInt();
        int[] coins=new int[n];

        System.out.println("Enter the coins: ");
        for (int i=0;i<n;i++) 
        {
            coins[i]=sc.nextInt();
        }
        System.out.println("Enter the target sum: ");
        int sum=sc.nextInt();

        int numThreads = 2; // Number of threads to use
        int result = countWays(coins, n, sum, numThreads);

        System.out.println("Number of ways to make sum " + sum + ": " + result);
    }
}
