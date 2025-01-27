/*
// Definition for a Node.*/

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class SolutionWithoutExtraSpace {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        // create copy next to each
        Node curr = head;
        while (curr != null) {
            Node tmp = new Node(curr.val);
            tmp.next = curr.next;
            curr.next = tmp;
            curr = tmp.next;
        }

        // fix random
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        // separate random list
        curr = head;
        Node copy = curr.next;
        while (curr != null) {
            Node tmp = curr.next;
            curr.next = tmp.next;

            curr = curr.next;
            if (curr != null)
                tmp.next = curr.next;

        }
        return copy;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node dummy = new Node(0);
        Node newCur = dummy;

        // next
        while (curr != null) {
            newCur.next = new Node(curr.val);
            map.put(curr, newCur.next);
            newCur = newCur.next;
            curr = curr.next;
        }

        // random
        curr = head;
        newCur = dummy;
        while (curr != null) {
            newCur.next.random = map.get(curr.random);
            newCur = newCur.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}