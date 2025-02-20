 class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tailA = headA;
        ListNode tailB = headB;

        while (tailA != tailB) {
            if (tailA == null)
                tailA = headB;
            else
                tailA = tailA.next;
            if (tailB == null)
                tailB = headA;
            else
                tailB = tailB.next;
        }
        return tailA;
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