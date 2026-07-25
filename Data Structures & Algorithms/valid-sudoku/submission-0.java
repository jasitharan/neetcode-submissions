class Solution {
    public boolean isValidSudoku(char[][] board) {

        int boardLength = board.length;
        Set<Character> checkHashSets = new HashSet<>();


        for (int i = 0; i < boardLength; i++) {
              for (int j = 0; j < boardLength; j++) {
                 if (board[i][j] == '.') continue;
                 
                if (checkHashSets.contains(board[i][j])) {
                    return false;
                }
                checkHashSets.add(board[i][j]);    
              }
              checkHashSets.clear();
        }


         for (int i = 0; i < boardLength; i++) {
              for (int j = 0; j < boardLength; j++) {
                 if (board[j][i] == '.') continue;
                 
                if (checkHashSets.contains(board[j][i])) {
                    return false;
                }
                checkHashSets.add(board[j][i]);    
              }
              checkHashSets.clear();
        }

        int r = 0;
        int c = 0;

        while (r < boardLength) {
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {

                    if (board[i][j] == '.') continue;    

                    if (checkHashSets.contains(board[i][j])) {
                        return false;
                    }
                    checkHashSets.add(board[i][j]);
                }
            }

            c += 3;

            if (c == boardLength) {
                r += 3;
                c = 0;
            }

            checkHashSets.clear();
        }
        return true;
    }
}
