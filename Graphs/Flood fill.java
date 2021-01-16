class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)
            return image;
        fill(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    public void fill(int[][] image, int sr, int sc, int color, int newColor){
	//if we move out of bounds then return
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=color)
            return;
	//fill color of current position to new color
        image[sr][sc] = newColor;
	//move in all possible directions
        fill(image, sr-1,sc,color,newColor);
        fill(image, sr+1,sc,color,newColor);
        fill(image, sr,sc-1,color,newColor);
        fill(image, sr,sc+1,color,newColor);
    }
    
}