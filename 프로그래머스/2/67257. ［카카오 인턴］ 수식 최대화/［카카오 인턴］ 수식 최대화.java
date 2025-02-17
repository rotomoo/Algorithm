import java.util.*;

class Solution {
    static long answer = Long.MIN_VALUE;
    static Deque<Integer> list;
    static Deque<Character> operator;
    static int[] ch, arr;
    static char[] operArr = {'-', '+', '*'};

    public static long calc(Deque<Long> listTmp, Deque<Character> operatorTmp) {
        for (int x : arr) {
            Deque<Long> resultList = new ArrayDeque<>();
            Deque<Character> resultOper = new ArrayDeque<>();
            char curOper = operArr[x];
            while (!operatorTmp.isEmpty()) {
                Long pollLong = listTmp.poll();
                char pollOper = operatorTmp.poll();
                if (pollOper == curOper) {
                    if (curOper== '-') listTmp.offerFirst(pollLong - listTmp.poll());
                    else if (curOper== '+') listTmp.offerFirst(pollLong + listTmp.poll());
                    else listTmp.offerFirst(pollLong * listTmp.poll());
                }
                else {
                    resultList.offerLast(pollLong);
                    resultOper.offerLast(pollOper);
                }
            }
            resultList.offerLast(listTmp.poll());
            listTmp = resultList;
            operatorTmp = resultOper;
        }
        return listTmp.poll();
    }

    public static void DFS(int L) {
        if (L == 3) {
            Deque<Long> FirstList = new ArrayDeque<>();
            Deque<Character> FirstOper = new ArrayDeque<>();
            for (long x : list) {
                FirstList.offer(x);
            }
            for (char x : operator) {
                FirstOper.offer(x);
            }
            answer = Math.max(answer, Math.abs(calc(FirstList, FirstOper)));
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (ch[i]==0) {
                ch[i]=1;
                arr[L]=i;
                DFS(L+1);
                ch[i]=0;
            }
        }
    }

    public static long solution(String expression) {
        list = new ArrayDeque<>();
        operator = new ArrayDeque<>();
        int startIdx = 0;
        int endIdx = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                endIdx = i+1;
            }
            else {
                list.offer(Integer.parseInt(expression.substring(startIdx, endIdx)));
                operator.offer(expression.charAt(i));
                startIdx = i+1;
            }
        }
        list.offer(Integer.parseInt(expression.substring(startIdx, endIdx)));
        ch = new int[3];
        arr = new int[3];
        DFS(0);
        return answer;
    }
}