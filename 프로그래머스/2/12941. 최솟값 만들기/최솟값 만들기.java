import java.util.Arrays;

class Solution {

    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1];
        }
        return answer;
    }
//    static int answer = Integer.MAX_VALUE;
//    static int len;
//    static int[] ch;
//
//    public static void dfs(int L, int score, int[] A, int[] B) {
//        if (score >= answer) return;
//        if (L == len) {
//            System.out.println(score);
//            answer = Math.min(answer, score);
//        }
//        else {
//            for (int i = 0; i < len; i++) {
//                if (ch[i] == 0) {
//                    ch[i]=1;
//                    dfs(L + 1, score + A[L] * B[i], A, B);
//                    ch[i]=0;
//                }
//            }
//        }
//    }
//
//    public int solution(int[] A, int[] B) {
//        len = A.length;
//        ch = new int[len];
//        dfs(0, 0 , A, B);
//        return answer;
//    }
}