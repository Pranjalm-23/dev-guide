import java.util.*;

class LockingTree {
    int[] parent;
    int[] locked;
    HashMap<Integer, List<Integer>> child;

    public LockingTree(int[] parent) {
        this.parent = parent;
        this.locked = new int[parent.length];
        Arrays.fill(locked, -1); // unlocked
        this.child = new HashMap<>();

        // Build the child map
        for (int i = 0; i < parent.length; i++) {
            child.putIfAbsent(parent[i], new ArrayList<>());
            child.get(parent[i]).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (locked[num] != -1)
            return false;
        locked[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (locked[num] != user)
            return false;
        locked[num] = -1;
        return true;
    }

    public boolean upgrade(int num, int user) {
        // Check if the node itself is locked
        if (locked[num] != -1)
            return false;

        // Check if any ancestor is locked
        int current = num;
        while (current != -1) {
            if (locked[current] != -1)
                return false;
            current = parent[current];
        }

        // Check if at least one descendant is locked
        if (!hasLockedDescendant(num))
            return false;

        // Unlock all descendants
        unlockAllDescendants(num);

        // Lock the current node for the user
        locked[num] = user;
        return true;

    }

    private boolean hasLockedDescendant(int num) {
        if (locked[num] != -1)
            return true;
        if (!child.containsKey(num))
            return false;

        for (int descendant : child.get(num)) {
            if (hasLockedDescendant(descendant))
                return true;
        }
        return false;
    }

    private void unlockAllDescendants(int num) {
        if (locked[num] != -1)
            locked[num] = -1;
        if (!child.containsKey(num))
            return;

        for (int descendant : child.get(num)) {
            unlockAllDescendants(descendant);
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
