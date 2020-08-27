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
    public int[] nextLargerNodes(ListNode head) {
        //Convert linked list to array list
        List<Integer> list = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            list.add(node.val);
        }
        
        /*
            Use stack to maintain index of the previous 
            elements of result pending ones 
        */
        Stack<Integer> stack = new Stack<>();
        
        //Result list
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                result[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return result;
    }
}


