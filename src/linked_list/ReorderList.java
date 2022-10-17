package linked_list;

import utils.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode latterHead = slow.next;
        slow.next = null;
        ListNode formerHead = head.next;
        latterHead = reverseList(latterHead);
        head.next = mergeLists(latterHead, formerHead);

    }

    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = temp;
        }
        return newHead;
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode helper = new ListNode();
        ListNode cur = helper;
        while (l1 != null && l2 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return helper.next;
    }
}
