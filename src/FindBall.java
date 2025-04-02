public class FindBall {
    // 所有球的重量数组，正常为100，假球为90
    private static final int[] balls = new int[10];

    public static int findFakeBall(int[] inputBalls) {
        System.arraycopy(inputBalls, 0, balls, 0, 10);

        // 第一次称重
        System.out.println("\n===== 第一次称重 =====");
        System.out.printf("称重范围：左[0-4] vs 右[5-9]\n");
        int firstLeft = sum(0, 5);
        int firstRight = sum(5, 5);
        System.out.printf("左边总重量：%d | 右边总重量：%d\n", firstLeft, firstRight);

        int start = (firstLeft < firstRight) ? 0 : 5;
        System.out.printf("判定假球在%s区[%d-%d]\n", (start == 0) ? "左" : "右", start, start+4);

        // 第二次称重
        System.out.println("\n===== 第二次称重 =====");
        System.out.printf("称重范围：%s区[%d-%d] vs [%d-%d]\n",
                (start == 0) ? "左" : "右",
                start, start+1,
                start+2, start+3);
        int secondLeft = sum(start, 2);
        int secondRight = sum(start + 2, 2);
        System.out.printf("左边总重量：%d | 右边总重量：%d\n", secondLeft, secondRight);

        if (secondLeft == secondRight) {
            int result = start + 4;
            System.out.printf("两侧平衡 → 假球是未称量的第%d号球\n", result);
            System.out.println("\n★★★ 最终判定 ★★★");
            System.out.printf("假球位置：%d号球 (重量：%d)\n", result, balls[result]);
            return result;
        }

        // 第三次称重
        System.out.println("\n===== 第三次称重 =====");
        int thirdIdx = (secondLeft < secondRight) ? start : start + 2;
        System.out.printf("称重范围：%d号球 vs %d号球\n", thirdIdx, thirdIdx+1);
        int finalLeft = balls[thirdIdx];
        int finalRight = balls[thirdIdx + 1];
        System.out.printf("左边重量：%d | 右边重量：%d\n", finalLeft, finalRight);

        int result = (finalLeft < finalRight) ? thirdIdx : thirdIdx + 1;
        System.out.println("\n★★★ 最终判定 ★★★");
        System.out.printf("假球位置：%d号球 (重量：%d)\n", result, balls[result]);
        return result;
    }


    private static int sum(int start, int count) {
        int sum = 0;
        for (int i = start; i < start + count; i++) sum += balls[i];
        return sum;
    }
}