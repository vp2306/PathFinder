package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.module.Configuration;
import java.nio.file.InvalidPathException;
import java.text.ParseException;

import javax.swing.text.html.Option;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.rolling.action.IfAccumulatedFileCount;

public class Main {

    public static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {

        CommandLineParser parser = new DefaultParser();
        Options options = new Options();

        // set hash arg to true because program expects -i or --i to have a file name associated with it
        options.addOption("i", "input", true, "user file input field");
        options.addOption("p", true, "user inputed path");
        
        
        
        try {
            //parse the commandline args
            CommandLine cmd = parser.parse(options, args);

            Algorithm rightHand = new Explore();
            Maze twoD = new CreateMaze();

            //create a string that will store the actual name of file that needs to be parsed
            String fileName = createFileName(cmd);

            String[][] actualMaze = twoD.generateMaze(fileName);

            if (cmd.hasOption("p")) {
                String userPath = cmd.getOptionValue("p");

                PathValidity pathValid = new PathValidity();

                if (pathValid.validPathEntry(userPath) == false) {
                    System.out.println("YOU ENTERED AN INVALID PATH");
                    return;
                }   

                PathChecker check = new PathChecker();

                if (check.checkPath(userPath, actualMaze) == true){
                System.out.println("correct path");
            }   else{
                    System.out.println("incorrect path");
                }
            } else{
                System.out.println("**** Computing path");
                //Explore explorer = new Explore();
                String path = rightHand.findPath(actualMaze);
                System.out.println(path);
            }           

        } catch(Exception e) {
            System.out.println("/!\\ An error has occured /!\\");
            System.out.println("PATH NOT COMPUTED");
        }
                
        System.out.println("** End of MazeRunner");
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
