class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left1 = 0;
        int result = 0;

        Map<Character,Integer> charByIndex = new HashMap<>();

        for (int i = 0;i<s.length();i++) {
            char currentChar = s.charAt(i);
            if (charByIndex.containsKey(currentChar)) {
                left1 = Math.max(charByIndex.get(currentChar) + 1,left1);
            } 

              charByIndex.put(currentChar, i);
              result = Math.max(result,i-left1+1);
            }

            return result;

        }

}
