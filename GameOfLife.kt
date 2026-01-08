// This problem expects us to return a matrix where by flipping certain 1s and 0s. What we do is for the first pass we use the consitions in th e problem flip the elements to 2 or 3 which are placeholders
// to indicate that they were originally 1 or 0 respectively. In the second pass we convert all 2s to 0s and all 3s to 1s. We also use a private function to count the alive elements in all directions. 
// Time complexity is O(m*n) and space complexity is O(1)

class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {

        //updating 1-> 0 as 2
        //updating 0->1 as 3
        val m = board.size
        val n = board[0].size

        for(i in 0..m-1) {
            for (j in 0..n-1) {
                val count = countAliveCells(board, i, j)
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2
                } 
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3
                }
            }
        }
        for(i in 0..m-1) {
            for (j in 0..n-1) {
                if(board[i][j] == 2) {
                    board[i][j] = 0
                }
                if(board[i][j] == 3) {
                    board[i][j] = 1
                }
            }
        }
    }

   private fun countAliveCells(board:  Array<IntArray>, i: Int, j: Int) : Int {
    var count = 0

    val dirs = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
        intArrayOf(-1, -1),
        intArrayOf(-1, 1),
        intArrayOf(1, -1),
        intArrayOf(1, 1)
    )

    
    for (dir in dirs) {
        val newRow = i + dir[0]
        val newCol = j + dir[1]

        if (newRow >= 0 && newCol >= 0 && newRow < board.size && newCol < board[0].size &&
         (board[newRow][newCol] == 1 || board[newRow][newCol] == 2)) {
            count++
        }
    }
    return count
   }
}