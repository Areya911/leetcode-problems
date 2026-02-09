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

// 4.141. Linked List Cycle

// 5.2. Add Two Numbers

// 6.160. Intersection of Two Linked Lists

// 7.234. Palindrome Linked List

// 8.25. Reverse Nodes in k-Group