package berger.scrabble;

import java.io.BufferedReader;
import java.io.*;
import java.util.HashSet;

public class scrabbleDictionary
{
    BufferedReader br;
    HashSet<String> dictionaryHash;

    public scrabbleDictionary() throws IOException
    {
        File file = new File("C:\\Users\\michal\\Desktop\\dictionary.txt");
        br = new BufferedReader(new FileReader(file));
        dictionaryHash = new HashSet<String>();

        String st;
        while ((st = br.readLine()) != null)
        {
            dictionaryHash.add((st.split(" ")[0]).toLowerCase());
        }
    }

    public boolean wordInFile(String word)
    {
        if (dictionaryHash.contains(word.toLowerCase()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}