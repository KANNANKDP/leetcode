/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution1 extends SolBase {
    int count = 1;
    int next = 7;
    
    public int rand10() {
        if (count >=8 && count <= 10) {
            count++;
            next++;
            return next;
        } else if (count > 10) {
            count = 2;
            next = 7;
            return rand7();
        }
        count++;
        return rand7();
    }
}

class Solution2 extends SolBase {
    public int rand10() {
          int rand40 = 40;
          while(rand40 >= 40){
             rand40 = (rand7() - 1) * 7 + (rand7() - 1);
          }
          return rand40 % 10 + 1;

    }
}

