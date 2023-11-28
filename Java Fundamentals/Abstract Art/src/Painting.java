public class Painting extends Art{
    String paintType;

    @Override
    public void viewArt() {
        System.out.println("Title: " + title + ", Author: " + author +  ", Description: "+ description + ", Paint Type: " + paintType);
    }
}