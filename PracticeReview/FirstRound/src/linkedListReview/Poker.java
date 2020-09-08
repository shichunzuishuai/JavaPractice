import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poker {
    static class Card{
        private String rank;//点数
        private String suit;//花色

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getSuit() {
            return suit;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }

        public Card(String rank, String suit) {
            this.rank = rank;
            this.suit = suit;
        }

        @Override
        public String toString() {
//            return "Card{" +
//                    "rank='" + rank + '\'' +
//                    ", suit='" + suit + '\'' +
//                    '}';
            return "[" + this.rank + this.suit + "]";
        }
    }
    public static void main(String[] args) {
        //1. 创建一副牌
        List<Card> pokers = buyPoker();
      //  System.out.println(pokers);
        //2. 洗牌,可以直接使用Collections.shuffle方法
        Collections.shuffle(pokers);
        //3.发牌,假设有三个玩家
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        for(int i = 0; i < 5; i++){
            //每个人发一张,一共发5张
            for(int j = 0; j < 3; j++){
                List<Card> player = players.get(j);
                player.add(pokers.remove(0));
            }
        }
        //发完了,可以查看手牌
        for(int i = 0; i < 3; i++){
            System.out.println("玩家" + i + ":" + players.get(i));
        }
    }
    private static List<Card> buyPoker(){
        List<Card> poker = new ArrayList<>();
        String[] suits = {"♥","♠","♦","♣"};
        for(int i = 0; i < 4; i++){
            for(int j = 2; j <= 10; j++){
                poker.add(new Card("" + j, suits[i]));
            }
            poker.add(new Card("" + "A",suits[i]));
            poker.add(new Card("" + "J",suits[i]));
            poker.add(new Card("" + "Q",suits[i]));
            poker.add(new Card("" + "K",suits[i]));
        }
        return poker;
    }
}
