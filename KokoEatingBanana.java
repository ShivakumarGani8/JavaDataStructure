import java.util.Arrays;

class KokoEatingBanana{
    public static void main(String[] args) {
        int[] piles = {1,1,1,999999999};
        int h = 10;
        System.out.println(findMinimumBananasToEat(piles,h));
    }

    //Let's assume KOKO will start eating (total-bananas)/total piles.
    public static long findMinimumBananasToEat(int[] piles,int h){
        Arrays.sort(piles);
        long totalBananas=0;
        for(int i: piles){ 
            totalBananas+=i;
        }
        long minBananas=totalBananas/h +1; //Koko eating minimum bananas per hour
        if(minBananas==0)//If minBananas=0 start eating from 1
            minBananas=1;
        while(true){
            double timeTaken=0;//Total time taken to eat 
            for(int i=0;i<piles.length;i++){
                timeTaken += Math.floor(piles[i]/minBananas);
                if(piles[i]%minBananas > 0)
                    timeTaken++;
                if(timeTaken>h){
                    minBananas++;
                    continue;
                }
            }
            if(timeTaken<=h)
                return minBananas;
            else
            minBananas++;
        }
    }
}