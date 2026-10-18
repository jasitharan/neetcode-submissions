class Solution {
   public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int currWinLongest = 0;
        int clength = 0;
        Map<Character,Integer> frequencyMap = new HashMap<>();


        while (right < s.length()) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            int newFreq = frequencyMap.getOrDefault(c2,0) + 1;
            frequencyMap.put(c2, newFreq);
            currWinLongest = Math.max(currWinLongest,newFreq);
            clength = Math.max(clength,currWinLongest);
             if ((left!=right) && ((currWinLongest+k < (right-left)+1)) ) {
                 Integer leavingCharPrevFreq = frequencyMap.get(c1);
                 if (leavingCharPrevFreq != null) {
                     frequencyMap.put(c1, leavingCharPrevFreq - 1);
                     if (leavingCharPrevFreq == currWinLongest) {
                         currWinLongest--;
                     }
                     currWinLongest = Math.max(currWinLongest,newFreq);
                 }
                left++;
            }

            right++;
        }

        return Math.min(s.length(), clength + k);

    }

}
