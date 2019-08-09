import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class QuickSort3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String line = sc.nextLine();
            ArrayList<Integer> array = new ArrayList<>();
            ArrayList<Integer> arrayJava8 = new ArrayList<>();
            int pivotIndex = array.size()-1;
            if(line.length()>1){
                array =
                        Pattern.compile(" ")
                                .splitAsStream(line).map(s -> Integer.parseInt(s))
                                .collect(Collectors.toCollection(ArrayList::new));
                arrayJava8 = array;
                quickSort(array,0,pivotIndex);
            }
            System.out.println(array);
            /*
                Como eu realmente faria com java 8
             */
            System.out.println(arrayJava8.stream().sorted().collect(Collectors.toList()));
             /*
                e com java 8 lista reversa
             */
            System.out.println(arrayJava8.stream().sorted((x,y)->Integer.compare(y,x)).collect(Collectors.toList()));
        }
    }

    public static void quickSort(List<Integer> array, int start, int end){
        if(start>=end) return;
        int pivot =start;
        for(int x = start+1;x<=end;x++){
            if(array.get(x)<=array.get(pivot)){
                swap(array,pivot,x);
                swap(array,x,pivot+1);
                pivot++;
            }
            quickSort(array,start,pivot-1);
            quickSort(array,pivot+1,end);
        }

    }

    public static void swap(List<Integer> array,Integer start,Integer end){
        int next = array.get(start);
        array.set(start, array.get(end));
        array.set(end, next);
    }
}
