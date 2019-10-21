import java.util.Scanner;

public class MazeRunner {

    public static void main(String[] args) {
        Maze myMap = new Maze();
        intro(myMap);
        int moves =0;
        check(movement(),myMap,movesMessage(moves));
    }

    public static void intro(Maze myMap){
        System.out.println("Welcome to Maze Runner!\nHere is your current position:");
        myMap.printMap();
    }

    public static String movement(){
        System.out.print("Where would you like to move? (R, L, U, D)");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


    public static void check(String directions, Maze myMap, int moves){
        if (myMap.didIWin()){
            System.out.println("Congratulations, you made it out alive! in "+moves+"/100 moves");
        } else {
            directions = directions.toUpperCase();
            if (directions.contains("R")){
                if (myMap.canIMoveRight()) {
                    System.out.println("You move to the Right");
                    myMap.moveRight();
                    System.out.println(moves + "/100");
                    myMap.printMap();
                    check(movement(), myMap, movesMessage(moves));
                } else if (myMap.isThereAPit("R")){
                    navigatePit(myMap,moves,directions);
                    System.out.println(moves+"/100");
                    myMap.printMap();
                    check(movement(),myMap,movesMessage(moves));

                } else{
                    System.out.println("Sorry, you've hit the wall.");
                    System.out.println("Try again");
                    System.out.println(moves+"/100");
                    myMap.printMap();
                    check(movement(),myMap,moves);
                }
            } else if (directions.contains("L")){
                if (myMap.canIMoveLeft()){
                    System.out.println("You move to the Left");
                    myMap.moveLeft();
                    System.out.println(moves+"/100");
                    myMap.printMap();
                    check(movement(),myMap,movesMessage(moves));
                } else if (myMap.isThereAPit("L")){
                    navigatePit(myMap,moves,directions);
                    System.out.println(moves+"/100");
                    myMap.printMap();
                    check(movement(),myMap,movesMessage(moves));

                } else{
                    System.out.println("Sorry, you've hit the wall.");
                    System.out.println("Try again");
                    System.out.println(moves+"/100");
                    myMap.printMap();
                    check(movement(),myMap,moves);
                }
            } else if (directions.contains("U")){
                if (myMap.canIMoveUp()){
                    System.out.println("You move Up");
                    myMap.moveUp();
                    System.out.println(moves+"/100");
                    myMap.printMap();
                    check(movement(),myMap,movesMessage(moves));
                } else if (myMap.isThereAPit("U")){
                    navigatePit(myMap,moves,directions);
                    System.out.println(moves+"/100");
                    myMap.printMap();
                    check(movement(),myMap,movesMessage(moves));

                } else{
                    System.out.println("Sorry, you've hit the wall.");
                    System.out.println("Try again");
                    System.out.println(moves+"/100");
                    myMap.printMap();
                    check(movement(),myMap,moves);
                }
            } else if (directions.contains("D")){
                if (myMap.canIMoveDown()){
                    System.out.println("You move Down");
                    myMap.moveDown();
                    System.out.println(moves+"/100");
                    myMap.printMap();
                    check(movement(),myMap,movesMessage(moves));
                } else if (myMap.isThereAPit("D")){
                    navigatePit(myMap,moves,directions);
                    System.out.println(moves+"/100");
                    myMap.printMap();
                    check(movement(),myMap,movesMessage(moves));

                } else{
                    System.out.println("Sorry, you've hit the wall.");
                    System.out.println("Try again");
                    System.out.println(moves+"/100");
                    myMap.printMap();
                    check(movement(),myMap,moves);
                }
            } else{
                System.out.println("Sorry, you've hit the wall.");
                System.out.println("Try again");
                myMap.printMap();
                System.out.println(moves+"/100");
                check(movement(),myMap,moves);
            }
        }
    }

    public static int movesMessage(int moves){
        moves ++;

        if (moves == 101){
            System.out.println("100 Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
        } else if (moves >= 90){
            System.out.println("90 DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        } else if (moves >= 75){
            System.out.println("75 Alert! You have made 75 moves, you only have 25 moves left to escape.");
        } else if (moves >= 50){
            System.out.println("50 Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        }
        return moves;
    }

    public static void navigatePit(Maze myMap, int moves, String directions){
        System.out.println("Watch out! There's a pit ahead, jump it?");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.contains("y") || input.contains("Y") ){
            myMap.jumpOverPit(directions.toUpperCase());
            movesMessage(moves);
        } else{
            System.out.println("Try again");
            myMap.printMap();
            System.out.println(moves+"/100");
            check(movement(),myMap,moves);
        }
    }
}
