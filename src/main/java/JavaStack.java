import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class JavaStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            AtomicInteger balance = new AtomicInteger(0);
            String input=sc.next();
            List<Character> chars = input.chars().mapToObj(e->(char)e).collect(Collectors.toList());
            Map<Character,Long> map = chars.stream()
                    .collect(Collectors.groupingBy(
                            p -> p,
                            Collectors.counting()));
            if(input.startsWith("}")||input.startsWith(")")||input.startsWith("]")) {
                System.out.println(false);
                continue;
            }
            balance.addAndGet((map.containsKey('{')?map.get('{').intValue():0)-(map.containsKey('}')?map.get('}').intValue():0));
            balance.addAndGet((map.containsKey('(')?map.get('(').intValue():0)-(map.containsKey(')')?map.get(')').intValue():0));
            balance.addAndGet((map.containsKey('[')?map.get('[').intValue():0)-(map.containsKey(']')?map.get(']').intValue():0));
            System.out.println(balance.get()==0);
        }

    }
}
