import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] tuning;
    static int[] chordNotes;
    static int minDifficulty = Integer.MAX_VALUE;
    static Map<String, Integer> noteMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        setupNoteMap();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tuning = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tuning[i] = noteMap.get(st.nextToken());
        }

        chordNotes = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            chordNotes[i] = noteMap.get(st.nextToken());
        }

        findMinDifficulty(0, new boolean[M], new int[N]);

        System.out.println(minDifficulty);
    }

    private static void setupNoteMap() {
        noteMap.put("A", 0); noteMap.put("A#", 1); noteMap.put("B", 2);
        noteMap.put("C", 3); noteMap.put("C#", 4); noteMap.put("D", 5);
        noteMap.put("D#", 6); noteMap.put("E", 7); noteMap.put("F", 8);
        noteMap.put("F#", 9); noteMap.put("G", 10); noteMap.put("G#", 11);
    }

    private static void findMinDifficulty(int stringIndex, boolean[] notesCovered, int[] currentFrets) {
        if (stringIndex == N) {
            boolean allNotesAreCovered = true;
            for (int i = 0; i < M; i++) {
                if (!notesCovered[i]) {
                    allNotesAreCovered = false;
                    break;
                }
            }

            if (!allNotesAreCovered) {
                return;
            }

            int maxFret = 0;
            int minFret = Integer.MAX_VALUE;
            boolean anyFretPressed = false;

            for (int fret : currentFrets) {
                if (fret > 0) {
                    anyFretPressed = true;
                    maxFret = Math.max(maxFret, fret);
                    minFret = Math.min(minFret, fret);
                }
            }

            int difficulty;
            if (!anyFretPressed) {
                difficulty = 0;
            } else {
                difficulty = maxFret - minFret + 1;
            }

            minDifficulty = Math.min(minDifficulty, difficulty);
            return;
        }

        for (int i = 0; i < M; i++) {
            int openNote = tuning[stringIndex];
            int targetNote = chordNotes[i];
            
            boolean alreadyCovered = notesCovered[i];
            notesCovered[i] = true;

            int baseFret = (targetNote - openNote + 12) % 12;
            currentFrets[stringIndex] = baseFret;
            findMinDifficulty(stringIndex + 1, notesCovered, currentFrets);

            currentFrets[stringIndex] = baseFret + 12;
            findMinDifficulty(stringIndex + 1, notesCovered, currentFrets);

            notesCovered[i] = alreadyCovered;
        }
    }
}