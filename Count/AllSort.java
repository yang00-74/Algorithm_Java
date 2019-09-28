package Count;

public class AllSort {

    public static void main(String[] args) {
        int a[] = {2, 5, 8, 9, 10, 45, 56, 78};
//		new AllSort().HeapSort(a,  10);
        new AllSort().QuickSort(a, 0, 7);
//		new AllSort().MergeSort(a, 0, 9);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public void Heapify(int a[], int i, int size) {//从a[i]向下调整堆
        int left_child = 2 * i + 1;
        int right_child = 2 * i + 2;
        int max = i;
        //找父节点和两个子节点中的最大值，确保父节点为最大值
        if (left_child < size && a[left_child] > a[max])
            max = left_child;
        if (right_child < size && a[right_child] > a[max])
            max = right_child;
        if (max != i) {
            swap(a, i, max);
            Heapify(a, max, size);//记录交换前子节点位置，从该位置向下调整堆
        }
    }

    //建最大堆
    public int BuildHeap(int a[], int n) {
        int heap_size = n;
        for (int i = heap_size / 2 - 1; i >= 0; i--) {//从非叶子结点开始调整，直到a[0]根
            Heapify(a, i, heap_size);
        }
        return heap_size;
    }

    //堆排序
    public void HeapSort(int a[], int n) {
        int heap_size = BuildHeap(a, n);
        while (heap_size > 1) {
            // 将堆顶元素与堆的最后一个元素互换，并将最后一个元素从以后的堆调整中忽略--heap_size
            swap(a, 0, --heap_size);
            Heapify(a, 0, heap_size);//从新的堆顶调整堆
        }
    }

    //归并排序
    public void Merge(int a[], int left, int mid, int right) {
        int len = right - left + 1;
        int temp[] = new int[len];
        int index = 0;
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            temp[index++] = a[i] <= a[j] ? a[i++] : a[j++];
        }//左右两部分长度不一样时的处理
        while (i <= mid) {
            temp[index++] = a[i++];
        }
        while (j <= right) {
            temp[index++] = a[j++];
        }
        for (int k = 0; k < len; k++) {
            a[left++] = temp[k];//把排序好的数组赋值给原数组
        }
    }

    public void MergeSort(int a[], int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;//把数组分划
        MergeSort(a, left, mid);
        MergeSort(a, mid + 1, right);

        Merge(a, left, mid, right);//归并数组

    }

	// 冒泡排序，最好时间为 O（n）,最大的冒到数组末尾
	public void bubbleSort(int a[]) {
		int length = a.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j+1);
				}
			}
		}
	}
	
	//插入排序，类似抓牌排序
	public void insertSort(int a[]) {
		for (int i = 0;i <a.length;i++) {
			int get = a[i]; // 默认 a[0]为排序好的元素
			int j = i-1;
			while (j >= 0 && a[j] >get) {// a[i] 需要往有序序列插入，序列中大于 get 的元素需往后移动，挪出位置
				a[j+1]= a[j];
				j--;
			}
			a[j+1] = get;
		}
	}
	
	//选择排序，每次选择最小值放到数组已排序的末尾
	public void selectSort(int a[]) {
		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(a, minIndex, i);
			}
		}
	}
    
    //快排
    public void QuickSort(int a[], int left, int right) {
        int i, j;
        while (left < right) {
            i = left;
            j = right + 1;
            do {
                while (a[++i] < a[left]) ;
                while (a[--j] > a[left]) ;
                if (i < j) swap(a, i, j);//从左往右找比标记元素大,从右往左找比标记元素小,交换
            } while (i < j);

            swap(a, left, j);//一趟完毕，交换标记元素位置
            QuickSort(a, left, j - 1);
            QuickSort(a, j + 1, right);
            return;
        }
    }

    private void swap(int a[], int current, int target) {
        int temp = a[current];
        a[current] = a[target];
        a[target] = temp;
    }
}
