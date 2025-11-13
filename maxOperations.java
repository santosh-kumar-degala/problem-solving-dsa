public class maxOperations {
    public int maxOperations(String s) {
        int count = 0, max = 0;
        boolean flag = false;
        for(char c : s.toCharArray()){
            if(c == '0'){
                if(flag){
                    max += count;
                    flag = false;
                }
            }else{
                count++;
                flag = true;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        maxOperations mo = new maxOperations();
        String s1 = "00110011";
        System.out.println(mo.maxOperations(s1)); // Output: 4

        String s2 = "111000";
        System.out.println(mo.maxOperations(s2)); // Output: 3

        String s3 = "0000";
        System.out.println(mo.maxOperations(s3)); // Output: 0
    }
}