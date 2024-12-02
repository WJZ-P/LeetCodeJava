//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//
//class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        //这里新建一个hashMap
//        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
//        for (String string : strs) {
//            //遍历字符串数组
//            char[] charStr = string.toCharArray();
//            Arrays.sort(charStr);
//            //排序好的字符串
//            String sortedStr = new String(charStr);
//            ArrayList<String> strList = hashMap.get(sortedStr);
//            if (strList == null) {
//                strList = new ArrayList<>();
//                hashMap.put(sortedStr, strList);
//            }
//
//            strList.add(string);
//
//
//        }
//        //hashMap不保证顺序，但是无所谓，题目不要求顺序
//
//        //现在全部存放好了，接下来需要的是输出！
//        return new ArrayList<>(hashMap.values());
//    }
//}

//import java.util.HashSet;
//import java.util.Set;
//
//class Solution {
//    public int longestConsecutive(int[] nums) {
//        //这里使用哈希集合
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);//先把元素插入
//        }
//        //接下来就开始查询
//        int currentCount = 0;
//        int currNum = 0;
//        int max = 0;
//        for (int number : set) {
//            currNum = number;
//            if (!set.contains(currNum - 1)) {//集合里面没有比这个小1的，说明是序列的开头
//                currentCount++;//数字增加
//                while (set.contains(++currNum)) {//如果集合里面有比这个大的
//                    currentCount++;
//                }
//                max = Math.max(max, currentCount);//更新最大值
//                currentCount=0;
//            }
//        }
//        return max;
//    }
//}

//class Solution {
//    public void moveZeroes(int[] nums) {
//        int lastNotZeroNumIndex=0;
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]!=0){
//                nums[lastNotZeroNumIndex]=nums[i];
//                lastNotZeroNumIndex++;
//            }
//        }
//        for(int i=lastNotZeroNumIndex;i<nums.length;i++){
//            nums[i]=0;
//        }
//    }
//}

//class Solution {
//    public int maxArea(int[] height) {
//        int left = 0, right = height.length - 1;
//        //上面定义了双指针。
//        int maxArea = 0;
//        while (left != right) {
//            int newArea = Math.min(height[left], height[right]) * (right - left);
//            if (newArea > maxArea) maxArea = newArea;
//            //上面进行最大面积的更新。
//            if(height[left]>height[right])//左边的高度比右边高，应该右边往左边靠拢
//                right--;
//            else
//                left++;
//        }
//        return maxArea;
//    }
//}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int[] threeNums = new int[]{nums[i], nums[j], nums[k]};
                        Arrays.sort(threeNums);
                        List<Integer> list = Arrays.stream(threeNums).boxed().toList();
                        resultSet.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(resultSet);
    }
}