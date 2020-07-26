package geektime.spring.demo.hellospring.algorithm.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * N皇后问题
 * https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-by-leetcode/  （非常清晰的34步，N皇后动画思路，想不明白的可以先看看动画）
 * https://leetcode-cn.com/problems/n-queens/solution/hui-su-suan-fa-xiang-jie-by-labuladong/  （代码出自一楼评论，方法一比较好懂）
 */
public class NQueues {

    /**
     * result = []
     * def backtrack(路径, 选择列表):
     *     if 满足结束条件:
     *         result.add(路径)
     *         return
     *
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     *  回溯算法的框架
     */

    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {

        if (n <= 0) return null;
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) Arrays.fill(chars, '.');
        backtrack(board, 0);
        return res;
    }

    /**
     * 路径：board中小于row的那些行都已经成功放置了皇后
     * 可选择列表: 第row行的所有列都是放置Q的选择
     * 结束条件: row超过board的最后一行
     *
     * @param board
     * @param row
     */
    private void backtrack(char[][] board, int row) {

        if (row == board.length) {
            res.add(charToString(board));
            return;
        }

        int n = board[row].length;

        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) continue;
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {

        int rows = board.length;

        // check is valid in col
        for (char[] chars : board) if (chars[col] == 'Q') return false;

        // check is valide upright
        for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        // check is valide upleft
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }


}
