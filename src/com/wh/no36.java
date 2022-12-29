package com.wh;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WH
 * @version 1.0
 * @date 2022/12/25 17:36
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 */
public class no36 {
    //存储所有已经出现的数字
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][][] boxes = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        //遍历依次,存储所有已经出现的数字
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '0' - 1;
                    rows[i][index] = true;
                    cols[j][index] = true;
                    boxes[i / 3][j / 3][index] = true;
                }

            }
        }
        findSolution(board);
    }

    //编写一个方法,用来寻找当前位置可以放的数字有哪些,返回这些数字的集合(0-8)
    private List<Integer> findNumber(int row, int col) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (!rows[row][i] && !cols[col][i] && !boxes[row / 3][col / 3][i]) {
                list.add(i);
            }
        }
        return list;
    }

    //编写一个方法,用于递归+回溯寻找数独的解
    private boolean findSolution(char[][] board) {
        //寻找空白的地方
        int row = -1;
        int col = -1;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        if (row == -1 && col == -1) {
            return true;
        }
        List<Integer> number = findNumber(row, col);
        while (true) {
            if (number.isEmpty()) {
                return false;
            }
            Integer index = number.get(0);
            board[row][col] = (char) (index + '0' + 1);
            rows[row][index] = true;
            cols[col][index] = true;
            boxes[row / 3][col / 3][index] = true;
            boolean solution = findSolution(board);
            if (solution) {
                return true;
            } else {
                board[row][col] = '.';
                rows[row][index] = false;
                cols[col][index] = false;
                boxes[row / 3][col / 3][index] = false;
                number.remove(0);
            }
        }
    }
}

class Test36 {
    @Test
    void test36() {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new no36().solveSudoku(board);
        System.out.println(Arrays.toString(board));
    }
}
