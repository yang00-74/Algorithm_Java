
import java.util.ArrayList;
import java.util.List;

public class SlideWindow {
    public static void main(String[] args) {
        int a[] = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        new SlideWindow().maxInWindows(a, 3);
    }

    /**
     * 长度为 n 的窗口在数组上滑动，窗口每次移动一格，输出每次移动前窗口中的最大数字
     *
     * */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        if (num == null || size < 0) {
            return null;
        }

        List list0 = new ArrayList();
        if (size == 0) {
            return (ArrayList<Integer>) list0;
        }

        int len = num.length;
        List list = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            list.add(num[i]);
        }

        while (list.size() >= size) {
            int max = 0;
            for (int j = 0; j < size; j++) {
                if (max < (int) list.get(j)) {
                    max = (int) list.get(j);
                }
            }
            System.out.print(max);
            list0.add(max);
            list.remove(0);
        }

        return (ArrayList<Integer>) list0;
    }
}
