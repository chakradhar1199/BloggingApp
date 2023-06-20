package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cursor_Iterator {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();

        for(int i=0;i<100;i++){
            l.add(i);
        }
        System.out.println(l);
        Iterator<Integer> i = l.iterator();

        while(i.hasNext()){
            int t = i.next();
            if(t%6 == 0){
                System.out.println(t);
            }
            else{
                i.remove();
            }
        }
        System.out.println(l);
    }
}
