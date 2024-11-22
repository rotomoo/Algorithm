import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    // 점수, 횟수 나누는 객체
    static class Point {
        int point, cnt;

        public Point(int point, int cnt) {
            this.point = point;
            this.cnt = cnt;
        }
    }

    // 정답 체크 객체
    static class AnswerCheck {
        int difference;
        int[] ryan;

        public AnswerCheck(int difference, int[] ryan) {
            this.difference = difference;
            this.ryan = ryan;
        }
    }

    static List<AnswerCheck> answer;

    // 중복조합, 경우의수 체크 메소드
    public static void DFS(int cnt, int n, int s, Point[] apeach, Point[] ryan) {
        if (cnt == n) {
            calc(apeach, ryan);
            return;
        }
        for (int i = s; i < 11; i++) {
            ryan[i].cnt++;
            DFS(cnt+1, n, i, apeach, ryan);
            ryan[i].cnt--;
        }
    }

    // 점수 계산, answer에 추가하는 메소드
    public static void calc(Point[] apeach, Point[] ryan) {
        int aPoint = 0;
        int rPoint = 0;
        for (int i = 0; i < 11; i++) {
            if (apeach[i].cnt == 0 && ryan[i].cnt ==0) continue;
            if (apeach[i].cnt >= ryan[i].cnt) aPoint += apeach[i].point;
            else rPoint += ryan[i].point;
        }

        // 어피치점수가 더 높거나 같다면 return
        if (aPoint >= rPoint) return;

        // 현재 점수차이
        int curDiff = rPoint - aPoint;

        // 현재 ryan 배열, Point[] -> int[]
        int[] curRyan = new int[ryan.length];
        for (int i=0; i<ryan.length; i++) {
            curRyan[i] = ryan[i].cnt;
        }


        // answer이 있을때
        if (!answer.isEmpty()) {

            // answerCheck 객체 가져오기
            AnswerCheck answerCheck = answer.get(0);

            // 기존에 차이값이 현재 차이값보다 크다면 return
            if (answerCheck.difference > curDiff) return;
            
            // 기존에 차이값이 현재 차이값보다 작다면 answer 초기화
            else if (answerCheck.difference < curDiff) answer.clear();
        }
        
        answer.add(new AnswerCheck(curDiff, curRyan));
    }
    
    public int[] solution(int n, int[] info) {

        answer = new ArrayList<>();
        // 객체 선언
        Point[] ryan = new Point[11];
        Point[] apeach = new Point[11];

        // 점수, 횟수 저장
        for (int i = 0; i < 11; i++) {
            apeach[i] = new Point(10 - i, info[i]);
            ryan[i] = new Point(10 - i, 0);
        }

        // ryan 모든 경우의수 찾기
        DFS(0, n, 0, apeach, ryan);

        // 답이 없다면 -1 리턴
        if (answer.isEmpty()) return new int[]{-1};

        // 정답 조건
        Collections.sort(answer, (o1, o2) -> {
            int[] aRyan = o1.ryan;
            int[] bRyan = o2.ryan;
            for (int i = 10; i >= 0; i--) {
                // 두 배열의 횟수가 다른경우 양수 리턴으로 순서 바꿈, 큰 횟수부터 반환
                if (aRyan[i] != bRyan[i]) return bRyan[i] - aRyan[i];
            }
            return 0;
        });
        return answer.get(0).ryan;
    }
}