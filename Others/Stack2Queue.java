
import java.util.Stack;

public class Stack2Queue {

    public static void main(String[] args) {
        Stack2Queue q = new Stack2Queue();
        q.push(6);
        q.push(5);

        System.out.println(q.pop());
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {//����ѹ��Ԫ��x
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();//���е���Ԫ��x
    }
}
