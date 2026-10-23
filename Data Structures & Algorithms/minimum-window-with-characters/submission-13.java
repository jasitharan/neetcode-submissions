class Solution {
  public String minWindow(String s, String t) {

        if (s.length() < t.length()) { return ""; }

        int n1 = t.length();
        int have = 0;
        Map<Character,Integer> needs = new HashMap<>();
        Map<Character,Integer> current = new HashMap<>();
        int[] bestIndexes = new int[2];
        bestIndexes[1] = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;

        for (int i = 0;i<n1;i++) {
            char c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s.length() || have == n1) {

           if (have != n1) {
               char rightChar = s.charAt(right);
               boolean contains = needs.containsKey(rightChar);
                int curr = current.get(rightChar) == null ? 0 : current.get(rightChar);
                if (contains) {
                    current.put(rightChar, curr + 1);
                    int currentCount = current.get(rightChar);
                    int needCount = needs.get(rightChar);
                    if (currentCount <= needCount) {
                        have++;
                    }
                }

                right++;
            }

            if (have == n1) {
                char leftChar = s.charAt(left);
                int length = bestIndexes[1] - bestIndexes[0];
                if (length>(right-left-1)) {
                    bestIndexes[0] = left;
                    bestIndexes[1] = right-1;
                }
                left++;

                if (needs.containsKey(leftChar)) {
                    current.put(leftChar, current.get(leftChar) - 1);

                    if (needs.get(leftChar) > current.get(leftChar)) {
                        have--;
                    }

                }

            }

        }

        StringBuilder sb = new StringBuilder();

        if (bestIndexes[0] == 0 && bestIndexes[1] == Integer.MAX_VALUE) {
            return "";
        }

        for (int j = bestIndexes[0];j<=bestIndexes[1];j++) {
            sb.append(s.charAt(j));
        }


        return !sb.toString().isEmpty() ? sb.toString() : "";
    }
}
