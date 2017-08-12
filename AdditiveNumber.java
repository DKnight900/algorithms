package algorithms;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DKnight900
 * 
 * Additive number is a string whose digits can form additive sequence.
 * 
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * 
 * For example:
 * 
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 
 * 1 + 99 = 100, 99 + 100 = 199
 * 
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * 
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * 
 * Follow up:
 * How would you handle overflow for very large input integers?
 * 
 */
public class AdditiveNumber
{
    public static void main(String[] args) {
        AdditiveNumber additiveNumber = new AdditiveNumber();                           
        System.out.println(additiveNumber.isAdditiveNumber("12122436")); //true 
        System.out.println(additiveNumber.isAdditiveNumber("198019823962")); //true         
        System.out.println(additiveNumber.isAdditiveNumber("112358")); //true       
        System.out.println(additiveNumber.isAdditiveNumber("199100199"));//true
        System.out.println(additiveNumber.isAdditiveNumber("1991001910"));//false
        System.out.println(additiveNumber.isAdditiveNumber("1203"));//false
        System.out.println(additiveNumber.isAdditiveNumber("1235"));//true
        System.out.println(additiveNumber.isAdditiveNumber("1023"));//false
        System.out.println(additiveNumber.isAdditiveNumber("101"));//true
        System.out.println(additiveNumber.isAdditiveNumber("111"));//false
        System.out.println(additiveNumber.isAdditiveNumber("9918"));//true
        System.out.println(additiveNumber.isAdditiveNumber("121474836472147483648"));//true
        System.out.println(additiveNumber.isAdditiveNumber("011235")); //true
        System.out.println(additiveNumber.isAdditiveNumber("101123581321345589144")); //true
        
        
        
    }
    public boolean isAdditiveNumber(String num)
    {
        Map<String,String> nextNumber;  
        int nextPos;
        String previousNumber1;
        String previousNumber2;    
        
        boolean isAdditiveNumber=false;                
        if(!num.isEmpty())
        {
            initFor:for(int i=1;i<=num.length()-1;i++)
            {
                for(int j=1;j<=num.length()-i;j++)
                {                
                    previousNumber1=num.substring(0,i);                                                    
                    previousNumber2=num.substring(previousNumber1.length(),previousNumber1.length()+j);                                                    
                    
                    if(previousNumber1.charAt(0)=='0' && previousNumber1.length()>1)
                        break initFor;
                    else
                    {
                        if(!(previousNumber2.charAt(0)=='0' && previousNumber2.length()>1))
                        {                                            
                            nextNumber=obtainNextNumber(num, previousNumber1, previousNumber2,0);                                                
                            if(nextNumber!=null)
                            {                                                                                                                            
                                if((new BigInteger(nextNumber.get("nextNumber"))).compareTo(new BigInteger(previousNumber1).add(new BigInteger(previousNumber2)))==0)                                
                                {                                               
                                    nextPos=previousNumber1.length()+previousNumber2.length()+String.valueOf(nextNumber.get("nextNumber")).length();
                                    isAdditiveNumber=evaluateTotalNextNumbers(previousNumber2,nextNumber,num,nextPos);       
                                    if(isAdditiveNumber)
                                        break initFor;                                                                            
                                }   
                            }                        
                            else
                                break;
                        }
                        else 
                            break;
                    }
                }                
            }
        }
                        
        return isAdditiveNumber;
    }
    private Map<String,String> obtainNextNumber(String originalNumber,String previousNumber1,String previousNumber2,Integer nextPos)
    {        
        Map<String,String> nextNumberMap = new HashMap<>();
        Integer beginIndex;
        Integer endIndex;
        Integer newNextPos;
        if(nextPos>0)        
            beginIndex=nextPos;        
        else        
            beginIndex=(previousNumber1.concat(previousNumber2)).length();            
        
        endIndex=beginIndex+String.valueOf(new BigInteger(previousNumber1).add(new BigInteger(previousNumber2))).length();
        if(endIndex>originalNumber.length())
                nextNumberMap=null;
        else
        {
            nextNumberMap.put("nextNumber",originalNumber.substring(beginIndex, endIndex));
            newNextPos=nextPos+String.valueOf(new BigInteger(previousNumber1).add(new BigInteger(previousNumber2))).length();
            nextNumberMap.put("nextPos",String.valueOf(newNextPos));
        }
        return nextNumberMap;        
    }        
    private boolean evaluateTotalNextNumbers(String previousNumber2,Map<String,String> nextNumber, String num, Integer nextPos)
    {
        boolean isAdditiveNumber=true;
        String previousNumber1;
        
        
        previousNumber1=previousNumber2;
        previousNumber2=String.valueOf(nextNumber.get("nextNumber"));                                    
        

        while(nextPos<=num.length()-1)
        {                        
            nextNumber=obtainNextNumber(num, previousNumber1, previousNumber2,nextPos);                                        
            if(nextNumber !=null && ((new BigInteger(nextNumber.get("nextNumber"))).compareTo(new BigInteger(previousNumber1).add(new BigInteger(previousNumber2)))==0))
            {
                previousNumber1=previousNumber2;
                previousNumber2=String.valueOf(nextNumber.get("nextNumber"));                                                                                
                nextPos=Integer.parseInt(nextNumber.get("nextPos"));                
            }
            else
            {
                isAdditiveNumber=false;
                break;
            }                        
        }                    
        
        return isAdditiveNumber;
    }
    
}
