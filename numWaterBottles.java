public class numWaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
       int max = numBottles;
       while(numBottles >= numExchange){
            int exchange = numBottles/numExchange;
            int remain = numBottles%numExchange; 
            max += exchange; 
            numBottles = exchange + remain;
       }
       return max;
    }

    public static void main(String[] args) {
        numWaterBottles solution = new numWaterBottles();
        int result = solution.numWaterBottles(9, 3);
        System.out.println("Maximum number of water bottles you can drink " + result); //13
    }
}