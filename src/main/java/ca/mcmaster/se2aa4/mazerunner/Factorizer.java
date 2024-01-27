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
                factorizedString += Integer.toString(characterCount) + currentCharacter;
                currentCharacter = path.charAt(i);
                characterCount = 1;
            }
        }

        factorizedString += Integer.toString(characterCount) + currentCharacter;
        
        return factorizedString.replace("1", "");
    }

    public String reverseFactorize(String path){
        StringBuilder nonFactorized = new StringBuilder();

        for(int i = 0; i < path.length(); i++){
            //check if the current character is a digit
            if (Character.isDigit(path.charAt(i))) {
                int num = Character.getNumericValue(path.charAt(i));
                
                //append the character num times
                for(int j = 0; j <num; j++){
                    nonFactorized.append(path.charAt(i+1));
                }
            
            //move i to next index, so it dosent append same character again
            i++;
                
            } else{
                nonFactorized.append(path.charAt(i));
            }
        }

        return nonFactorized.toString();
    }
}


