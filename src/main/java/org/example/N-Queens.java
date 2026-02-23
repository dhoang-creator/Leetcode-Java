/*
    The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attach each other
    Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
    Each solution contains a distinct board configuration of the n queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively

    Input: n = 4
    Output: [[".Q..", "...Q", "Q...", "..Q."], ["..Q.", "Q...", "...Q", ".Q.."]]

    Input: n = 1
    Output [["Q"]]
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        // board[row] = col where queen is placed
        int[] board = new int[n];

        backtrack(0, n, board, result);
        return result;
    }

    private void backtrack(int row, int n, int[] board, List<List<String>>) {
        // Time: O(n) leaf node creation (building the board)
        if (row == n) {
            result.add(buildBoard(board, n));
            return;
        }

        // Try each column in the current row -> O(n)
        for (int col = 0; col < n; col++) {

            // Check if placing queen at (row, col) is valid -> O(row)
            if (isValid(row, col, board)) {

                board[row] = col; // O(1)
                backtrack(row + 1, n, board, result); // recursive branch
                // backtrack implicitly happens when we overwrite board[row]
            }
        }
    }

    private boolean isValid(int row, int col, int[] board) {
        // Check all previous rows -> O(n)
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = board[prevRow];

            // same column
            if (prevCol == col) return false;

            // same diagonal
            if (Math.abs(prevCol - col) == Math.abs(prevRow - row)) return false;
        }
        return true;
    }

    private List<String> buildBoard(int[] board, int n) {
        // Build final visual board -> O(n^2)
        List<String> res = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[board[r]] = 'Q';
            res.add(new String(row));
        }
        return res;
    }
}

