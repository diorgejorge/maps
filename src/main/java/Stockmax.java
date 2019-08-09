import java.util.*;
import java.util.stream.Collectors;

public class Stockmax {

    public static void main(String[] args) {
        List<Integer> prices = new ArrayList<>();
        prices.addAll(Arrays.asList(5, 4, 3, 4, 5));
        System.out.println(profit(prices));
    }

    public static long profit(List<Integer> prices) {
        Iterator iterator = prices.stream()
                .collect(Collectors.toCollection(ArrayDeque::new)) // or LinkedList
                .descendingIterator();
        long profit = 0l;
        long maiorLucro = 0l;
        int share = 0;
        while (iterator.hasNext()){
            Integer price = (Integer)iterator.next();
            if(!iterator.hasNext()){
                if(maiorLucro>=price)share++;
                profit += (share * maiorLucro);
            }
            if(maiorLucro<price){
                profit += (share * maiorLucro);
                maiorLucro = price;
                share=0;
            }else{
                share++;
                profit += - price;
            }
        }

        return profit;
    }





}
