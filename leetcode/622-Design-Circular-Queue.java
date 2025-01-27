class ListNode {
    int val;
    ListNode left, right;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

class MyCircularQueue {
    private int size, capacity;
    private ListNode head, tail;

    public MyCircularQueue(int k) {
        capacity = k;
        size = 0;
        head = new ListNode(-1); // Sentinel node for the start
        tail = new ListNode(-1); // Sentinel node for the end
        head.right = tail;
        tail.left = head;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        ListNode newNode = new ListNode(value);
        ListNode prev = tail.left;
        prev.right = newNode;
        newNode.left = prev;
        newNode.right = tail;
        tail.left = newNode;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        ListNode nodeToRemove = head.right;
        head.right = nodeToRemove.right;
        nodeToRemove.right.left = head;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : head.right.val;
    }

    public int Rear() {
        return isEmpty() ? -1 : tail.left.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */