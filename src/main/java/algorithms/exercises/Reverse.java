package algorithms.exercises;

public class Reverse {
    public String reverseWord(String word) {
        char[] result = new char[word.length()];
        char[] str = word.toCharArray();
        for (int i = str.length-1; i >= 0; i--) {
            result[str.length-1-i] = str[i];
        }

        return String.valueOf(result);
    }
}
