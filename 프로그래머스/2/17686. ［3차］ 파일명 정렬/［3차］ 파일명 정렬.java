import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            int sIdx1 = 0;
            int sIdx2 = 0;
            int eIdx1 = 0;
            int eIdx2 = 0;
            boolean flag = true;
            for (int i = 0; i < o1.length(); i++) {
                if (flag && Character.isDigit(o1.charAt(i))) {
                    sIdx1 = i;
                    flag = false;
                }
                if (!flag && !Character.isDigit(o1.charAt(i))) {
                    eIdx1 = i;
                    break;
                }
            }
            flag = true;
            for (int i = 0; i < o2.length(); i++) {
                if (flag && Character.isDigit(o2.charAt(i))) {
                    sIdx2 = i;
                    flag = false;
                }
                if (!flag && !Character.isDigit(o2.charAt(i))) {
                    eIdx2 = i;
                    break;
                }
            }
            String str1 = o1.substring(0, sIdx1).toUpperCase();
            String str2 = o2.substring(0, sIdx2).toUpperCase();
            eIdx1 = eIdx1 == 0 ? o1.length() : eIdx1;
            eIdx2 = eIdx2 == 0 ? o2.length() : eIdx2;
            int int1 = Integer.parseInt(o1.substring(sIdx1, eIdx1));
            int int2 = Integer.parseInt(o2.substring(sIdx2, eIdx2));
            if (str1.equals(str2)) return int1 - int2;
            return str1.compareTo(str2);
        });
        return files;
    }
}