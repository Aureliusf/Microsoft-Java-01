public class MazeRunner {
    Maze myMap=new Maze;
    public static void main(String[] args) {
        intro();
    }
    public static void intro(){
        System.out.println("Welcome to the Maze");
    }
    public static String userMover(){
        if_myMap.canIMoveRight("R"); = true{
            myMap.MoveRight();
        }
        if_myMap.canIMoveLeft("L"); = true{
            myMap.MoveLeft();
        }
        if_myMap.canIMoveUp("U"); = true{
            myMap.MoveUp();
        }
        if_myMap.canIMoveDown("D"); = true{
            myMap.MoveDown();
        }

        return direction;
    }

    public static void movesMessage(int moves){
        System.out.println((100-moves)+" moves left");

        if (moves==100){
            System.out.println("You lost");
            break;
        } else if (moves>90){
            System.out.println("You better wrap it up fast");
        } else if (moves>50){
            System.out.println("You are half way in");
        }
    }

    public static void navigatePit(direction){
        if (myMap.isThereAPit()){
            System.out.println("There is a pit");
            System.out.println("Do you want to jump over the pit?");
        }

    }
}
