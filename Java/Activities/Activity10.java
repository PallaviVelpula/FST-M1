package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("Mikey");
        hs.add("Draken");
        hs.add("Baji");
        hs.add("Mitsuya");
        hs.add("Kazutora");
        hs.add("Pah Chin");
        System.out.println("Hashset is:" + hs);
        System.out.println("Size of the Hashset is:" + hs.size());
        hs.remove("Kazutora");
        hs.remove("Takemichi");
        System.out.println(hs.contains("Baji"));
        System.out.println("Updated Hashset is:" + hs);

    }
}
