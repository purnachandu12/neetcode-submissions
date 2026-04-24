class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        while(true){
            int sum=0;
            while(n!=0){
                int value=n%10;
                value=power(value,2);
                sum=sum+value;
                n=n/10;
            }
            if(sum==1){
                return true;
            }
            else if(set.add(sum)==false){
                return false;
            }
            else{
                n=sum;
            }
        }
    }
    public static int power(int base, int exponent) {
    if (exponent < 0) {
        throw new IllegalArgumentException("Exponent must be non-negative");
    }
    int result = 1;
    for (int i = 0; i < exponent; i++) {
        result *= base;
    }
    return result;
    }
}
