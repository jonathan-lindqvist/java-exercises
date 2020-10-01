package exercises.ex4hangman;

/*
 * This represents the secret word to guess
 */
public class Secret {
    // TODO

    private String secretWord;

    public Secret(String secretWord){
        this.secretWord = secretWord;
    }

    public int getLength(){
        return secretWord.length();
    }
}
