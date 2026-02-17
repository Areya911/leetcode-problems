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

    public void removeFirst(){
        if(length==0) return null; 
        Node temp=head;
        head=head.next; // update head reference to next node
        temp.next=null;
        length--;
        //if real length=1, after removal list becomes empty, so tail should also be null
        if(length==0){
            tail=null;
        } //return temp;
    }

    public Node get(int index){
        if(index<0 ||index>=length) return null;
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        } //return temp
    }

    public boolean Set(int index,int value){
        Node temp=get(index); //get method returns node at index
        if(temp==null) return false;
        else{
            temp.value=value; //update value of node at index to new value
            return true;
        } 
    }
    public Node remove(int index){
        if(index=0 || index>=length) return null;
        if(index==0) return removeFirst();
        if(index==length-1) return removeLast();
        Node prev=get(index-1);
        Node temp=prev.next;
        prev.next=temp.next;
        temp.next=null;
        length--;
        return temp;
    }
    public void reverse(){
        Node temp=head;
        head=tail;
        tail=temp;
        Node after=temp.next;
        Node before=null;
        for(int i=0;i<length;i++){
            after=temp.next;
            temp.next=before;
            before=temp;
            temp=after;
        }
    }

    
        // 1) Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; //slow is now at the middle node
}
