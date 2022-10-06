//Time: O(n^2), Space: O(1)
var gameOfLife = function(board) {
    if(board.length ==0 ) return;
    let m = board.length;
    let n = board[0].length;

    for(let i=0;i<m;i++){
        for(let j=0;j<n;j++){
            let live_neighbours = count_live_neighbours(board,i,j);
            if(board[i][j] == 0 ){
                if(live_neighbours == 3){
                    board[i][j]=3;
                }
            }else{
               if(live_neighbours < 2 || live_neighbours > 3 ){
                    board[i][j]=2;
                }
            }
        }
    }
    for(let i=0;i<m;i++){
        for(let j=0;j<n;j++){
            if(board[i][j] == 2){
                board[i][j]=0;
            }else if(board[i][j]===3){
                board[i][j]=1;
            }
        }
    }
    function count_live_neighbours(board,i,j){
    let count = 0;
    let dirs = [[0,1],[0,-1],[1,0],[-1,0],[-1,-1],[-1,1],[1,-1],[1,1]]
    for(let k=0;k<dirs.length;k++){
        let nr = i + dirs[k][0];
        let nc = j + dirs[k][1];
        if( nr >= 0 && nr <= m && nc < n && nr < m && (board[nr][nc] == 1 || board[nr][nc] == 2)){
            count++;
        }
    }
    return count;
}
};
