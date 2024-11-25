import java.util.Scanner;
interface WaterConservationSystem 
{
    int calculateTrappedWater(int[] blockHeights);

}
abstract class RainySeasonConservation implements WaterConservationSystem
{
    public abstract int calculateTrappedWater(int[] blockHeights);

}
class CityBlockConservation extends RainySeasonConservation
{
    public int calculateTrappedWater(int[] blockHeights)
    {
        int n=blockHeights.length;
        //If there are no buildings
        if(n==0)
        {
            return 0;
        }
        int left=0;
        int right=0;
        int water=0;
        for(int i=0, j=n-1; i<=j;)
        {
            if (blockHeights[i] < blockHeights[j]) 
            {
                //left side
                if(blockHeights[i]>=left)
                {
                    left=blockHeights[i];
                }
                else
                {
                    water+=left-blockHeights[i];
                }
                i++;
            }
            else 
            {
                //right side
                if (blockHeights[j]>=right) 
                {
                    right=blockHeights[j];
                }
                else
                {
                    water+=right-blockHeights[j];
                }
                j--;
            }
        }
        return water;
    }
}
public class WaterConservation
{
    public static void main(String\u005B \u005D args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length of city blocks: ");
        int n=sc.nextInt();
        int[] blockHeights=new int[n];
        System.out.println("Enter city blocks: ");
        for(int i=0; i<n; i++)
        {
            blockHeights[i]=sc.nextInt();
        }
        CityBlockConservation conservation = new CityBlockConservation();
        int totalwater=conservation.calculateTrappedWater(blockHeights);
        System.out.println("Total water trapped: "+totalwater+" units.");
        sc.close();
    }
}