class Solution {
    public int rob(int[] nums) {
        if(nums.length <= 1) return nums[0];
        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = prev;
            prev = Math.max(prev2 + nums[i], prev);
            prev2 = temp;
        }

        return prev;
    }
}
