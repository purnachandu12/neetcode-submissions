class MedianFinder {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;

    public MedianFinder() {
        minheap=new PriorityQueue<>();
        maxheap=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxheap.add(num);
        if(Math.abs(maxheap.size()-minheap.size())>1){
            int element=maxheap.remove();
            minheap.add(element);
        }
        if(minheap.size()>0 && maxheap.size()>0 && maxheap.peek()>minheap.peek()){
            int element=maxheap.remove();
            int element2=minheap.remove();
            minheap.add(element);
            maxheap.add(element2);
        }
    }
    
    public double findMedian() {
       if(maxheap.size()==minheap.size()){
        int value1=minheap.peek();
        int value2=maxheap.peek();
        double result=(double)(value1+value2)/2;
        return result;
       }
       else if(maxheap.size()>minheap.size()){
        return maxheap.peek();
       }
       else{
        return minheap.peek();
       }
    }
}
