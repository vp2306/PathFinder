package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateMaze {
    public static final Logger logger = LogManager.getLogger();

    public String[][] generateMaze(String fileName){

        //maze will contain the pass and wall. this data structure will allow for easier storage
        ArrayList<ArrayList<String>> maze = new ArrayList<ArrayList<String>>();

        //later convert the arraylist into a 2d array to make it easier to iterate
        
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

        //initilaize 2d array with same rows and colums to make it easier to iterate
        String [][] mazeArr = new String[maze.size()][maze.get(0).size()];

        for(int i = 0; i < maze.size(); i++){
            for(int j = 0; j < maze.get(i).size(); j++){
                mazeArr[i][j] = maze.get(i).get(j);
            }
        }
        for (int i = 0; i < mazeArr.length; i++) {
            for (int j = 0; j < mazeArr[i].length; j++) {
                System.out.print(mazeArr[i][j] + " ");
            }
            System.out.println();
        }
        
        return mazeArr;

    }
}
