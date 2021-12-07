package doublelinkedlist;


import datastructures.MyList;
import datastructures.Node;

/**
 *
 * @author DKnight900
 *
 */
public class DoubleLinkedList<K>  implements MyList<K>
{
    private Node initNode;
    private Node lastNode;
    
    @Override
    public void add(K content)
    {
        Node newNode = new Node(content);
        
        if(initNode == null)
            initNode = newNode;
        else
        {
            if(!initNode.hasNext())
            {
                initNode.setNextNode(newNode);
                initNode.getNextNode().setPreviousNode(initNode);
                lastNode=initNode.getNextNode();
            }
            else
            {
                lastNode.setNextNode(newNode);
                lastNode.getNextNode().setPreviousNode(lastNode);
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
            do
            {
                if(currentNode.getContent().equals(content))
                {
                    if(currentNode.getPreviousNode() == null)//init node
                    {                        
                        if(currentNode.getNextNode() != null)
                        {
                            initNode = currentNode.getNextNode();
                            currentNode.getNextNode().setPreviousNode(null);
                            currentNode.setNextNode(null);                            
                        }                        
                    }
                    else if(currentNode.getNextNode() == null)//last node
                    {
                        lastNode=currentNode.getPreviousNode();
                        currentNode.getPreviousNode().setNextNode(null);
                        currentNode.setPreviousNode(null);                        
                    }
                    else//middle node
                    {
                        currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
                        currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
                        currentNode.setNextNode(null);
                        currentNode.setPreviousNode(null);                        
                    }
                    currentNode = null;
                }
                if (currentNode != null)
                    currentNode = currentNode.getNextNode();
            } while(currentNode != null);
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
