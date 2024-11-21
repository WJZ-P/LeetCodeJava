//class Solution {
//    public int sum(int num1, int num2) {
//        return num1 + num2;
//    }
//}

//2469. 温度转换
//class Solution {
//    public double[] convertTemperature(double celsius) {
//        return new double[]{celsius+273.15,celsius*1.8+32};
//    }
//}

//2413. 最小偶倍数
//class Solution {
//    public int smallestEvenMultiple(int n) {
//        if (n <= 2) return 2;
//        return (2 * n) / gcd(n, 2);
//    }
//
//    private int gcd(int a, int b) {
//        while (b != 0) {
//            int temp = b;
//            b = a % b;
//            a = temp;
//        }
//        return a;
//    }
//}