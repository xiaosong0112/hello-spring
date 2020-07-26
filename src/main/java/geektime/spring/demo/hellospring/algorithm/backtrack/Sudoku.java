package geektime.spring.demo.hellospring.algorithm.backtrack;

public class Sudoku {

    //官方用的hashmap，但采用数组更方便（如何不统计一次以上次数的话）
    public boolean isValidSudoku(char[][] board) {

        // 用于统计每一行出现的数字。出现过就在对应的位置上放置数字1.表示该位置对应的数字已经存在了。
        int[][] rows = new int[9][9];

        // 用于统计每一列出现的数字。
        int[][] col = new int[9][9];

        // 把棋盘按照格子划分进行统计。
        int[][] sbox = new int[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]!='.'){

                    // 把数字换算成数组要保存的位置(行和列的)
                    int num = board[i][j] - '1';

                    // 把数字换成box数组要保存的位置。
                    int index_box = (i/3)*3+j/3;

                    if (rows[i][num]==1) { return false;}
                    else { rows[i][num]=1; }
                    if (col[j][num]==1) { return false;}
                    else { col[j][num]=1; }
                    if (sbox[index_box][num]==1)  { return false;}
                    else { sbox[index_box][num]=1; }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

//        int index_box = (0/3)*3+4/3;
//        System.out.println(index_box);

        // char类型转int类型
        // https://blog.csdn.net/weixin_43777983/article/details/85774779
        int a = '5';
        System.out.println(a - '1');
    }


}
