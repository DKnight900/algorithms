/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.hackerrank;

import java.util.Scanner;

/**
 *
 * @author 904935
 */
public class TheGridSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();                
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            int index;
            String contained="NO";
            outsiderFor:for(int i=0;i<R;i++)
            {      
                
                for(int k=0;k<C;k++)
                {                    
                    if((index=G[i].indexOf(P[0],k))!=-1)
                    {           
                        for(int j=1;j<r;j++)
                        {
                            if(G[i+j].indexOf(P[j],k)==index)
                            {
                                if(j==(r-1))
                                {
                                    contained="YES";
                                    break outsiderFor;
                                }
                                    
                            }
                            else
                                break;
                        }
                        if(index!=-1)
                            k=index;                        
                    }                                
                }
            }
            System.out.println(contained);                                    
        }
    }
}
