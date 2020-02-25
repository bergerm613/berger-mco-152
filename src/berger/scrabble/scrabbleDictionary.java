package berger.scrabble;

import java.io.BufferedReader;
import java.io.*;
import java.util.HashSet;

public class scrabbleDictionary
{
    BufferedReader br;
    HashSet<String> wordHash;

    public scrabbleDictionary() throws IOException
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
        if (wordHash.contains(word.toLowerCase()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}