package com.nathan.array;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Ye.Yang
 * @date 19-7-25 下午2:26
 **/
public class DealArray {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

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
     * Move zeros to com.nathan.array end.
     *
     * @param nums the com.nathan.array
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
     * @param nums   the sorted com.nathan.array {0, 0, 1, 2, 5, 6}
     * @param target the target sum
     * @return index com.nathan.array,else null
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

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[1] = i;
                result[0] = map.get(nums[i]);
            }
            // 遍历时将当前元素与目标 target 的差值作为 key 存入，后续遍历如果遇到值为该差值的数组元素，则找到了
            map.put(target - nums[i], i);
        }
        return result;
    }

}