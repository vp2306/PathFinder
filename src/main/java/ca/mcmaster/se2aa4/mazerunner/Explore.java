package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Explore {

    private Position pCurrent = new Position();
    private Position pEnd = new Position();
    
    public String findPath(String[][] maze){

        Factorizer factorize = new Factorizer();

        String currentPath = " ";

        /*
         * R: facing right
         * U: facing up
         * L: facing left
         * D: facing down
        */

        String currentDirection = "R"; //initialize it to right ->

        pCurrent = Position.starPosition(maze);
        pEnd = Position.endPosition(maze);

        while(pCurrent.x != pEnd.x || pCurrent.y != pEnd.y){
            if (rightWall(maze, currentDirection) == true) {
                if (frontWall(maze, currentDirection) == true) {
                    currentDirection = ccwRotator(currentDirection);
                    currentPath += "L";
                } else{
                    moveForward(currentDirection);
                    currentPath += "F";
                }
            } else{
                currentDirection = cwRotator(currentDirection);
                currentPath += "R";
                moveForward(currentDirection);
                currentPath += "F";
            }
        }
        currentPath = factorize.factorizeString(currentPath);
        return currentPath;
    }

    private void moveForward(String direction){

        switch (direction) {
            case "R":
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
        
            default:
                break;
        }
    }

    private String cwRotator(String direction){

        switch (direction) {
            case "R":
                //if facing right, clockwise rotation would be down
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

    private String ccwRotator(String direction){

        switch (direction) {
            case "R":
                //if facing right, counter-clockwise rotation would be down up
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
            case "R":
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
            case "R":
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
