import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static class Coordinate {
    long x;
    long y;

    Coordinate(long x, long y) {
      this.x = x;
      this.y = y;
    }
  }

  static class Segment {
    Coordinate start;
    Coordinate end;

    Segment(Coordinate start, Coordinate end) {
      this.start = start;
      this.end = end;
    }
  }

  // 이 문제에서는 x = 좌우, y = 상하, 순서대로 상우하좌
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static class Snake {
    Coordinate head;
    int dir;
    List<Segment> segments;

    public Snake() {
      this.head = new Coordinate(0, 0);
      this.dir = 1;
      this.segments = new ArrayList<>();
      Coordinate initialCoordinate = new Coordinate(0, 0);
      this.segments.add(new Segment(initialCoordinate, initialCoordinate));
    }

    public void move(long duration) {
      Coordinate startCoordinate = new Coordinate(head.x, head.y);
      head.x += dx[this.dir] * duration;
      head.y += dy[this.dir] * duration;
      Coordinate endCoordinate = new Coordinate(head.x, head.y);
      this.segments.add(new Segment(startCoordinate, endCoordinate));
    }

    public void turn(char command) {
      if (command == 'L') {
        this.dir = switch (this.dir) {
          case 0 -> 3;
          case 1 -> 0;
          case 2 -> 1;
          case 3 -> 2;
          default -> this.dir;
        };
      } else {
        this.dir = switch (this.dir) {
          case 0 -> 1;
          case 1 -> 2;
          case 2 -> 3;
          case 3 -> 0;
          default -> this.dir;
        };
      }
    }

    public long getStepsToBoundary(long L) {
      long steps = switch (this.dir) {
        case 0 -> L - head.y;
        case 1 -> L - head.x;
        case 2 -> head.y + L;
        case 3 -> head.x + L;
        default -> Long.MAX_VALUE;
      };
      return steps + 1;
    }

    public long getStepsToSelfCollision() {
      long minSteps = Long.MAX_VALUE;
      for (Segment seg : this.segments) {
        long x1 = seg.start.x;
        long y1 = seg.start.y;
        long collisionSteps = Long.MAX_VALUE;

        if (this.dir == 1 || this.dir == 3) {
          if (seg.start.x == seg.end.x
              && head.y >= Math.min(y1, seg.end.y)
              && head.y <= Math.max(y1, seg.end.y)) {
            if (this.dir == 1 && x1 > head.x) {
              collisionSteps = x1 - head.x;
            } else if (this.dir == 3 && x1 < head.x) {
              collisionSteps = head.x - x1;
            }
          }
        } else {
          if (seg.start.y == seg.end.y
              && head.x >= Math.min(x1, seg.end.x)
              && head.x <= Math.max(x1, seg.end.x)) {
            if (this.dir == 0 && y1 > head.y) {
              collisionSteps = y1 - head.y;
            } else if (this.dir == 2 && y1 < head.y) {
              collisionSteps = head.y - y1;
            }
          }
        }
        minSteps = Math.min(minSteps, collisionSteps);
      }
      return minSteps;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long L = Long.parseLong(br.readLine());
    int N = Integer.parseInt(br.readLine());

    long totalTime = 0;
    Snake snake = new Snake();

    for (int i = 0; i <= N; i++) {
      long duration;
      char turnCommand = ' ';

      if (i < N) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        duration = Long.parseLong(st.nextToken());
        turnCommand = st.nextToken().charAt(0);
      } else {
        duration = Long.MAX_VALUE;
      }

      long stepsToBoundary = snake.getStepsToBoundary(L);
      long stepsToSelfCollision = snake.getStepsToSelfCollision();
      long stepsToDeath = Math.min(stepsToBoundary, stepsToSelfCollision);

      if (stepsToDeath <= duration) {
        totalTime += stepsToDeath;
        System.out.println(totalTime);
        return;
      }

      totalTime += duration;
      snake.move(duration);

      if (i < N) {
        snake.turn(turnCommand);
      }
    }
  }
}