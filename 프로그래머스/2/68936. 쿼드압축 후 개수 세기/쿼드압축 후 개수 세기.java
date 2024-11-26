class Solution {
    static int[] answer;
    static int[][] arrTmp;

    public static boolean isCheck(int len, int x, int y) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (arrTmp[x][y]!=arrTmp[i][j]) return false;
            }
        }
        return true;
    }

    public static void DFS(int len, int x, int y) {
        if (isCheck(len, x, y) || len==1) {
            answer[arrTmp[x][y]]++;
            return;
        }
        DFS(len/2, x, y);
        DFS(len/2, x, y+len/2);
        DFS(len/2, x+len/2, y);
        DFS(len/2, x+len/2, y+len/2);
    }

    public int[] solution(int[][] arr) {
        answer = new int[2];
        arrTmp = arr;
        DFS(arr.length, 0, 0);
        return answer;
    }
}