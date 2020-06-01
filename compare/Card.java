package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

class Card {
    public String rank;
    public String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int convertRank() {
        //把String类型的rank转换成Int类型
        if ("A".equals(rank)) {
            return 14;
        }
        if ("K".equals(rank)) {
            return 13;
        }
        if ("Q".equals(rank)) {
            return 12;
        }
        if ("J".equals(rank)) {
            return 11;
        }
        return Integer.parseInt(rank);
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}
    class CardComparator implements Comparator<Card> {
        @Override
        public int compare(Card o1, Card o2) {
            int rank1 = o1.convertRank();
            int rank2 = o2.convertRank();
            return rank1 - rank2;
        }
    }
    class TestCompare{
        public static void main(String[] args) {
            List<Card> cards = new ArrayList<>();
            cards.add(new Card("A","♥"));
            cards.add(new Card("5","♥"));
            cards.add(new Card("J","♥"));
            cards.add(new Card("8","♥"));
           Collections.sort(cards,new CardComparator());
//            Collections.sort(cards, new Comparator<Card>() {
//                @Override
//                public int compare(Card o1, Card o2) {
//                    int rank1 = o1.convertRank();
//                    int rank2 = o2.convertRank();
//                    return rank1 - rank2;
//                }
//            });
            System.out.println(cards);
        }
    }

