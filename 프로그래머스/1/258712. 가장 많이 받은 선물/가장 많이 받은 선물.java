import java.util.*;

class Solution {
    
    static class GiftScore {
        int sendScore = 0;
        int receiveScore = 0;

        public int calculateGiftScore() {
            return sendScore - receiveScore;
        }
    }

    public static int solution(String[] friends, String[] gifts) {
        HashMap<String, HashMap<String, Integer>> giftHistories = new HashMap<>();
        HashMap<String, GiftScore> friendInfos = new HashMap<>();

        for (String friend : friends) {
            giftHistories.put(friend, new HashMap<>());
            friendInfos.put(friend, new GiftScore());
        }

        for (String gift : gifts) {
            String[] names = gift.split(" ");
            String sender = names[0];
            String receiver = names[1];

            giftHistories.get(sender).put(receiver, giftHistories.get(sender).getOrDefault(receiver, 0) + 1);
            friendInfos.get(sender).sendScore++;
            friendInfos.get(receiver).receiveScore++;
        }

        int answer = Integer.MIN_VALUE;

        for (String sender : friends) {
            int receiveCnt = 0;
            for (String receiver : friends) {
                if (!sender.equals(receiver)) {
                    int send = giftHistories.get(sender).getOrDefault(receiver, 0);
                    int receive = giftHistories.get(receiver).getOrDefault(sender, 0);
                    int giverScore = friendInfos.get(sender).calculateGiftScore();
                    int receiverScore = friendInfos.get(receiver).calculateGiftScore();
                    if (send > receive || (send == receive && giverScore > receiverScore)) {
                        receiveCnt++;
                    }
                }
            }
            answer = Math.max(answer, receiveCnt);
        }

        return answer;
    }
}