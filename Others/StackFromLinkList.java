package Others;

import java.util.LinkedList;

public class StackFromLinkList {

    /**
     * ������ģ�����ݽṹջ/����
     */
    private LinkedList link;

    public StackFromLinkList() {
        link = new LinkedList();
    }

    public void add(Object obj) {
        link.addFirst(obj);

    }

    public Object get() {

        //return link.removeFirst();//����ͷ���,ģ��ջ���Ƚ����
        return link.removeLast();//����β����㣬ģ����У��Ƚ��ȳ�
    }

    public boolean isEmpty() {
        return link.isEmpty();
    }

    public static void main(String[] args) {
        StackFromLinkList m = new StackFromLinkList();
        m.add("hello");
        m.add("you");
        m.add("are");
        while (!m.isEmpty()) {
            System.out.println(m.get());
        }

    }

}
