class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();
        
        int maxCandy = -1;
        for (int candy : candies) {
            maxCandy = Math.max(candy, maxCandy);
        }
        
        for (int candy : candies) {
            if (candy + extraCandies >= maxCandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
    }
}
