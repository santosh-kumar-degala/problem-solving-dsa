import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class nonCoPrimes {
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
    public static List<Integer> processArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i : arr){
            stack.push(i);
        }
        while(stack.size() > 1){
            int top = stack.pop();
            int next = stack.pop();
            if(gcd(top, next) > 1){
                stack.push(lcm(top, next));
            }else{
                stack.push(next);
                stack.push(top);
                break;
            }
        }
        return new ArrayList<>(stack);
    }


    public static void main(String[] args) {
        int[] arr = {6,4,3,2,7,6,2};
        List<Integer> result  = processArray(arr);
        System.out.println(result);
    }
}
