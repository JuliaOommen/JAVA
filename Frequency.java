import java.util.Scanner;

class Num
{
    static int a[];
    Num(int n)
    {
        Num.a = new int[n];
    }

    static void check(int k) 
    {
        int[] frequency = new int[101]; 
        for (int i=0;i<a.length; i++) 
        {
            int x=a[i];
            if (x>=0 && x<frequency.length) 
            {
                frequency[x]++;
            }
        }
    
        int[][] numfreq= new int[101][2];
        for(int i=0; i<frequency.length; i++)
        {
            numfreq[i][0]=i;
            numfreq[i][1]=frequency[i];
        }

        //Sorting based on frequency
        for (int i=0;i<numfreq.length-1; i++) 
        {
            for (int j=0;j<numfreq.length-1-i; j++) 
            {
                if (numfreq[j][1] <numfreq[j+1][1] || 
                (numfreq[j][1] == numfreq[j+1][1] && numfreq[j][0]<numfreq[j+1][0])) 
                {
                    int[] temp =numfreq[j];
                    numfreq[j] = numfreq[j+1];
                    numfreq[j+1] = temp;
                }
            }
        }

        System.out.println("Top " + k + " numbers with maximum occurrences:");
        for (int i=0;i<k;i++) 
        {
            if (numfreq[i][1] > 0)
            {
                System.out.println(numfreq[i][0] + " occurs " +numfreq[i][1] + " times");
            }
        }
    }
}
public class Frequency 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the value of k: ");
        int k=sc.nextInt();
        System.out.println("Enter number of values to be inputted greater than or equal to k");
        int n=sc.nextInt();
        Num obj=new Num(n);

        if(n>=k)
        {
            System.out.println("Enter "+n+ " numbers that lie between 0 to 100 ");
            for(int i=0; i<n;i++)
            {
                int temp;
                while(true)
                {
                    temp=sc.nextInt();
                    if(temp>=0 && temp<=100)
                    {
                        Num.a[i]=temp;
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid input! Values should be between 0 and 100");
                    }
                }
            }
            Num.check(k);
        }
        else
        {
            System.out.println("Incorrect input! Number of values should be greater than k!");
        }
    }
}
