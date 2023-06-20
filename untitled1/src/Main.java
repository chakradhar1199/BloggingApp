import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        List<String> car =  new ArrayList<>(5);

        car.add(3,"Audi");

        for(String a:car){
            System.out.println(a);
        }
    }
}