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