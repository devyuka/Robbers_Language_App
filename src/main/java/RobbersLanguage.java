import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RobbersLanguage {
    private static final List < Character > ALPHABET_LIST = new ArrayList < Character > (
            (Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'))
    );

    private static final List < Character > VOWEL_LIST = new ArrayList < Character > (
            (Arrays.asList('a', 'e', 'i', 'o', 'u'))
    );
    
    private static final List < Integer > VOWEL_INDEX_LIST = new ArrayList < Integer > (
            (Arrays.asList(
                    ALPHABET_LIST.indexOf('a'),
                    ALPHABET_LIST.indexOf('e'),
                    ALPHABET_LIST.indexOf('i'),
                    ALPHABET_LIST.indexOf('o'),
                    ALPHABET_LIST.indexOf('u')
            ))
    );

    public RobbersLanguage() {};

    public String replaceLetters(String word) {
        StringBuilder replacedWord = new StringBuilder();

        for (char ch: word.toCharArray()) {
            if (isVowel(ch)) {
                replacedWord.append(ch);
            } else {
                replacedWord.append(convertConsonant(ch));
            }
        }

        return replacedWord.toString();
    };

    private boolean isVowel(char ch) {
        return VOWEL_LIST.indexOf(ch) != -1;
    }

    private String convertConsonant(Character ch) {
        StringBuilder convertedLetters = new StringBuilder();
        convertedLetters.append(ch);
        convertedLetters.append(getClosestVowel(ch));
        convertedLetters.append(getNextConsonant(ch));

        return convertedLetters.toString();
    }

    private Character getClosestVowel(Character consonant) {

        int consonantIndex = ALPHABET_LIST.indexOf(consonant);
        int distance = consonantIndex - VOWEL_INDEX_LIST.get(0);
        int closestVowelIndex = VOWEL_INDEX_LIST.get(0);

        for (int index: VOWEL_INDEX_LIST) {
            if (Math.abs(consonantIndex - index) == distance) {
                continue;
            } else if (Math.abs(consonantIndex - index) < distance) {
                closestVowelIndex = index;
            }
            distance = consonantIndex - index;
        }

        return ALPHABET_LIST.get(closestVowelIndex);
    }

    private Character getNextConsonant(Character consonant) {
        int consonantIndex = ALPHABET_LIST.indexOf(consonant);

        if (consonant == 'z') {
            return consonant;
        }
        if (VOWEL_LIST.contains(ALPHABET_LIST.get(consonantIndex + 1))) {
            return ALPHABET_LIST.get(consonantIndex + 2);
        } else {
            return ALPHABET_LIST.get(consonantIndex + 1);
        }
    }
}