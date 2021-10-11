package com.greatlearning.lab3;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
	// function to check if brackets are balanced
	static boolean checkingBalanceBrackets(String brackets) {
		// Using Stack Class
		Stack<Character> stack = new Stack<Character>();
		// Traversing the Expression
		for (int i = 0; i < brackets.length(); i++) {
			char character = brackets.charAt(i);
			if (character == '(' || character == '[' || character == '{') {
				// Push the element in the stack
				stack.push(character);
				continue;
			}

			if (stack.isEmpty())
				return false;
			char localChar;
			switch (character) {
			case '}': {
				localChar = stack.pop();
				if (localChar == '(' || localChar == '[')
					return false;
				break;
			}
			case ')': {
				localChar = stack.pop();
				if (localChar == '{' || localChar == '[')
					return false;
				break;
			}
			case ']': {
				localChar = stack.pop();
				if (localChar == '(' || localChar == '{')
					return false;
				break;
			}

			}
		}
		// Check Empty Stack
		return (stack.isEmpty());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The String you want to serach the Balancing");
		String brackets = sc.next();
		if (checkingBalanceBrackets(brackets)) {
			System.out.println("The entered String has Balanced Brackets");
		} else
			System.out.println("The entered Strings do not contain Balanced Brackets");

		sc.close();
	}

}
