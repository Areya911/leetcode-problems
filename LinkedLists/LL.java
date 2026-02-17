// Linked Lists (8 Questions)
// 1.206. Reverse Linked List:
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // iterative , here we we just reverse the direction of the pointers, we don't change the values of the nodes
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
// 2.21. Merge Two Sorted Lists

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        ListNode headNode=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                dummy.next=list1;
                list1=list1.next;
            }else{
                 dummy.next=list2;
                list2=list2.next;
            }
            dummy=dummy.next;
        }
        if(list1!=null)  dummy.next=list1;
        if(list2!=null)  dummy.next=list2;
        return headNode.next;
    }
}

// 3.19. Remove Nth Node From End of List
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy= new ListNode(0); 
        dummy.next=head; //
        // we use 2 pointers, one fast and one slow
        ListNode fast=dummy; 
        ListNode slow=dummy;
    
        for(int i=0;i<=n;i++){ //1->2->3->4->5, n=2, we want to remove 4
            fast=fast.next;   // then fast will be at 3
        }   
        while(fast!=null){ //fast reaches null and slow will be at 3, we want to remove 4, so we need to change the next pointer of 3 to point to 5
            fast=fast.next;
            slow=slow.next; 
        }
        slow.next=slow.next.next; //so we skip the node that we want to remove
        return dummy.next;
    }

}

// 4.141. Linked List Cycle

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow == fast) return true;
        }
        return false;
    }
}

// 5.2. Add Two Numbers
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode ptr=result;
        int carry=0;
        while(l1!=null || l2!=null){
            int sum=0+carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            carry=sum/10;
            sum=sum%10;
            ptr.next=new ListNode(sum);
            ptr=ptr.next;  
        }
        if (carry==1)  ptr.next=new ListNode(1);
        return result.next;
 
    }
}

// 6.160. Intersection of Two Linked Lists
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode p1=headA;
        ListNode p2=headB;
        while(p1!=p2){
            p1= (p1==null)? headB : p1.next;
            p2= (p2==null)? headA : p2.next;
        }
        return p1;
    }
}
// 7.234. Palindrome Linked List

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head==null ||head.next==null) return true;
        // fimd mid element
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        // reverse
        ListNode prev=null;
        while(slow!=null){
          ListNode next=slow.next;
            slow.next=prev;
            prev=slow;
            slow=next;
        }
        // compare
        ListNode first=head;
        ListNode second=prev;
        while(second!=null){
            if(first.val!=second.val) return false;
            first=first.next;
            second=second.next;
        }
        return true;
    }
}

// 8.25. Reverse Nodes in k-Group
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {

            // 1) Check if k nodes exist
            ListNode kth = prevGroupEnd;
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if (kth == null) return dummy.next;
            }

            // 2) Mark important nodes
            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // 3) Reverse k nodes
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;

            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // 4) Connect previous part to reversed group
            prevGroupEnd.next = kth;

            // 5) Move prevGroupEnd for next round
            prevGroupEnd = groupStart;
        }
    }
}
