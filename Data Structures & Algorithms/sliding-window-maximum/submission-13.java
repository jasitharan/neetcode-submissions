class Solution {
 public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        int left = 0;
        int right = 0;
        int[] results = new int[nums.length-k+1];
        int index = 0;

        while (right < nums.length) {

            if (deque.isEmpty()) {
                deque.addLast(right);
            } else if (right - left < k) {
                if (nums[deque.getFirst()] >= nums[right]) {
                    while (nums[deque.getLast()] < nums[right]) {
                        deque.removeLast();
                    }
                    deque.addLast(right);
                } else {
                    deque.clear();
                    deque.addFirst(right);
                }

            }

            if (right - left == k-1) {
                results[index++] = nums[deque.getFirst()];
                left++;
                if (deque.size() == k || left > deque.getFirst()) {
                    deque.removeFirst();
                }
            }
            right++;
        }

        return results;
    }
}
