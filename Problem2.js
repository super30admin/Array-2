// https://leetcode.com/problems/game-of-life/
// accepted in LeetCode
//Tc is O(m*n) and Sc O(m*n)

/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var gameOfLife = function(board) {

    let m = board.length;
    let n = board[0].length;

    const dir = [[-1,0], [1,0],[0,-1],[0,1],[-1,-1],[-1,1],[1,-1],[1,1]];

    //pass through the matix

    for(let i=0;i<m;i++){
        for(let j=0;j<n;j++){
            //count the neighbours
           let count = countAliveNei(i,j,m,n);

           if(board[i][j]==1 && (count<2 || count>3)){
               board[i][j] =2;
           }
            else if (board[i][j] == 0 && count == 3){
                board[i][j] = 3;
            }
        }
    }
    
    // change state before returning

    for(let i=0;i<m;i++){
        for(let j=0;j<n;j++){
            if(board[i][j]==2) board[i][j]=0;
            else if(board[i][j] == 3) board[i][j] =1;
        }
    }

    // function to count the neighbours

    function countAliveNei(i,j,m,n){
        let count =0;
        for(const [diri,dirj] of dir){
            let r = i+diri;
            let c = j+dirj;
            //boundry check
         if (r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 2)) count++;
        }
     return count;
    }

};