public class LeetCode {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Index for elements not equal to val

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        //5, 3, 6, 5, 5, 5, 2, 4
        //val = 5
        //3, 6, 2, 4, -, -, -, -

        return k;
    }
}

