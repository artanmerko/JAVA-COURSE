import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Map
 */
public class Map {

    public static void main(String[] args) {
        HashMap<String, String>  trackList = new HashMap<>();
        trackList.put("Song Title 1", "Sample Lyrics 1");
        trackList.put("Song Title 2", "Sample Lyrics 2");
        trackList.put("Song Title 3", "Sample Lyrics 3");
        trackList.put("Song Title 4", "Sample Lyrics 4");

        String songTitle = "Song Title 2";
        String lyrics = trackList.get(songTitle);
        System.out.println("Lyrics for \"" + songTitle + "\": " + lyrics);

        System.out.println("\nAll Track and Lyrics:");
        for (Entry <String, String> track: trackList.entrySet()){
            System.out.println("Track: " + track.getKey() + " Lyrics: " + track.getValue());
        }
    }
}
