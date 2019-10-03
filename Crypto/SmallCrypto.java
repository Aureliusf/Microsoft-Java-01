import java.util.Scanner;

public class SmallCrypto {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String s = "";

        for(int x=0; x<str.length(); x++){
            char ch = str.charAt(x);
            s += "" + (char)(ch +3);
        }
        System.out.println(s);
    }
}
