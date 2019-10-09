class ShortestDistanceBetweenTwoNodesInBST {
    public int distanceBeteenNodes(TreeNode root, int a, int b ) {
        if (root.val == a) {
            return distanceToRoot(root, b);
        }
        if (root.val == b) {
            return distanceToRoot(root, a);
        }
        return distanceToRoot(root, b) + distanceToRoot(root, a);
    }

    private int distanceToRoot(TreeNode root, int a) {
        if (root.val == a) {
            return 0;
        }
        if (root.val > a) {
            return distanceToRoot(root.left, a) + 1;
        }
        return distanceToRoot(root.right, a) + 1;
    }
}