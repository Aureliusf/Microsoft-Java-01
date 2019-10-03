import java.util.Random;
import java.util.*;

public class OddsAndEvens {
    public static void main(String[] args) {
        System.out.println("Odds and Evens");
        System.out.println("What is your name?");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Welcome "+name+", which do you choose? (O)dds or (E)vens?");
        String option = sc.nextLine();
        if (option.startsWith("O")){
            System.out.println(name+" has picked odds! the computer will be evens");
        }else if (option.startsWith("E")){
            System.out.println(name+" has picked evens! the computer will be odds");
        }else{
            System.out.println("shut up and pick something");
        }
        System.out.println("-------------------");

        System.out.println("How many fingers do you put out?");
        int fingers = sc.nextInt();
        Random rand = new Random();
        int computer = rand.nextInt((10+1));
        System.out.println("The computer plays number " + computer);

        System.out.println("-------------------");

        int sum = fingers+computer;
        boolean oddOrEven = sum % 2 ==0;
        if (oddOrEven){
            System.out.println("The sum is odd");
            if (option.startsWith("O")){
                System.out.println("That means "+name+" wins");
            }else{
                System.out.println("That means the computer wins!");
            }
        }else{
            System.out.println("The sum is even");
            if (option.startsWith("E")){
                System.out.println("That means "+name+" wins");
            }else{
                System.out.println("That means the computer wins!");
            }
        }

        System.out.println("-------------------");

    }
}
