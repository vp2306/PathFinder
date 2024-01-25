package ca.mcmaster.se2aa4.mazerunner;

public class Factorizer {
    
    public String factorizeString(String path) {
        String factorizedString = "";
        
        char currentCharacter = path.charAt(0);
        int characterCount = 0;

        for(int i = 0; i < path.length(); i++){
            if (path.charAt(i) == currentCharacter) {
                characterCount++;
            } else{
                factorizedString += "" + characterCount + currentCharacter + " ";
                currentCharacter = path.charAt(i);
                characterCount = 1;
            }
        }

        factorizedString += "" + characterCount + currentCharacter;
        
        return factorizedString.replace("1", "");
    }
}


