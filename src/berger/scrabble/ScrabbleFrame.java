package berger.scrabble;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ScrabbleFrame extends JFrame
{
    private final JLabel answerLabel;
    private final JTextField wordField;
    private ScrabbleDictionary dictionary;

    public ScrabbleFrame()
    {
        setSize(400, 300);
        setTitle("Scrabble Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        wordField = new JTextField();
        wordField.setPreferredSize(new Dimension(160, 40));
        JButton checkButton = new JButton("Check");

        checkButton.addActionListener(actionEvent -> checkWord());

        answerLabel = new JLabel();
        answerLabel.setPreferredSize(new Dimension(100, 40));
        answerLabel.setOpaque(true);
        answerLabel.setForeground(Color.WHITE);

        add(wordField);
        add(checkButton);
        add(answerLabel);

        try
        {
            dictionary = new ScrabbleDictionary();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void checkWord()
    {
        boolean isInDictionary = dictionary.wordInFile(wordField.getText());
        answerLabel.setText(String.valueOf(isInDictionary));
        answerLabel.setBackground(isInDictionary? Color.GREEN : Color.RED);
    }


    public static void main(String[] args)
    {
        ScrabbleFrame frame = new ScrabbleFrame();
        frame.setVisible(true);
    }
}
