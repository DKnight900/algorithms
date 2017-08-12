/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.singlelinkedlist;

import algorithms.Node;
import algorithms.MyList;


/**
 *
 * @author 904935
 * @param <K>
 */
public class SingleLinkedList<K>  implements MyList<K>
{
    private Node initNode;
    private Node lastNode;
    
    @Override
    public void add(K content)
    {
        Node newNode = new Node(content);
        
        if(initNode==null)
            initNode=newNode;
        else
        {
            if(!initNode.hasNext())
            {
                initNode.setNextNode(newNode);
                lastNode=initNode.getNextNode();
            }
            else
            {
                lastNode.setNextNode(newNode);
                lastNode=lastNode.getNextNode();            
            }
        }
    }
    @Override
    public void remove(K content)
    {
        Node currentNode = initNode;
        if(currentNode!=null)
        {
            boolean alreadyFinded=false;
            Node previousNode=null;
            do
            {
                if(currentNode.getContent().equals(content))
                {
                    if(currentNode==initNode)                   
                        initNode=currentNode.getNextNode();                        
                    else if(currentNode==lastNode)
                    {
                        lastNode=previousNode;
                        previousNode.setNextNode(null);                                                
                    }
                    else
                    {                        
                        previousNode.setNextNode(currentNode.getNextNode());
                        currentNode.setNextNode(null);                        
                    }
                    currentNode=null;
                }
                if(currentNode!=null)
                {
                    previousNode=currentNode;
                    currentNode=currentNode.getNextNode();
                }
            }while(currentNode!=null);
        }        
    }
    @Override
    public String toString() 
    {
        String list="";
        Node currentNode = initNode;
        if(currentNode==null)
            list="Empty list";
        else
        {
            do
            {                                
                list=list.concat(currentNode.getContent().toString()+" -> ");                                
                currentNode=currentNode.getNextNode();
            }while(currentNode!=null);
        }
        
        return list;
    }    
}
