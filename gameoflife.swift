// Time Complexity : 0(m*n)
// Space Complexity : 0(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
    func gameOfLife(_ board: inout [[Int]]) -> [[Int]]  {
        var newBoard = board
       for row in 0..<board.count {
           for col in 0..<board[row].count {
                print(row,col)
               if board[row][col] == 1 {
                   liveCellNextState(board,&newBoard,row,col)
               } else {
                    deadCellNextState(board,&newBoard,row,col)
               }
           }
       }
        board = newBoard
        return newBoard
    }
    func liveCellNextState(_ board: [[Int]], _ newboard: inout [[Int]], _ row:Int, _ col: Int) {
        if neighborLiveCellCount(board,row,col) < 2 {
            newboard[row][col] = 0
        } else if neighborLiveCellCount(board,row,col) > 3 {
            newboard[row][col] = 0
        }
    }
    func deadCellNextState(_ board: [[Int]], _ newboard: inout [[Int]], _ row:Int, _ col: Int) {
       if neighborLiveCellCount(board,row,col) == 3 {
            newboard[row][col] = 1
       }
    }
    func neighborLiveCellCount(_ board: [[Int]], _ row:Int, _ col: Int) -> Int {
        var liveCellCount = 0
        if row - 1 >= 0 && col - 1 >= 0 {
            if board[row-1][col-1] == 1 {
                liveCellCount += 1
            }
        }
         if row - 1 >= 0 {
            if board[row-1][col] == 1 {
                liveCellCount += 1
            }
        }
         if row - 1 >= 0 && col + 1 < board[row].count {
           if board[row-1][col+1] == 1 {
                liveCellCount += 1
            }
        }
         if col - 1 >= 0 {
           if board[row][col-1] == 1 {
                liveCellCount += 1
            }
        }
         
         if row + 1 < board.count && col - 1 >= 0 {
            if board[row+1][col-1] == 1 {
                liveCellCount += 1
            }
        }
        if row + 1 < board.count {
           if board[row+1][col] == 1 {
                liveCellCount += 1
            }
        }
        if row + 1 < board.count && col + 1 < board[row].count {
            if board[row+1][col+1] == 1 {
                liveCellCount += 1
            }
        }
        if col + 1 < board[row].count {
           if board[row][col+1] == 1 {
                liveCellCount += 1
            }
        }
        return liveCellCount
        
    }