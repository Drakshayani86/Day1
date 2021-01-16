class Solution
{
    void booleanMatrix(int matrix[][]){
	//row size
        int R = matrix.length;
	//column size
        int C = matrix[0].length; 
        int[] row = new int[R];
        int[] col = new int[C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(matrix[i][j]==1){
		//put corresponding row and column values as 1
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
		//if any row or column value is 1 then the corresponding matrix value is altered to 1
                if(row[i]==1 || col[j]==1){
                    matrix[i][j]=1;
                }
            }
        }
        
    }
}