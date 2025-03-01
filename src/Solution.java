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

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//
//class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> resultList = new ArrayList<>();
//        //先对数组进行排序
//        Arrays.sort(nums);
//        //下面开始遍历查找
//        for (int first = 0; first < nums.length - 2; first++) {
//            //这是三元组的第一个数字
//            if (first > 0 && nums[first] == nums[first - 1]) continue;
//
//            int target = -nums[first];//确认target
//
//            //接下来定位第三个数为数组的末尾，此时有对应关系，b+c=-a.又因为数组是排序好的，那么找三元组的过程中，
//            //第三个指针只会往左，第二个指针只会往右。
//            int third = nums.length - 1;
//            for (int second = first + 1; second < third; second++) {
//                //下面开始找，要先保证second不重复
//                if (second > first + 1 && nums[second] == nums[second - 1]) continue;//说明这个second会重复，就不找了
//                while (nums[second] + nums[third] > target && second < third) {
//                    //说明后两个数字加起来不满足条件
//                    third--;
//                }
//                //现在third索引位置的元素大小就是正常的
//                if (nums[second] + nums[third] == target && second != third) {
//                    resultList.add(Arrays.asList(nums[first], nums[second], nums[third]));
//                }
//            }
//        }
//        return new ArrayList<>(resultList);
//    }
//}

import java.util.*;

//class Solution {
//    public int trap(int[] height) {
//        int leftMax = 0;
//        int rightMax = 0;
//        int leftIndex = 0;
//        int rightIndex = height.length - 1;
//        int result = 0;
//        while (leftIndex < rightIndex) {
//            //先更新最大值
//            leftMax = Math.max(leftMax, height[leftIndex]);
//            rightMax = Math.max(rightMax, height[rightIndex]);
//
//            if (height[leftIndex]<height[rightIndex]){
//                result+=leftMax-height[leftIndex];
//                leftIndex++;
//            }
//            else{
//                result+=rightMax-height[rightIndex];
//                rightIndex--;
//            }
//        }
//        return result;
//    }
//}

//class Solution {
//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> result = new ArrayList<>();
//        if (p.length() > s.length()) return result;
//        //用数组替代
//        int[] stand = new int[26];
//        int[] window = new int[26];
//        // 初始化标准表和第一个窗口
//        for (int i = 0; i < p.length(); i++) {
//            stand[p.charAt(i) - 'a']++;
//            window[s.charAt(i) - 'a']++;
//        }
//        if (Arrays.equals(stand, window)) result.add(0);
//        //开始滑动窗口
//        for (int i = p.length(); i < s.length(); i++) {
//            //窗口右移，加新的字母，减去旧的字母
//            window[s.charAt(i) - 'a']++;
//            window[s.charAt(i - p.length()) - 'a']--;
//            if (Arrays.equals(stand, window)) result.add(i - p.length() + 1);
//        }
//
//        return result;
//    }
//}

//class NumArray {
//    private int[] nums;
//
//    public NumArray(int[] nums) {
//        this.nums = nums;
//    }
//
//    public int sumRange(int left, int right) {
//        int result = 0;
//        for (int i = left; i <= right; i++) {
//            result += nums[i];
//        }
//        return result;
//    }
//}

//class Solution {
//    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//        int s = 0;//这个是前缀和
//        Map<Integer, Integer> map = new HashMap<>(nums.length + 1);
//        map.put(0, 1);//前缀和s[0]单独统计
//        for (int x : nums) {
//            //统计前缀和
//            s += x;
//            //统计s[i]-s[j]=k的个数
//            count += map.getOrDefault(s - k, 0);
//            map.merge(s, 1, Integer::sum);
//        }
//        return count;
//    }
//}

//class Solution {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        //滑动窗口最大值，应使用双端队列
//        int[] result = new int[nums.length - k + 1];
//        Deque<Integer> deque = new ArrayDeque<>();
//        //循环处理
//        for (int i = 0; i < nums.length; i++) {
//            //处理入队
//            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
//                deque.removeLast();
//            }
//            deque.addLast(i);//索引放入
//            if (i - deque.getFirst() >= k) {
//                //说明最大值已经滑出了
//                deque.removeFirst();
//            }
//            //处理结果
//            if (i >= k - 1) {
//                result[i - k + 1] = nums[deque.getFirst()];
//            }
//        }
//        return result;
//    }
//}

//class Solution {
//    public String minWindow(String s, String t) {
//        char[] chars = s.toCharArray();
//        int[] cnt = new int[128];
//        int ansLeft = -1;
//        int ansRight = s.length() - 1;
//        int less = 0;//表示当前子串中某个字符少于标准串的该字符的数量
//        for (char c : t.toCharArray()) {
//            if (cnt[c] == 0) {
//                less++;
//            }
//            cnt[c]++;
//        }
//
//        int left = 0;
//        for (int right = 0; right < s.length(); right++) {
//            cnt[chars[right]]--;//右边字符移入，则计数减少
//            //减少到0的时候就说明这个字符覆盖了
//            if (cnt[chars[right]] == 0) {
//                //那么未覆盖数-1；
//                less--;
//            }
//            //判断是否全覆盖
//            while (less == 0) {
//                //如果全覆盖了，判断当前左右差值是否比已查到最小的小
//                if (right - left < ansRight - ansLeft) {
//                    ansRight = right;
//                    ansLeft = left;
//                }
//                //左侧移出去之前要先判断
//                char leftChar = chars[left];
//                if (cnt[leftChar] == 0) {
//                    less++;
//                }
//                cnt[leftChar]++;
//                left++;
//            }
//        }
//        return ansLeft >= 0 ? s.substring(ansLeft, ansRight + 1) : "";
//    }
//}

//class Solution {
//    public int maxSubArray(int[] nums) {
//        //这道题用最小前缀和做。
//        int ans = Integer.MIN_VALUE;
//        int preSum = 0;
//        int minPreSum = 0;
//        for (int num : nums) {
//            preSum += num;
//            //更新结果
//            ans = Math.max(ans, preSum - minPreSum);
//            //维护最小前缀和
//            minPreSum = Math.min(preSum, minPreSum);
//        }
//        return ans;
//    }
//}


class Solution {
    public int[][] merge(int[][] intervals) {
        //现在就是按照子元素的左端点排序好了
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]);
        //创造一个新的数组
        List<int[]> ans = new ArrayList<>();
        for (int[] element : intervals) {
            int ansSize = ans.size();
            if (ansSize > 0 && element[0] <= ans.get(ansSize - 1)[1]) {
                //说明当前数组的开始小于结果数组的结束，说明是可以合并的
                ans.get(ansSize - 1)[1] = Math.max(element[1], ans.get(ansSize - 1)[1]);
            } else {
                ans.add(element);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}