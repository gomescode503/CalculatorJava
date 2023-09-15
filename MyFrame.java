import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {

    JPanel centerPanel;
    JLabel centerLabel;

    JButton[] numberButton = new JButton[10];
    JButton[] opButton = new JButton[4];
    JButton[] sysButton = new JButton[4];

    JButton dotButton, equButton, delButton, clrButton; // System Button
    JButton addButton, subButton, mulButton, divButton; // Operators Buttons
    JTextField textField;

    Font font = new Font("Monospace", Font.BOLD, 20);

    ImageIcon image = new ImageIcon("img/ab6761610000517476e43c292e6ea3fc51faa1a4.jpeg");

    int[] buttonCounter = new int[8];

    double num1, num2, result = 0;
    char op;

    MyFrame() {

        opButton();
        numberButtons();
        sysButton();
        center();
        text();
        outherButtons();
        sepBords();

        this.add(delButton);
        this.add(clrButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.decode("#E66EA6"));
        this.setSize(400, 620);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.setIconImage(image.getImage());
        this.setTitle("Fernando's Calculator");

        this.add(textField);
        this.add(centerPanel);
    }

    public void center() {

        centerPanel = new JPanel();
        centerPanel.setBounds(40, 80, 300, 390);
        centerPanel.setLayout(new GridLayout(4, 4));
        centerPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#0B0904")));
        centerPanel.setBackground(Color.DARK_GRAY);

        centerPanel.add(numberButton[1]);
        centerPanel.add(numberButton[2]);
        centerPanel.add(numberButton[3]);
        centerPanel.add(addButton);
        centerPanel.add(numberButton[4]);
        centerPanel.add(numberButton[5]);
        centerPanel.add(numberButton[6]);
        centerPanel.add(subButton);
        centerPanel.add(numberButton[7]);
        centerPanel.add(numberButton[8]);
        centerPanel.add(numberButton[9]);
        centerPanel.add(mulButton);
        centerPanel.add(numberButton[0]);
        centerPanel.add(equButton);
        centerPanel.add(dotButton);
        centerPanel.add(divButton);
    }

    public void sepBords() {
        equButton.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 0, Color.decode("#0B0904")));
        dotButton.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.decode("#0B0904")));
        mulButton.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.decode("#0B0904")));
        subButton.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.decode("#0B0904")));
        addButton.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.decode("#0B0904")));
    }

    public void numberButtons() {

        for (int i = 0; i <= 9; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(font);
            numberButton[i].setForeground(Color.decode("#0B0904"));
            numberButton[i].setBackground(Color.decode("#F27E68"));
            numberButton[i].setBorder(null);
            numberButton[i].setFocusable(false);
        }

    }

    public void text() {

        textField = new JTextField();
        textField.setBounds(40, 24, 301, 40);
        textField.setFont(font);
        textField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#0B0904")));
        textField.setBackground(Color.decode("#F27E68"));
        textField.setForeground(Color.decode("#0B0904"));
    }

    public void opButton() {

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        opButton[0] = addButton;
        opButton[1] = subButton;
        opButton[2] = mulButton;
        opButton[3] = divButton;

        for (int i = 0; i <= 3; i++) {
            opButton[i].addActionListener(this);
            opButton[i].setFont(font);
            opButton[i].setForeground(Color.decode("#0B0904"));
            opButton[i].setBackground(Color.decode("#FC6E6D"));
            opButton[i].setBorder(null);
            opButton[i].setFocusable(false);
        }
    }

    public void sysButton() {

        clrButton = new JButton("C");
        delButton = new JButton("DEL");
        equButton = new JButton("=");
        dotButton = new JButton(".");

        sysButton[0] = clrButton;
        sysButton[1] = delButton;
        sysButton[2] = equButton;
        sysButton[3] = dotButton;

        for (int i = 0; i <= 3; i++) {
            sysButton[i].addActionListener(this);
            sysButton[i].setFont(font);
            sysButton[i].setForeground(Color.decode("#0B0904"));
            sysButton[i].setBackground(Color.decode("#FC6E6D"));
            sysButton[i].setBorder(null);
            sysButton[i].setFocusable(false);
        }
    }

    public void outherButtons() {

        delButton = new JButton("DELETE");
        delButton.setBounds(40, 500, 140, 60);
        delButton.setFont(font);
        delButton.addActionListener(this);
        delButton.setForeground(Color.decode("#0B0904"));
        delButton.setBackground(Color.decode("#FC6E6D"));
        delButton.setBorder(BorderFactory.createLineBorder(Color.decode("#0B0904")));
        delButton.setFocusable(false);

        clrButton = new JButton("CLEAR");
        clrButton.setBounds(200, 500, 140, 60);
        clrButton.setFont(font);
        clrButton.addActionListener(this);
        clrButton.setForeground(Color.decode("#0B0904"));
        clrButton.setBackground(Color.decode("#FC6E6D"));
        clrButton.setBorder(BorderFactory.createLineBorder(Color.decode("#0B0904")));
        clrButton.setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i <= 9; i++) {
            if (e.getSource() == numberButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == dotButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            op = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            op = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            op = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            op = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == delButton) {
            textField.setText(" ");
        }

        if (e.getSource() == clrButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
    }
}
