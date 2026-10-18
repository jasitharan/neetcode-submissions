class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        int[] s1Arr = new int[26];
        int[] currWinArr = new int[26];

        for (int i = 0;i<n1;i++) {
            char c = s1.charAt(i);
            s1Arr[c - 'a'] += 1; 
        }

        int left = 0;
        int right = 0;

        while(right < n2) {
            char c = s2.charAt(right);
            currWinArr[c - 'a'] += 1;

            if (right - left + 1 == n1) {
                boolean isEqual = true;
                for (int i=0;i<26;i++) {
                    if (currWinArr[i] != s1Arr[i]) {
                        isEqual = false;
                    }
                 }
                if (isEqual) return true;

                currWinArr[s2.charAt(left) - 'a'] -= 1;
                left++;
            } 
            right++;

        }
        
      return false;
        
    }
}
