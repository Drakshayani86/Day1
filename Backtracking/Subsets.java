class GFG
 {
	public static void main (String[] args){
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0){
	        int n=sc.nextInt();
	        int a[]=new int[n];
	        for(int i=0;i<n;i++){
	            a[i]=sc.nextInt();
	        }
	        Arrays.sort(a);
	        List<List<Integer>> res=new ArrayList<>();
	        List<Integer> curr=new ArrayList<>();
	        subsets(a, 0, curr, res);
	       // System.out.println(res);
	       StringBuilder sb=new StringBuilder();
	       sb.append("()");
	        for(List<Integer> al:res){
	            sb.append("(");
	            for(Integer i:al){
	                sb.append(i+" ");
	            }
	            sb.append(")");
	            sb.deleteCharAt(sb.length()-2);
	        }
	        System.out.println(sb);
	    }
	}
	public static void subsets(int a[], int index, List<Integer> curr, List<List<Integer>> res){
	    
	    if(curr.size()>0){
	        res.add(new ArrayList<>(curr));
	    }
	    //if index out of bounds then return
	    if(index==a.length){
	        return;
	    }
	    //generate all possible subsets
	    for(int i=index;i<a.length;i++){
	        curr.add(a[i]);
	        subsets(a, i+1, curr, res);
	        curr.remove(curr.size()-1);
		//skip incase of duplicates
	        while(i<a.length-1 && a[i]==a[i+1])
	            i++;
	    }
	}
}