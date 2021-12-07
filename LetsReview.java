import java.util.Scanner;

/**
 *
 * @author DKnight900
 */
public class LetsReview {
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();        
        String theString;
        String evenIndexString;
        String oddIndexString;
        
        for(int i = 0; i < T + 1; i++)
        {            
            evenIndexString = "";
            oddIndexString = "";
            theString=s.nextLine();
            for(int j = 0; j < theString.length(); j++)
            {
                if(j == 0 || j % 2 == 0)
                    evenIndexString += theString.charAt(j);
                else
                    oddIndexString += theString.charAt(j);
            }
            System.out.print(evenIndexString + " ");
            System.out.println(oddIndexString);
        }
    }
}
