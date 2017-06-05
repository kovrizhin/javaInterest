/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 4/24/14
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class SortArray {

    public void sort(){
        RelatedArray[] relatedArrays = initArray();
        for (int i = 0; i < relatedArrays.length; i++) {
            RelatedArray firstElement = relatedArrays[i];
            for (int j = i; j < relatedArrays.length; j++) {
                RelatedArray secondElement = relatedArrays[j];
                if(secondElement.value <= firstElement.value){

                    RelatedArray tempElement = new RelatedArray(firstElement.prev,firstElement.next,firstElement.value);

                    firstElement = secondElement;


                    secondElement =tempElement;



                    relatedArrays[i] = secondElement;
                    relatedArrays[j] = tempElement;


                }
            }
        }
        System.out.println("Sorted Array");
        for (int i = 0; i < relatedArrays.length; i++) {
            System.out.println(relatedArrays[i]);
        }
    }

    public static void main(String[] args) {
        SortArray sortArray = new SortArray();
        sortArray.sort();
    }

    private RelatedArray[] initArray() {
        Integer count = 100;
        RelatedArray[] relatedArrays = new RelatedArray[count];
        for (int i = 0; i < count; i++) {
            RelatedArray relatedArray = new RelatedArray(null,null,new Double(Math.random() * 1000).intValue());
            relatedArrays[i] = relatedArray;
        }

        relatedArrays[0].setRelated(null,relatedArrays[1]);
        for (int i = 1; i < count - 1; i++) {
            relatedArrays[i].setRelated(relatedArrays[i-1], relatedArrays[i+1]);
        }
        relatedArrays[count -1].setRelated(relatedArrays[count -2],null);

        System.out.println("Unsorted Array");
        for (int i = 0; i < relatedArrays.length; i++) {
            System.out.println(relatedArrays[i]);

        }
        return relatedArrays;
    }


    private class RelatedArray{
        RelatedArray prev = null;
        RelatedArray next = null;
        Integer value = null;

        private RelatedArray(RelatedArray prev, RelatedArray next, Integer value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }

        @Override
        public String toString() {
            String var1 = String.valueOf(prev==null?"":prev.value);
            String var2 = String.valueOf(next==null?"":  next.value);
            return "Prev: " +var1 + " next: " + var2 + " value: " + value;
        }

        public void setRelated(RelatedArray relatedArray, RelatedArray relatedArray1) {
            prev = relatedArray;
            next = relatedArray1;
        }
    }
}
