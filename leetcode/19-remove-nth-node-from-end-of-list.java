
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode now = head;
        int nodeCount = 0;

        while (now != null) {
            nodeCount++;
            now = now.next;
        }

        if (nodeCount == n)
            return head.next;
        now = head;
        int toGo = nodeCount - n;
        while (toGo-- > 1)
            now = now.next;
        now.next = now.next.next;
        return head;
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
