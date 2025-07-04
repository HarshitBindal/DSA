class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<Integer> wordset = new HashSet(wordList);
        if(!wordset.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        wordset.remove(beginWord);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                String curr = q.poll();
                if(curr.equals(endWord)) return level;
                char[] chars = curr.toCharArray();
                
                for(int j=0; j<curr.length(); j++){
                    char orig = chars[j];
                    for(char c='a'; c<='z'; c++){
                        if(c == orig) continue;
                        chars[j] = c;
                        String nextword = new String(chars);
                        if(wordset.contains(nextword)){
                            q.offer(nextword);
                            wordset.remove(nextword);
                        }
                    }
                    chars[j] = orig;
                }
            }
            level++;
        }
        return 0;        
    }
}