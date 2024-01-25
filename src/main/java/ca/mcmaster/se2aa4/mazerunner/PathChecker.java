package ca.mcmaster.se2aa4.mazerunner;

public class PathChecker {

    private Position pCurrent = new Position(0, 0);
    private Position pEnd = new Position(0,0);

    public boolean checkPath (String path, String [][] maze){

        Explore explore = new Explore();

        /*
         * R: facing right >
         * U: facing up ^
         * L: facing left <
         * D: facing down v
        */

        String currentDirection = "R"; //initialize it to right for time being >

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
        if (pCurrent.x == pEnd.x && pCurrent.y == pEnd.y) {
            return true;
        }


        return false;
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
