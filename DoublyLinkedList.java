/**
 * NAME: TENZIN NGAWANG
 * PROJECT: CSCI-313 PROJECT 1, FALL 2016
 * DATE: 20TH OCTOBER 2016
 * PROFESSOR: DR. SVITAK 
 * DESCRIPTION: THIS PROJECT READ A VECTOR FROM TEXT FILE AND INSERT IN TO DOUBLYLINKEDLIST AND DO OPERATION AS INSTRUCTED.
 */
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class DoublyLinkedList<AnyType> implements List<AnyType>
{
  private static class Node<AnyType>
  {
    private AnyType data;
    private Node<AnyType> prev;
    private Node<AnyType> next;

    public Node(AnyType d, Node<AnyType> p, Node<AnyType> n)
    {
      setData(d);
      setPrev(p);
      setNext(n);
    }

    public AnyType getData() { return data; }

    public void setData(AnyType d) { data = d; }

    public Node<AnyType> getPrev() { return prev; }

    public void setPrev(Node<AnyType> p) { prev = p; }

    public Node<AnyType> getNext() { return next; }

    public void setNext(Node<AnyType> n) { next = n; }
  }

  private int theSize;
  private int modCount;
  private Node<AnyType> header;
  private Node<AnyType> trailer;

  public DoublyLinkedList()
  {
    header = new Node<AnyType>(null, null, null);
    trailer = new Node<AnyType>(null, null, null);
    modCount = 0;
    clear();
  }

  public void clear()
  {
    header.setNext(trailer);
    trailer.setPrev(header);
    theSize = 0;
  }

  public int size()
  {
    return theSize;
  }

  public boolean isEmpty()
  {
    return (size() == 0);
  }
  
  protected void checkIndex(int i, int n) throws IndexOutOfBoundsException
  {
	  //while(size()!=0)
		  if (i<0 || i >n) throw new IndexOutOfBoundsException ("Illegal index: " +i);
  }

  public AnyType get(int index)
  {
	  /*
	  Node<AnyType> currNode = header.getNext();
	  
	  while(currNode !=null)
	  {
		  if(currNode.getIndex()== index)
		  {
			  // return currNode.getElemtn();
			  //break
			  //return
		  }else
		  {
			  currNode = currNode.getNext();
		  }
	  }
	  
	  return null;
	  */
	  
	  checkIndex(index,size());
	  return (getNode(index).getData());
  }

  

public AnyType set(int index, AnyType newValue)
  {
    checkIndex(index,size());
    AnyType oldValue = getNode(index).data;
    getNode(index).data = newValue;
    return oldValue;
    
  }

  public boolean add(AnyType newValue)
  {
    add(size(), newValue);
    return true;
  }

  public void add(int index, AnyType newValue)
  {
    checkIndex(index,size());
    Node<AnyType> currNode;
    /*
    Node<> currNode = header.getNext();
    
    while(currNode !=null)
    {
    	if(currNode.getIndex()== index)
    	{
    		//insert node at this location
    		//return]
    		// if you ahve more code, then use break;
    	}else
    	{
    		currNode = currNode.getNext();
    	}
    	
    }*/
    
    
    currNode = header.getNext();
    for(int i=0; i<index;i++)
    {
    	currNode = currNode.getNext();
    }
    Node<AnyType> newNode = new Node<>(null,null,null);
//    newNode.setData(currNode.getData());
    newNode.setPrev(currNode.getPrev());
    currNode.getPrev().setNext(newNode);
    newNode.setNext(currNode);
    currNode.setPrev(newNode);
    newNode.setData(newValue);
    
    theSize++;
    
    
  }

  public AnyType remove(int index)
  {
    return remove(getNode(index));
  }

  public Iterator<AnyType> iterator()
  {
    return new LinkedListIterator();    
  }

  private Node<AnyType> getNode(int index)
  {
    return getNode(index, 0, size()-1);
  }

  private Node<AnyType> getNode(int index, int lower, int upper)
  {
    checkIndex(index,upper);
    Node<AnyType> currNode = new Node<>(null,null,null);
    currNode = header.getNext();
    for(int i=0; i<index;i++)
    	currNode = currNode.getNext();
    //remove(currNode);
    
    return currNode;
    
  }

  private AnyType remove(Node<AnyType> currNode)
  {
//	  currNode = header.getNext();
//    for(int i=0;i<size();i++)
//    	currNode = currNode.getNext();
//    
    currNode.getPrev().setNext(currNode.getNext());
    currNode.getNext().setPrev(currNode.getPrev());
    theSize--;
   // System.out.print(currNode.getData());
    return (currNode.getData());
    
  }

  private class LinkedListIterator implements Iterator<AnyType>
  {
    private Node<AnyType> current;
    private int expectedModCount;
    private boolean okToRemove;

    LinkedListIterator()
    {
      current = header.getNext();
      expectedModCount = modCount;
      okToRemove = false;
    }

    public boolean hasNext()
    {
      return (current != trailer);
    }

    public AnyType next()
    {
      if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
      if (!hasNext())
        throw new NoSuchElementException();

      AnyType nextValue = current.getData();
      current = current.getNext();
      okToRemove = true;
      return nextValue;
    }

    public void remove()
    {
      if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
      if (!okToRemove)
        throw new IllegalStateException();

      DoublyLinkedList.this.remove(current.getPrev());
      expectedModCount++;
      okToRemove = false;
    }
    
  }
}
