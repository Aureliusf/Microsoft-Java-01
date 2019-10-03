import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        int key = 6;
        int ratio =3;
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String normalizeText = normalizeText(text);
        String result = encryptString(normalizeText,key,ratio);
        System.out.println(result);
        System.out.println(decryptString(result,key));

    }

    // Starts every procedure for the program
    public static String encryptString(String text, int key, int ratio){
        String normalizeText = normalizeText(text);
        String encrypted = caesarify(normalizeText,key);
        String result = groupify(encrypted,ratio);
        return result;
    }

    // Normalize the text, everything uppercase no spaces no punctuation signs
    public static String normalizeText(String text) {
        String str = "";
        for (int y = 0; y < text.length(); y++) {
            char ch = text.charAt(y);
            if (ch >= 'a' && ch <= 'z') {
                str += "" + (char) (ch - 32);
            } else if (ch >= 'A' && ch <= 'Z') {
                str += "" + ch;
            } else
                str += "";
            }
        return str;
    }

    // Shifts entire alphabet key times to address it in caesarify()
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
        return result;
    }

    // Changes every character in a given String to the respective character in the shifted alphabet
    public static String caesarify( String text, int key) {
        String shiftedABC = shiftAlphabet(key);
        String result ="";
        for (int n =0; n<text.length();n++){
            char ch = text.charAt(n);
            result += "" + (char) shiftedABC.charAt(Character.getNumericValue(ch)-10);
        }
        return result;

    }

    // Groups any given String into packages of ratio and patch with x's to complete every package
    public static String groupify( String text, int ratio) {
        String result = "";
        int x =0;
        // adds 1 space if the x counter reaches 3
        for (int n = 0; n<text.length();n++){
            char ch = text.charAt(n);
            if (x<ratio){
                x+=1;
                result += "" + ch;
            } else {
                x = 1;
                result += " " + ch;
            }
        }
        // patches with the x's
        for (int n=0;n<2;n++){
            if (normalizeText(result).length()%3==0){
                break;
            } else {
                result += "x";
            }
        }
        return result;
    }

    // Gets read of every space in a String
    public static String ungroupify(String text){
        String str = "";
        for (int y = 0; y < text.length(); y++) {
            char ch = text.charAt(y);
            if (ch >= 'a' && ch <= 'z') {
                str += "" + ch;
            } else if (ch >= 'A' && ch <= 'Z') {
                str += "" + ch;
            } else
                str += "";
        }
        return str;
    }

    // Decrypts any given string encrypted by this algorithm
    public static String decryptString(String text, int key){
        text = ungroupify(text);

        // last and secondLast are the last and second to last characters of text
        String last ="";
        last += text.charAt(text.length()-1);

        String secondLast ="";
        secondLast += text.charAt(text.length()-2);
        secondLast += text.charAt(text.length()-1);

        // Removes xx or x or it leaves it like that and send it
        if (secondLast.equals("xx")){
            String str = "";
            for (int n =0; n<text.length()-2;n++){
                char ch = text.charAt(n);
                str += "" +ch;
            }
            String result = caesarify(str,-key);
            return result;
        } else if (last.equals("x")){
            String str = "";
            for (int n =0; n<text.length()-1;n++){
                char ch = text.charAt(n);
                str += "" +ch;
            }
            String result = caesarify(str,-key);
            return result;
        }else {
            String result = caesarify(text,-key);
            return result;
        }
    }
}
