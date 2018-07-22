import java.util.Queue;

class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue pQueue = new LinkedList<TreeNode>();
        Queue qQueue = new LinkedList<TreeNode>();
        pQueue.add(p.getLeft());
        pQueue.add(p.getRight());
        qQueue.add(q.getLeft());
        qQueue.add(q.getRight());
        while(!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode currentP = pQueue.poll();
            TreeNode currentQ = qQueue.poll();
            if(currentP.getValue() != currentQ.getValue()) {
                return false;
            }
        }

    }

}