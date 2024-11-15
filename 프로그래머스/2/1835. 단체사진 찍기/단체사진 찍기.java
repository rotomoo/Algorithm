class Solution {
    static int[] ch, arr = {0, 1, 2, 3, 4, 5, 6, 7};
    static char[] charArr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int answer;
    static String[] Data;

    public static boolean isCheck(int[] arr) {
        for (String x : Data) {
            char c1 = x.charAt(0);
            char c2 = x.charAt(2);
            char c3 = x.charAt(3);
            char c4 = x.charAt(4);
            int first = 0;
            int second = 0;
            for (int i = 0; i < 8; i++) {
                if (charArr[arr[i]] == c1) {
                    first = i;
                }
                else if (charArr[arr[i]] == c2) {
                    second = i;
                }
            }
            if (c3=='=') {
                if (Math.abs(second - first)!=c4-'0'+1) return false;
            }
            else if (c3=='>') {
                if (!(Math.abs(second - first) > c4-'0'+1)) return false;
            }
            else if (c3=='<'){
                if (!(Math.abs(second - first) < c4-'0'+1)) return false;
            }
        }
        return true;
    }

    public static void DFS(int L) {
        if (L==8) {
            if (isCheck(arr)) answer++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (ch[i]==0) {
                arr[L]=i;
                ch[i]=1;
                DFS(L+1);
                ch[i]=0;
            }
        }
    }

    public static int solution(int n, String[] data) {
        ch = new int[8];
        Data = data;
        answer = 0;
        DFS(0);
        return answer;
    }
}