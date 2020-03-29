package berger.scrabble;

import java.io.*;
import java.util.HashSet;

public class ScrabbleDictionary
{
    BufferedReader br;
    HashSet<String> wordHash;

    public ScrabbleDictionary() throws IOException
    {
        File file = new File("dictionary.txt");
        br = new BufferedReader(new FileReader(file));
        wordHash = new HashSet<String>();

        String st;
        while ((st = br.readLine()) != null)
        {
            wordHash.add((st.split(" ")[0]).toLowerCase());
        }
    }

    public boolean wordInFile(String word)
    {
        return wordHash.contains(word.toLowerCase());
    }
}