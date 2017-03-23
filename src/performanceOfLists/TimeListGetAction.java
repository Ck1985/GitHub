package performanceOfLists;

import java.util.List;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class TimeListGetAction implements TimeListAction{
    private final String pattern = "Element %s";
    @Override
    public String getName(){
        return "get";
    }
    @Override
    public long timeAction(final List<String> list, final int limit){
        for (int i = 0; i < limit; i++){
            list.add(String.format(pattern,i));
        }
        final long start = System.nanoTime();
        for (int j = 0, size = list.size(); j < size; j++) {
            list.get(j % size);
        }
        return System.nanoTime() - start;
    }
}
