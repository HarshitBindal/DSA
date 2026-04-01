class Robot{
    int pos;
    int health;
    int ind;
    char ch;
    Robot(int pos, int health, int ind, char ch){
        this.pos = pos;
        this.health = health;
        this.ind = ind;
        this.ch = ch;
    }
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = healths.length;
        Robot[] robots = new Robot[n];
        for(int i=0; i<n; i++){
            robots[i] = new Robot(positions[i], healths[i], i, directions.charAt(i));
        }
        Arrays.sort(robots, (a,b)-> a.pos - b.pos);
        Stack<Robot> st = new Stack<>();
        for(Robot curr: robots){
            if(curr.ch == 'R'){
                st.push(curr);
            }
            else {
                while(!st.isEmpty() && st.peek().ch=='R'){
                    Robot top = st.peek();
                    if(top.health == curr.health){
                        st.pop();
                        curr.health = 0;
                        break;
                    }
                    else if(top.health > curr.health){
                        top.health--;
                        curr.health = 0;
                        break;
                    }
                    else {
                        st.pop();
                        curr.health--;
                    }
                }
                if(curr.health>0) st.push(curr);
            }
        }
        List<Robot> list = new ArrayList<>(st);
        Collections.sort(list, (a,b)-> a.ind-b.ind);
        List<Integer> res = new ArrayList<>();
        for(Robot it: list){
            res.add(it.health);
        }
        return res;
    }
}