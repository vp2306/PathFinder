package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Explore implements Algorithm {

    private Position pCurrent = new Position(0, 0);
    private Position pEnd = new Position(0, 0);
    
    @Override
    public String findPath(String[][] maze){

        Factorizer factorize = new Factorizer();

        String currentPath = " ";

        /*
         * R: facing right >
         * U: facing up ^
         * L: facing left <
         * D: facing down v
        */

        String currentDirection = "R"; //initialize it to right >

        //initialize some start and end positions
        pCurrent = Position.starPosition(maze);
        pEnd = Position.endPosition(maze);

        //keeps iterating till explorer not at the end
        while(pCurrent.x != pEnd.x || pCurrent.y != pEnd.y){
            if (rightWall(maze, currentDirection) == true) {
                if (frontWall(maze, currentDirection) == true) {
                    currentDirection = leftTurn(currentDirection);
                    currentPath += "L";
                } else{
                    moveForward(currentDirection);
                    currentPath += "F";
                }
            } else{
                currentDirection = rightTurn(currentDirection);
                currentPath += "R";
                moveForward(currentDirection);
                currentPath += "F";
            }
        }
        //factorize the string
        currentPath = factorize.factorizeString(currentPath);
        return currentPath;
    }

    private void moveForward(String direction) {
    switch (direction) {
        case "R": //if facing right, going forward would go into next column
            pCurrent.x++;
            break;
        case "U":
            pCurrent.y--;
            break;
        case "L":
            pCurrent.x--;
            break;
        case "D":
            pCurrent.y++;
            break;

    }
}


    public String rightTurn(String direction){

        switch (direction) {
            case "R":
                //if facing right, right rotation would be down
                return "D";
 
            case "U":
                return "R";               

            case "L":
                return "U";

            case "D":
                return "L";
        
            default:
                return direction;
        }
  
    }

    public String leftTurn(String direction){

        switch (direction) {
            case "R":
                //if facing right, left rotation would be up
                return "U";

            case "U":
                return "L";

            case "L":
                return "D";

            case "D":
                return "R";
        
            default:
                return direction;
        }
    }

    private boolean rightWall(String[][] maze, String direction){

        switch (direction) {
            case "R": //right wall to someone facing > would be the next row down
                return maze[pCurrent.y+1][pCurrent.x] == "WALL";

            case "U":
                return maze[pCurrent.y][pCurrent.x+1] == "WALL";

            case "L":
                return maze[pCurrent.y-1][pCurrent.x] == "WALL";

            case"D":
                return maze[pCurrent.y][pCurrent.x-1] == "WALL";
        
            default:
                break;
        }
        
        return false;
    }

    private boolean frontWall(String[][] maze, String direction){
        switch (direction) {
            case "R": //front wall to someone facin > would be the next column over
                return maze[pCurrent.y][pCurrent.x+1] == "WALL";

            case "U":
                return maze[pCurrent.y-1][pCurrent.x] == "WALL";

            case "L":
                return maze[pCurrent.y][pCurrent.x-1] == "WALL";

            case"D":
                return maze[pCurrent.y+1][pCurrent.x] == "WALL";
        
            default:
                break;
        }
        
        return false;
    }
}
