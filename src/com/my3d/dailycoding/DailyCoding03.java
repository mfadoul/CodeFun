package com.my3d.dailycoding;
/*
Python Question
 
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'


node1 (root)--node4 (right)
|
node2 (left)
|
node3 (left.left)

 */
public class DailyCoding03 {

	private static class Node {
		String value;
		Node left;
		Node right;
		
		public Node (String value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
		@Override
		public String toString () {
			return value;
		}
	}
	
	public DailyCoding03() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Node node1;
		Node node2;
		Node node3;
		Node node4;
		
		node4 = new Node ("right", null, null);
		node3 = new Node ("left.left", null, null);
		node2 = new Node ("left", node3, null);
		node1 = new Node ("root", node2, node4);
	}
}
