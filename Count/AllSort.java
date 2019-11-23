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

    public void Heapify(int a[], int i, int size) {//��a[i]���µ�����
        int left_child = 2 * i + 1;
        int right_child = 2 * i + 2;
        int max = i;
        //�Ҹ��ڵ�������ӽڵ��е����ֵ��ȷ�����ڵ�Ϊ���ֵ
        if (left_child < size && a[left_child] > a[max])
            max = left_child;
        if (right_child < size && a[right_child] > a[max])
            max = right_child;
        if (max != i) {
            swap(a, i, max);
            Heapify(a, max, size);//��¼����ǰ�ӽڵ�λ�ã��Ӹ�λ�����µ�����
        }
    }

    //������
    public int BuildHeap(int a[], int n) {
        int heap_size = n;
        for (int i = heap_size / 2 - 1; i >= 0; i--) {//�ӷ�Ҷ�ӽ�㿪ʼ������ֱ��a[0]��
            Heapify(a, i, heap_size);
        }
        return heap_size;
    }

    //������
    public void HeapSort(int a[], int n) {
        int heap_size = BuildHeap(a, n);
        while (heap_size > 1) {
            // ���Ѷ�Ԫ����ѵ����һ��Ԫ�ػ������������һ��Ԫ�ش��Ժ�Ķѵ����к���--heap_size
            swap(a, 0, --heap_size);
            Heapify(a, 0, heap_size);//���µĶѶ�������
        }
    }

    //�鲢����
    public void Merge(int a[], int left, int mid, int right) {
        int len = right - left + 1;
        int temp[] = new int[len];
        int index = 0;
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            temp[index++] = a[i] <= a[j] ? a[i++] : a[j++];
        }//���������ֳ��Ȳ�һ��ʱ�Ĵ���
        while (i <= mid) {
            temp[index++] = a[i++];
        }
        while (j <= right) {
            temp[index++] = a[j++];
        }
        for (int k = 0; k < len; k++) {
            a[left++] = temp[k];//������õ����鸳ֵ��ԭ����
        }
    }

    public void MergeSort(int a[], int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;//������ֻ�
        MergeSort(a, left, mid);
        MergeSort(a, mid + 1, right);

        Merge(a, left, mid, right);//�鲢����

    }

	// ð���������ʱ��Ϊ O��n��,����ð������ĩβ
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
	
	//������������ץ������
	public void insertSort(int a[]) {
		for (int i = 0;i <a.length;i++) {
			int get = a[i]; // Ĭ�� a[0]Ϊ����õ�Ԫ��
			int j = i-1;
			while (j >= 0 && a[j] >get) {// a[i] ��Ҫ���������в��룬�����д��� get ��Ԫ���������ƶ���Ų��λ��
				a[j+1]= a[j];
				j--;
			}
			a[j+1] = get;
		}
	}
	
	//ѡ������ÿ��ѡ����Сֵ�ŵ������������ĩβ
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
    
    //����
    public void QuickSort(int a[], int left, int right) {
        int i, j;
        while (left < right) {
            i = left;
            j = right + 1;
            do {
                while (a[++i] < a[left]) ;
                while (a[--j] > a[left]) ;
                if (i < j) swap(a, i, j);//���������ұȱ��Ԫ�ش�,���������ұȱ��Ԫ��С,����
            } while (i < j);

            swap(a, left, j);//һ����ϣ��������Ԫ��λ��
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
