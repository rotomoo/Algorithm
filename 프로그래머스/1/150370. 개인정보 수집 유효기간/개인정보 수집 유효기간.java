import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


class Solution {
    
    static class privacy {
        LocalDate getDt;
        LocalDate endDt;

        public privacy(LocalDate getDt, LocalDate endDt) {
            this.getDt = getDt;
            this.endDt = endDt;
        }
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> termMonths = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            termMonths.put(split[0], Integer.parseInt(split[1]));
        }

        List<privacy> privacyList = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        for (String privacy : privacies) {
            String[] split = privacy.split(" ");
            LocalDate getDt = LocalDate.parse(split[0], dateTimeFormatter);

            Integer month = termMonths.get(split[1]);
            privacyList.add(new privacy(getDt, getDt.plusMonths(month).minusDays(1)));
        }

        int idx = 1;
        
        for (privacy privacy : privacyList) {
            LocalDate toDay = LocalDate.parse(today, dateTimeFormatter);
            if (toDay.isAfter(privacy.endDt)) answer.add(idx);
            idx++;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}