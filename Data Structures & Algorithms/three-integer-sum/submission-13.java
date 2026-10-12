class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0;i<nums.length;i++) {
            left = i + 1;
            right = nums.length - 1;
            if (left == right) break;
            if (i != 0 && nums[i] == nums[i-1]) continue;
          
                int target = nums[i] * -1;

                while (left < right) {
                
                    if (nums[right] + nums[left] < target) left++;
                    
                    if (nums[right] + nums[left] > target) right--;

                    if (left == right) break;
                    if (nums[left] + nums[right] + nums[i] == 0) {
                            results.add(Arrays.asList(nums[left], nums[i], nums[right]));
                            left++; 
                            right--;

                            
                     while (left < right && (nums[right] == nums[right+1])) {
                        right--;
                    }

                    while(left < right && (nums[left] == nums[left-1])) {
                      left++;
                    }
                    }

             
            }
        }
        return results;
    }
}