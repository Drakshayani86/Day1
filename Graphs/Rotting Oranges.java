class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
		    //count number of fresh oranges
                    fresh++;
                else if(grid[i][j]==2)
                    q.add(new int[]{i,j});
            }
        }
        if(fresh == 0)
            return 0;
	//possible moves
        int moves[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int minutes = -1;
        while(!q.isEmpty()){
            int size = q.size();
            minutes++;
            while(size-->0){
                int[] d = q.poll();
                for(int[] dir:moves){
		    //next moves 
                    int x = d[0]+dir[0];
                    int y = d[1]+dir[1];
                    if(x<0||x>=m||y<0||y>=n||grid[x][y]==0||grid[x][y]==2)
                        continue;
                    grid[x][y]=2;
                    fresh--;
                    q.add(new int[]{x,y});
                }
            }
        }
        if(fresh==0)
            return minutes;
        return -1;
    }
}