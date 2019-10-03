public class test {
    public static void main(String[] args) {
        String text = "UIJTJTTPNFSFBMMZHSFBUUFYUxx";
        int key =1;

        String last = "";
        last += text.charAt(text.length() - 1);

        String secondLast = "";
        secondLast += text.charAt(text.length() - 2);
        secondLast += text.charAt(text.length() - 1);

        if (secondLast.equals("xx")) {
            String str = "";
            for (int n = 0; n < text.length() - 2; n++) {
                char ch = text.charAt(n);
                str += "" + ch;
            }
            System.out.println(1);
            caesarify(text, -key);
        } else if (last.equals("x")) {
            String str = "";
            for (int n = 0; n < text.length() - 1; n++) {
                char ch = text.charAt(n);
                str += "" + ch;
            }
            System.out.println(2);
            caesarify(text, -key);
        } else {
            System.out.println(3);
            caesarify(text, -key);
        }
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for (; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if (result.length() < 26) {
            for (currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String caesarify(String text, int key) {
        String shiftedABC = shiftAlphabet(key);
        String result = "";
        for (int n = 0; n < text.length(); n++) {
            char ch = text.charAt(n);
            result += "" + (char) shiftedABC.charAt(Character.getNumericValue(ch) - 10);
        }
        return result;
    }
}
