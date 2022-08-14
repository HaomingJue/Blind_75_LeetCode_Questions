package linked_list;

import utils.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists_PQSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode preHead = new ListNode();
        ListNode prev = preHead;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            prev.next = cur;
            prev = cur;
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }
        return preHead.next;
    }
}
