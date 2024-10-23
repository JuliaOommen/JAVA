import java.util.Scanner;
class Solver
{
    int w,p,b,s;
    int m,q,d,z;
    int leftScore,rightScore;

    Solver()
    {
        w=4;p=3;b=2;s=1;
        m=4;q=3;d=2;z=1;
    }
    Solver(int w,int p, int b, int s, int m, int q, int d, int z)
    {
        this.w=w; this.p=p; this.b=b; this.s=s;
        this.m=m; this.q=q; this.d=d; this.z=z;
    }
    void display()
    {
        System.out.println("Team A : w = "+w+", p = "+p+", b= "+b+", s="+s);
        System.out.println("Team B : m = "+m+", q = "+q+", d= "+d+", z="+z);
    }
     void play(String word)
    {
        for(int i=0; i<word.length();i++)
        {
            char ch = word.charAt(i);  
            switch (ch) 
            {
                case 'w': leftScore += w;
                break;
                case 'p': leftScore += p; 
                break;
                case 'b': leftScore += b; 
                break;
                case 's': leftScore += s; 
                break;
                case 'm': rightScore += m; 
                break;
                case 'q': rightScore += q; 
                break;
                case 'd': rightScore += d; 
                break;
                case 'z': rightScore += z; 
                break;
                default: break;
            }
        }
        winner(leftScore, rightScore);

    }
    void play(String word1, String word2)
    {
        

        for (int i = 0; i < word1.length(); i++)
        {
            char ch = word1.charAt(i);  
            switch (ch) 
            {
                case 'w': leftScore += w;
                break;
                case 'p': leftScore += p; 
                break;
                case 'b': leftScore += b; 
                break;
                case 's': leftScore += s; 
                break;
                default: break;
            }
        }

        for (int i = 0; i < word2.length(); i++)
        {
            char ch = word2.charAt(i);  
            switch (ch) 
            {
                case 'm': rightScore += m; 
                break;
                case 'q': rightScore += q; 
                break;
                case 'd': rightScore += d; 
                break;
                case 'z': rightScore += z; 
                break;
                default: break;
            }
        }
        winner(leftScore, rightScore);  
    }

    void winner(int ls, int rs)
    {
        if(leftScore>rightScore)
        {
            System.out.println("Team A wins!");
        }
        else if(rightScore>leftScore)
        {
            System.out.println("Team B wins!");
        }
        else
        {
            System.out.println("Its a tie!");
        }
    }
}
public class Game 
{
    public static void main(String[] args)
    {
        Solver obj = new Solver();
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Alphabet Wars!");
        System.out.println("There are 2 teams, each having 4 players");
        System.out.println("The teams are: Team A [w,p,b,s] \t Team B [m,q,d,z]");
        System.out.println("Would you like to assign strengths to each player?");
        System.out.println("Enter 'Y' to assign your own strength, else 'N'");
        char a=sc.next().charAt(0);
        if(a=='Y')
        {
            System.out.println("Assign strengths to Team A players");
            System.out.println("w");
            int w=sc.nextInt();
            System.out.println("p");
            int p=sc.nextInt();
            System.out.println("b");
            int b=sc.nextInt();
            System.out.println("s");
            int s=sc.nextInt();
            System.out.println("Assign strengths to Team B players");
            System.out.println("m");
            int m=sc.nextInt();
            System.out.println("q");
            int q=sc.nextInt();
            System.out.println("d");
            int d=sc.nextInt();
            System.out.println("z");
            int z=sc.nextInt();
            obj = new Solver(w,p,b,s,m,q,d,z);

        }
        if(a=='N')
        {
            System.out.println("The strengths of players in Team A and B are: ");
            obj.display();
        }
        if(a=='N'|| a=='Y')
        {
            System.out.println("How many words are you entering(1 or 2)?");
            int n=sc.nextInt();
            sc.nextLine();
            if(n==1)
            {
                System.out.println("Enter a word");
                String str=sc.nextLine();
                obj.play(str);
            }
            else if(n==2)
            {
                System.out.println("Enter 1st word");
                String str1=sc.nextLine();
                System.out.println("Enter 2nd word");
                String str2=sc.nextLine();
                obj.play(str1, str2);

            }
            else
            {
                System.out.println("Enter either 1 or 2!");
            }
        }
        else
        {
            System.out.println("Invalid Input! Try again!");
        }

    }
}
