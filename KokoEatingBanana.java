/*
KokoEatingBanana-
Given array of banana's per pile and int h maximum time kooku can eat banana's. calculate the min banana's kooku should eat per hour to complete all banana's(In 1 hour kooku can eat max 1 pile).
*/

import java.util.Arrays;

class KokoEatingBanana{
    public static void main(String[] args) {
        int[] piles = {1,1,1,999999999};
        int h = 10;
        System.out.println(findMinimumBananasToEat(piles,h));
    }

    //Let's assume KOKO will start eating (total-bananas)/(max-time).
    public static long findMinimumBananasToEat(int[] piles,int h){
        Arrays.sort(piles);
        // long totalBananas=0;
        // for(int i: piles){
        //     totalBananas+=i; //to Take average of banana's
        // }
        // long minBananas=totalBananas/h; 
        // if(minBananas==0) //If minBananas==0 then start from 1
        long minBananas=1;
        while(true){
            double timeTaken=0;
            for(int i=0;i<piles.length;i++){
                timeTaken += piles[i]/minBananas; //Total time taken to complete all piles
                if(piles[i]%minBananas > 0)
                    timeTaken++;
                if(timeTaken>h){ //If time exceeding break for current minBananas and increase by 1.
                    minBananas++;
                    break;
                }
            }
            if(timeTaken<=h)
                return (int)minBananas; //return time when timetaken<=h
        }
    }
}