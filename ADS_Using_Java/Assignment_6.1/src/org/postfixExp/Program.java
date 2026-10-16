package org.postfixExp;

public class Program {
	public static double evaluate(String[] expression) {
		Stack stack = new Stack();
		double result;
		for (int i = 0; i < expression.length; i++) {
			if (expression[i] == "+" || expression[i] == "-" || expression[i] == "*" || expression[i] == "/") {
				String operator = expression[i];
				switch (operator) {

				case "+": {
					double s1 = Double.parseDouble(stack.pop());
					double s2 = Double.parseDouble(stack.pop());
					result = s2 + s1;
					stack.push(Double.toString(result));
					break;
				}
				case "-": {
					double s1 = Double.parseDouble(stack.pop());
					double s2 = Double.parseDouble(stack.pop());
					result = s2 - s1;
					stack.push(Double.toString(result));
					break;
				}
				case "*": {
					double s1 = Double.parseDouble(stack.pop());
					double s2 = Double.parseDouble(stack.pop());
					result = s2 * s1;
					stack.push(Double.toString(result));
					break;
				}

				case "/": {

					double s1 = Double.parseDouble(stack.pop());
					double s2 = Double.parseDouble(stack.pop());
					result = s2 / s1;
					stack.push(Double.toString(result));
					break;
				}

				}

			} else {
				stack.push(expression[i]);
			}

		}

		result = Double.parseDouble(stack.pop());

		return result;

	}

	public static void main(String[] args) {
		String[] expression = { "2", "1", "+", "3", "*" };
		String[] expression1 = { "4", "13", "5", "/", "+" };
		String[] expression2 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		double result = evaluate(expression);
		double result1 = evaluate(expression1);
		double result2 = evaluate(expression2);
		System.out.println(result);
		System.out.println(result1);
		System.out.println(result2);

	}

}
