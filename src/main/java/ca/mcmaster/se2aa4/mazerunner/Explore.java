package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Explore {
    
    public String findPath(String[][] maze){

        String currentPath = " ";


        //find starting coordiate
        ArrayList<Position> path = new ArrayList<>();
        Position p = new Position();

        int row = maze.length;

        //now we find the actual starting position. iterate 2d arr
        for(int i = 0; i < row; i ++){
            if (maze[i][0] == "PASS") {
                p.x = 0;//column 0
                p.y = i+1;//row i
                break;
            }
        }

        
        return currentPath;
    }


}
