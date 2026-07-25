class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int area = 0;


        while (l < r) {
            area = Math.max(area,(r - l) * Math.min(heights[r],heights[l]));
            if (heights[r] < heights[l]) {
                r--;
            } else {
                l++;
            }

        }
        return area;
    }
}
