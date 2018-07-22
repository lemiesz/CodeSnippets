import java.util.Arrays;

class TreeNode {
    private int val; 
    private TreeNode left;
    private TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.val = x;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public int getValue() {
        return this.val;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setValue(int val) {
        this.val = x;
    }

    /**
     * Given an inOrder and preOrder traversal return the root of tree
     * generated by that ordering
     */
    public static TreeNode buildTree(int[] inOrder, int[] preOrder) {
        if(inOrder.length <= 0 || preOrder.length <= 0) {
            return null;
        }
        final TreeNode root = new TreeNode(preOrder[0]);
        final int i = indexOf(inOrder, root.getValue());
        root.setLeft(buildTree(Arrays.copyOfRange(inOrder, 0, i),
                               Arrays.copyOfRange(preOrder, 1, i + 1)));
        root.setRight(buildTree(Arrays.copyOfRange(inOrder, i + 1, inOrder.length), 
                                Arrays.copyOfRange(preOrder, i + 1, preOrder.length)));
        return root;
    }

    public static int indexOf(int[] array, int val) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == val) {
                return i;
            }
        }
        return -1;
    }
 }