class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Start from the end and add 1
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;  // No carry, we're done
                return digits;
            }
            digits[i] = 0;  // Set to 0 and carry over
        }
        
        // If we're here, all digits were 9 (e.g., 999 → 1000)
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;  // Leading 1, rest are 0
        return newDigits;
    }
}