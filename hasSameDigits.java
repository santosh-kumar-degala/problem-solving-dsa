public class hasSameDigits{
    public static boolean hasSameDigits(String s) {
        while(s.length() > 2){
            int i=0, j=i+1;
            StringBuilder sb = new StringBuilder();
            while(j < s.length()){
                int digit = Character.getNumericValue(s.charAt(i));
                int nextDigit = Character.getNumericValue(s.charAt(j));
                int sum = (digit + nextDigit) % 10;
                sb.append(sum);
                i++;
                j++;
            }
            s = sb.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }

    public static void main(String[] args) {
        System.out.println(hasSameDigits("3902")); // true
        System.out.println(hasSameDigits("34789")); // false 
        System.out.println(hasSameDigits("123321")); // true 
    }
}