import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] gears = new String[4];
        for (int i = 0; i < 4; i++) {
            gears[i] = br.readLine();
        }
        
        int k = Integer.parseInt(br.readLine());

        int[][] operations = new int[k][2];
        for (int i = 0; i < k; i++) {
            String[] line = br.readLine().split(" ");
            operations[i][0] = Integer.parseInt(line[0]);
            operations[i][1] = Integer.parseInt(line[1]);
        }
        
        
        for (int[] operation: operations) {
            int gearOrder = operation[0] - 1;
            int direction = operation[1];
            
            int[] gearDirections = new int[4];
            gearDirections[gearOrder] = direction;
            
            // 왼쪽
            for (int i = gearOrder; i > 0; i--) {
                if (gears[i].charAt(6) != gears[i - 1].charAt(2)) {
                    gearDirections[i - 1] = -gearDirections[i];
                } else  {
                    break;
                }
            }

            // 오른쪽
            for (int i = gearOrder; i < 3; i++) {
                if (gears[i].charAt(2) != gears[i + 1].charAt(6)) {
                    gearDirections[i + 1] = -gearDirections[i];
                } else {
                    break;
                } 
            }

            // 회전
            for (int i = 0; i < 4; i++) {
                if (gearDirections[i] != 0) {
                    gears[i] = rotation(gears[i], gearDirections[i]);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i].charAt(0) == '1') {
                answer += (int) Math.pow(2,i);
            }
        }
        System.out.println(answer);
    }
    
    private static String rotation(String gear, int direction) {
        return direction == 1
            ? gear.charAt(7) + gear.substring(0, 7)   // 시계
            : gear.substring(1) + gear.charAt(0);     // 반시계
    }
}