package performanceOfLists;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class TimeListAddAction implements TimeListAction{
    private final String pattern = "Element %s";
    @Override
    public String getName(){
        return "add";
    }
    @Override
    public long timeAction(final List<String> list, final int limit){
        final long start = System.nanoTime();
        for (int i = 0; i < limit; i++) {
            list.add(String.format(pattern,i));
        }
        return System.nanoTime() - start;
    }
}
