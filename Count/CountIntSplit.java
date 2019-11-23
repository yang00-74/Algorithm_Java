package Count;

public class CountIntSplit {

    public static void main(String[] args) {
//		new CountIntSplit().FindContinueSequence(10);
        new CountIntSplit().DFS(1,4);
    }

    int s[] = new int[100];//�洢���е�����
    int count = 0;//���������Ĵ洢����
    int sum = 0;


    public void DFS(int index, int n) {

        if (sum == n) {
            for (int i = 0; i <= count - 1; i++) {
                if (i == count - 1) {
                    System.out.println(s[i]);
                } else {
                    System.out.print(s[i] + "+");
                }
            }
            return;
        }
        if (sum > n) return;
        for (int i = index; i <= n; i++) {
            sum += i;
            s[count++] = i; // ��ռ��¼
            System.out.println("DFS: " + i + ", s[] index: " + count);
            DFS(i,n);
            sum -= i;
            s[--count] = 0;//���������±�,������һ��
        }

    }

    //�������������ӵ���n������
    public void FindContinueSequence(int n) {

        for (int i = 1; i <= n / 2; i++) {
            int sum = i;
            for (int j = i + 1; j < n; j++) {
                sum += j;
                if (sum > n) {
                    break;
                } else if (sum == n) {
                    for (int k = i; k <= j; k++) {//�����������ʿɱ���
                        if (k == j) {
                            System.out.println(k);
                        } else {
                            System.out.print(k + ",");
                        }
                    }
                }
            }
        }

    }
}
