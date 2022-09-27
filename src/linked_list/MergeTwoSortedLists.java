package linked_list;

import utils.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return list1 == null ? list2 : list1;
        ListNode helper = new ListNode();
        ListNode cur = helper;
        if (list1.val < list2.val) {
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        } else {
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }
        cur.next = mergeTwoLists(list1, list2);
        return helper.next;
    }
}