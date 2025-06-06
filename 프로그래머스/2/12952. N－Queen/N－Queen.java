class Solution {
    int answer = 0;
    int[] col;

    public int solution(int n) {
        col = new int[n];
        dfs(n, 0);
        return answer;
    }

    private void dfs(int n, int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            col[row] = i;
            if (isValid(row)) {
                dfs(n, row + 1);
            }
        }
    }

    private boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            if (col[i] == col[row] || Math.abs(row - i) == Math.abs(col[row] - col[i])) {
                return false;
            }
        }
        return true;
    }
}