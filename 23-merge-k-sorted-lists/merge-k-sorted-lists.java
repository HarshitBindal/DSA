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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode list: lists){
            ListNode curr = list;
            while(curr!=null){
                pq.offer(curr.val);
                curr = curr.next;
            }
        }
        if(pq.isEmpty()) return null;
        ListNode head = new ListNode(pq.poll());
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        while(!pq.isEmpty()){
            ListNode curr = new ListNode(pq.poll());
            temp.next = curr;
            temp = temp.next;
        }
        return dummy.next;
    }
}