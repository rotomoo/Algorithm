import java.util.*;

class Solution {
    
    static class Data implements Comparable<Data> {
        int code;
        int date;
        int maximum;
        int remain;
        int extValue;
        String ext;
        int valExt;
        String sortBy;

        public Data(int code, int date, int maximum, int remain, int extValue, String ext, int valExt, String sortBy) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
            this.extValue = extValue;
            this.ext = ext;
            this.valExt = valExt;
            this.sortBy = sortBy;
        }

        @Override
        public int compareTo(Data o) {
            switch (sortBy) {
                case "code" :
                    return this.code - o.code;
                case "date" :
                    return this.date - o.date;
                case "maximum" :
                    return this.maximum - o.maximum;
                case "remain" :
                    return this.remain - o.remain;
            }
            return 0;
        }

        public void setExtValue() {
            switch (ext) {
                case "code" :
                    extValue = code;
                    break;
                case "date" :
                    extValue = date;
                    break;
                case "maximum" :
                    extValue = maximum;
                    break;
                case "remain" :
                    extValue = remain;
                    break;
            }
        }
    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> dataList = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            Data curData = new Data(data[i][0], data[i][1], data[i][2], data[i][3], 0, ext, val_ext, sort_by);
            curData.setExtValue();
            if (curData.extValue < val_ext) dataList.add(curData);
        }

        Collections.sort(dataList);


        return dataList.stream()
                .map(dataItem -> new int[]{dataItem.code, dataItem.date, dataItem.maximum, dataItem.remain})
                .toArray(int[][]::new);
    }
}