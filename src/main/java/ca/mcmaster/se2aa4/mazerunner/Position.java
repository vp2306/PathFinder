package ca.mcmaster.se2aa4.mazerunner;

public class Position {

    public int x;
    public int y;

    

    public static Position starPosition (String[][] maze){
        Position current = new Position();

        for(int i = 0; i < maze.length; i ++){
            if (maze[i][0] == "PASS" || maze[i][0] == null) {
                current.x = 0;//column 0
                current.y = i;//row i
                break;
            }
        }
        
        return current;
    }

    public static Position endPosition(String[][] maze){
        Position end = new Position();

        for(int j = 0; j < maze.length; j++){
            if(maze[j][maze[0].length-1] == "PASS" || maze[j][maze[0].length-1]== null){
                end.x = maze[0].length-1; // last column
                end.y = j;//row in last column that contains the pass
                break;
            }
        }

        return end;

    }

    
}
