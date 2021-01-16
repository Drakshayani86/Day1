class Sum
{
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int index = 0;
        int a[]=new int[A.size()];
        for(int i=0;i<A.size();i++){
            a[i]=A.get(i);
        }
        subsets(a, index, curr, res, B);
        return res;
    }
    public static void subsets(int a[], int index, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res, int k){
	    //if subset of sum k is generated then add into result
            if(k==0){
	    	if(!res.contains(curr))
	             res.add(new ArrayList<>(curr));  
	    }
	    //if we move out of bound then return
	    if(k<0 || index==a.length){
	        return;
	    }
	    for(int i=index;i<a.length;i++){
	        curr.add(a[i]);
	        subsets(a, i, curr, res, k-a[i]);
	        curr.remove(curr.size()-1);
	    }
	}
}
