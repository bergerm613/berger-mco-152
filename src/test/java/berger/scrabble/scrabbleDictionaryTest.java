package berger.scrabble;

import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.*;

public class scrabbleDictionaryTest
{
    @Test
    //tests that a real word is in the dictionary
    public void realWordInFile() throws IOException
    {
        ScrabbleDictionary test = new ScrabbleDictionary();
        boolean answer = false;

        answer = test.wordInFile("hi");

        assertTrue(answer);
    }

    @Test
    //tests that a fake word is not in the dictionary
    public void fakeWordInFile() throws IOException
    {
        ScrabbleDictionary test = new ScrabbleDictionary();
        boolean answer = false;

        answer = test.wordInFile("blibble");

        assertFalse(answer);
    }

    @Test
    //tests that the method is not case sensitive
    public void caseWordInFile() throws IOException
    {
        ScrabbleDictionary test = new ScrabbleDictionary();
        boolean answer = false;

        answer = test.wordInFile("sLoWpOkEs");

        assertTrue(answer);
    }
}