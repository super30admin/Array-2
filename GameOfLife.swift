//
//  GameOfLife.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/11/26.
//

/*
 1 -> 0 = 2
 0 -> 1 = 3
 
 Use directionss array to iterated over each and every direction in the directions array.
 [[0,1], [0, -1], [-1, 0], [1, 0], [-1, -1]....]
 
 any live cell dies -> with fewer than 2 live neighbours
 any live cell live -> with 2 or 3 live neighbours
 any live cell dies -> with more than 3 live neighbours
 any dead cell lives -> exactly 3 live neighbours
 */
class GameOfLife {
    
    init() {
        var matrix = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
        let nextState = gameOfLife(matrix: &matrix)
        print("next state *** \(nextState)")
    }
    
    func gameOfLife(matrix: inout [[Int]]) -> [[Int]] {
        
        //replace 1 -> 0 = 2
        //replace 0 -> 1 = 3
        //after making the changes on thw hole matrix, replace 2 with 1 and 3 with 0
        for i in 0..<matrix.count {
            for j in 0..<matrix[0].count {
                let liveNeighbours = countLiveCellsAround(matrix: matrix, i: i, j: j)
                if (matrix[i][j] == 0) {
                    if (liveNeighbours == 3) {
                        //dead cell lives
                        matrix[i][j] = 3
                    }
                } else if (matrix[i][j] == 1) {
                    if (liveNeighbours < 2) {
                        matrix[i][j] = 2 //dies
                    } else if (liveNeighbours > 3) {
                        matrix[i][j] = 2 //live cell dies
                    }
                }
            }
        }
        
        //replace back 2 -> 0 and 3 -> 1
        for i in 0..<matrix.count {
            for j in 0..<matrix[0].count {
                if (matrix[i][j] == 2) {
                    matrix[i][j] = 0
                } else if (matrix[i][j] == 3) {
                    matrix[i][j] = 1
                }
            }
        }
        
        return matrix
    }
    
    func countLiveCellsAround(matrix: [[Int]], i: Int, j: Int) -> Int {
        let directionArray = [[1, 1], [1, 0], [1, -1], [0, -1], [-1, -1], [-1, 0], [-1, 1], [0, 1]]
        var countOfLiveNeighbours = 0
        for dir in directionArray {
            if ((i + dir[0] < 0) || i + dir[0] >= matrix.count) {
                continue
            }
            if ((j + dir[1] < 0) || j + dir[1] >= matrix[0].count) {
                continue
            }
            
            //When we changed from 1 -> 0, we placed 2. So need to check 2 for the original value of 1 to count the live neighbours
            if (matrix[i + dir[0]][j + dir[1]] == 1 || matrix[i + dir[0]][j + dir[1]] == 2) {
                countOfLiveNeighbours += 1
            }
        }
        return countOfLiveNeighbours
    }
}
