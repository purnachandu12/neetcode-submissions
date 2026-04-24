class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1;  // Koko's speed starts at 1 (minimum possible speed)
        int j = Arrays.stream(piles).max().getAsInt(); // Maximum pile size
        int res = j; // Store the possible minimum speed
        
        while (i <= j) {
            int mid = (i + j) / 2;
            long time = 0;
            
            for (int m = 0; m < piles.length; m++) {
                time += (piles[m] + mid - 1) / mid; // Ceiling division without Math.ceil()
            }
            
            if (time <= h) {
                res = mid;  // Update the result, try for a lower speed
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return res;
    }
}
