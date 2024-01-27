package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateMaze implements Maze {
    public static final Logger logger = LogManager.getLogger();

    @Override
    public String[][] generateMaze(String fileName){

        //maze will contain the pass and wall. this data structure will allow for easier storage
        ArrayList<ArrayList<String>> maze = new ArrayList<ArrayList<String>>();

        //initilaize a 2d array
        String [][] maze2d;

        
        try{
            logger.info("**** Reading the maze from file " + fileName);
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {

                //new array list that will be appended to maze every line break to create the maze
                ArrayList<String> currentRow = new ArrayList<>();
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        //System.out.print("WALL ");
                        currentRow.add("WALL");
                    } else if (line.charAt(idx) == ' ') {
                        //System.out.print("PASS ");
                        currentRow.add("PASS");
                    }
                }
                //System.out.print(System.lineSeparator());
                maze.add(currentRow);

            }
        }catch(Exception e){
            logger.error("an error occured");
        }

        maze2d = convert2dArr(maze);
        return maze2d;     
    }

    private String[][] convert2dArr (ArrayList<ArrayList<String>> maze){
        //initilaize 2d array with same rows and colums to make it easier to iterate
        String [][] mazeArr = new String[maze.size()][maze.get(0).size()];

        for(int i = 0; i < maze.size(); i++){
            for(int j = 0; j < maze.get(i).size(); j++){
                mazeArr[i][j] = maze.get(i).get(j);
            }
        }       
        return mazeArr;
    }
}
