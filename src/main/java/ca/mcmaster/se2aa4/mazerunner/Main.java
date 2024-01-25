package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.module.Configuration;
import java.text.ParseException;

import javax.swing.text.html.Option;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {

        CommandLineParser parser = new DefaultParser();
        Options options = new Options();

        // set hash arg to true because program expects -i or --i to have a file name associated with it
        options.addOption("i", "input", true, "user file input field");
        options.addOption("p", true, "user inputed path");
        
        System.out.println("** Starting Maze Runner");
        
        try {
            //parse the commandline args
            CommandLine cmd = parser.parse(options, args);

            //create a string that will store the actual name of file that needs to be parsed
            String fileName = createFileName(cmd);

            String userPath = cmd.getOptionValue("p");

            PathChecker check = new PathChecker();
            
            
            

            CreateMaze maze = new CreateMaze();
            String[][] actualMaze = maze.generateMaze(fileName);

            Explore explorer = new Explore();
            String path = explorer.findPath(actualMaze);

            if (check.checkPath(userPath, actualMaze) == true){
                System.out.println("you entered a valid path");
            } else{
                System.out.println("No valid path");
            }
            //System.err.println(check.checkPath(userPath, actualMaze));

            System.out.println("Path for current maze: " + path);

        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }


    private static String createFileName(CommandLine cmd){
        //empty string
        String fileName = "";
        //check the valid options and store into fileName
        if (cmd.hasOption("i")) {
            fileName = cmd.getOptionValue("i");
        } else if(cmd.hasOption("input")){
            fileName = cmd.getOptionValue("input");
        } else {
            logger.error("incorrect or no command line tags entered.");
        } 
        
        return fileName;
    }

    
    
}
