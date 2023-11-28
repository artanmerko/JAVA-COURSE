public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // insert a word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    // check if a prefix exists in the trie
    public boolean isPrefixValid(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    // check if a word exists in the trie
    public boolean isWordValid(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return false;
            }
        }
        return node.isWord;
    }

    // printAllKeys
    private void printKeys(TrieNode node, String prefix) {
        if (node.isWord) {
            System.out.println(prefix);
        }
        for (char c : node.children.keySet()) {
            printKeys(node.children.get(c), prefix + c);
        }
    }

    // print all keys
    public void printAllKeys() {
        printKeys(root, "");
    }
}
