import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    static class Point{
        String n;
        int s;
        int idx;
        Point(String n, int s, int idx) {
            this.n=n;
            this.s=s;
            this.idx=idx;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> map =new HashMap<>();
        ArrayList<Point> list= new ArrayList<>();
        for (int i=0; i<genres.length; i++) {
            list.add(new Point(genres[i],plays[i],i));
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
        }
        Collections.sort(list, (o1,o2) -> {
            if (o1.n.equals(o2.n)) return o2.s-o1.s;
            else return map.get(o2.n) - map.get(o1.n);
        });
        int cnt=1;
        for (int i=1; i<list.size(); i++) {
            if (list.get(i).n.equals(list.get(i-1).n)) cnt++;
            else cnt=1;
            if (cnt>2) {
                list.remove(list.get(i--));
            }
        }
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i]=list.get(i).idx;
        }
        for (int x : answer) System.out.println(x+" ");
        return answer;
    }
}