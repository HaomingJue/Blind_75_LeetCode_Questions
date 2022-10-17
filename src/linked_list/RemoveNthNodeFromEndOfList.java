package linked_list;

import utils.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode helper = new ListNode();
        helper.next = head;
        ListNode front = helper;
        ListNode back = helper;
        for (int i = 0; i <= n; i++) {
            front = front.next;
        }
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return helper.next;
    }
}
