class Solution {
    int maxLen = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root.left, 1, true); 
        traverse(root.right, 1, false);
        return maxLen;
    }

    private void traverse(TreeNode node, int len, boolean isRight) {
        if (node == null) {
            maxLen = Math.max(maxLen, len - 1);
            return;
        }
        if (isRight) { 
            traverse(node.right, len + 1, false); 
            
            traverse(node.left, 1, true); 
        } else { 
            traverse(node.left, len + 1, true); 
            traverse(node.right, 1, false); 
        }
    }
}