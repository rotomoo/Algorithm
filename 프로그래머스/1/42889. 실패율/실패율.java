import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static class Point {
        int index;
        double tmp;

        Point(int index, double tmp) {
            this.index=index;
            this.tmp=tmp;
        }
    }

    public static double per(int stage, int[] stages){
        double b = 0;
        double c = 0;
        for (int i=0; i<stages.length; i++) {
            if (stages[i] == stage) {
                b++;
                c++;
            }
            else if (stages[i] > stage) {
                c++;
            }
        }
        if (c==0) c=1;
        return b/c;
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Point> list = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            list.add(new Point(i, per(i, stages)));
        }
        Collections.sort(list, (o1, o2) -> Double.compare(o2.tmp, o1.tmp));
        for (int i=0; i<N; i++) answer[i]=list.get(i).index;
        return answer;
    }
}