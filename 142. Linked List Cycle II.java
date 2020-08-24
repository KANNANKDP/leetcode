/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                slowPointer = head;
                while (fastPointer != null ) {
                    if (slowPointer == fastPointer) {
                        return slowPointer;
                    }
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                }
            }
        }
        return null;
    }
}

