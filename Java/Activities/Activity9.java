package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {

    public static void main(String[] a) {
        ArrayList<String> lst = new ArrayList<String>();
        lst.add("Ankita");
        lst.add("Ram");
        lst.add("Ana");
        lst.add("John");
        lst.add("Joe");

        for(int i =0 ;i<lst.size();i++)
        {
            System.out.println(lst.get(i));
        }

        String third_ele = lst.get(2);
        System.out.println("3rd element of the list : " + third_ele);

        if(lst.contains(third_ele))
        {
            System.out.println("ELement is present in the list");
        }

        //int lst_size = lst.size();
        System.out.println("Size of the list is : "+ lst.size());

        lst.remove("Joe");
        System.out.println("Size of the list after remove operation is : "+ lst.size());

    }
}
