public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123)); //321
        System.out.println(reverse(-123)); //-321
        System.out.println(reverse(120)); //21
        System.out.println(reverse(1534236469)); //0: The reversed number is not in range of int

    }

    // https://leetcode.com/problems/reverse-integer/
    public static int reverse(int x) {
        long rev=0; //Stores final reversed number
        while(x != 0){
            rev = rev*10 + x%10; //reverses a number by taking remainder.
            if(rev<Integer.MIN_VALUE || rev>Integer.MAX_VALUE) return 0; //Once number crossess int range return 0.
            x/=10;
        }
        return (int)rev;//Final result if reversed val is in the range of int(i.e 32 bit).
    }
}
