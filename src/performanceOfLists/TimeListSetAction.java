package performanceOfLists;

import java.util.List;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class TimeListSetAction implements TimeListAction{
    private final String pattern = "Element %s";
    @Override
    public String getName(){
        return "set";
    }
    @Override
    public long timeAction(List<String> list, int limit) {
        for (int i = 0; i < limit; i++) {
            list.add("anonymous.vn1985");
        }
        final long start = System.nanoTime();
        for (int j = 0, size = list.size(); j < limit; j++) {
            list.set(j % size, String.format(pattern, j));
        }
        return System.nanoTime() - start;
    }
}
