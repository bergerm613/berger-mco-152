package berger.scrabble;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ScrabbleFrame extends JFrame
{
    private JLabel answerLabel;
    private JTextField wordField;

    public ScrabbleFrame()
    {
        setSize(400, 300);
        setTitle("Scrabble Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        wordField = new JTextField();
        wordField.setPreferredSize(new Dimension(160, 40));
        JButton checkButton = new JButton("Check");

        checkButton.addActionListener(actionEvent -> checkWord());

        answerLabel = new JLabel();
        answerLabel.setPreferredSize(new Dimension(100, 40));

        add(wordField);
        add(checkButton);
        add(answerLabel);
    }
        public void checkWord()
        {
            try
            {
                scrabbleDictionary dictionary = new scrabbleDictionary();
                boolean isInDictionary = dictionary.wordInFile(wordField.getText());
                answerLabel.setText(String.valueOf(isInDictionary));
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }



    public static void main(String[] args)
    {
        ScrabbleFrame frame = new ScrabbleFrame();
        frame.setVisible(true);
    }
}
