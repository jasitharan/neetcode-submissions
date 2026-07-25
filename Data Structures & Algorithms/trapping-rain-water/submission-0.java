class Solution {
    public int trap(int[] height) {
        int size = height.length;

        if (size < 3) return 0;

        int result = 0;

        int l = 0;
        int r = 1;

        while (r < size) {
            int start = height[l];
            int k = size - 1;
            int foundedMax = 0;
            while (l < k) {
                if (height[k] >= start) {
                    foundedMax = start;
                    break;
                } 
                foundedMax = Math.max(foundedMax, height[k]);
                k--;
            }

            start = foundedMax >= start ? start : foundedMax;

            while (r < size && start > height[r]) {
              result +=  (start - height[r]);
            l++;
            r++;

            
        }

        if (r >= size) break;
          
        if (!(start > height[r])) {
             l++;
             r++;
        }
    }
    return result;
}
}
