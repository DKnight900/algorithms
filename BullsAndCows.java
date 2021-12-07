/**
 *
 * @author DKnight900
 * 
 * You are playing the following Bulls and Cows game with your friend: You write down a number and 
 * ask your friend to guess what the number is. Each time your friend makes a guess, you provide a 
 * hint that indicates how many digits in said guess match your secret number exactly in both digit 
 * and position (called "bulls") and how many digits match the secret number but locate in the 
 * wrong position (called "cows"). Your friend will use successive guesses and hints to eventually 
 * derive the secret number.

 *  For example:

 *  Secret number:  "1807"
 *  Friend's guess: "7810"

 *  Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)

 *  Write a function to return a hint according to the secret number and friend's guess, 
 *  use A to indicate the bulls and B to indicate the cows. In the above example, 
 *  your function should return "1A3B".

 *  Please note that both secret number and friend's guess may contain duplicate digits, 
 *  for example:

 *  Secret number:  "1123"
 *  Friend's guess: "0111"

 *  In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, 
 *  and your function should return "1A1B".

 *  You may assume that the secret number and your friend's guess only contain digits, 
 *  and their lengths are always equal.
 * 
 */
public class BullsAndCows 
{
    public static void main(String[] args) 
    {
        BullsAndCows bullsAndCows = new BullsAndCows();
        System.out.println(bullsAndCows.getHint("2822013305",
                                                "5706322849"));//0A6B
        System.out.println(bullsAndCows.getHint("1122", 
                                                "2210"));//0A3B
        System.out.println(bullsAndCows.getHint("1122", 
                                                "2211"));//0A4B
        System.out.println(bullsAndCows.getHint("1", 
                                                "0"));//0A0B
        System.out.println(bullsAndCows.getHint("1", 
                                                "1"));//1A0B
        System.out.println(bullsAndCows.getHint("11", 
                                                "10"));//1A0B
        System.out.println(bullsAndCows.getHint("1807", 
                                                "7810"));//1A3B        
        System.out.println(bullsAndCows.getHint("1123", 
                                                "0111"));//1A1B
        System.out.println(bullsAndCows.getHint("0111", 
                                                "1123"));//1A1B
        System.out.println(bullsAndCows.getHint("1111", 
                                                "1111"));//4A0B
        
    }
    public String getHint(String secret, String guess) 
    {
        String hint = "0A0B";
        int bulls = 0;
        int cows = 0;
        int i;
        int currentSecretChar;
        int currentGuessChar;
        
        int secretPositions[] = new int[10];
        int guessPositions[] = new int[10];
        
        if(secret.length() == guess.length() && secret.length() > 0)
        {
            for(i = 0; i < secret.length(); i++)
            {
                currentSecretChar = ((int)secret.charAt(i)) - 48;
                currentGuessChar = ((int)guess.charAt(i)) - 48;

                if(currentSecretChar == currentGuessChar)
                    bulls++;
                else
                {            
                    secretPositions[currentSecretChar]++;
                    guessPositions[currentGuessChar]++;                                    
                }
            }
            for(i = 0; i <= 9; i++)
            {
                if(guessPositions[i] != 0 && secretPositions[i] != 0)
                {
                    if(guessPositions[i] <= secretPositions[i])
                        cows += guessPositions[i];
                    else
                        cows += secretPositions[i];
                }

            }        
            hint = bulls + "A" + cows + "B";
        }
        return hint;       
    }
}
