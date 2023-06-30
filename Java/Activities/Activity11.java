package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        Map<Integer, String> colourMap= new HashMap<>();
        colourMap.put(1, "Black");
        colourMap.put(2,"Blue");
        colourMap.put(3, "Purple");
        colourMap.put(4, "Rose Quartz");
        colourMap.put(5, "Serenity");
        System.out.println("Hashmap is: "+ colourMap);
        colourMap.remove(2);
        System.out.println("Is green colur present in the map? "+colourMap.containsValue("green"));
        System.out.println("Size of the map is: "+ colourMap.size());
    }


}
