class Solution {
    public boolean isAnagram(String s, String t) {

    if (s.length() != t.length()) return false;

    return occurancePerCharacter(s).equals(occurancePerCharacter(t));

    }

    private Map occurancePerCharacter(String s) {
         Map<Character, Integer> charOccurance = new HashMap<>();

         for (char c : s.toCharArray()) {
            if (charOccurance.containsKey(c)) {
                charOccurance.put(c, charOccurance.get(c) + 1);
            } else {
                charOccurance.put(c, 1);
            }
         }

         return charOccurance;
    } 
}
