package activities;

public class Activity5 extends Book {
    public void setTitle(String s) {
        title = s;
    }

    public static void main(String[] args) {
        Book newNovel = new Activity5();
        newNovel.setTitle("Hover Car racer");
        System.out.println("The title is: " + newNovel.getTitle());
    }

}
