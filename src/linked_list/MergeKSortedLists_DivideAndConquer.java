package linked_list;

import utils.ListNode;

public class MergeKSortedLists_DivideAndConquer {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 ) return null;
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                mergeTwoSortedLists(lists, i, i + interval);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private void mergeTwoSortedLists(ListNode[] lists, int i, int j) {
        ListNode c1 = lists[i];
        ListNode c2 = lists[j];
        ListNode preHead = new ListNode();
        ListNode cur = preHead;
        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                cur.next = c1;
                cur = c1;
                c1 = c1.next;
            }
            else {
                cur.next = c2;
                cur = c2;
                c2 = c2.next;
            }
        }
        if (c1 != null) {
            cur.next = c1;
        }
        if (c2 != null) {
            cur.next = c2;
        }
        lists[i] = preHead.next;
    }
}
