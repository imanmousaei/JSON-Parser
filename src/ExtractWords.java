import java.util.ArrayList;
import java.util.Arrays;

public class ExtractWords {
    public static ArrayList<String> extractWordsByHand(String txt, char splitBy) {
        ArrayList<String> words = new ArrayList<>();
        int start = 0, n = txt.length();
        for (int i = 0; i < n; i++) {
            if (txt.charAt(i) == splitBy) {
                words.add(txt.substring(start, i));
                start = i + 1;
            }
        }
        words.add(txt.substring(start, n));
        return words;
    }

    public static ArrayList<String> extractWordsBySplit(String txt, String splitBy) {
        String[] words = txt.split(splitBy);
        return new ArrayList<>(Arrays.asList(words));
    }

}
