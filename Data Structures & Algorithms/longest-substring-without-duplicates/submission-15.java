class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left1 = 0;
        int result = 0;

        Map<Character,Integer> charByIndex = new HashMap<>();

        for (int i = 0;i<s.length();i++) {
            if (charByIndex.get(s.charAt(i)) != null) {
                left1 = Math.max(charByIndex.get(s.charAt(i)) + 1,left1);
            } 

              charByIndex.put(s.charAt(i), i);
              result = Math.max(result,i-left1+1);
            }

            return result;

        }

}
