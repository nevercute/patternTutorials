package pro.nevercute.tut.patterns.adapters.iteratorenum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class IteratorEnumTest {
    public static void main(String[] args) {
        EnumerationAdapter<String> eAdapter = new EnumerationAdapter<String>(new Vector<String>(Arrays.asList("one", "two", "three")).elements());

        eAdapter.forEachRemaining(e -> System.out.println(e.toString()));

        /*while(eAdapter.hasNext()){
            System.out.println(eAdapter.next());
        }   */

        IteratorAdapter<String> iAdapter = new IteratorAdapter<String>(new ArrayList<String>(Arrays.asList("one","two","three")).iterator());

        while(iAdapter.hasMoreElements()){
            System.out.println(iAdapter.nextElement());
        }
    }
}
