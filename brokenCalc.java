//time complexity O(1)
//space complexity O(1)

class Solution {
    int count;
    public int brokenCalc(int X, int Y) {
        while(Y > X){
            if(Y % 2 == 0){
                Y = Y/2;
            } else{
                Y++;
            }
            count++;
        }
        return count + (X-Y);
    }
}
