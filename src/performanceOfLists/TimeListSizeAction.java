package performanceOfLists;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class TimeListSizeAction implements TimeListAction{
    private final String pattern = "Element %s";
    @Override
    public String getName(){
        return "size";
    }
    @Override
    public long timeAction(List<String> list, int limit){
        for (int i = 0; i < limit; i++) {
            list.add(String.format(pattern, i));
        }
        final long start = System.nanoTime();
        for (int i = 0; i < limit; i++) {
            list.size();
        }
        return System.nanoTime() - start;
    }
}
