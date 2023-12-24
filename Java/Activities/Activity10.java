package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {

    public static void main(String[] a) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("Ankita");
        hs.add("Ram");
        hs.add("Ana");
        hs.add("John");
        hs.add("Joe");
        hs.add("Yashika");

        System.out.println("Size of the hashset : "+ hs.size());

        hs.remove("Ana");
        if(hs.remove("ana")) {
            System.out.println("ana removed from the Set");
        } else {
            System.out.println("ana is not present in the Set");
        }

        if(hs.contains("Yashika"))
        {
            System.out.println("Yashika element is present in the set");
        }

        for(String s : hs)
        {
            System.out.println("ELement of the set : " +s);
        }


    }
}
