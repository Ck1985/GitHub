package performanceOfLists;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public interface ListFactory {
    List<String> create(int size);
    String getName();
    abstract class AbstractListFactory implements ListFactory{
        private final String name;
        public AbstractListFactory(final String name){
            this.name = name;
        }
        @Override
        public String getName(){
            return this.name;
        }
    }
    ListFactory ARRAY_LIST_FACTORY = new AbstractListFactory("ArrayList"){
        public List<String> create(final int size){
            return new ArrayList<String>();
        }
    };
    ListFactory ARRAY_LIST_WITH_SIZE_FACTORY = new AbstractListFactory("ArrayList With init size"){
        public List<String> create(final int size){
            return new ArrayList<String>(size);
        }
    };
    ListFactory VECTOR_FACTORY = new AbstractListFactory("Vector"){
        public List<String> create(final int size){
            return new Vector<String>();
        }
    };
    ListFactory VECTOR_WITH_SIZE_FACTORY = new AbstractListFactory("Vector with init size"){
        public List<String> create(int size){
            return new Vector<String>(size);
        }
    };
    ListFactory LINKEDLIST_FACTORY = new AbstractListFactory("LinkedList"){
        public List<String> create(int size){
            return new LinkedList<String>();
        }
    };
    ListFactory STACK_FACTORY = new AbstractListFactory("Stack"){
        public List<String> create(int size){
            return new Stack<String>();
        }
    };
}
