package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args)
    {
        HashMap<Integer,String> hm = new HashMap<Integer, String>();
        hm.put(1,"red");
        hm.put(2,"green");
        hm.put(3,"orange");
        hm.put(4,"blue");
        hm.put(5,"voilet");

        System.out.println("The original map is : " + hm);

        hm.remove(4);

        System.out.println("After removing blue: " + hm);

        if(hm.containsValue("green")) {
            System.out.println("Green exists in the Map");
        } else {
            System.out.println("Green does not exist in the Map");
        }

        System.out.println("Number of pairs in the Map is: " + hm.size());

    }
}
