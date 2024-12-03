
package calculator;

import java.awt.*; //importing java AWT which contains classes for creating graphical user interfaces

import java.awt.event.*;

public class Calculator extends Frame { // define class Calculator and extends(inherits) from Frame class (Frame is
										// basic window in Java's AWT(Abstract Window Toolkit) to create GUI
										// applications
	public Calculator() { // constructor of Calculator class {Constructor is a special method called when
							// object of the class i created
		setTitle("My Calculator"); // sets title of the window to "My Calculator"
		setSize(300, 400); // size of window in pixels 300 width and 400 height
		setLayout(new BorderLayout()); // Border layout for buttons

		TextField display = new TextField(); // Adding a textfield
		add(display, BorderLayout.NORTH);

		Panel buttonPanel = new Panel();
		buttonPanel.setLayout(new GridLayout(5, 4)); // 5 rows, 4 columns grid layout

		// Buttons
		String[] buttonLabels = { "AC", "C", "%", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "00",
				"0", ".", "=" };

		for (String label : buttonLabels) {
			Button button = new Button(label);
			buttonPanel.add(button);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Handle button actions (this part will depend on the functionality)
					String text = display.getText();
					if (label.equals("AC")) {
						display.setText(""); // Clears display
					} else if (label.equals("C")) {
						if (text.length() > 0) {
							display.setText(text.substring(0, text.length() - 1)); // Clears last character
						}
					} else if (label.equals("=")) {
						// Add logic to evaluate expression
					} else {
						display.setText(text + label);
					}
				}
			});
		}

		add(buttonPanel, BorderLayout.CENTER); // Add buttons panel below the display field

		setVisible(true);

	} // constructor closed

	public static void main(String[] args) { // main method where java program begins execution
		new Calculator(); // creates an instance(object) of the Calculator class which calls the
							// constructor and displays the window

	}

}
