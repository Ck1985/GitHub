package performanceOfLists;

import java.util.List;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public interface TimeListAction {
    String getName();
    long timeAction(List<String> list, int limit);
}
