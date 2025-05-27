class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] prefixSum = new int[n+1][m+1];
        
        for (int[] s : skill) {
            int type = s[0];
            int fromX = s[1];
            int fromY = s[2];
            int toX = s[3];
            int toY = s[4];
            int degree = s[5];
            
            if(type == 1) {
                degree = -degree;
            }
            
            prefixSum[fromX][fromY] += degree;
            prefixSum[fromX][toY+1] += -degree;
            prefixSum[toX+1][fromY] += -degree;
            prefixSum[toX+1][toY+1] += degree;
        }
        
        // 왼쪽 -> 오른쪽
        for (int i=0; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                prefixSum[i][j] += prefixSum[i][j-1];
            }
        }

        // 위 -> 아래
        for (int i=1; i<n + 1; i++) {
            for (int j=0; j<m + 1; j++) {
                prefixSum[i][j] += prefixSum[i-1][j];
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] + prefixSum[i][j] > 0) {
                    answer ++;
                }
            }
        }
        
        return answer;
    }
}