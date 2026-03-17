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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGrp = dummy;
        while(true){
            ListNode kth = prevGrp;
            for(int i=0; i<k && kth!=null; i++){
                kth = kth.next;
            }
            if(kth==null) break;
            ListNode nextGrp = kth.next;
            ListNode prev = nextGrp;
            ListNode curr = prevGrp.next;
            while(curr!=nextGrp){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode temp = prevGrp.next;
            prevGrp.next = kth;
            prevGrp = temp;
        }
        return dummy.next;
    }
}