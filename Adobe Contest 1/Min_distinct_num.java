class Solution{
    static int mindistinct(int[] Arr,int N,int K){
	//Store the elements and its frequency in hashmap

        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i:Arr){
            h.put(i, h.getOrDefault(i, 0)+1);
        }

	//Sort the elements by frequency

        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(h.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer>o1, Map.Entry<Integer, Integer>o2){
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<Integer, Integer> res = new LinkedHashMap<>();
        for(Map.Entry<Integer, Integer> m : list){
            res.put(m.getKey(), m.getValue());
        }
	int count = 0;
        for(Map.Entry<Integer, Integer> e : res.entrySet()){
            if(e.getValue()<=K){
                K -= e.getValue();
		//count the elements 
                count++;
            }
            else{
                break;
            }
        }
	//
        return h.size()-count;
    }   
}