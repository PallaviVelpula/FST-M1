package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList= new ArrayList<>();
        myList.add("Naruto");
        myList.add("Sasuke");
        myList.add("Kakashi");
        myList.add("Itachi");
        myList.add("Nagato");

        for (String names: myList){
            System.out.println(names);
        }
        System.out.println("Third name in the list is: "+myList.get(2));
        if(myList.contains("Itachi"))
            System.out.println("Itachi is present in the list");
        else
            System.out.println("Itachi is not present in the list");
        System.out.println("Size of the list is: "+myList.size());
        myList.remove(1);
        System.out.println("Size of the list after removing a name is: "+myList.size());
    }
}
