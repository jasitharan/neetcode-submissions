class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s: strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

       int i = 0;

       while (i < str.length()) {
          int j = str.indexOf('#', i);                      // j = position of the #
          int len = Integer.parseInt(str.substring(i, j));
          decoded.add(str.substring(j+1, len + j + 1));
          i = j+1+len;
       }

       return decoded;

    }
}
