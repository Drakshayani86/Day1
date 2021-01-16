class Solution{
    static int mindistinct(int[] Arr,int N,int K){
	//store the elements and their frequency
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i:Arr){
            h.put(i, h.getOrDefault(i, 0)+1);
        }
	//create a list from hashmap
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(h.entrySet());
        //sort the elements by their frequency
	Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer>o1, Map.Entry<Integer, Integer>o2){
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
	//put the elements into the hashmap
        HashMap<Integer, Integer> res = new LinkedHashMap<>();
        for(Map.Entry<Integer, Integer> m : list){
            res.put(m.getKey(), m.getValue());
        }
	int count = 0;
        for(Map.Entry<Integer, Integer> e : res.entrySet()){
            if(e.getValue()<=K){
                K -= e.getValue();
		//count the distinct elements deleted
                count++;
            }
            else{
                break;
            }
        }
	//return the remaining distinct elements left
        return h.size()-count;
    }   
}