import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))//找到数字了
                return new int[]{map.get(target - nums[i]), i};
            else
                map.put(nums[i], i);//记录下来
        }
        return new int[0];
    }
}