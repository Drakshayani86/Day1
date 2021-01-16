class Tree{
    public ArrayList<Integer> result = new ArrayList<>();
    ArrayList<Integer> rightView(Node root) {
        rightSideView(root);
        return result;
    }
    void rightSideView(Node root){
        if(root==null)
            return;
	//level order traversal of the tree
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=null;
            int n=q.size();
            for(int i=1;i<=n;i++){
                temp=q.poll();
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
	    //add the last node of each level into result
            result.add(temp.data);
        }
    }
}
