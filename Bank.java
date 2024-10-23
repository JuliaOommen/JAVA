import java.util.Scanner;
class CreditCard
{
    int ccn;
    int count;
    CreditCard(int n)
    {
        ccn=n;
    }
    void display()
    {
        System.out.println("Entered credit card number: "+ccn);
    }
    boolean cardlength()
    {
        boolean flag=false;
        String numStr = Integer.toString(ccn);
        count = numStr.length();
        
        if(count==8 || count==9)
        {
            flag=true;
        }
        return flag;
    }
    int reversed(int x)
    {
        int rev=0;
        while(x!=0)
        {
            int a=x%10;
            rev=rev*10+a;
            x=x/10;
        }
        return rev;
    }

    int positionsum(int x)
    {
        int sum=0;
        String str=Integer.toString(x);

        for (int i=0;i<str.length(); i++)
        {
            int digit = str.charAt(i) - '0';
            if((i+1)%2== 1)
            { 
                digit=digit*2; 
                if (digit>9) 
                {
                    sum=sum+(digit / 10) + (digit % 10);
                } 
                else 
                {
                    sum+=digit; 
                }
            } 
            else 
            { 
                sum+=digit; 
            }
        }
        return sum;
    }
}

public class Bank 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter credit card number: ");
        int card = sc.nextInt();

        CreditCard obj=new CreditCard(card);
        obj.display();
        boolean verified = obj.cardlength();
        if(verified==true)
        {
            int last = card%10;
            int a = card/10;
            int rev=obj.reversed(a);
            System.out.println("Reversed number: "+rev);   
               
            int sum = obj.positionsum(rev);
            System.out.println(sum);
            int temp=10-(sum%10);
            if(temp==last)
            {
                System.out.println("Valid Credit Card Number!");
            }
            else
            {
                System.out.println("Invalid Credit Card Number");
            }
        }
        else 
        {
            System.out.println("Invalid Credit Card Number!");
        }
    }
}

