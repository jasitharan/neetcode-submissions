class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
     Map<List<Character>, List<String>> mapping = new HashMap<>();
     List<List<String>> grid = new ArrayList<>();
        
     for (String s : strs) {
       List<Character> chars = toListChar(s);
       if (mapping.containsKey(chars)) {
          mapping.get(chars).add(s);
       } else {
          mapping.put(chars, new ArrayList<>(List.of(s)));
       }
     }

     return new ArrayList<>(mapping.values()); 

    }

    private List<Character> toListChar(String s) {
        List<Character> chars = new ArrayList<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
        Collections.sort(chars);
        return chars;
    }       
}
