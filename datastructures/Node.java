package datastructures;

/**
 *
 * @author DKnight900
 */
public class Node 
{
    private Node nextNode;
    private Node previousNode;
    private Object content;
    
    public Node()
    {}
    public Node(Object content)
    {
        this.content=content;               
    }
    public boolean hasNext()
    {
        return this.nextNode!=null;
    }
    public boolean hasPrevious()
    {
        return this.previousNode!=null;
    }
    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
