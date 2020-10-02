package exercises.ex4hangman;

/*
 * This represents the secret word to guess
 */
public class Secret {
    // TODO

    private String secretWord;
    private char[] mask;

    public Secret(String secretWord){
        this.secretWord = secretWord;
        mask = new char[secretWord.length()];
        fillMask();
    }

    private void fillMask(){
        for(int i = 0; i < mask.length; i++){
            mask[i] = '_';
        }
    }

    public int getLength(){
        return secretWord.length();
    }

    public String getSecretWord(){
        return secretWord;
    }

    public String getMask(){
        return String.valueOf(mask);
    }

    public boolean isGuessInSecret(char ch){
       if(secretWord.indexOf(ch) > -1){
           return true;
       }else{
           return false;
       }
    }

    public void updateMask(char ch){
        for(int i = 0; i < secretWord.length(); i++){
            if(ch == secretWord.charAt(i)){
                mask[i] = ch;
            }
        }
    }

    public boolean isWordGuessed(){
        for(char c : mask){
            if(c == '_'){
                return false;
            }
        }
        return true;
    }
}
