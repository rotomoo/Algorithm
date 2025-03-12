import java.util.*;

class Solution {

    static class ListObject {
        String command, id;

        public ListObject(String command, String id) {
            this.command = command;
            this.id = id;
        }
    }

    public static String[] solution(String[] record) {

        HashMap<String, String> idNickMap = new HashMap<>();
        ArrayList<ListObject> inOutList = new ArrayList<>();

        for (String curRecord : record) {

            String[] curRecordArr = curRecord.split(" ");

            String command = curRecordArr[0];
            String id = curRecordArr[1];
            String nickname = "";
            if (!command.equals("Leave")) nickname = curRecordArr[2];

            if (command.equals("Enter") || command.equals("Change")) {
                idNickMap.put(id, nickname);
            }

            if (command.equals("Enter") || command.equals("Leave")) {
                inOutList.add(new ListObject(command, id));
            }
        }

        String[] answer = new String[inOutList.size()];

        int idx = 0;
        for (ListObject listObject : inOutList) {
            String responseCommand = "";
            String responseNickname = "";

            if (listObject.command.equals("Enter")) {
                responseCommand = "님이 들어왔습니다.";
            }
            else {
                responseCommand = "님이 나갔습니다.";
            }

            responseNickname = idNickMap.get(listObject.id);

            answer[idx++] = responseNickname + responseCommand;
        }

        return answer;
    }
}