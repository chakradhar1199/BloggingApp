package lambdaExpressions;

import java.util.ArrayList;

public class Lambda_forEach {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(1);
        list.add(2);
        list.add(3);

        list.forEach((n) -> System.out.println(n+5));

    }
}