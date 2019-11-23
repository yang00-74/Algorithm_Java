
/**
 * @author Ye.Yang
 * @date 19-7-25 下午2:26
 **/
public class DealArray extends DynamicPlan {

    @Override
    public boolean canPartition(int[] nums) {
        return true;
    }


    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 1, 2, 5, 6};

        int[] b = new int[]{1,3,4};

//        DealArray.moveZeros(a);
//        DealArray.sumToTarget(a, 6);
//
//        DealArray.hash("",16);

        System.out.println(DealArray.missingNumber(b));
        /* // use LinkedHashMap to implement LRU cache.
        Map<String, String> map = new LinkedHashMap<String, String>(3, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > 3;
            }
        };

        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        map.put("d","4");
        for (String s : map.values()) {
            System.out.println(s);
        }
        map.get("c");
        map.get("b");

        for (String s : map.values()) {
            System.out.println(s);
        }
        */
        String ab = "ab";
        System.out.println(ab.hashCode());
    }

    /**
     * 数组元素在 0-n 之间，但是有一个数是缺失的，要求找到这个缺失的数。
     *
     * */
    public static int missingNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ i ^ nums[i];
        }
        return ret ^ nums.length;
    }


    /**
     * Move zeros to array end.
     *
     * @param nums the array
     */
    public static void moveZeros(int nums[]) {
        int[] array = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                array[index++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = array[i];
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

    /**
     * 在有序数组中找出两个数，使它们的和为 target.
     * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     *
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     *
     * @param nums   the sorted array {0, 0, 1, 2, 5, 6}
     * @param target the target sum
     * @return index array,else null
     */
    public static int[] sumToTarget(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];
            System.out.print("sum:" + sum + " index:" + i + "," + j);
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return null;
    }

    /**
     * hash 定位数组下标
     *
     * @param key    键值
     * @param length 数组长度
     * @return 返回计算得出的数组下标
     */
    public static int hash(Object key, int length) {
        int h;
        int hashcode = key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
        int index = hashcode & (length - 1);
        System.out.print("the key:" + Integer.toBinaryString(key == null ? 0 : key.hashCode())
                + " hashcode =" + Integer.toBinaryString(hashcode) + " in length=" + length + " table, index=" + index);
        return index;
    }
}