public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       ArrayList<pair> list=new ArrayList<>();
       for(int i=0;i<position.length;i++){
        list.add(new pair(position[i],speed[i]));
       }
       Comparator comparator=new Comparator<pair>(){
        public int compare(pair p1,pair p2){
            return p1.position-p2.position;
        }
       };
       Collections.sort(list,comparator);
       Stack<Double> stack=new Stack<>();
       for(int i=list.size()-1;i>=0;i--){
        double time_taken=(double)(target-list.get(i).position)/list.get(i).speed;
        if(stack.isEmpty()==true || stack.peek()<time_taken){
            stack.push(time_taken);
        }
       }
       return stack.size();
    }
}
class pair{
    int position;
    int speed;
    public pair(int position,int speed){
        this.position=position;
        this.speed=speed;
    }
}