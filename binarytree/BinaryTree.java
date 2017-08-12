/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.binarytree;

/**
 *
 * @author 904935
 */
public class BinaryTree 
{
    private BinaryTree leftChild;
    private BinaryTree rightChild;
    private Object content;
    
    public BinaryTree(Object content)
    {
        this.content=content;
    }
    public static void preOrder(BinaryTree binaryTree)
    {
        if(binaryTree!=null)
        {
            System.out.print(binaryTree.getContent()+" -> ");
            if(binaryTree.getLeftChild()!=null)
                preOrder(binaryTree.getLeftChild());            
            if(binaryTree.getRightChild()!=null)
                preOrder(binaryTree.getRightChild());
        }
    }
    public static void inOrder(BinaryTree binaryTree)
    {
        if(binaryTree!=null)
        {
            if(binaryTree.getLeftChild()!=null)
                inOrder(binaryTree.getLeftChild());
            System.out.print(binaryTree.getContent()+" -> ");
            if(binaryTree.getRightChild()!=null)
                inOrder(binaryTree.getRightChild());
        }
    }
    public static void postOrder(BinaryTree binaryTree)
    {
        if(binaryTree!=null)
        {
            if(binaryTree.getLeftChild()!=null)
                postOrder(binaryTree.getLeftChild());            
            if(binaryTree.getRightChild()!=null)
                postOrder(binaryTree.getRightChild());
            System.out.print(binaryTree.getContent()+" -> ");
        }
    }
    
    public Object getContent() {
        return content;
    }
    public void setContent(Object content) {
        this.content = content;
    }

    public BinaryTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTree leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTree rightChild) {
        this.rightChild = rightChild;
    }
    
    
    
}
