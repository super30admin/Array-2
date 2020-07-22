
// Time Complexity : (O)n^2
// Space Complexity : (O)1
// Did this code successfully run on Leetcode : yes
//Based on the direction logic find a neighbor value.
//apply rule. Modify live value to 2 and dead cell to 3 so that we can identify lives in place.
//last replace all 2 and 3 with 0 and 1


class Solution {
    
    func gameOfLife(_ board: inout [[Int]]) {
        let lives = getLiveNeighbors(board,0,0)
        for i in 0..<board.count {
            for j in 0..<board[0].count {
                let lives = getLiveNeighbors(board,i,j)
                //Apply rule
                if board[i][j] == 1 && (lives < 2 || lives > 3){
                    board[i][j] = 2
                }else if board[i][j] == 0 && lives == 3 {
                    board[i][j] = 3
                }
            }
        }
        
        for i in 0..<board.count {
            for j in 0..<board[0].count {
                board[i][j] = board[i][j]%2
            }
        }
    }
    
    func getLiveNeighbors(_ board: [[Int]], _ row: Int, _ column: Int) -> Int {
        let m = board.count
        let n = board[0].count
        let directions = [[1,-1],[1,0],[1,1],[0,-1],[0,1],[-1,-1],[-1,0],[-1,1]]
        var count = 0
        for d in directions {
            let r = row+d[0]
            let c = column+d[1]
            if r>=0 && c>=0 && r<m && c<n && ( board[r][c] == 1 || board[r][c] == 2){
                count += 1
            }
        }
        return count
    }
}