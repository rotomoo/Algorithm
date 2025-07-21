import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<String> people = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String action = sc.next();

            if (action.equals("enter")) {
                people.add(name);
            } else {
                people.remove(name);
            }
        }

        List<String> result = new ArrayList<>(people);
        result.sort(Collections.reverseOrder());

        for (String name : result) {
            System.out.println(name);
        }
    }
}
