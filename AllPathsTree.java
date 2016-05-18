import java.util.*;

/**
 * Print all paths given the root of a binary tree
 */
public class AllPathsTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode('F');

        // left subtree
        root.left = new TreeNode('B');
        root.left.left = new TreeNode('A');
        root.left.right = new TreeNode('D');
        root.left.right.left = new TreeNode('C');
        root.left.right.right = new TreeNode('E');

        // right subtree
        root.right = new TreeNode('G');
        root.right.right = new TreeNode('I');
        root.right.right.right = new TreeNode('H');

        findAllPaths(root);
    }

    /**
     *  Algorithm Design:
     *  - When we reach a leaf node then print the path and pop off the stack
     *  - Continue searching for other paths
     *  - Repeat until there are no more paths
     */
    private static void findAllPaths(TreeNode root) {
        if(root == null) return;
        List<TreeNode> path = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        path.add(root);

        // go through the entire binary tree
        while(!stack.isEmpty()) {
            TreeNode tmp = stack.peek();

            // encounter a leaf node, then print the path
            if(tmp.left == null && tmp.right == null) {
                printPaths(path);
                visited.add(stack.pop());
                path.remove(path.size() - 1);
                continue;
            }

            // add a left child if the node has one else add its right child
            if(tmp.left != null && !visited.contains(tmp.left)) {
                stack.add(tmp.left);
                path.add(tmp.left);
            } else if(tmp.right != null && !visited.contains(tmp.right)) {
                stack.add(tmp.right);
                path.add(tmp.right);
            } else if(visited.contains(tmp.left) && visited.contains(tmp.right)) {
                visited.add(stack.pop());
                path.remove(path.size() - 1);
            } else {
                visited.add(stack.pop());
            }
        }
    }

    /**
     * Print all paths from the root node to the leaf node
     */
    private static void printPaths(List<TreeNode> path) {
        for(TreeNode t : path) System.out.print(t.data);
        System.out.println();
    }

    private static class TreeNode {
        char data;
        TreeNode left, right;

        protected TreeNode(char d) {
            this.data = d;
        }
    }

}
