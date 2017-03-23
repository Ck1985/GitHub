package performanceOfLists;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class TestListPerformance {
    private static String allTestField = null;
    private static String typeListField = null;
    private static String typeTestField = null;
    private static String blankField = null;
    private static String numberField = null;
    private static int totalWidth = 0;
    private static int sizeTypeListField = 15;
    private static int sizeTypeTestField = 12;
    private static int sizeAllTestField = 0;
    private static int sizeBlankField = 15;
    private static int sizeNumberField = 12;

    public static void run(){
        final ListFactory[] listFactories = {
                ListFactory.ARRAY_LIST_FACTORY,
                ListFactory.ARRAY_LIST_WITH_SIZE_FACTORY,
                ListFactory.LINKEDLIST_FACTORY,
                ListFactory.STACK_FACTORY,
                ListFactory.VECTOR_FACTORY,
                ListFactory.VECTOR_WITH_SIZE_FACTORY,
        };
        final TimeListAction[] listActions = {
                new TimeListAddAction(),
                new TimeListGetAction(),
                new TimeListSetAction(),
                new TimeListIteratorAction(),
                new TimeListSizeAction()
        };
        sizeAllTestField = sizeTypeTestField * (listActions.length - 2);
        allTestField = "%" + sizeAllTestField + "s";
        blankField = "%" + sizeBlankField + "s";
        typeListField = "%" + sizeTypeListField + "s";
        typeTestField = "%" + sizeTypeTestField + "s";
        numberField = "%" + sizeNumberField + ".2f";
        System.out.format(blankField, " ");
        System.out.format(allTestField, "Type of Tests");
        System.out.format("%n");
        System.out.format(typeListField, "Type of List");
        for (int i = 0; i < listActions.length; i++) {
            System.out.format(typeTestField, listActions[i].getName());
        }
        System.out.println();
        for (final ListFactory listFactory : listFactories) {
            TestListPerformance.run(10000,100,listFactory,listActions);
        }

    }
    public static void run(final int limit, final int runs, final ListFactory listFactory, final TimeListAction[] listActions){
        System.out.format(typeListField, listFactory.create(limit).getClass().getSimpleName());
        for (final TimeListAction action : listActions) {
            long timeInNs = 0;
            System.gc();
            for (int i = 0; i < runs; i++) {
                long time = action.timeAction(listFactory.create(limit),limit);
                timeInNs = timeInNs + time;
            }
            long avgTimeInNs = timeInNs / runs;
            double avgTimeInMs = timeInNs / 1000000D;
        System.out.format(numberField, avgTimeInMs);
        }
        System.out.format("%n");
        System.gc();
    }
    public static void main(String[] args){
        run();
    }
}
