public class Sculpture extends Art{
    String material;
    @Override
    public void viewArt() {
        System.out.println("Title: " + title + ", Author: " + author +  ", Description: "+ description +", Material: " + material);
    }
}
