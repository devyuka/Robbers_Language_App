import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;
import java.util.stream.Stream;

public class RobbersLanguageTest {

    @ParameterizedTest
    @MethodSource("replaceLettersTestSource")
    public void replaceLettersTest(String word, String replacedWord) {
        RobbersLanguage test = new RobbersLanguage();
        assertEquals(replacedWord, test.replaceLetters(word));
    }

    static Stream < Arguments > replaceLettersTestSource() {
        return Stream.of(
                arguments("ham", "hijamon"),
                arguments("joy", "jikoyuz"),
                arguments("aieou", "aieou")
        );
    }
}