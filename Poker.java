package poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Poker {
    //通过这个类来创建一副牌,洗牌,发牌
    //不加static的内部类,创建card对象的时候必须依赖poker的实例才能创建
    //加了static的内部类,创建card对象的时候就不需要依赖poker的实例,就可以在poker
    //的静态方法中创建实例了
    static class Card{
        public String suit;
        public String rank;
        public Card(String suit,String rank){
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
            //return "("+ suit + rank +")";
            //String.format静态方法可以向c语言的printf一样格式化输出
            return String.format("(%s%s)",suit,rank);
        }
    }

    //构建一副牌
    public static List<Card> byPoker(){
        String[] suits = {"♥","♠","♣","♦"};
        List<Card> poker = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            for(int k = 2; k <= 10;k++){
                Card card = new Card(suits[i],String.valueOf(k));
                poker.add(card);
            }
            poker.add(new Card(suits[i],"J"));
            poker.add(new Card(suits[i],"Q"));
            poker.add(new Card(suits[i],"K"));
            poker.add(new Card(suits[i],"A"));
        }
        return poker;
    }

    //洗牌
    public static void shuffle(List<Card> poker){
        //从后往前取一张排,然后和前面的随机一张牌进行交换
        Random random = new Random();
        for (int i = poker.size() - 1; i > 0; i--) {
            int r = random.nextInt(i);
            swap(poker,i,r);
        }
    }
    //交换两张牌
    public static void swap(List<Card> poker, int i ,int j){
        Card tmp = poker.get(i);
        poker.set(i,poker.get(j));
        poker.set(j,tmp);
    }


    public static void main(String[] args) {
        List<Card> poker = byPoker();
        //System.out.println(poker);
        shuffle(poker);
       //System.out.println(poker);
        //发牌,一共三个人,每个人发五张
        //每个玩家的手牌是一个List,多个玩家在构成一个List
        //plays中的元素个数就是玩家的个数,有几个元素就有几哥玩家,每个玩家又是一个list
        List<List<Card>> players = new ArrayList<List<Card>>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        for(int cardIndex = 0; cardIndex < 5; cardIndex++){
            for(int playerIndex = 0; playerIndex < 3; playerIndex++){
                //先获取到这个玩家
                List<Card> player = players.get(playerIndex);
                //把第一张牌给第一个玩家,2->2,3->3,4->1...依次每人五张牌
                Card topCard = poker.remove(0);
                player.add(topCard);
            }
        }
        //展示手牌,比较大小
        System.out.println("玩家一的手牌" + players.get(0));
        System.out.println("玩家二的手牌" + players.get(1));
        System.out.println("玩家三的手牌" + players.get(2));

    }
}
