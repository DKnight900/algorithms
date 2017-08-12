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
 * @author DKnight900
 */
public class HeapSort {
    public static void main(String[] args) {
                       
        System.out.println(heapSort((new ArrayList<>(Arrays.asList(4, 1, 3, 2, 16, 9, 10, 14, 8, 7)))));                
    }
    private static List<Integer> heapSort(List<Integer> unsortedArray) {
        List<Integer> sortedArray; 
        List<Integer> maxHeap;
        
        maxHeap = buildMaxHeap(unsortedArray);
        sortedArray = new ArrayList<>(maxHeap);                
        
        for (int i = 0; i < sortedArray.size(); i++) {                        
            sortedArray.set(sortedArray.size() - i - 1, maxHeap.get(0));   
            
            maxHeap.set(0, maxHeap.get(maxHeap.size() - 1));
            maxHeap.remove(maxHeap.size() - 1);            
            maxHeap = maxHeapify(maxHeap, 0);
        }
        return sortedArray;
    }
    private static List<Integer> buildMaxHeap(List<Integer> heap) {
        for (int i = (heap.size() / 2) - 1; i >= 0; i--) {
            heap = maxHeapify(heap, i);
        }
        return heap;
    }
    private static List<Integer> maxHeapify(List<Integer> heap, int index) {        
        int left;
        int right; 
        
        right = Integer.MIN_VALUE;
        
        if (index * 2 >= heap.size() || heap.size() == 1) {
            return heap;
        }
        
        left = heap.get((index * 2) + 1);
        
        if ((heap.size() / 2) - 1 == index) {            
            
            if(heap.size() % 2 != 0) {
                right = heap.get((index * 2) + 2);
            }                        
        }
        else {
            right = heap.get((index * 2) + 2);
        }
        int current = heap.get(index);
        int max = Math.max(left, Math.max(right, current));
        if (max == current) {
            return heap;
        }
        else if(max == left) {
            heap.set(index, left);
            heap.set((index * 2) + 1, current);
            return maxHeapify(heap, (index * 2) + 1);            
        }
        else {
            heap.set(index, right);
            heap.set((index * 2) + 2, current);
            return maxHeapify(heap, (index * 2) + 2);
        }                
        
    }
}
