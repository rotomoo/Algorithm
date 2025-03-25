import java.util.*;

class Solution {

    static class Car implements Comparable<Car>{
        public int startRoot;
        public int endRoot;
        public Boolean cameraYn = false;

        @Override
        public int compareTo(Car o) {
            return this.endRoot - o.endRoot;
        }

        public Car(int startRoot, int endRoot) {
            this.startRoot = startRoot;
            this.endRoot = endRoot;
        }
    }

    public int solution(int[][] routes) {
        int answer = 0;

        List<Car> cars = new ArrayList<>();

        for (int[] route : routes) {
            cars.add(new Car(route[0], route[1]));
        }

        Collections.sort(cars);

        int carRoot = Integer.MIN_VALUE;
        for (Car car : cars) {
            if (carRoot < car.startRoot) {
                carRoot = car.endRoot;
                answer++;
            }
        }

        return answer;
    }
}