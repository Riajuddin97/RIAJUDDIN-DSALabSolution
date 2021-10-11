package com.greatlearning.lab3;

import java.util.ArrayList;

public class FindingTheLongestPath {
	// Binary tree node
	static class Node {
		Node left;
		Node right;
		int data;
	};

	// Function to create a new Binary node
	static Node newNode(int data) {
		Node temp = new Node();

		temp.data = data;
		temp.left = null;
		temp.right = null;

		return temp;
	}
	// Function to find and return the longest path

	public static ArrayList<Integer> findLongestPath(Node root) {
		// If root is null means there is no binary tree so return empty output

		if (root == null) {
			ArrayList<Integer> output = new ArrayList<Integer>();
			return output;

		}
		// Recursive call on root.right
		ArrayList<Integer> rightNodeList = findLongestPath(root.right);

		// Recursive call on root.left
		ArrayList<Integer> leftNodeList = findLongestPath(root.left);

		// Compare the size of the two ArrayList and insert current node accordingly

		if (rightNodeList.size() < leftNodeList.size()) {
			leftNodeList.add(root.data);

		} else {
			rightNodeList.add(root.data);
		}

		// Return the appropriate ArrayList
		return (leftNodeList.size() > rightNodeList.size() ? leftNodeList : rightNodeList);

	}

	// Driver Code
	public static void main(String[] args) {
		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);

		ArrayList<Integer> resultList = findLongestPath(root);
		int resultlistsize = resultList.size();
		System.out.println();
		for (int i = resultlistsize - 1; i >= 0; i--) {
			System.out.print(resultList.get(i) + " -> ");
		}

	}

}
