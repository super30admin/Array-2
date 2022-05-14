// Time Complexity :O(m*n)
// Space Complexity :O(1)
class Game{
    public void gameOfLife(int[][] n) {
        int a=n.length,b=n[0].length;
        int m[][]=new int[a][b];
        for(int i=0;i<a;i++)
        {
            for(int j=0;j<b;j++)
            {
                m[i][j]=n[i][j];
            }
        }
        for(int i=0;i<a;i++)
        {
            for(int j=0;j<b;j++)
            {
                int k=task(m,i,j);
                if(m[i][j]==0&&k==3)
                    n[i][j]=1;
                else if(m[i][j]==1&&(k==2||k==3))
                    n[i][j]=1;
                else if(m[i][j]==1&&(k<2||k>3))
                    n[i][j]=0;
            }
        }
    }
    static int task(int n[][], int i, int j)
    {
        int count=0;
        int dir[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int di[]:dir)
        {
            int x=di[0]+i;
            int y=di[1]+j;
            if(x<0||y<0||x>=n.length||y>=n[0].length)
                continue;
            else if(n[x][y]==1)
                count++;
        }
        return count;
        
    }
}