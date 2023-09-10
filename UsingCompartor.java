import java.util.*;
/*
Comparators are used to compare two objects. In this challenge, you'll create a comparator and use it to sort an array.

The Player class is provided for you in your editor. It has  fields: a name String and a score integer.

Given an array of  Player objects, write a comparator that sorts them in order of decreasing score; if  or more players have the same score, sort those players alphabetically by name. To do this, you must create a Checker class that implements the Comparator interface, then write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) method.

Sample Input-
5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150

Output-
aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
*/


class UsingComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}


class Checker implements Comparator{   
    public int compare(Object o1,Object o2){
        Player a=(Player)o1;
        Player b=(Player)o2;
        if(a.score==b.score){
            return compareName(a,b);
        }else if(a.score>b.score)
        return -1;
        else return 1;
    }
    public int compareName(Player a,Player b){
        return a.name.compareTo(b.name);
    }
}
class Player{
    String name;
    int score;
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}