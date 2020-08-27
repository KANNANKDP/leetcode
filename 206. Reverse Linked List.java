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

// Recursive
class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null ) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}

//Iterative
class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode currNode = head;
        ListNode nextNode = null;
        ListNode prevNode = null;
        
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }
}

