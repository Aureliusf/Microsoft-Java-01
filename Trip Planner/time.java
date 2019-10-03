import java.util.Scanner;

public class time {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("\nWhat is the time difference between your home and your destination? ");
            int diff = input.nextInt();
            if (diff <0) {
                int noon = 12 + diff;
                int mid = 24 + diff;
                System.out.println("\nWhen is midnight at home it will be "+ mid +":00 at your destination");
                System.out.println("When is noon at home it will be "+ noon +":00 at your destination");
            } else {
                int noon = 12 + diff;
                int mid = diff;
                System.out.println("\nWhen is midnight at home it will be "+ mid +":00 at your destination");
                System.out.println("When is noon at home it will be "+ noon +":00 at your destination");
            }

        }
    }
