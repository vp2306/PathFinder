package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Explore {
    
    public String findPath(String[][] maze){

        String currentPath = " ";

        //find starting coordiate
        ArrayList<Position> path = new ArrayList<>();
        Position pCurrent = new Position();
        Position pEnd = new Position();

        int row = maze.length;

        //now we find the actual starting position. iterate 2d arr
        for(int i = 0; i < row; i ++){
            if (maze[i][0] == "PASS") {
                pCurrent.x = 0;//column 0
                pCurrent.y = i;//row i
                break;
            }
        }

        for(int j = 0; j < row; j++){
            if(maze[j][maze[0].length-1] == "PASS"){
                pEnd.x = maze[0].length-1; // last column
                pEnd.y = j;//row in last column that contains the pass
                break;
            }
        }

        currentPath = "col " + pCurrent.x + " row " + pCurrent.y + " done";

        
        return currentPath;
    }


}
