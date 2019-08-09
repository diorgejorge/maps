import java.util.*;

import static java.util.stream.Collectors.joining;


class FlaskLoss {

    /*
     * Complete the 'chooseFlask' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY requirements
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY markings
     */

    public class ChooseFlask {
        int index;
        int loss = -1;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getLoss() {
            return loss;
        }

        public void setLoss(int loss) {
            this.loss = loss;
        }
    }


    public Integer chooseFlask(List<Integer> requirements, int m, List<List<Integer>> markings) {
        // Write your code here
        requirements = requirements.subList(0,m);
        int index =0;
        int index2 = 0;
        ChooseFlask chooseFlask = new ChooseFlask();
        for(List<Integer> markingSublist : markings){
                int loss =0;
                if(Collections.max(requirements)>Collections.max(markingSublist)){
                    continue;
                }

                for(Integer marking : markingSublist.subList(0,m)){
                    loss += marking - requirements.get(index);
                    index++;
                }
                if(loss<chooseFlask.getLoss()||chooseFlask.getLoss()==-1){
                    chooseFlask.setIndex(index2);
                    chooseFlask.setLoss(loss);
                }
                index=0;
                index2++;
            }
        return chooseFlask.getIndex();
    }

    public static void main (String[ ]args){
        FlaskLoss result = new FlaskLoss();
        Integer integerArray[] = {
                4,
                6,
                2,
                5,
                2};
        List<List<Integer>> multi = new ArrayList<>();
        List<Integer> flask0 = new ArrayList<>();
        flask0.add(5);
        flask0.add(7);
        flask0.add(10);
        List<Integer> flask1 = new ArrayList<>();
        flask1.add(4);
        flask1.add(10);
        multi.add(flask0);
        multi.add(flask1);
        System.out.println(result.chooseFlask(Arrays.asList(integerArray),2,multi));
    }

}


