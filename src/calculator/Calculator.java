package calculator;

import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame {
    private TextField display;
    private CalculatorLogic logic;
    private boolean isResultDisplayed = false; // Flag to track if the result is displayed

    public Calculator() {
        setTitle("My Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());

        display = new TextField();
        add(display, BorderLayout.NORTH);

        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] buttonLabels = {
            "AC", "C", "%", "/", "7", "8", "9", "*", 
            "4", "5", "6", "-", "1", "2", "3", "+", 
            "00", "0", ".", "="
        };

        for (String label : buttonLabels) {
            Button button = new Button(label);
            buttonPanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String text = display.getText();

                    if (label.equals("AC")) {
                        display.setText("");
                        isResultDisplayed = false;
                    } else if (label.equals("C")) {
                        if (text.length() > 0) {
                            display.setText(text.substring(0, text.length() - 1));
                        }
                    } else if ("+-*/".contains(label)) {
                        if (isResultDisplayed) {
                            // Continue operation with the result
                            isResultDisplayed = false;
                            display.setText(text + " " + label + " ");
                        } else {
                            display.setText(text + " " + label + " ");
                        }
                    } else if (label.equals("=")) {
                        try {
                            double result = logic.evaluateExpression(text);
                            display.setText(String.valueOf(result));
                            isResultDisplayed = true; // Result is displayed
                        } catch (Exception ex) {
                            display.setText("Error");
                            isResultDisplayed = false;
                        }
                    } else {
                        if (isResultDisplayed) {
                            // Clear display on new number input after result
                            display.setText(label);
                            isResultDisplayed = false;
                        } else {
                            display.setText(text + label);
                        }
                    }
                }
            });
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);

        logic = new CalculatorLogic(); // Initialize logic after GUI setup
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

