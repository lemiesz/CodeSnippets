import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode currentNode = root;
        TreeNode processedNode = null;
        final List<Integer> resultList = new ArrayList<>();
        final Stack<TreeNode> dfsStack = new Stack<>();
        final Set<TreeNode> trackingSet = new HashSet<>();
        dfsStack.push(currentNode);
        while(!dfsStack.empty()) {
            currentNode = dfsStack.peek().getLeft();
            while(currentNode != null && !trackingSet.contains(currentNode)) {
                dfsStack.push(currentNode);
                currentNode = currentNode.getLeft();
            }
          
            processedNode = dfsStack.pop();
            currentNode = processedNode;
            resultList.add(currentNode.getValue());
            if(currentNode.getRight() != null) {
                dfsStack.push(currentNode.getRight());
            }
            trackingSet.add(processedNode);
        }

        return resultList;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        final List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        inorder(root.getLeft(), list);
        list.add(root.getValue());
        inorder(root.getRight(), list);
    }

}