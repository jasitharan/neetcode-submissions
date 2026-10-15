class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] carSortedByPos = new int[n][2];

        for (int i = 0;i<n;i++) {
            carSortedByPos[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(carSortedByPos, (a, b) -> Integer.compare(a[0],b[0]));

        Deque<Double> stack = new ArrayDeque<>();

        for (int i = 0;i<n;i++) {
            double time = (double) (target - carSortedByPos[i][0]) / carSortedByPos[i][1];
            Double previousCarTime = stack.peek();

             while (previousCarTime != null && (time > previousCarTime || time == previousCarTime)) {
                stack.pop();
                previousCarTime = stack.peek();
            }
            stack.push(time);

        }



        return stack.size();
    }
}
