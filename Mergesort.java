/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mario Alberto Morales
 */
public class Mergesort {
    public static void main(String[] args) {
        System.out.println(mergesort(new ArrayList<>(Arrays.asList(5,1,2,4)), 0, 3));
    }
    private static List<Integer> mergesort(List<Integer> unsortedArray, int init, int end) {
        int middle = end / 2;
        if(init != middle) {
            mergesort(unsortedArray, init, middle);
            mergesort(unsortedArray, middle + 1, end);
        }
        return null;
        
    }
    
}
