import java.io.File;
import java.util.*;

public class CS6085Aashikari {

	// A Linked List class with a private static inner Node class.     
		private static class Node     
		{        
			private int data;        
			private Node next; 
	 
	       public Node(int data, Node next)        
	       {           
	    	   this.data = data;           
	    	   this.next = next;        
	    	   }     
	       }      
		private Node head; 
	 
	   // Constructs an empty list      
		public CS6085Aashikari()    
		{       
			head = null;    
		}    
		// Returns true if the list is empty otherwise returns false        
		public boolean isEmpty()    
		{       
			return (head == null);    
			}    
		// Inserts a new node at the beginning of this list. 
	 
	   public void insertAtBeginning(int element)    
	   {       
		   head = new Node(element, head);    
		   }   
	   //  Returns the first element in the list
	
	   public int getFirstElement()    
	   {     
		   if(head == null) {      
			   System.out.println("Empty linked list");      
			   throw new IndexOutOfBoundsException();     
		   } 
	   
	      return head.data;    
	      }   
	   // Removes the first node in the list. 
	 
	   public int removeFirstNode()   
	   {       
		   int tmp = getFirstElement();       
		   head = head.next;       
		   return tmp;    
		   }   
	 
	 // Empties linked list    
	   public void clear()   
	   {       
		   head = null;    
		   } 
	 
	 // Returns the length of the linked list  
	 
	   public static int LLlength(Node head){     
		   int length = 0;     Node currentNode = head;     
		   while(currentNode != null){      length++;      
		   currentNode = currentNode.next;     
		   }     
		   return length;    
		   } 
	 
	   // Displays the linked list elements        
	   public static void display(Node head){     
		   if(head == null) {      
			   System.out.println("Empty linked list");      
			   throw new IndexOutOfBoundsException();     
			   }
	
		   Node currentNode = head;     
		   while(currentNode != null){      
			   System.out.print(currentNode.data+"  ");      
			   currentNode = currentNode.next;     
		   }
		   System.out.println("");
	   } 

   // Displays the linked list elements in reverse order     
	public static void displayReverse(Node head){      
		if(head == null){}      
		else{       
			Node currentNode = head;       
			displayReverse(currentNode.next);        
			System.out.print(currentNode.data+"  ");              
		}
	}
	
	   public static void displayLastNum(Node head){     
		   if(head == null) {      
			   System.out.println("Empty linked list");      
			   throw new IndexOutOfBoundsException();     
			   }
	
		   Node currentNode = head;
		   
		   while(currentNode != null){      
			      
			   if(currentNode.next == null) {
				   
				   System.out.println("The last number in the linked list is " + currentNode.data);
				   
			   }
			   
			   currentNode = currentNode.next;
			   				   
		   }
	   }
	
	 public void addToEnd(int add) {
		 
		 if(head == null){
			 
			 head = new Node(add, head);
			 
		 }else {
			 
			 Node currentNode = head;
			 while (currentNode.next != null) {
			 
				 currentNode = currentNode.next;
			 
			 }
			 
			 currentNode.next = new Node (add, currentNode.next);			 
			 
		 }
		 
	 }
	 
	 public static boolean searchFor(Node head, int num) 
	    { 
	        Node currentNode = head;    //Initialize current 
	        while (currentNode != null) 
	        { 
	            if (currentNode.data == num) 
	                return true;    //data found 
	            currentNode = currentNode.next; 
	        } 
	        return false;    //data not found 
	    } 
	
	public static void main(String[] args)  throws Exception  {  
		
		Scanner file = new Scanner(new File("dataForLinkedList.txt"));
		 
		CS6085Aashikari nums = new CS6085Aashikari();
		
		int i = 0;
		int line2 = 0;
		int line3 = 0;
		int line4 = 0;
		
		while(file.hasNext())
		{
			
			i = file.nextInt();
			
			if (i == 0) {
				
				line2 = file.nextInt();
				line3 = file.nextInt();
				line4 = file.nextInt();
				
			}else {
			
		     nums.addToEnd(i);		     
		     
			}
		     
						
		}				
		
		//display/print linked list
		
		display(nums.head);
		
		//print the size of the linked list
		
		//System.out.println(count);
		System.out.println("The length of the linked list is " + LLlength(nums.head));
		
		//search for the number on the second line of the file
		//print whether it has been found or not
		
		if (searchFor(nums.head, line2) == true) {
			
			System.out.println("The number " + line2 + " has been found within the linked list!");
			
		}else {
			
			System.out.println("The number " + line2 + " could not be found within the linked list!");
			
		}
		
		//System.out.println(searchFor(nums.head, line2));
		
		//print the last element of the list
		
		displayLastNum(nums.head);
		
		//insert the integer from the 3rd line of the file
		//at the front of the list
		
		nums.insertAtBeginning(line3);
		
		//display the linked list again with the new elements
		
		display(nums.head);
		
		//insert the integer on the 4th line at the end of the list
		
		nums.addToEnd(line4);
		
		//display the linked list once again
		
		display(nums.head);
		
		file.close();
		
		} 
		
	}
	

