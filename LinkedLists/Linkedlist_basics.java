package LinkedLists;

public class ll basic {
    //printing elements of linked list
    public void printList(Node head){
        Node curr= head;
        while(curr!=null){
            System.out.println(curr.value);
            curr=curr.next;
        }
    }
    
    public void append(int value){
        if(length==0){
            head=new Node(value);
            tail=head; //both point to same node as it has only one node
        }
        tail.next=new Node(value);
        tail=newNode; //update tail reference to new node
        length++; //increase length
    }
     
    public void removeLast(){
        if(length==0) return;
        Node temp=head;
        Node prev=head;
        while(temp.next!=null){
            prev=temp;
            temp=temp.next;
        }
        tail=prev; // executes when temp.next==null
        tail.next=null;
        length--;
        if(length==0){ // if list contained 1 element and becomes empty after removal
            head=null;
            tail=null;
        }
    }

    public void prepend(){
        if(length==0){
            head=newNode;
            tail=head;
        }
        newNode.next=head;
        head=newNode;
        length++;
    }
}
