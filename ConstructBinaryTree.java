/*
 *<aside>
💡 **Question 4**

You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
You always start to construct the **left** child node of the parent first if it exists.

</aside>
 * **Input:** s = "4(2(3)(1))(6(5))"

**Output:** [4,2,6,3,1,5]
 * 
 */

package in.ineuron.gouthami;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ConstructBinaryTree {
    public static TreeNode str2tree(String s) {
        if (s.isEmpty()) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        StringBuilder num = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c) || c == '-') {
                num.append(c);
            } else if (c == '(') {
                TreeNode node = new TreeNode(Integer.parseInt(num.toString()));
                num = new StringBuilder();

                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();

                    if (parent.left == null) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }

                stack.push(node);
            } else if (c == ')') {
                if (!num.toString().isEmpty()) {
                    TreeNode node = new TreeNode(Integer.parseInt(num.toString()));
                    num = new StringBuilder();

                    TreeNode parent = stack.pop();

                    if (parent.left == null) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                } else {
                    stack.pop();
                }
            }
        }

        return stack.pop();
    }

    public static void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        TreeNode root = str2tree(s);
        printInorder(root);
    }
}



