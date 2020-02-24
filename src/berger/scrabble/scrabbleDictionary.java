package berger.scrabble;

import java.io.BufferedReader;
import java.io.*;

public class scrabbleDictionary
{
    BufferedReader br;

    public scrabbleDictionary() throws IOException
    {
        File file = new File("C:\\Users\\michal\\Desktop\\dictionary.txt");
        br = new BufferedReader(new FileReader(file));
    }

    public boolean wordInFile(String word) throws IOException
    {
        String st;

        while ((st = br.readLine()) != null)
        {
            if ((st.split(" ")[0]).equalsIgnoreCase(word))
            {
                return true;
            }
        }
        return false;
    }
}