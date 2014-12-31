import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Gabe Fernando
 * Date: 2014-12-31
 * Time: 14:10
 */
public class StringList implements Iterator<String> {
    String[] theStrings;
    int currentPos;

    public StringList(String[] theStrings) {
        this.theStrings = theStrings;
        this.currentPos = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPos < theStrings.length;
    }

    @Override
    public String next() {
        return theStrings[currentPos++];
    }
}
