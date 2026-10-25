class Solution {
 public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        int left = 0;
        int right = 0;
        int[] results = new int[nums.length-k+1];
        int index = 0;

        while (right < nums.length) {

            if (deque.isEmpty()) {
                deque.addLast(nums[right]);
            } else if (right - left < k) {
                if (deque.getFirst() >= nums[right]) {
                    while (deque.getLast() < nums[right]) {
                        deque.removeLast();
                    }
                    deque.addLast(nums[right]);
                } else {
                    deque.clear();
                    deque.addFirst(nums[right]);
                }

            }

            if (right - left == k-1) {
                results[index++] = deque.getFirst();
                if (deque.size() == k || nums[left] == deque.getFirst()) {
                    deque.removeFirst();
                }
                left++;
            }
            right++;
        }

        return results;
    }
}
