import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] car = new int[position.length][2]; // position, speed
        for (int i = 0; i < position.length; i++) {
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }

        Arrays.sort(car, (a, b) -> (b[0] - a[0])); // reverse sorted
        Stack<Double> st = new Stack<>();

        for (int i = 0; i < car.length; i++) {
            double t = (double) (target - car[i][0]) / car[i][1]; // time to reach target
            if (st.isEmpty() || st.peek() < t)
                // Only create a new fleet if the current car cannot catch the previous fleet
                st.push(t);

        }

        return st.size();
    }
}