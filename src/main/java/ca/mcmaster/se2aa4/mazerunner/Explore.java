package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Explore {

    private Position pCurrent = new Position();
    private Position pEnd = new Position();
    
    public String findPath(String[][] maze){

        String currentPath = " ";

        /*
         * R: facing right
         * U: facing up
         * L: facing left
         * D: facing down
        */

        String currentDirection = "R"; 

        //find starting coordiate
        ArrayList<Position> path = new ArrayList<>();
        

        int row = maze.length;

        //now we find the actual starting position. iterate 2d arr
        for(int i = 0; i < row; i ++){
            if (maze[i][0] == "PASS" || maze[i][0] == null) {
                pCurrent.x = 0;//column 0
                pCurrent.y = i;//row i
                break;
            }
        }

        for(int j = 0; j < row; j++){
            if(maze[j][maze[0].length-1] == "PASS" || maze[j][maze[0].length-1]== null){
                pEnd.x = maze[0].length-1; // last column
                pEnd.y = j;//row in last column that contains the pass
                break;
            }
        }

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

            case"D":
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

            case"D":
                return "R";
        
            default:
                return direction;
        }
    }

    private boolean rightWall(String[][] maze, String direction){

        switch (direction) {
            case "R":
                //if facing right and wall exists to movers right
                if (maze[pCurrent.y+1][pCurrent.x] == "WALL") {
                    return true;
                }
                break;

            case "U":
                if (maze[pCurrent.y][pCurrent.x+1] == "WALL") {
                    return true;
                }
                break;

            case "L":
                if (maze[pCurrent.y-1][pCurrent.x] == "WALL") {
                    return true;
                }
                break;
            case"D":
                if(maze[pCurrent.y][pCurrent.x-1] == "WALL"){
                    return true;
                }
                break;
        
            default:
                break;
        }
        
        return false;
    }

    private boolean frontWall(String[][] maze, String direction){
        switch (direction) {
            case "R":
                //if facing right and wall exists to movers front
                if (maze[pCurrent.y][pCurrent.x+1] == "WALL") {
                    return true;
                }
                break;

            case "U":
                if (maze[pCurrent.y-1][pCurrent.x] == "WALL") {
                    return true;
                }
                break;

            case "L":
                if (maze[pCurrent.y][pCurrent.x-1] == "WALL") {
                    return true;
                }
                break;
            case"D":
                if(maze[pCurrent.y+1][pCurrent.x] == "WALL"){
                    return true;
                }
                break;
        
            default:
                break;
        }
        
        return false;
    }


}
