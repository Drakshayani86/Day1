class Solution{
    Long countWays(int N){
        long m = (long)Math.pow(10, 9)+7;
        if(N==1 || N==2)
            return (long)N;
	//values of first and second step
        long first = 1, second = 2, res=0;
        for(int i=3;i<=N;i++){
	   //value of nth step is sum of (n-1)th and (n-2)th step 
            res = (first+second)%m;
            first = second;
            second = res;
        }
        return res%m;
    }
}