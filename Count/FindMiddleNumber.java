
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 找中位数和出现次数超过数组长度一半的数
 *
 * @author Administrator
 */
public class FindMiddleNumber {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new FindMiddleNumber().MoreThanHalfNum_Solution(a));
       // System.out.println(new FindMiddleNumber().MiddleNumber(a));
    }

    //找中位数
    public Double MiddleNumber(double a[]) {
        ArrayList<Double> list = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }

        Collections.sort(list);
        int len = list.size();
        if (len % 2 == 0) {
            return (list.get(len / 2) + list.get(len / 2 - 1)) / 2;
        } else {
            return list.get(len / 2);
        }

    }

    /**
     * 问题：找出数组中出现次数超过数组长度一半的元素。
     *
     * 解法：
     *  方法一：先将数组中的元素排序，由于目标元素的数量超过数组长度的一半，故排序后数组的中间元素(即数组的中位数)就是目标元素。
     *  时间复杂度O(nlogn)
     *
     *  方法二：构造一个hashmap，key为元素的值，value为元素出现的次数，然后遍历hashmap就可以找到目标元素了。
     *  时间复杂度O(n)，空间复杂度为O(n)
     *
     *  方法三：
     *  思想：将一个目标元素和一个其它元素进行抵消，由于目标元素的数量大于其它元素的数量，故经过多次抵消后，剩下的元素即目标元素。
     *      *
     *      * 步骤：
     *      *  1)在遍历数组的时候保存两个值：数组中的一个元素(target) 和 该元素出现的次数(times)。
     *      *  2)当我们遍历到下一个元素的时候，如果下一个元素和我们之前保存的元素相等，则次数加1。
     *      *  3)如果下一个元素和我们之前保存的元素不相等，则次数减1。
     *      *  4)如果次数为零，我们需要保存下一个元素，并且把次数重设为1。
     *      *  5)由于目标元素出现的次数比其它所有元素出现的次数之和还要多，所以目标元素肯定是最后一次把次数设为1时对应的元素。
     *
     *  时间复杂度O(n)
     *
     * @param array 给定数组, 已知存在某个数出现次数 > 数组长度一半.
     * @return 返回该数
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int result = array[0]; // 记录候选值
        int count = 1; // 记录候选值出现次数,为 0 则更新候选值

        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                result = array[i];
                count++;
            } else if (result == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
