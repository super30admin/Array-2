
// Time Complexity :  O(m*n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

func gameOfLife(board [][]int)  {
    if len(board) == 0{
        return
    }
    
    m := len(board) //row
    n := len(board[0]) //column
    
    //0 -> 1 ---> 2
    //1 --> 0 --->3
    
    for i:=0;i<m;i++{
        for j:=0;j<n;j++{
            countlive := countliveneighbor(board,i,j,m,n)
            
            if board[i][j] == 0{
                if countlive == 3{
                    board[i][j] = 2
                }
            }else{
                if countlive > 3{
                    board[i][j] = 3
                }
                
                if countlive < 2{
                    board[i][j] = 3
                }
            }
        }
    }
    
    for i:=0;i<m;i++{
        for j:=0;j<n;j++{
            if board[i][j] == 2{
                board[i][j] = 1
            }
            
            if board[i][j] == 3{
                board[i][j] = 0
            }            
            
        }
    }
    
    return 
}


func countliveneighbor(board [][]int,row int,column int,m int,n int) int{
    count := 0
    
    dirs := [][]int{{1,0},{0,1},{0,-1},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}}
    
    for _,val := range dirs{
        nr := row+val[0]
        nc := column+val[1]
        
        if ((nr >=0) && (nr < m) && (nc >=0) && (nc < n) && (board[nr][nc] == 1 || board[nr][nc] == 3) ){
            count+=1
        }
    }
    
    return count
}
