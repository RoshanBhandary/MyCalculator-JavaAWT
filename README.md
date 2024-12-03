Overview

This project implements a Graphical User Interface (GUI) Calculator in Java. It supports basic arithmetic operations, including addition, subtraction, multiplication, and division, and allows chaining of expressions for continuous calculations. The design ensures a clean display of expressions and results, enhancing usability.

Features
Basic Arithmetic: Supports +, -, *, /.
Expression Continuation: Allows operations to continue after displaying results.
Clear Operations: Includes options for clearing the display (C) and resetting the calculator (AC).
Error Handling: Handles division by zero and invalid expressions gracefully.

GUI Design: Interactive interface built using Java AWT.


Requirements
Java Development Kit (JDK) 8 or higher.
Basic knowledge of Java to run the program.
Files
Calculator.java: Contains the GUI and main application logic.
CalculatorLogic.java: Handles expression parsing and evaluation.
How to Run
Compile the files using:
bash
Copy code
javac Calculator.java CalculatorLogic.java
Run the application:
bash
Copy code
java calculator.Calculator
The calculator window will appear.
Usage
Enter numbers and operators to create an expression (e.g., 9 + 7 * 3).
Press = to evaluate.
Press a new operator after a result to continue calculations.
Use AC to reset or C to delete the last input.
Future Enhancements
Add support for parentheses ().
Include advanced functions like square root, power, and trigonometry.
Author
This calculator is designed to demonstrate Java GUI programming and arithmetic operations. Feel free to expand and customize as needed!
