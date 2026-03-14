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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right) return head;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev1 = temp;
        for(int i=1; i<left; i++){
            prev1 = prev1.next;
        }
        ListNode start = prev1.next;
        ListNode curr = start;
        ListNode prev = null;
        ListNode next;
        for(int i=left; i<=right; i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        start.next=curr;
        prev1.next = prev;
        return temp.next;
    }
}