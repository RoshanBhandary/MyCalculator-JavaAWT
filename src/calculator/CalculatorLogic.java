package calculator;

import java.util.*;

public class CalculatorLogic {
	public double evaluateExpression(String expression) {
		// Check for empty or invalid expressions
		if (expression == null || expression.trim().isEmpty()) {
			throw new IllegalArgumentException("Expression cannot be empty.");
		}

		// Split the expression into tokens (operands and operators)
		String[] tokens = expression.split("(?=[-+*/()])|(?<=[-+*/()])");

		Stack<Double> values = new Stack<>(); // Stack for values (numbers)
		Stack<Character> ops = new Stack<>(); // Stack for operators

		for (String token : tokens) {
			token = token.trim();
			if (token.matches("[0-9.]+")) {
				values.push(Double.parseDouble(token)); // If the token is a number, push it to the stack
			} else if (token.equals("(")) {
				ops.push('('); // If it's a '(', push to the operators stack
			} else if (token.equals(")")) {
				while (ops.peek() != '(') {
					values.push(applyOperator(ops.pop(), values.pop(), values.pop())); // Evaluate the expression
				}
				ops.pop(); // Remove '(' from the stack
			} else if (token.matches("[-+*/]")) {
				while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(token.charAt(0))) {
					values.push(applyOperator(ops.pop(), values.pop(), values.pop())); // Apply operator
				}
				ops.push(token.charAt(0)); // Push the current operator
			}
		}

		while (!ops.isEmpty()) {
			values.push(applyOperator(ops.pop(), values.pop(), values.pop())); // Apply remaining operators
		}

		return values.pop(); // Final result
	}

	// Method to apply the operator to two numbers
	private double applyOperator(char operator, double b, double a) {
		switch (operator) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0) {
				throw new ArithmeticException("Cannot divide by zero.");
			}
			return a / b;
		}
		return 0;
	}

	// Method to get the precedence of operators
	private int precedence(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;
	}
}
