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
        ArrayList<Iterator<String>> res = new ArrayList<Iterator<String>>();
        String[] list1 = {"a", "b", "c", "d"};
        String[] list2 = {"e", "f", "g"};
        String[] list3 = {"h", "i", "j", "k"};
        res.add(new StringList(list1));
        res.add(new StringList(list2));
        res.add(new StringList(list3));
        return res;
    }

    public static ArrayList<String> zip(List<Iterator<String>> iterators) {
        ArrayList<String> res = new ArrayList<String>();
        while (hasRemainingElements(iterators)) {
            for (Iterator<String> it : iterators) {
                if (it.hasNext()) {
                    res.add(it.next());
                }
            }
        }
        return res;
    }

    public static boolean hasRemainingElements(List<Iterator<String>> iterators) {
        for (Iterator it : iterators) {
            if (it.hasNext()) return true;
        }
        return false;
    }
}
