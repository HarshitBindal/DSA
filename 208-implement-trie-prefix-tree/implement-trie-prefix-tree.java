class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}
class Trie {

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            int ind = ch - 'a';
            if(node.children[ind]==null){
                node.children[ind] = new TrieNode();
            }
            node = node.children[ind];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            int ind = ch - 'a';
            if(node.children[ind]==null){
                return false;
            }
            node = node.children[ind];
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch: prefix.toCharArray()){
            int ind = ch-'a';
            if(node.children[ind]==null){
                return false;
            }
            node = node.children[ind];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */