import java.util.HashMap;
import java.util.Map;

class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}
