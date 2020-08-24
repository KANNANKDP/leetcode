/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = findLength(headA);
        int lengthB = findLength(headB);
        
        if (lengthA < lengthB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        
        int diff = Math.abs(lengthA - lengthB);
        while (diff > 0) {
            headA = headA.next;
            diff--;
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
    
    private int findLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}

