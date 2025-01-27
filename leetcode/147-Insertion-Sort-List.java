/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode prev, curr, dummy = new ListNode(0, head);
        prev = head;
        curr = head.next;

        while (curr != null) {
            if (curr.val >= prev.val) {
                prev = curr;
                curr = curr.next;
                continue;
            }
            // insert
            ListNode tmp = dummy;
            while (tmp.next.val < curr.val) {
                tmp = tmp.next;
            }
            prev.next = curr.next;
            curr.next = tmp.next;
            tmp.next = curr;
            curr = prev.next;
        }
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}