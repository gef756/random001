import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Iterator<String>> the_list = populateDummyList();
        System.out.println("Zipped List:");
        for (String s : zip(the_list)) {
            System.out.println(s);
        }
    }

    private static ArrayList<Iterator<String>> populateDummyList() {
        // Populate List of Iterators with Dummy Data
        // Expected result: a, e, h, b, f, i, c, g, j, d, k
        ArrayList<Iterator<String>> res = new ArrayList<Iterator<String>>();
        res.add(new StringList(new String[] {"a", "b", "c", "d"}));
        res.add(new StringList(new String[] {"e", "f", "g"}));
        res.add(new StringList(new String[] {"h", "i", "j", "k"}));
        return res;
    }

    public static ArrayList<String> zip(List<Iterator<String>> iterators) {
        /* Sequentially pull the i-th element from each iterator and
        concatenate that to a final ArrayList.
        If an iterator is shorter than the others, ignore it. */
        ArrayList<String> res = new ArrayList<String>();
        // Make sure we exhaust all iterators
        while (hasRemainingElements(iterators)) {
            // Check each iterator
            for (Iterator<String> it : iterators) {
                // Only append next element to result if iterator has a
                // next element.
                if (it.hasNext()) {
                    res.add(it.next());
                }
            }
        }
        return res;
    }

    public static boolean hasRemainingElements(List<Iterator<String>> iterators) {
        // returns true if any iterator has any remaining elements
        // otherwise, false
        for (Iterator it : iterators) {
            if (it.hasNext()) return true;
        }
        return false;
    }
}
