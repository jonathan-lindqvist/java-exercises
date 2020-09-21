package exercises;

import java.util.Arrays;

import static java.lang.System.out;

/*
 *  Pig Latin, silly secret language
 *  https://en.wikipedia.org/wiki/Pig_Latin
 *
 *  See:
 *  - UseCharacter
 *  - UseStringBuilder
 *  - UseString
 *  - ShortForLoop
 *
 */
public class Ex2PigLatin {

    public static void main(String[] args) {
        new Ex2PigLatin().program();
    }

    void program() {
        out.println(toPigLatin("My name is Eric")
                .equals("yMay amenay isway Ericway"));
    }

    // ---------- Methods --------------------

    // TODO
    String toPigLatin(String str){
        String[] strs = str.trim().split(" ");
        for(int i = 0; i < strs.length; i++){
            boolean consonantLetter = isFirstLetterConsonant(strs[i].toLowerCase().charAt(0));
             if(consonantLetter){
                out.println("Hello world");
             }
        }
        return "hello";
    }

    boolean isFirstLetterConsonant(char letter){
        switch (letter) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return false;
            default:
                return true;
        }
    }

}
