import java.util.ArrayList;
import java.util.Collections;

public class Museum {
    public static void main(String[] args) {
        Painting painting1 = new Painting();
        painting1.title = "Starry Night";
        painting1.author = "Van Gogh";
        painting1.description = "A beautiful night sky with swirling patterns";
        painting1.paintType = "Oil";

        Painting painting2 = new Painting();
        painting2.title = "The Mona Lisa";
        painting2.author = "Da Vinci";
        painting2.description = "A portrait of a woman with a mysterious smile";
        painting2.paintType = "Oil";

        Painting painting3 = new Painting();
        painting3.title = "The Scream";
        painting3.author = "Munch";
        painting3.description = "An expressionist depiction of a figure screaming";
        painting3.paintType = "Tempera";

        Sculpture sculpture1 = new Sculpture();
        sculpture1.title = "David";
        sculpture1.author = "Michelangelo";
        sculpture1.description = "A Renaissance sculpture of the biblical hero David";
        sculpture1.material = "Marble";

        Sculpture sculpture2 = new Sculpture();
        sculpture2.title = "The Thinker";
        sculpture2.author = "Rodin";
        sculpture2.description = "A sculpture depicting a man in deep thought";
        sculpture2.material = "Bronze";

        ArrayList<Art> museum = new ArrayList<Art>();
        museum.add(painting1);
        museum.add(painting2);
        museum.add(painting3);
        museum.add(sculpture1);
        museum.add(sculpture2);

        Collections.shuffle(museum);
        for (Art art : museum) {
            art.viewArt();
        }
    }
}
