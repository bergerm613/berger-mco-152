package berger.scrabble;

import java.io.BufferedReader;
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

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
            dictionaryHash.add(st.split(" ")[0]);
        }
    }

    public boolean wordInFile(String word)
    {
        Iterator<String> itr = dictionaryHash.iterator();
        while (itr.hasNext())
        {
            if (itr.next().equalsIgnoreCase(word))
            {
                return true;
            }
        }

        return false;
    }
}