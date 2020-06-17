public class InverseString {

    public static void main(String[] args) {
        String word = "Andres";
        int len = word.length();
        reverse(word, len);
    }

    public static void reverse(String w, int len) {
        if (len - 1 >= 0) {
            System.out.print(w.charAt(len - 1));
            reverse(w, len - 1);
        }
    }
}