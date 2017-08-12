package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author DKnight900
 * 
 * Given a pattern and a string str, find if str follows the same 
 * pattern.
 *
 * Here follow means a full match, such that there is a bijection 
 * between a letter in pattern and a non-empty word in str.
 *
 * Examples:
 *
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 *
 * Notes:
 * You may assume pattern contains only lowercase letters, and 
 * str contains lowercase letters separated by a single space. 
 */
public class WordPattern 
{
    public static void main(String[] args) 
    {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));
        
    }
    public boolean wordPattern(String pattern, String str)
    {                                
        Map<String,String> patternToStrMap = new HashMap<>();
        
        boolean matched=false;
        int i,j;
        String currentPattern;
        String currentStr;
        
        String strTransformed="";
        StringTokenizer stringTokenizer;
        
        if(!(pattern.isEmpty() || str.isEmpty()))
        {        
            stringTokenizer = new StringTokenizer(str);
            if(stringTokenizer.countTokens()!=pattern.length())
                matched=false;
            else
            {
                for(i=0;i<pattern.length();i++)
                {
                    currentPattern=String.valueOf(pattern.charAt(i));
                    currentStr=stringTokenizer.nextToken();
                    if(patternToStrMap.isEmpty())                
                        patternToStrMap.put(currentPattern,currentStr);                                    
                    else
                    {
                        j=0;
                        for(String patternString:patternToStrMap.keySet())
                        {

                            if(patternString.equals(currentPattern))
                                break;
                            j++;
                        }
                        if(j==patternToStrMap.size())                    
                        {
                            j=0;
                            for(String strString:patternToStrMap.values())
                            {
                                if(strString.equals(currentStr))
                                    break;
                                j++;
                            }
                            if(j==patternToStrMap.size())
                                patternToStrMap.put(currentPattern,currentStr);
                        }

                    }                
                }            
                for(i=0;i<pattern.length();i++)
                {
                    currentPattern=String.valueOf(pattern.charAt(i));
                    if(patternToStrMap.containsKey(currentPattern))
                        strTransformed=strTransformed.concat(patternToStrMap.get(currentPattern)).concat(" ");                                        
                }
                matched=strTransformed.trim().equals(str);                                    
            }               
        }
        return matched;
    }
    
}
