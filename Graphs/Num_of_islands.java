class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j, m, n);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int i, int j, int m, int n){
	//if we move out of bounds then return
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0')
            return;
        grid[i][j]='0';
	//move in all possible directions
        dfs(grid,i+1,j,m,n);
        dfs(grid,i,j+1,m,n);
        dfs(grid,i-1,j,m,n);
        dfs(grid,i,j-1,m,n);
    }
}