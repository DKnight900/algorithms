/**
 *
 * @author DKnight900
 */
public class BinaryNumbers 
{
    public static void main(String[] args) 
    {
        String binaryString=convertBinary(5);        
        int maxConsec = 1;
        int counter = 1;
        for(int i = 0; i < binaryString.length() - 1; i++)
        {
            if(binaryString.charAt(i) == '1')
            {
                if(binaryString.charAt(i) == binaryString.charAt(i + 1))
                {
                    counter++;
                    if(counter > maxConsec)
                        maxConsec = counter;
                }
                else                                
                    counter = 1;
            }    
            else
                counter = 1;
        }        
        System.out.println(maxConsec);
    }
    private static String convertBinary(int n)
    {
        StringBuilder binary = new StringBuilder();
        while(n > 0)
        {           
            if(n % 2 == 0)
                binary.append(0);
            else
                binary.append(1);
            n /= 2;
        }                        
        return binary.reverse().toString();
    }
}
