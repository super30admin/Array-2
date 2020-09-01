//Time Complexity: O(n*m)
//Space Complexity: O(1)
//Did it run on leetcode: yes
//Problems faced any: No


import java.util.ArrayList;
import java.util.List;

public class Problem32 {
    public void gameOfLife(int[][] board) {

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                //returning values in all directions and adding to list
                List<Integer> list = new ArrayList<>();
                list.add(getValue(i-1,j,board));
                list.add(getValue(i-1,j+1,board));
                list.add(getValue(i,j+1,board));
                list.add(getValue(i+1,j+1,board));
                list.add(getValue(i+1,j,board));
                list.add(getValue(i+1,j-1,board));
                list.add(getValue(i,j-1,board));
                list.add(getValue(i-1,j-1,board));
                if(board[i][j]==1){
                    if(calculateStateforOne(list) == false)
                        //to keep track of what elements have changed
                        //this line means 1 is changed to 0
                        board[i][j]=2;
                }else{
                    if(calculateStateforZero(list) == true)
                        //to keep track of what elements have changed
                        //this line means 0 is changed to 1
                        board[i][j]=3;
                }
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==2)
                    board[i][j]=0;
                else if(board[i][j]==3)
                    board[i][j]=1;
                else
                    continue;
            }
        }

    }

    public boolean calculateStateforOne(List<Integer> dir){
        int count = 0;
        for(Integer i:dir){
            if(i==1)
                count+=1;
        }

        if(count==2 || count==3)
            return true;

        return false;

    }

    public boolean calculateStateforZero(List<Integer> dir){
        int count = 0;
        for(Integer i:dir){
            if(i==1)
                count+=1;
        }

        if(count==3)
            return true;

        return false;

    }

    public int getValue(int i, int j, int[][] board){
        if((i>=0 && i<board.length) && (j>=0 && j<board[0].length)){
            if(board[i][j]==2)
                return 1;
            else if(board[i][j]==3)
                return 0;
            else
                return board[i][j];
        }
        return 0;
    }
}
