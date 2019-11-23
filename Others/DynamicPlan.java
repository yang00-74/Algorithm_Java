package Others;

/**
 * @author Ye.Yang
 * @date 19-7-8 ����7:24
 **/
public class DynamicPlan {

    public static void main(String[] args) {

        DynamicPlan dp = new DynamicPlan();
        int[] weights = {1, 2, 3, 4};
        int[] values = {2, 4, 3, 6};

        System.out.println("The max value:" + dp.knapsack(4, weights, values));
//        dp.spiltArray(0,5);
//        dp.canPartition(new int[]{1,2,5,6});
//        dp.coinChange(new int[]{3, 4, 5}, 12);
    }

    /**
     * 0-1 Knapsack.һ����Ʒֻ����һ��
     *
     * ��һ������Ϊ W �ı�����Ҫ���������װ����Ʒ�ļ�ֵ�����Щ��Ʒ���������ԣ���� w �ͼ�ֵ v��
     *
     * ����һ����ά���� dp �洢����ֵ������ dp[i][j] ��ʾǰ i ����Ʒ��������� j ��������ܴﵽ������ֵ����� i ����Ʒ���Ϊ w����ֵΪ v��
     * ���ݵ� i ����Ʒ�Ƿ���ӵ������У����Է�����������ۣ�
     *
     * 1.�� i ����Ʒû��ӵ������������������ j ��ǰ i ����Ʒ������ֵ��������������� j ��ǰ i-1 ����Ʒ������ֵ��dp[i][j] = dp[i-1][j]��
     * 2.�� i ����Ʒ��ӵ������У�dp[i][j] = dp[i-1][j-w] + v
     *
     * dp[i][j] = max(dp[i-1][j-w] + v,dp[i-1][j])
     **/

    /**
     * @param W       ��������������
     * @param weights ��Ʒ������� {1,2,3,4}
     * @param values  ��Ʒ��ֵ���� {2,4,3,6}
     * @return ��������ֵ
     **/
    public int knapsack(int W, int[] weights, int[] values) {
        int length = weights.length;
        /*int[][] dp = new int[length + 1][W + 1];
        for (int i = 1; i <= length; i++) { // ��Ʒ����ѭ��
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = 1; j <= W; j++) { // ��Ʒ���ѭ��
                if (j >= w) { // �� i ����Ʒ���뱳��
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length][W];*/

        int[] dp = new int[W + 1]; // һά�����Ż�
        for (int i = 1; i <= length; i++) { // ��Ʒ����ѭ��
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = W; j >=1; j--) { // 0-1 ��������һά�����ʾ���������,����֮ǰ�ļ��������֮��Ľ�����Ӱ��
                if (j >= w) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                    System.out.println("dp[" + j + "]:" + dp[j]+" dp[" + (j-w) + "]:"+ dp[j - w]);
                }
            }
        }
        return dp[W];
    }

    int[] a = new int[20];
    int count = 0;
    int sum = 0;
    int[] nums = {1, 2, 3, 4};

    // ��������Ϊ��ȵ�������,���ݷ�
    public void spiltArray(int startIndex, int target) {

        if (target == sum) {
            for (int i = 0; i <= count - 1; i++) {
                System.out.print(a[i] + ",");
            }
            System.out.println(" ");
        }
        if (sum > target) return;
        int length = nums.length;
        for (int i = startIndex; i < length; i++) {
            a[count++] = nums[i];
            sum += nums[i];
            spiltArray(i + 1, target); //����Ԫ�ز��ɸ���, index +1
            sum -= nums[i];
            a[--count] = 0;
        }
    }

    // �ж������Ƿ�ɻ���Ϊ����ȵ�������,��̬�滮,�ɿ���һ��������СΪ sum/2 �� 0-1 ��������
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        for (int num : nums) {
            System.out.println("the num is " + num);
            for (int i = W; i >= num; i--) {   // �Ӻ���ǰ���ȼ��� dp[i] �ټ��� dp[i-num]
                dp[i] = dp[i] || dp[i - num];
                System.out.println("dp[" + i + "]:" + dp[i] + "," + "dp[" + (i - num) + "]:" + dp[i - num]);
            }
        }
        return dp[W];
    }


    /***
     * @param coins Ӳ����ֵ����
     * @param amount Ŀ������
     * @return ʹ��Ӳ�Ҵճ�Ŀ�����������Ӳ����
     * */
    public int coinChange(int[] coins, int amount) {
        // coins = [1, 2, 5], amount = 12
        if (amount == 0 || coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) { // ����һ����ȫ�������⡣��ȫ������Ҫ�� 0-1 ������������� dp �����Ϊ�������,
                if (i == coin) {
                    dp[i] = 1;
                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;
                } else if (dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }

                System.out.print("dp[" + i + "]:" + dp[i] + " ");
            }
            System.out.println();
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

}
