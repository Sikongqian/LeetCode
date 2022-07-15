import java.util.Scanner;

public class Leetcode59 {

    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     *
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     */

    //解法一：大概用时20min
    /**
     * 首先输入n
     * 赋值要重复n方次
     * 要转n/2次
     * 所以可以循环n/2次。每次代表一圈
     * 每次循环起点是（i，i），做如下动作：右移n-1-2i下移n-1-2i左移n-1-2i上移n-2-2i右移1
     * 如果n-1-2i为0那么只重构（i，i）退出
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int [][] matrix = new int[n][n];
        int num = 1;//记录当前的值
        int i = 0;//记录目前第几圈，从0开始
        for (i = 0;i < n + 1 / 2;i ++) {
            //判断是否为边界条件
            if (n - 2 * i - 1 == 0) {
                matrix[i][i] = num++;
                break;
            }
            //首先向右移
            for (int j = i;j <= n - i - 1;j ++) {
                matrix[i][j] = num++;
            }
            //向下移
            for (int j = i + 1;j <= n - i - 1;j ++) {
                matrix[j][n - i - 1] = num++;
            }
            //向左移
            for (int j = n - i - 2;j >= i;j --) {
                matrix[n - i - 1][j] = num++;
            }
            //向上移
            for (int j = n - i - 2;j >= i + 1;j --) {
                matrix[j][i] = num++;
            }
        }
        System.out.print(matrix);
    }


    //解法二：代码随想录解法

    class Solution {
        public int[][] generateMatrix(int n) {
            int loop = 0;  // 控制循环次数
            int[][] res = new int[n][n];
            int start = 0;  // 每次循环的开始点(start, start)
            int count = 1;  // 定义填充数字
            int i, j;

            while (loop++ < n / 2) { // 判断边界后，loop从1开始
                // 模拟上侧从左到右
                for (j = start; j < n - loop; j++) {
                    res[start][j] = count++;
                }

                // 模拟右侧从上到下
                for (i = start; i < n - loop; i++) {
                    res[i][j] = count++;
                }

                // 模拟下侧从右到左
                for (; j >= loop; j--) {
                    res[i][j] = count++;
                }

                // 模拟左侧从下到上
                for (; i >= loop; i--) {
                    res[i][j] = count++;
                }
                start++;
            }

            if (n % 2 == 1) {
                res[start][start] = count;
            }

            return res;
        }
    }
}
