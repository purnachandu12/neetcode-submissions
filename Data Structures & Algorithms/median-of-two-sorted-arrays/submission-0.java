class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> a1=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                a1.add(nums1[i]);
                i++;
            }
            else{
                a1.add(nums2[j]);
                j++;
            }
        }
        while(i<nums1.length){
            a1.add(nums1[i]);
            i++;
        }
        while(j<nums2.length){
            a1.add(nums2[j]);
            j++;
        }
        System.out.println(a1);
        if(a1.size()%2==0){
            int mid1=a1.get((a1.size()/2));
            int mid2=a1.get((a1.size()/2)-1);
            System.out.println(a1.size()+" "+mid1+" "+mid2);
            double mid=((double)mid1+mid2)/2.0;
            return mid;
        }
        else{
            int mid=a1.get(a1.size()/2);
            return mid;
        }
    }
}
