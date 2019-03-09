
package edu.iastate.cs228.hw08;



import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
/**
 * 
 * 
 * A class that implements the ADT dictionary by using a chain of nodes.
 * The dictionary is unsorted and has distinct search keys, i.e., can have 
 * duplicate values, however, those are differentiated based on their keys.
 * 
 * @author Vismay Gehlot
 * 
 * NOTEs and REQUIREMENTs:
 * 
 * Exactly same as the ones listed for SortedVectorDictionary class.
 * 
 * In addition to above ANSWER the following 6 QUESTIONS, inside these 
 * comments right below each question. Figures needed to answer questions
 * 3, 4, and 5 are shown on Canvas under description of HW08.
 * 
 * =========================================================================
 * Q1. (a) What is the height of the shortest binary tree that contains 22
 *     nodes? (b) Is this tree full? (c) Is it balanced?
 *     
 * A1. (a) 	5
 *     (b)	no
 *     (c)	yes
 * =========================================================================
 * Q2. Consider a binary tree that has four levels.
 *     (a) What is the maximum number of nodes in this tree?
 *     (b) What is the maximum number of leaves in this tree?
 *     
 * A2. (a)	15
 *     (b)	8
 * =========================================================================
 * Q3. Consider a traversal of a binary tree, which contains Integer data. 
 *     Suppose that visiting a node means to simply display the data in the 
 *     node. What are the results of each of the following traversals of the 
 *     binary tree shown in Figure 1.
 *     (a) Preorder
 *     (b) Postorder
 *     (c) Inorder
 *     (d) Level order
 *     
 * A3. (a) 	6, 4, 2, 1, 3, 5, 8, 7, 9, 10, 11
 *     (b)	1, 3, 2, 5, 4, 9, 7, 11, 10, 8, 6
 *     (c)	1, 2, 3, 4, 5, 6, 7, 9, 8, 10, 11
 *     (d)	6, 4, 8, 2, 5, 7, 10, 1, 3, 9, 11
 *     
 * =========================================================================
 * Q4. Repeat Q3 but for the binary tree shown in Figure 2. 
 * A4. (a)	11, 8, 3, 2, 1, 5, 4, 6, 10, 9, 7
 *     (b)	2, 1, 3, 4, 6, 5, 8, 9, 7, 10, 11
 *     (c)	2, 3, 1, 8, 5, 4, 6, 11, 9, 10, 7
 *     (d)	11, 8, 10, 3, 5, 9, 7, 2, 1, 4, 6
 *  
 * =========================================================================
 * Q5. The two binary trees shown in Figures 1 and 2 contain Integer data.
 *     (a) Is the tree in Figure 1 a binary search tree? Why or why not?
 *     (b) Is the tree in Figure 2 a maxheap? Why or why not?
 *  
 * A5. (a)	yes, because for each parent node, the child node on the left
 * 			will be less than the parent, and the child node on the right
 * 			will be greater than the parent. This holds true for the entire
 * 			tree.
 *     (b)	no, because while everything else in the tree follows the maxheap
 *     		criteria, in one of the lowest nodes, the child node (6) is greater
 *     		than it's parent node (5).
 *     
 * =========================================================================
 * Q6. Can a binary search tree ever be a maxheap? Explain.
 * A6.     	No, because in order for a tree to be a binary search tree, the child
 * 			node on the right side of the parent node must be greater than the 
 * 			parent node, while for a maxheap, both child nodes must be less than
 * 			the parent node.             
 *     
 *     
 *     
 *     
 *     
 *     
 */
public class LinkedDictionary<K, V> implements DictionaryInterface<K, V>
{
 private Node firstNode;   // Reference to first node of chain
 private int  numberOfEntries; 
	
 public LinkedDictionary()
 {
  firstNode = null;
  numberOfEntries = 0;
 }
	
 public V add(K key, V value)
 {
	if(Objects.isNull(key) || Objects.isNull(value))
	{
		throw new IllegalArgumentException();
	}
  	
  	if (firstNode == null)
  	{
  		firstNode = new Node (key, value);
  		numberOfEntries++;
  		return null;
  	}
  	
  	Node tempNode = firstNode;
  	V val = null;
  	Node node = new Node (key, value);
  	
  	for (int i = 0; i < getSize(); i++)
  	{
  		if (tempNode.key == key)
  		{
  			val = tempNode.value;
  			tempNode.value = value;
  			return val;
  		}
  		tempNode = tempNode.next;
  	}
  	
  	node.next = firstNode;
  	numberOfEntries++;
  	
  	return null;
 }

 public V remove(K key)
 {
  if(Objects.isNull(key))
	throw new IllegalArgumentException();
  
  Node tempNode = firstNode;
  Node prevNode = null;
  V val = null;
  
  while(tempNode != null)
  {
	  if (tempNode.key == key)
	  {
		  val = tempNode.value;
		  numberOfEntries--;
		  
		  if (tempNode == firstNode)
		  {
			  firstNode = firstNode.next;
			  return val;
		  }
		  
		  prevNode = tempNode;
		  tempNode = tempNode.next;
	  }
	  
	  prevNode = tempNode;
	  tempNode = tempNode.next;
  }
  return null;  
 }

 public V getValue(K key)
 {
	if(Objects.isNull(key))
		throw new IllegalArgumentException();
	
	Node tempNode = firstNode;
	V val = null;
	
	for (int i = 0; i < getSize(); i++)
  	{
  		if (tempNode.key == key)
  		{
  			val = tempNode.value;
  			return val;
  		}
  		tempNode = tempNode.next;
  	}
  
  	return null;
 }

 public boolean contains(K key)
 {
  if(Objects.isNull(key))
	throw new IllegalArgumentException();
		   
  	Node tempNode = firstNode;

	
	for (int i = 0; i < getSize(); i++)
	{
		if (tempNode.key == key)
		{
			return true;
		}
		tempNode = tempNode.next;
	}
	   
  return false; 
 }

 public boolean isEmpty()
 {
	 if (firstNode == null)
	 {
		 return true;
	 }
	 return false;
 }
	
 public int getSize()
 {
	 return numberOfEntries;
 }

 public void clear()
 {
	 firstNode = null;
	 numberOfEntries = 0;
 }

 // Needs to output String representation in exact same
 // format as the one done by SortedVectorDictionary.
 public String toString()
 {
	 Node tempNode = firstNode;
	 String temp = "";
	 
	 for (int i = 0; i < getSize() - 1; i++)
		{
			temp += tempNode + ",";
			tempNode = tempNode.next;
		}
	 
	 return "[" + temp + tempNode + "]";
 }

 public Iterator<K> getKeyIterator()
 {
  return new KeyIterator();
 }
	
 public Iterator<V> getValueIterator()
 {
  return new ValueIterator();
 }

 private class KeyIterator implements Iterator<K>
 {
  private Node nextNode;
		
  private KeyIterator()
  {
	  nextNode = firstNode;
  }
		
  public boolean hasNext() 
  {
	  if (nextNode == null)
	  {
		  return false;
	  }
	  return true;
  }
		
  public K next()
  {
	  if (!hasNext())
	  {
		  throw new NoSuchElementException();
	  }
	  
	  K key = null;
	  
	  key = nextNode.key;
	  nextNode = nextNode.next;
	  
	  return key;
  }
 } 
	
 private class ValueIterator implements Iterator<V>
 {
  private Node nextNode;
  		
  private ValueIterator()
  {
	  nextNode = firstNode;
  }
		
  public boolean hasNext() 
  {
	  if (nextNode == null)
	  {
		  return false;
	  }
	  return true;
  }
		
  public V next()
  {
	  if (!hasNext())
	  {
		  throw new NoSuchElementException();
	  }
	  
	  V val = null;
	  
	  val = nextNode.value;
	  nextNode = nextNode.next;
	  
	  return val;
  }
 }

 private class Node
 {
  private K key;
  private V value;
  private Node next;

  private Node(K searchKey, V dataValue)
  {
   key = searchKey;
   value = dataValue;
   next = null;	
  }
		
  private Node(K searchKey, V dataValue, Node nextNode)
  {
   key = searchKey;
   value = dataValue;
   next = nextNode;	
  }
		
  private K getKey()
  {
   return key;
  }
		
  private V getValue()
  {
   return value;
  }

  private void setValue(V newValue)
  {
   value = newValue;
  }

  private Node getNextNode()
  {
   return next;
  }
		
  private void setNextNode(Node nextNode)
  {
   next = nextNode;
  }
  
  public String toString()
  {
   return "("+key+":"+value+")";	
  }
 }
}
		
