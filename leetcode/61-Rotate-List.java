class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        int len = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }

        curr.next = head;

        int times = len - (k % len) - 1;
        curr = head;
        while (times-- > 0) {
            curr = curr.next;
        }
        ListNode ans = curr.next;
        curr.next = null;

        return ans;
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