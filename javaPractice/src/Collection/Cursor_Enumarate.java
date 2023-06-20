package Collection;

import java.util.Enumeration;
import java.util.Vector;

public class Cursor_Enumarate {
    public static void main(String[] args) {
        Vector v = new Vector();

        for(int i=1;i<100;++i){
            v.addElement(i);
        }

        Enumeration e = v.elements();
        while(e.hasMoreElements()){
            Integer i = (Integer)e.nextElement();
            if(i%2 == 0)
                System.out.println(i);


        }
    }
}
