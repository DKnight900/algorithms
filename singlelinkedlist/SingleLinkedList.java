package singlelinkedlist;

import datastructures.Node;
import datastructures.MyList;


/**
 *
 * @author DKnight900
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
