package berger.scrabble;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class scrabbleDictionaryTest
{
    @Test
    //tests that a real word is in the dictionary
    public void realWordInFile() throws IOException
    {
        scrabbleDictionary test = new scrabbleDictionary();
        boolean answer = false;

        answer = test.wordInFile("hi");


        assertEquals(answer, true);
    }

    @Test
    //tests that a fake word is not in the dictionary
    public void fakeWordInFile() throws IOException
    {
        scrabbleDictionary test = new scrabbleDictionary();
        boolean answer = false;

        answer = test.wordInFile("blibble");


        assertEquals(answer, false);
    }

    @Test
    //tests that the method is not case sensitive
    public void caseWordInFile() throws IOException
    {
        scrabbleDictionary test = new scrabbleDictionary();
        boolean answer = false;

        answer = test.wordInFile("sLoWpOkEs");


        assertEquals(answer, true);
    }
}