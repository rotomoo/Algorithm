class Solution {
    public int solution(int [][]board) {
        int answer = Integer.MIN_VALUE;
        int[][] dy = board;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j]==1) dy[i][j] = Math.min(dy[i - 1][j], Math.min(dy[i][j - 1], dy[i - 1][j - 1])) + 1;
                answer = Math.max(answer, dy[i][j]);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                answer = Math.max(answer, dy[i][j]);
            }
        }
        return answer * answer;
    }
}