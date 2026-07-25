class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] -1)) {
                continue;
            }
             int streak  = 0, curr = nums[i];
             while(set.contains(curr)) {
                streak++;
                curr++;
             }
             res = Math.max(res, streak); 
        } 
        return res;
    }
}
