class Solution {
    public boolean isPalindrome(String s) {
       
        
        char[] sCharArr= s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();

        int front = 0;
        int back = sCharArr.length - 1;

        while (front < back) {
            if (sCharArr[front] != sCharArr[back]) return false;
            front++;
            back--;
        }
        
        return true;
    }
}
