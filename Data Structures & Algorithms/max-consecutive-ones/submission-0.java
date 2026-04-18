class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int temp = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp += 1;
            }
            if ((nums[i] == 0 || i == nums.length - 1) && result < temp) {
                result = temp;
            }
            if(nums[i] == 0) {
                temp = 0;
            }
        }

        return result;
    }
}