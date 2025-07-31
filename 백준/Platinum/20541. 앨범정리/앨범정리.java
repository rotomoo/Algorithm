import java.util.*;

public class Main {

    static class Album {
        String name;
        Album parent;
        TreeMap<String, Album> children = new TreeMap<>();
        TreeSet<String> photos = new TreeSet<>();

        Album(String name, Album parent) {
            this.name = name;
            this.parent = parent;
        }

        private int[] deleteAll() {
            int albumCount = 0;
            int photoCount = photos.size();
            for (Album child : children.values()) {
                int[] res = child.deleteAll();
                albumCount += 1 + res[0];
                photoCount += res[1];
            }
            return new int[]{albumCount, photoCount};
        }
    }

    static Album root = new Album("album", null);
    static Album current = root;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] cmd = sc.nextLine().split(" ");
            switch (cmd[0]) {
                case "mkalb":
                    if (current.children.containsKey(cmd[1])) {
                        sb.append("duplicated album name\n");
                    } else {
                        current.children.put(cmd[1], new Album(cmd[1], current));
                    }
                    break;

                case "rmalb":
                    removeAlbum(cmd[1]);
                    break;

                case "insert":
                    if (!current.photos.add(cmd[1])) {
                        sb.append("duplicated photo name\n");
                    }
                    break;

                case "delete":
                    deletePhoto(cmd[1]);
                    break;

                case "ca":
                    changeAlbum(cmd[1]);
                    break;
            }
        }

        System.out.print(sb);
    }

    private static void removeAlbum(String arg) {
        if (arg.equals("0")) {
            int album = 0, photo = 0;
            for (Album a : current.children.values()) {
                int[] res = a.deleteAll();
                album += 1 + res[0];
                photo += res[1];
            }
            current.children.clear();
            sb.append(album).append(" ").append(photo).append("\n");
        } else if (arg.equals("-1") || arg.equals("1")) {
            if (current.children.isEmpty()) {
                sb.append("0 0\n");
                return;
            }
            String key = arg.equals("-1") ? current.children.firstKey() : current.children.lastKey();
            Album removed = current.children.remove(key);
            int[] res = removed.deleteAll();
            sb.append(res[0] + 1).append(" ").append(res[1]).append("\n");
        } else {
            Album removed = current.children.remove(arg);
            if (removed == null) {
                sb.append("0 0\n");
                return;
            }
            int[] res = removed.deleteAll();
            sb.append(res[0] + 1).append(" ").append(res[1]).append("\n");
        }
    }

    private static void deletePhoto(String arg) {
        int deleted = 0;
        if (arg.equals("0")) {
            deleted = current.photos.size();
            current.photos.clear();
        } else if (arg.equals("-1") && !current.photos.isEmpty()) {
            current.photos.pollFirst();
            deleted = 1;
        } else if (arg.equals("1") && !current.photos.isEmpty()) {
            current.photos.pollLast();
            deleted = 1;
        } else if (current.photos.remove(arg)) {
            deleted = 1;
        }
        sb.append(deleted).append("\n");
    }

    private static void changeAlbum(String arg) {
        if (arg.equals("/")) {
            current = root;
        } else if (arg.equals("..")) {
            if (current.parent != null) current = current.parent;
        } else {
            Album next = current.children.get(arg);
            if (next != null) current = next;
        }
        sb.append(current.name).append("\n");
    }
}