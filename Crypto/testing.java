public class testing {
    public static void main(String[] args) {
        String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedABC = shiftAlphabet(-1);
        String text = "ILIKEAPPLES";
        //System.out.println(Character.getNumericValue(ch)-10);
        String result ="";
        for (int n =0; n<text.length();n++){
            char ch = text.charAt(n);
            System.out.println(shiftedABC.charAt(Character.getNumericValue(ch)-10));
            result += "" + (char) shiftedABC.charAt(Character.getNumericValue(ch)-10);
        }
        System.out.println(result);
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
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        System.out.println(result);
        return result;
    }
}
