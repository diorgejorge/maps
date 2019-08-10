import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Dijkstrashortreach {
    public  static Map<Integer,Integer> menorCustoPara = new HashMap<>();
    public static List<Node> nodes = new ArrayList<>();
    public static List<Integer> nodesVisitados = new ArrayList<>();
    public static Integer startingNode = null;
    public static class Node {
        int value;
        Map<Integer,Integer> destino = new HashMap<>();
        public Node(int value, int destino,int valor) {
            this.value = value;
            this.destino.put(destino,valor);
        }
        public void addDestino(int destino,int valor){
            this.destino.put(destino,valor);
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String line  = sc.nextLine();
            if(line.length()==1){
                startingNode = Integer.parseInt(line);
                if(startingNode!=null) {
                    int finalStartingNode2 = startingNode;
                    calculaCusto(nodes.stream().filter(node1 -> node1.value == finalStartingNode2).findAny().get());

                }
            }else {
                List<Integer> input = Pattern.compile(" ")
                        .splitAsStream(line).map(s -> Integer.parseInt(s))
                        .collect(Collectors.toCollection(ArrayList::new));
                Node node = nodes.stream().filter(node1 -> node1.value == input.get(0)).findFirst().orElse(new Node(input.get(0), input.get(1), input.get(2)));
                node.addDestino(input.get(1), input.get(2));
                nodes.add(node);
            }
        }



    }

    public static void calculaCusto(Node node){
        nodesVisitados.add(node.value);
        for (Integer key:    node.destino.keySet() ) {
            if(!menorCustoPara.keySet().contains(key)||menorCustoPara.get(key)<node.destino.get(key)) {
                menorCustoPara.put(key, node.destino.get(key));
                System.out.println("menor custo para "+key+" = "+menorCustoPara.get(key)+" Vindo de "+node.value);
            }
            Node destino = nodes.stream().filter(node1 -> node1.value == key).findFirst().orElse(null);
            if(destino!=null&&!nodesVisitados.contains(key)) {
                calculaCusto(destino);
            }
        }
    }
}
