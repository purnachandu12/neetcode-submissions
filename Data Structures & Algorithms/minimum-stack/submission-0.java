class MinStack {
    static ArrayList<Integer> a1;
    public MinStack() {
       a1=new ArrayList<>();
    }
    
    public void push(int val) {
        a1.add(val);
    }
    
    public void pop() {
        int value=a1.get(a1.size()-1);
        a1.remove(a1.size()-1);
    }
    
    public int top() {
        return a1.get(a1.size()-1);
    }
    
    public int getMin() {
        int min=a1.get(0);
        for(int i=0;i<a1.size();i++){
            if(a1.get(i)<min){
                min=a1.get(i);
            }
        }
        return min;
    }
}
