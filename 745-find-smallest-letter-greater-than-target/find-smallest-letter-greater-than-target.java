class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char mini = '{';
        for(char ch: letters){
            if(target<ch && ch<mini) {
                mini = ch;
            }
        }
        return mini=='{'? letters[0]: mini;
    }
}