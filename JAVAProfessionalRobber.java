import java.util.Scanner;

abstract class Robber
{
    // Abstract methods
    abstract void RobbingClass();

    abstract void RowHouses();
    abstract void RoundHouses();
    abstract void SquareHouse();
    abstract void MultiHouseBuilding();

    // Default method
    void MachineLearning() 
    {
        System.out.println("I love MachineLearning.");
    }
}
public class JAVAProfessionalRobber extends Robber
{
    //Instantiate Scanner object
    Scanner sc=new Scanner(System.in);

    // Implement the abstract method RobbingClass
    void RobbingClass() 
    {
        System.out.println("MSc AI&ML");
    }

    //Method to calculate maximum amount that can be stolen from row houses
    void RowHouses()
    {
        System.out.println("Row house locality");
        System.out.println("Enter the number of houses in the row house locality: ");
        int n =sc.nextInt();

        if(n==0)
        {
            System.out.println("No houses to steal from!");
            return;
        }
        int[] a =new int[n];
        System.out.println("Enter the amount of money present in the "+n+" houses : ");
        for(int i=0; i<n; i++)
        {
            a[i]=sc.nextInt();
        }
        if(n==1)
        {
            System.out.println("Total amount that can be stolen from the house is: "+a[0]);
            return;
        }
        int sumodd=0;
        int sumeven=0;
        for(int i=0; i<n; i++)
        {
            if(i%2!=0)
            {
                sumodd+=a[i];
            }
            else
            {
                sumeven+=a[i];
            }
        }
        if(sumeven>=sumodd)
        {
            System.out.println("The maximum amount that can be stolen from the row houses is : "+sumeven);
            System.out.println("Starting from the first house, collect money from alternate houses!");
        }
        else
        {
            System.out.println("The maximum amount that can be stolen from the row houses is : "+sumodd);
            System.out.println("Starting from the second house, collect money from alternate houses!");
        }
    }

    //Method to calculate maximum amount that can be stolen from round houses
    void RoundHouses()
    {
        System.out.println("Round house locality");
        System.out.println("Enter the number of houses in the roundhouse locality: ");
        int n =sc.nextInt();

        if(n==0)
        {
            System.out.println("No houses to steal from!");
            return;
        }
        int[] a =new int[n];
        System.out.println("Enter the amount of money present in the "+n+" houses : ");
        for(int i=0; i<n; i++)
        {
            a[i]=sc.nextInt();
        }
        if(n==1)
        {
            System.out.println("Total amount that can be stolen from the house is: "+a[0]);
            return;
        }
        //Even number of houses
        if(n%2==0)
        {
            int sumodd=0;
            int sumeven=0;
            for(int i=0; i<n; i++)
            {
                if(i%2==0)
                {
                    sumeven+=a[i];
                }
                else
                {
                    sumodd+=a[i];
                }
            }
            if(sumeven>=sumodd)
            {
                System.out.println("The maximum amount that can be stolen from the roundhouses is : "+sumeven);
                System.out.println("Starting from the first house, collect money from alternate houses!");
            }
            else
            {
                System.out.println("The maximum amount that can be stolen from the roundhouses is : "+sumodd);
                System.out.println("Starting from the second house, collect money from alternate houses!");
            }
        }
        //Odd number of houses
        else
        {
            int sumfromstart =0;
            int sumfromend=0;
            int sumalternate=0;
            for(int i=0; i<n-1; i++)
            {
                if(i%2==0)
                {
                    sumfromstart+=a[i];
                }
                else
                {
                    sumalternate+=a[i];
                }
            }
            for(int i=n-1; i>=1; i=i-2)
            {
                sumfromend+=a[i];
            }
            if(sumfromstart>=sumfromend & sumfromstart>=sumalternate)
            {
                System.out.println("The maximum amount that can be stolen from the roundhouses is : "+sumfromstart);
                System.out.println("Starting from the first house, collect money from alternate houses!");
            }
            else if(sumalternate>sumfromstart & sumalternate>=sumfromend)
            {
                System.out.println("The maximum amount that can be stolen from the roundhouses is : "+sumalternate);
                System.out.println("Starting from the second house, collect money from alternate houses!");
            }
            else
            {
                System.out.println("The maximum amount that can be stolen from the roundhouses is : "+sumfromend);
                System.out.println("Starting from the last house, collect money from alternate houses!");
            }
        }
        
    }

    //Method to calculate maximum amount that can be stolen from square houses
    void SquareHouse()
    {
        System.out.println("Square house locality");
        System.out.println("Enter the number of houses present in a single row ? ");
        int x=sc.nextInt();

        //Condition to check in the case of no houses
        if(x==0)
        {
            System.out.println("No houses to steal from!");
            return;
        }

        int[][] a =new int[x][x];
        System.out.println("Enter the amount of money present in the "+(x*x)+" houses : ");
        for(int i=0; i<x; i++)
        {
            for(int j=0; j<x;j++)
            {                
                a[i][j]=sc.nextInt();
            }
        }
        if(x==1)
        {
            System.out.println("Total amount that can be stolen from the house is: "+a[0][0]);
            return;
        }

        //Money to be stolen starting from first house(0, 0)
        int sum1 = 0;
        for (int i = 0; i < x; i++) 
        {
            for (int j = 0; j < x; j++) 
            {
                // Collect money from houses where (i+j) is even
                if ((i + j) % 2 == 0) 
                {
                    sum1 += a[i][j];
                }
            }
        }
        //Money to be stolen starting from second house (0, 1)
        int sum2 = 0;
        for (int i = 0; i < x; i++) 
        {
            for (int j = 0; j < x; j++) 
            {
                // Collect money from houses where (i+j) is odd
                if ((i + j) % 2 != 0)
                {
                    sum2 += a[i][j];
                }
            }
        }
        if(sum1>=sum2)
        {
            System.out.println("The maximum amount that can be stolen from the square houses is : "+sum1);
            System.out.println("Starting from the first house, collect money from alternate houses!");

        }
        else
        {
            System.out.println("The maximum amount that can be stolen from the square houses is : "+sum2);
            System.out.println("Starting from the second house, collect money from alternate houses!");
        }

    }

    //Method to calculate maximum amount that can be stolen from multi-house buildings
    void MultiHouseBuilding()
    {
        System.out.println("Multi-house buildings locality");
        System.out.println("Enter the number of types of houses (rows in the matrix): ");
        int m = sc.nextInt(); 

        System.out.println("Enter the number of houses in each type (columns in the matrix): ");
        int n = sc.nextInt(); 

        int[][] houses = new int[m][n];

        System.out.println("Enter the amount of money in each house: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) 
            {
                houses[i][j] = sc.nextInt();
            }
        }

        //If there are no houses, nothing to rob
        if (m == 0 || n == 0) {
            System.out.println("No houses to rob!");
            return;
        }

        // DP array to store the maximum amount that can be robbed up to each house type
        int[][] dp = new int[m][n];

        // Initialize the first row in the DP table
        for (int j = 0; j < n; j++) 
        {
            dp[0][j] = houses[0][j];
        }

        // Fill the DP table row by row
        for (int i = 1; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                // For each house in the current row, we have two choices:
                // 1. Rob this house and skip adjacent houses in the same row (previous row's column)
                // 2. Skip this house and consider the maximum value robbed from previous row

                // Option 1: Rob this house, considering the previous row (no adjacent columns)
                int maxPrevRow = 0;
                if (j > 0) {
                    maxPrevRow = Math.max(maxPrevRow, dp[i - 1][j - 1]); // Left neighbor
                }
                if (j < n - 1) {
                    maxPrevRow = Math.max(maxPrevRow, dp[i - 1][j + 1]); // Right neighbor
                }

                // Option 2: Skip this house, use the value from previous row's column
                int maxCurrentHouse = Math.max(dp[i - 1][j], maxPrevRow) + houses[i][j];

                dp[i][j] = Math.max(dp[i - 1][j], maxCurrentHouse);
            }
        }

        // Get the maximum value from the last row to determine the most money that can be stolen
        int maxRobbedAmount = dp[m - 1][0];
        for (int i = 1; i < n; i++) 
        {
            maxRobbedAmount = Math.max(maxRobbedAmount, dp[m - 1][i]);
        }

        System.out.println("The maximum amount that can be robbed is: " + maxRobbedAmount);
    }
    public static void main(String[] args) 
    {
        JAVAProfessionalRobber robber = new JAVAProfessionalRobber();

        robber.RobbingClass(); 
        robber.MachineLearning(); 

        /* Test cases
        RowHouses([1, 2, 3, 0])
        RoundHouses([1, 2, 3, 4])
        SquareHouse([5, 10, 2, 7])
        MultiHouseBuilding([[5, 3, 8, 2], [10, 12, 7, 6], [4, 9, 11, 5], [8, 6, 3, 7]])
        */

        robber.RowHouses();
        robber.RoundHouses();
        robber.SquareHouse();
        robber.MultiHouseBuilding();    
    }
}