// Time Complexity : O(m*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : 
class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val ALIVE = 1
        val DEAD = 0
        val TURNED_ALIVE = 3
        val TURNED_DEAD = 4
        val dir = arrayOf(
            -1 to -1, -1 to 0, -1 to 1,
            0 to -1,/*0 to 0*/ 0 to 1,
            1 to -1, 1 to 0, 1 to 1
        )

        val ROWS = board.size
        val COLS = board[0].size

        for (r in 0 until ROWS) {
            for (c in 0 until COLS) {
                val initialState = board[r][c]
                var aliveCount = 0
                for ((dr, dc) in dir) {
                    val nr = r + dr
                    val nc = c + dc
                    if (nr in 0 until ROWS && nc in 0 until COLS) {
                        val neighbourState = board[nr][nc]
                        if (neighbourState == ALIVE || neighbourState == TURNED_DEAD) {
                            aliveCount++
                        }
                    }
                }
                when (initialState) {
                    ALIVE -> {
                        if (aliveCount < 2 || aliveCount > 3) {
                            board[r][c] = TURNED_DEAD
                        }
                    }

                    DEAD -> {
                        if (aliveCount == 3) {
                            board[r][c] = TURNED_ALIVE
                        }
                    }
                }
            }
        }
        for (r in 0 until ROWS) {
            for (c in 0 until COLS) {
                when (board[r][c]) {
                    TURNED_ALIVE -> board[r][c] = ALIVE
                    TURNED_DEAD -> board[r][c] = DEAD
                }
            }
        }
    }
}