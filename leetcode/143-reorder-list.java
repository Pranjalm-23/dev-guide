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

//////////////////////////////////////////
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second
        ListNode second = reverse(slow.next);
        slow.next = null;

        // merge
        ListNode first = head;
        while (first != null && second != null) {
            ListNode nxt1 = first.next;
            ListNode nxt2 = second.next;

            first.next = second;
            second.next = nxt1;
            first = nxt1;
            second = nxt2;
        }

    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}