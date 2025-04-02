import junit.framework.TestCase;

public class FindBallTest extends TestCase {
    // 测试数据：索引位置即假球位置
    private static final int[][] testCases = new int[10][];

    static {
        for (int i = 0; i < 10; i++) {
            int[] arr = new int[10];
            java.util.Arrays.fill(arr, 100);
            arr[i] = 90; // 设置假球
            testCases[i] = arr;
        }
    }

    public void testFindFakeBall() {
        // 测试所有假球情况
        for (int i = 0; i < 10; i++) {
            assertEquals(i, FindBall.findFakeBall(testCases[i]));
        }
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(FindBallTest.class);
    }
}
