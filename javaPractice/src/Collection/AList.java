package Collection;

import java.io.*;
import java.security.spec.ECField;
import java.util.*;

//import static java.lang.invoke.MethodHandleImpl.ArrayAccessor.type;

public class AList {
    public static void main(String[] args) {
//        ArrayList a = new ArrayList(3);
//        a.add(1);
//        a.add(2);
//        a.add(5);
//        System.out.println(a);
//        a.clear();
//        System.out.println(a);
        int b[] = new int[2];
        b[1] = 1;
        b[0] = 0;
        List<String> list5 = new ArrayList<>(Arrays.asList( "One", "Two", "Three"));
        ArrayList<String> list6 = (ArrayList<String>) Collections.synchronizedList(list5);

        Map m = new HashMap();


        list5.add("dsf");
        System.out.println(list5);

//        -------------cloning----------------------------
        ArrayList<Integer> bList = new ArrayList(Arrays.asList(b));
        List c = new ArrayList();
        c.add(1);
        c.add(2);
        ArrayList d = (ArrayList) ((ArrayList<?>) c).clone();
//        --------------------------------deepcopy test with cloning--------------------------------
        List<List<Integer>> deepList  = new ArrayList<>();
        int j=0;
        deepList.add(new ArrayList<>());
        deepList.add(new ArrayList<>());
        for(List l: deepList){

            for(int i=0;i<10;i++){
                l.add(i+j);
            }
            j+=10;

        }
        System.out.println(deepList);
        List<List<Integer>> clonedList = (List<List<Integer>>) ((ArrayList<List<Integer>>) deepList).clone();//

        // -----------------serialize and deserialize an list ------------------
try {
    FileOutputStream outputStream = new FileOutputStream("list.txt");
    ObjectOutputStream out = new ObjectOutputStream(outputStream);
    out.writeObject(deepList);
    out.close();
    System.out.println("serialized the list");
    deepList.get(0).set(3,400);
    FileInputStream inputStream = new FileInputStream("list.txt");
    ObjectInputStream in = new ObjectInputStream(inputStream);
    List<List<Integer>> clonedSerializedList= (List<List<Integer>> ) in.readObject();
    System.out.println(clonedSerializedList);
    clonedSerializedList.get(0).set(4,450);
    System.out.println(deepList);
    System.out.println(clonedSerializedList);
    System.out.println("deserialization completed for the list");
}catch (Exception ex){
    System.out.println(ex.getMessage());

}

        clonedList.get(0).set(5,999);
        System.out.println("after clone");
        System.out.println(clonedList);
        System.out.println(deepList);
//        for(List l: deepList){
//            List temp = l.clone
//            clonedList.add((ArrayList)l.clone());
//        }

//        System.out.println(d);
//        for(int i=0;i<bList.size();i++){
//            System.out.println(bList.get(i).getClass().toString());
//        }
    }
}
