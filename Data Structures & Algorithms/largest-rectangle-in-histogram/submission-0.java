class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> frequePerHeight = new ArrayDeque<>();
        int largeRecArea = 0;

        for (int i = 0;i<heights.length;i++) {
            int[] current = frequePerHeight.peek();

            if (current == null || heights[i] > current[0]) {
                frequePerHeight.push(new int[]{heights[i], 1});
                continue;
            }
            
            if (heights[i] == current[0]) {
                frequePerHeight.pop();
                frequePerHeight.push(new int[]{heights[i], current[1] + 1});
            } else if (heights[i] < current[0]) {
                int[] prev = current;
                int countsBefore = 0;
                while (!frequePerHeight.isEmpty() && heights[i] < prev[0]) {
                    if (!(heights[i] < frequePerHeight.peek()[0])) {
                        break;
                    }
                    prev = frequePerHeight.pop();
                    countsBefore += prev[1];
                    int prevHeight = prev[0];
                    largeRecArea = Math.max(prevHeight * countsBefore, largeRecArea);
                }
                frequePerHeight.push(new int[]{heights[i], 1 + countsBefore});
            }
        }

        int remainHeightFreq = 0;
        int[] remainHeight = new int[]{};
        while (!frequePerHeight.isEmpty()) {
            remainHeight = frequePerHeight.pop();
            largeRecArea = Math.max(remainHeight[0] * (remainHeight[1] + remainHeightFreq), largeRecArea);
            remainHeightFreq += remainHeight[1];
        }

        return largeRecArea;
    }
}