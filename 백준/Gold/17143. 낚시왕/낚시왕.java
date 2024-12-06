import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static class Person {
        int col, totalSize;

        public Person(int col) {
            this.col = col;
        }

        public void move() {
            col++;
        }

        public boolean finishFishing() {
            if (col == c + 1) {
                return true;
            }
            return false;
        }

        public void fishing(Shark shark) {
            totalSize += shark.size;
        }

    }

    static class Shark {
        int row, col, speed, direction, size;

        public Shark(int row, int col, int speed, int direction, int size) {
            this.row = row;
            this.col = col;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }

        public void move() {
            changeBoundary();
            if (direction == 1) row--;
            else if (direction == 2) row++;
            else if (direction == 3) col++;
            else if (direction == 4) col--;
        }

        public void changeBoundary () {
            // 1:위 2:아래 3:오른쪽 4:왼쪽
            if (direction == 1 && row == 1) direction = 2;
            else if (direction == 2 && row == r) direction = 1;
            else if (direction == 3 && col == c) direction = 4;
            else if (direction == 4 && col == 1) direction = 3;
        }

        public Shark eat(Shark shark) {
            if (size > shark.size) return this;
            else return shark;
        }

        public Shark eaten(Shark shark) {
            if (size > shark.size) return shark;
            else return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Shark shark = (Shark) o;
            return row == shark.row && col == shark.col && speed == shark.speed && direction == shark.direction && size == shark.size;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col, speed, direction, size);
        }
    }

    static int r, c, m;
    static Shark[][] sea;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sea = new Shark[r+1][c+1];
        List<Shark> sharks = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            int s = Integer.parseInt(st2.nextToken());
            int d = Integer.parseInt(st2.nextToken());
            int z = Integer.parseInt(st2.nextToken());
            Shark shark = new Shark(r, c, s, d, z);
            sea[r][c] = shark;
            sharks.add(shark);
        }

        Person person = new Person(0);

        while (true) {

            // 1.낚시왕이 오른쪽으로 한 칸 이동한다.
            person.move();

            // 낚시왕은 가장 오른쪽 열의 오른쪽 칸에 이동하면 이동을 멈춘다.
            if (person.finishFishing()) break;

            // 2.낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다.
            // 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
            for (int row = 1; row <= r; row++) {
                if (sea[row][person.col] != null) {
                    person.fishing(sea[row][person.col]);
                    sharks.remove(sea[row][person.col]);
//                    sea[row][person.col] = null;
                    break;
                }
            }

            // 3.상어가 이동한다.
            sea = new Shark[r+1][c+1];
            List<Shark> smallSharks = new ArrayList<>();

            for (Shark shark : sharks) {
                int prevSpeed = shark.direction == 1 || shark.direction == 2 ? shark.speed % ((r-1) * 2) : shark.speed % ((c-1) * 2);
                while (prevSpeed > 0) {
                    shark.move();
                    prevSpeed--;
                }
                // 가장 큰 상어가 나머지 상어를 잡아먹는다.
                if (sea[shark.row][shark.col] != null) {
                    Shark bigShark = shark.eat(sea[shark.row][shark.col]);
                    Shark smallShark = shark.eaten(sea[shark.row][shark.col]);
                    sea[shark.row][shark.col] = bigShark;
                    smallSharks.add(smallShark);
                    continue;
                }
                sea[shark.row][shark.col] = new Shark(shark.row, shark.col, shark.speed, shark.direction, shark.size);
            }
            sharks.removeAll(smallSharks);
        }

        System.out.println(person.totalSize);

    }
}
