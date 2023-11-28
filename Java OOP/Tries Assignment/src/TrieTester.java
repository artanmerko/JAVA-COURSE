public class TrieTester {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // insert
        trie.insert("cat");
        trie.insert("cap");
        trie.insert("cape");
        trie.insert("caper");

        // isPrefixValid
        System.out.println("Is 'ca' a valid prefix? " + trie.isPrefixValid("ca"));
        System.out.println("Is 'bat' a valid prefix? " + trie.isPrefixValid("bat"));

        // isWordValid
        System.out.println("Is 'cape' a valid word? " + trie.isWordValid("cape"));
        System.out.println("Is 'capo' a valid word? " + trie.isWordValid("capo"));

        // Print all
        System.out.println("All keys in the trie:");
        trie.printAllKeys();
    }
}
