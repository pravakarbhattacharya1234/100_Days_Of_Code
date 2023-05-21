//1491. Average Salary Excluding the Minimum and Maximum Salary

class Solution {
    public double average(int[] salary) {
    int minSalary = Integer.MAX_VALUE;
    int maxSalary = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0; i < salary.length; i++) {
        minSalary = Math.min(minSalary, salary[i]);
        maxSalary = Math.max(maxSalary, salary[i]);
        sum += salary[i];
    }
    return (double) (sum - minSalary - maxSalary) / (salary.length - 2);
}

}