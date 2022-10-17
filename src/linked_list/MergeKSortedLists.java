package linked_list;

import utils.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        ListNode helper = new ListNode();
        ListNode cur = helper;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.add(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return helper.next;
    }
}
