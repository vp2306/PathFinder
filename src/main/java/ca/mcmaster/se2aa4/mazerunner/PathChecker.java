package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.core.pattern.PlainTextRenderer;

public class PathChecker {

    private Position pCurrent = new Position(0, 0);
    
    private Position pEnd = new Position(0,0);
    String currentDirection = "R"; //initialize it to right for time being >

    public boolean checkPath (String userPath, String [][] maze){
       
        /*
         * R: facing right >
         * U: facing up ^
         * L: facing left <
         * D: facing downwards v
        */

        //create instance of factorizer so program handles both factorized and nonfactorized paths
        Factorizer factor = new Factorizer();
        userPath = factor.reverseFactorize(userPath);

        //call mover moethod for initial iteration (left to right)
        moverMethod(userPath, maze, currentDirection);
        if (pCurrent.x == pEnd.x && pCurrent.y == pEnd.y) {
            return true;
        } 
        //if its not vlaid for left to right, check right to left
        else if(pCurrent.x != pEnd.x || pCurrent.y != pEnd.y){

            //change initial direction since it will be oposite
            currentDirection = "L";
            //swap start and end positions
            pCurrent = Position.endPosition(maze);
            pEnd = Position.starPosition(maze);
            //call mover method again with new direction 
            moverMethod(userPath, maze, currentDirection);

            return pCurrent.x == pEnd.x && pCurrent.y == pEnd.y;
            
        } return false;       
        
    }

    private void moverMethod(String path, String [][] maze, String direction){
        Explore explore = new Explore();

        pCurrent = Position.starPosition(maze);
        pEnd = Position.endPosition(maze);

        String pathNoSpaces = path.replace(" ", "");
        char[] inputPathArr = pathNoSpaces.toCharArray();


        for(int i = 0; i < inputPathArr.length; i++){
            
            switch(inputPathArr[i]){
                case 'F':
                    goForward(currentDirection);
                    break;
                case 'R':
                    currentDirection = explore.rightTurn(currentDirection);
                    break;
                case 'L':
                    currentDirection = explore.leftTurn(currentDirection);
                    break;

            }
            
        }
    }   
    
    private void goForward (String direction){
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

    }
    }

    
}
