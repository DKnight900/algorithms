/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import algorithms.binarytree.BinaryTree;
import algorithms.doublelinkedlist.DoubleLinkedList;
import algorithms.singlelinkedlist.SingleLinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author 904935
 */
public class MainDataStructures 
{
    public static void main(String[] args) 
    {                                        
        System.out.println("======SingleLinkedList======");
        singleLinkedList();
        System.out.println("======DoubleLinkedList======");
        doubleLinkedList();                
        System.out.println("======BinaryTree======");
        binaryTree();
    }    
    public static void binaryTree()
    {
        BinaryTree binaryTree = new BinaryTree("F");
        
        binaryTree.setLeftChild(new BinaryTree("B"));
        binaryTree.setRightChild(new BinaryTree("G"));
        
        binaryTree.getRightChild().setRightChild(new BinaryTree("I"));
        binaryTree.getRightChild().getRightChild().setLeftChild(new BinaryTree("H"));
        
        binaryTree.getLeftChild().setLeftChild(new BinaryTree("A"));
        binaryTree.getLeftChild().setRightChild(new BinaryTree("D"));
        
        binaryTree.getLeftChild().getRightChild().setLeftChild(new BinaryTree("C"));
        binaryTree.getLeftChild().getRightChild().setRightChild(new BinaryTree("E"));
        
        System.out.println("======InOrder======");
        BinaryTree.inOrder(binaryTree);
        System.out.println("\n======PostOrder======");
        BinaryTree.postOrder(binaryTree);
        System.out.println("\n======PreOrder======");
        BinaryTree.preOrder(binaryTree);
    }
    public static void singleLinkedList()
    {
        MyList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        singleLinkedList.add(5);
        
        System.out.println(singleLinkedList);
        singleLinkedList.remove(4);
        singleLinkedList.remove(1);
        singleLinkedList.remove(2);
        singleLinkedList.remove(3);
        System.out.println(singleLinkedList);
        singleLinkedList.add(1);
        singleLinkedList.add(4);
        singleLinkedList.add(3);
        singleLinkedList.add(2);
        System.out.println(singleLinkedList);
        singleLinkedList.remove(2);
        singleLinkedList.remove(3);
        System.out.println(singleLinkedList);
    }
    public static void doubleLinkedList()
    {
        MyList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
        doubleLinkedList.add(3);
        doubleLinkedList.add(4);
        doubleLinkedList.add(5);
        
        System.out.println(doubleLinkedList);
        doubleLinkedList.remove(4);
        doubleLinkedList.remove(1);
        doubleLinkedList.remove(2);
        doubleLinkedList.remove(3);
        System.out.println(doubleLinkedList);
        doubleLinkedList.add(1);
        doubleLinkedList.add(4);
        doubleLinkedList.add(3);
        doubleLinkedList.add(2);
        System.out.println(doubleLinkedList);
        doubleLinkedList.remove(2);
        doubleLinkedList.remove(3);
        System.out.println(doubleLinkedList);
    }
    
}
