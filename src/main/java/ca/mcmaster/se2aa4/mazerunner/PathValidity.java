package ca.mcmaster.se2aa4.mazerunner;

public class PathValidity {
    
    public boolean validPathEntry(String path) {

        for (char x : path.toCharArray()) {
            //check if the character is 'F', 'R', 'L', or a digit
            if (!(x == 'F' || x == 'R' || x == 'L' || Character.isDigit(x))) {
                return false;
            }
        }
        return true;
    }
}
