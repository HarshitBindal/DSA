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
        for(int i=0; i<lists.length; i++){
            ListNode temp = lists[i];
            while(temp != null){
                pq.offer(temp.val);
                temp = temp.next;
            }
        }
        if(pq.isEmpty()) return null;
        ListNode curr = new ListNode();
        curr.val = pq.poll();
        ListNode head = curr;
        while(!pq.isEmpty()){
            ListNode agla = new ListNode();
            agla.val = pq.poll();
            curr.next = agla;
            curr = agla;
        }
        return head;
    }
}