/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Mario Alberto Morales
 */
public class SumTwoArrays {
    public static void main(String[] args) {                        
        System.out.println(sumTwoArrays(new int[]{8,5,3,9,6}, new int[]{3,3,3,3,3}));
        System.out.println(sumTwoArrays(new int[]{3,3,3,3,3}, new int[]{8,5,3,9,6}));
    }
    private static Deque<Integer> sumTwoArrays(int[] a, int[] b) {
        int lengthA = a.length;
        int lengthB = b.length;        
        
        Deque<Integer> sums = new ArrayDeque<>();
        int carry = 0;
        int maxLength = lengthA > lengthB ? lengthA : lengthB;        
        
        
        for (int i = maxLength - 1; i >= 0; i --) {
            int sum = carry + a[i] + b[i];
            if(sum > 9) {
                carry = 1;
                sums.push(sum - 10);
            }
            else {
                carry = 0;
                sums.push(sum);
            }                
        }
        
        if (carry == 1) {
            sums.push(1);
        }
        return sums;
    }
}
