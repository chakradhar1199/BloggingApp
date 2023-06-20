package lambdaExpressions;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Lambda_function {
    public static void main(String[] args) {
        final StringBuilder temp = new StringBuilder();
        Consumer<String> method = (String s) -> {temp.append(s);};
        ArrayList list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.forEach(method);
        System.out.println(temp);
    }
}
