
/**
 * isunique
 */
public class isunique {

    static boolean uniqueChars(String str) {
        if (str.length() > 128)
            return false;

        boolean[] char_set = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }

            char_set[val] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        String strToCheck = "aafweas"; // Has duplicates
        String strToCheck2 = "asdfghjkl"; // No duplicates

        System.out.println(uniqueChars(strToCheck));
        System.out.println(uniqueChars(strToCheck2));

    }
}