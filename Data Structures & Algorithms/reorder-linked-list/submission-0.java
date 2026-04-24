class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return; // Edge case: empty list or single node
        
        // Step 1: Store values in an ArrayList
        ArrayList<Integer> a1 = new ArrayList<>();
        ListNode temp = head; // Preserve original head reference
        while (temp != null) {
            a1.add(temp.val);
            temp = temp.next;
        }
        
        System.out.println(a1); // Debugging

        // Step 2: Reorder values
        ArrayList<Integer> result = new ArrayList<>();
        result.add(a1.get(0));
        int n = a1.size();
        boolean count = true;
        int j = 1;

        for (int i = 1; i < n; i++) {
            if (count) {
                result.add(a1.get(n - j));
                count = false;
            } else {
                result.add(a1.get(j));
                j++;
                count = true;
            }
        }

        System.out.println(result); // Debugging
        
        // Step 3: Modify the original linked list in-place
        temp = head;
        int index = 0;
        while (temp != null) {
            temp.val = result.get(index);
            temp = temp.next;
            index++;
        }
    }
}
