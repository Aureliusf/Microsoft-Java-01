import java.util.Scanner;

public class TripPlanner {
    public static void main(String[] args) {
        intro();
        budget();
        time();
        area();
    }
    public static void intro(){
        Scanner input = new Scanner(System.in);
        System.out.print("Hello, welcome to this trip planner.\nWhat is your name? ");
        String name = input.nextLine();
        System.out.print("Hello "+name+".\nWhere are you going to travel? ");
        String place = input.nextLine();
        System.out.println(place + " sounds like a great trip!");
    }

    public static void budget(){
        Scanner input = new Scanner(System.in);

        // days and currency
        System.out.print("How many days is your trip going to be? ");
        int days = input.nextInt();
        System.out.print("How much are you planning to spend in USD? ");
        Double usdbudget = input.nextDouble();

        // USD conversion and buget
        System.out.print("What is the currency symbol in your destination? ");
        String dcurrency = input.next();
        System.out.print("How many "+dcurrency+" are in 1 USD? ");
        Double change = input.nextDouble();

        // Conversion calculations
        double dayusdbudget = Math.round(( usdbudget / days)* 100.0) / 100.0;
        double desbudget = Math.round(( usdbudget*change)* 100.0) / 100.0;
        double daydesbudget =  Math.round(( desbudget / days)* 100.0) / 100.0;

        // Time calculations
        int hours = days * 24;
        int minutes = hours *60;
        int seconds = minutes*60;

        // Prints Time and then budgeting
        System.out.println("If you are travelling for " + days + " days that is the same as " + hours + " hours or " + minutes + " minutes");
        System.out.println("\nIf you are going to spend $" + usdbudget + " that means per day you can spend $" + dayusdbudget + " USD");
        System.out.println("Your total buget in " + dcurrency + " is " + desbudget + " which per day is " + daydesbudget + " " + dcurrency);

    }

    public static void time(){
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

    public static void area(){
       Scanner input = new Scanner(System.in);
        System.out.print("How big is your destination in sq km");
        int kmarea = input.nextInt();
        double mlarea = Math.round(( kmarea *0.386102 ) * 100.0) / 100.0;
        System.out.println("Your destination is " + mlarea + " square miles");

    }

}
