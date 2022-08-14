package linked_list;

import utils.ListNode;

public class ReverseLinkedList_Recursive {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode helper = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return helper;
    }
}
