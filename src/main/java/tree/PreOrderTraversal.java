package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144.前序遍历
 */
public class PreOrderTraversal {

    public List<Integer> solution(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        preOrder(root, result);
        return result;


    }

    // 自己维护一个栈，先压入右子节点，再压右子节点
    public List<Integer> soultionB(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        if (root == null) {
            return result;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            result.add(node.val);  // 取根节点值

            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return result;


    }

    // 利用栈  参考中序的
    public List<Integer> solutionC(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return result;
        }

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                result.add(curr.val);
                stack.add(curr);
                curr = curr.left;
            }

            TreeNode node = stack.pollLast();
            curr = node.right;
        }

        return result;
    }



    private void preOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }


}
