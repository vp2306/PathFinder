package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateMaze {
    public static final Logger logger = LogManager.getLogger();

    public ArrayList<ArrayList<String>> generateMaze(String fileName){

        //maze will contain the pass and wall. this data structure will allow for easier storage
        ArrayList<ArrayList<String>> maze = new ArrayList<ArrayList<String>>();

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
                System.out.print(System.lineSeparator());
                maze.add(currentRow);

            }
        }catch(Exception e){
            logger.error("an error occured");
        }
        
        for(ArrayList<String> row:maze){
            for(String cell: row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        return maze;

    }
}
