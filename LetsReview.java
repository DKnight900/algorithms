/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;

/**
 *
 * @author 904935
 */
public class LetsReview {
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();        
        String theString;
        String evenIndexString;
        String oddIndexString;
        
        for(int i=0;i<T+1;i++)
        {            
            evenIndexString="";
            oddIndexString="";                    
            theString=s.nextLine();
            for(int j=0;j<theString.length();j++)
            {
                if(j==0 || j%2==0)
                    evenIndexString+=theString.charAt(j);
                else
                    oddIndexString+=theString.charAt(j);
            }
            System.out.print(evenIndexString+" ");
            System.out.println(oddIndexString);
        }
        
    }
}
