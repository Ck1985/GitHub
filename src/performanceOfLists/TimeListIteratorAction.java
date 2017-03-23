package performanceOfLists;

import java.util.List;
import java.util.Iterator;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class TimeListIteratorAction implements TimeListAction{
    private final String pattern = "Element %s";
    @Override
    public String getName(){
        return "iterator";
    }
    @Override
    public long timeAction(List<String> list, int limit){
        for (int i = 0; i < limit; i++) {
            list.add(String.format(pattern, i));
        }
        final long start = System.nanoTime();
        Iterator<String> iterator;
        for (iterator = list.iterator(); iterator.hasNext(); ){
            iterator.next();
        }
        return System.nanoTime() - start;
    }
}
