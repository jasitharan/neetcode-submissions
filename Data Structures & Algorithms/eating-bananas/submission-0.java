class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (int i = 0;i<piles.length;i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        int left = 1;
        int right = max;
        int miminumFound = max;

        while (left <= right) {
            int mid = left + (right-left)/2;

            int takenHours = 0;
            for (int j = 0;j<piles.length;j++) {
                 takenHours+=Math.ceil((double) piles[j]/mid);
            }

            if (takenHours <= h) {
                miminumFound = Math.min(miminumFound, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return miminumFound;
    }
}
