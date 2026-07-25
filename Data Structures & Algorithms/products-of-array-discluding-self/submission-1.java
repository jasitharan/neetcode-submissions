class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arrSize = nums.length;
         
         int mul = 1;
         int zeroIndexCount = 0;

        for (int i = 0; i < arrSize; i++) {
            
            if (nums[i] == 0) {
                zeroIndexCount++;
            } else {
              mul *= nums[i];
            }
        }

        int[] results = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            if (zeroIndexCount > 1) {
                results[i] = 0;
            } 
            else if (zeroIndexCount == 1) {
                results[i] = nums[i] == 0 ? mul : 0;
            }
            else {
                results[i] = mul / nums[i];
            }
        }

        return results;
    }
}  
