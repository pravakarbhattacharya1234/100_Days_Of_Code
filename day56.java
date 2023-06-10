//1351. Count Negative Numbers in a Sorted Matrix

class Solution {
    public int countNegatives(int[][] grid) {
        int i = 0;
        int j = grid[0].length - 1;
        int count = 0;
        
        while (i < grid.length && j >= 0) {
            if (grid[i][j] < 0) {
                count += (grid.length - i);
                j--; 
            } else if (grid[i][j] >= 0) {
                i++;
            }
        }
        
        return count;
    }
}