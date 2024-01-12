import java.util.Scanner;

class LinkedList { 

    Node head;  
      
    static class Node { 
        int data; 
        Node next; 
  
        Node(int d){
            data = d; 
            next=null;
        } 
    } 

   //Insert node at the beginning of the list 
   public static LinkedList insert_start(LinkedList list, int data) 
    { 
        // We create the new node 
        Node newNode = new Node(data); 
  
        //Now we link the node to the list 
        newNode.next=list.head;
        list.head=newNode;

       // Return the modified list 
        return list; 
    } 
  
    //Display the content of the linked list 
    public static void printList(LinkedList list) 
    { 
        Node tmp = list.head; 
        if(tmp!=null)
         {
           System.out.println("The content of the list is:");
           // Traverse the list 
           while (tmp != null) { 
            // Print the data at current node 
            System.out.print(tmp.data); 
   
            // Move to next node 
            tmp = tmp.next; 
            if(tmp!= null)
                   System.out.print("->");
        } 
        System.out.println("");
        }
        else
           System.out.println("The list is empty");
    } 
   
    //Delete the first element with data part equal to x
    public static LinkedList delete(LinkedList list, int x)
   {
     Node tmp=list.head;
     Node prev;

     if(tmp==null)
         {System.out.println("There is nothing to delete");
         return list; }
      else
      {

         //Case 1: x is found in the first node
         if(tmp.data==x)
         {
          list.head=tmp.next; //head points to the second element
          return list;
         }

         else   //Case 2: X is not in the first position, we must keep searching
         {
         prev=tmp;
         tmp=tmp.next;
         while(tmp!=null)
          {
             if(tmp.data==x)
              {
                 prev.next=tmp.next;
                 return list;
               }
             prev=tmp;
             tmp=tmp.next;
           }   
          }
         System.out.println("Element not found");
        return list;
    }

}


   
    public static void main(String[] args) 
    { 
        //create a new list
        LinkedList list = new LinkedList(); 

        //Create variable to read from keyboard
        Scanner in=new Scanner(System.in);
        int option, x;
        
        
        do
       {
         System.out.println("Select your option:");
         System.out.println("0: Quit the programme");
         System.out.println("1: Insert an element to the beginning of the list");
         System.out.println("2: Delete an element to the list");
         System.out.println("3: Print the content of the list");
    
         option=in.nextInt();
         if(option==1)
         {
           System.out.println("What number do you want to insert?");
           x=in.nextInt();
           list=insert_start(list, x);
           printList(list);
         }

         if(option==2)
         {
           System.out.println("What number do you want to delete?");
           x=in.nextInt();
           list=delete(list, x);
           printList(list);
         }
         
         if(option==3)
             printList(list);

         if(option==0)
            System.out.println("Good bye!");



       } while(option!=0);

    } 
} 
