/*In this program the objective is to identify the 0 element in a given matrix and return an output such that all the non zero values in the row 
same as the zero element and column same as the zero element is changed to 0
*/
//Time complexity O(MN * (M+N)) //In order to iterate over the whole matrix first O(MN) and then iterating over 1 row and 1 column to change it to 0 O(M+N)
//Space Complexity O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        //Taking a dummy value outside of the given range 
        int MOD = -1000000;
        //no of rows
        int m = matrix.length;
        //no of columns
        int n = matrix[0].length;
        //Iterate over the matrix
        for (int i = 0; i<m; i++)
        {
            for (int j = 0; j<n; j++)
            {
                //check if element is 0
                if(matrix[i][j] == 0)
                {
                    
                    //for all the values in that row i which contains the 0 element 
                    for (int k = 0; k < n ; k++)
                    {
                        //Check for non zero elements in that row 
                        if(matrix[i][k] !=0)
                        {
                            //Assign dummy value to it
                            matrix[i][k] = MOD;
                        }
                    }
                    //all the values in that column j which contains the 0 element
                    for (int k=0; k< m; k++)
                    {  
                        //Check for non zero elements in that column
                        if(matrix[k][j]!=0)
                        {
                            //Assign dummy value to it
                            matrix[k][j] = MOD;
                        } 
                    }
                }
            }
        }
        //Iterate again for final output matrix
        for (int i = 0; i< m ; i++)
        {
            for (int j = 0; j< n; j++ )
            {
                //Check if the value of element is MOD
                if (matrix[i][j] == MOD)
                {
                    //if so Change to 0
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}