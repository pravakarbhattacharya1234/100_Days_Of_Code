//54. Spiral Matrix

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int total = m * n;
        int startingRow = 0;
        int endingRow = m - 1;
        int startingCol = 0;
        int endingCol = n - 1;
        
        while (count < total) {
            
            for (int i = startingCol; count < total && i <= endingCol; i++) {
                ans.add(matrix[startingRow][i]);
                count++;
            }
            startingRow++;
            
            
            for (int i = startingRow; count < total && i <= endingRow; i++) {
                ans.add(matrix[i][endingCol]);
                count++;
            }
            endingCol--;
            
            
            for (int i = endingCol; count < total && i >= startingCol; i--) {
                ans.add(matrix[endingRow][i]);
                count++;
            }
            endingRow--;
            
            
            for (int i = endingRow; count < total && i >= startingRow; i--) {
                ans.add(matrix[i][startingCol]);
                count++;
            }
            startingCol++;
        }
        
        return ans;
    }
}