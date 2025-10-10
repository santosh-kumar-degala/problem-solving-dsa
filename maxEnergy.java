public class maxEnergy {
    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[energy.length];
        for(int i=energy.length-1; i>=0; i--){
            dp[i] = energy[i];
            if(i + k < energy.length)
                dp[i] += dp[i+k];
            max = Math.max(max, dp[i]);  
        }
        return max;
    }

    public static void main(String[] args) {
        int[] energy = {-5,2,-10,-5,1};
        int k = 3;
        maxEnergy me = new maxEnergy();
        System.out.println(me.maximumEnergy(energy, k)); //3
    }
    
}
