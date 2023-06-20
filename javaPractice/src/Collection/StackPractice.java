package Collection;

import java.util.Stack;

public class StackPractice {
    public static void main(String[] args){
        Stack s= new Stack();
        s.push("1ewr");
        s.push(2);
        s.push(2);
        s.push(2);
       // s.push(s);
        s.add(4);
        System.out.println(s.pop());
        System.out.println(s.peek());

        System.out.println(s.empty());
        System.out.println(s.search("1ewr"));

    }
}
