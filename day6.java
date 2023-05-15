class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        List<Pair<Integer, Integer>> levelIndices = new ArrayList<>();
        
        queue.add(new Pair<>(root, 0));
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Integer levelLeft = null, levelRight = null;
            
            for (int i = 0; i < levelSize; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                
                if (node.left != null) {
                    queue.add(new Pair<>(node.left, 2 * index));
                }
                
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, 2 * index + 1));
                }
                
                if (i == 0) {
                    levelLeft = index;
                }
                
                if (i == levelSize - 1) {
                    levelRight = index;
                }
            }
            
            levelIndices.add(new Pair<>(levelLeft, levelRight));
        }
        
        int maxWidth = 0;
        
        for (Pair<Integer, Integer> pair : levelIndices) {
            int left = pair.getKey();
            int right = pair.getValue();
            int width = right - left + 1;
            maxWidth = Math.max(maxWidth, width);
        }
        
        return maxWidth;
    }
}
