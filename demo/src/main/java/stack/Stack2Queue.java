package stack;

import java.util.Stack;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2019-02-28 11:07
 */
public class Stack2Queue {

    private Stack<Integer> stackPut = new Stack<>();
    private Stack<Integer> stackPop = new Stack<>();

    public void put(Integer value){
        stackPut.add(value);
    }

    public Integer pop(){
        if (stackPop.size() > 0){
            return stackPop.pop();
        }
        while (stackPut.size() > 0){
            stackPop.add(stackPut.pop());
        }
        if (stackPop.size() == 0){
            return -1;
        }
        return stackPop.pop();
    }

    public static void main(String[] args) {
        Stack2Queue stack2Queue = new Stack2Queue();

        stack2Queue.put(3);
        stack2Queue.put(4);
        stack2Queue.put(2);
        System.out.println(stack2Queue.pop());
        System.out.println(stack2Queue.pop());
        System.out.println(stack2Queue.pop());
        System.out.println(stack2Queue.pop());
        stack2Queue.put(1);
        stack2Queue.put(7);
        System.out.println(stack2Queue.pop());
        System.out.println(stack2Queue.pop());
        System.out.println(stack2Queue.pop());
    }
}
