//Time Complexity: O(n*m)
//Space Complexity: O(n*m)
//Did it run on leetcode: yes
//Problems faced any: No


import java.util.ArrayList;
import java.util.List;

public class Problem32 {
    public void gameOfLife(int[][] board) {
        int[][] arr = new int[board.length][board[0].length];

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
                        arr[i][j]=0;
                    else
                        arr[i][j]=1;
                }else{
                    if(calculateStateforZero(list) == false)
                        arr[i][j]=0;
                    else
                        arr[i][j]=1;
                }
            }
        }

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                board[i][j] = arr[i][j];
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
        if((i>=0 && i<board.length) && (j>=0 && j<board[0].length))
            return board[i][j];
        return 0;
    }
}
