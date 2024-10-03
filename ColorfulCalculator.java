import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ColorfulCalculator implements ActionListener {

    JFrame jf;
    JLabel displayLabel;
    JButton[] numberButtons = new JButton[10]; 
    JButton dotButton, equalButton, addButton, subButton, mulButton, divButton, clearButton;
    String operator;
    double num1, num2, result;

    public ColorfulCalculator() {
        jf = new JFrame("Colorful Calculator");
        jf.setLayout(null);
        jf.setSize(400, 600);
        jf.getContentPane().setBackground(new Color(30, 30, 30)); 

        // Font and colors for buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 24);
        Color buttonColor = new Color(60, 60, 60);  
        Color textColor = new Color(255, 255, 255); 

        // Display label
        displayLabel = new JLabel("");
        displayLabel.setBounds(30, 50, 340, 50);
        displayLabel.setBackground(new Color(0, 0, 139));  
        displayLabel.setOpaque(true);
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setFont(new Font("Arial", Font.BOLD, 32)); 
        jf.add(displayLabel);

        // Number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(buttonFont);
            numberButtons[i].setBackground(buttonColor);
            numberButtons[i].setForeground(textColor);
        }

        // Adding number buttons to the frame
        numberButtons[7].setBounds(30, 130, 80, 80);
        numberButtons[8].setBounds(130, 130, 80, 80);
        numberButtons[9].setBounds(230, 130, 80, 80);
        numberButtons[4].setBounds(30, 230, 80, 80);
        numberButtons[5].setBounds(130, 230, 80, 80);
        numberButtons[6].setBounds(230, 230, 80, 80);
        numberButtons[1].setBounds(30, 330, 80, 80);
        numberButtons[2].setBounds(130, 330, 80, 80);
        numberButtons[3].setBounds(230, 330, 80, 80);
        numberButtons[0].setBounds(130, 430, 80, 80);

        for (int i = 0; i < 10; i++) {
            jf.add(numberButtons[i]);
        }

        // Other buttons
        dotButton = new JButton(".");
        dotButton.setBounds(30, 430, 80, 80);
        dotButton.setFont(buttonFont);
        dotButton.setBackground(buttonColor);
        dotButton.setForeground(textColor);
        dotButton.addActionListener(this);
        jf.add(dotButton);

        equalButton = new JButton("=");
        equalButton.setBounds(230, 430, 80, 80);
        equalButton.setFont(buttonFont);
        equalButton.setBackground(new Color(70, 130, 180));  
        equalButton.setForeground(Color.WHITE);
        equalButton.addActionListener(this);
        jf.add(equalButton);

        addButton = new JButton("+");
        addButton.setBounds(330, 130, 80, 80);
        addButton.setFont(buttonFont);
        addButton.setBackground(new Color(255, 165, 0)); 
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(this);
        jf.add(addButton);

        subButton = new JButton("-");
        subButton.setBounds(330, 230, 80, 80);
        subButton.setFont(buttonFont);
        subButton.setBackground(new Color(255, 69, 0)); 
        subButton.setForeground(Color.WHITE);
        subButton.addActionListener(this);
        jf.add(subButton);

        mulButton = new JButton("*");
        mulButton.setBounds(330, 330, 80, 80);
        mulButton.setFont(buttonFont);
        mulButton.setBackground(new Color(0, 128, 0));
        mulButton.setForeground(Color.WHITE);
        mulButton.addActionListener(this);
        jf.add(mulButton);

        divButton = new JButton("/");
        divButton.setBounds(330, 430, 80, 80);
        divButton.setFont(buttonFont);
        divButton.setBackground(new Color(75, 0, 130)); 
        divButton.setForeground(Color.WHITE);
        divButton.addActionListener(this);
        jf.add(divButton);

        clearButton = new JButton("C");
        clearButton.setBounds(30, 530, 340, 50);
        clearButton.setFont(new Font("Arial", Font.BOLD, 28));
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener(this);
        jf.add(clearButton);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handling number and dot buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                displayLabel.setText(displayLabel.getText() + i);
            }
        }

        if (e.getSource() == dotButton) {
            displayLabel.setText(displayLabel.getText() + ".");
        }

        // Handling operators
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(displayLabel.getText());
            operator = "+";
            displayLabel.setText("");
        } else if (e.getSource() == subButton) {
            num1 = Double.parseDouble(displayLabel.getText());
            operator = "-";
            displayLabel.setText("");
        } else if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(displayLabel.getText());
            operator = "*";
            displayLabel.setText("");
        } else if (e.getSource() == divButton) {
            num1 = Double.parseDouble(displayLabel.getText());
            operator = "/";
            displayLabel.setText("");
        }

        // Handling equals button
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(displayLabel.getText());

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }

            displayLabel.setText(String.valueOf(result));
        }

        // Handling clear button
        if (e.getSource() == clearButton) {
            displayLabel.setText("");
        }
    }

    public static void main(String[] args) {
        new ColorfulCalculator();
    }
}
