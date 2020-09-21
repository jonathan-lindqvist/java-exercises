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
        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            boolean consonantLetter = isFirstLetterConsonant(s.toLowerCase().charAt(0));
            int startAt = 0;
            if (consonantLetter) {
                startAt = 1;
            }

            char[] charArr = s.toCharArray();
            for (int j = startAt; j < charArr.length; j++) {
                sb.append(charArr[j]);
            }

            if (startAt == 1) {
                sb.append(charArr[0]).append('a').append('y').append(' ');
            } else {
                sb.append('w').append('a').append('y').append(' ');
            }
        }
        return sb.toString().trim();
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
