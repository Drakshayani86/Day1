class GfG {
    public static ArrayList<String> res;
    public static String path = "";
    public static ArrayList<String> findPath(int[][] m, int n) {
        res = new ArrayList<>();
        boolean visited[][] = new boolean[n][n];
        findPathUtil(0, 0, m, n, visited, path);
        Collections.sort(res);
        return res;
    }
    public static void findPathUtil(int x, int y, int[][] m, int n, boolean[][] visited, String path){
	//check if current path is equal to destination 
        if(x==n-1 && y==n-1 && !visited[x][y] && m[x][y] == 1){
            res.add(path);
            return;
        }
	//if we move out of the maze then return 
        if(x<0 || x>n || y<0 || y>n || visited[x][y]==true || m[x][y]==0)
            return;
        visited[x][y] = true;
	//check if we can move upwards
        if(isSafe(x-1, y, m, n, visited)){
            findPathUtil(x-1, y, m, n, visited, path+'U');
        }
	//check if we can move leftwards
        if(isSafe(x, y-1, m, n, visited)){
            findPathUtil(x, y-1, m, n, visited, path+'L');
        }
	//check if we can move rightwards
        if(isSafe(x, y+1, m, n, visited)){
            findPathUtil(x, y+1, m, n, visited, path+'R');
        }
	//check if we can move downwards
        if(isSafe(x+1, y, m, n, visited)){
            findPathUtil(x+1, y, m, n, visited, path+'D');
        }
	//if we cannot move then backtrack
        visited[x][y] = false;
    }
    //check if the current position is safe or not
    public static boolean isSafe(int x, int y, int[][] m, int n, boolean[][] visited){
        return (x>=0 && x<n && y>=0 && y<n && m[x][y]==1 && visited[x][y]==false);
    }
}
