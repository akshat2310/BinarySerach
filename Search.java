import java.util.Arrays;

public class Search {
    public static <T extends Comparable<T>> int index( T[] items, T item )
    {
        return index( items, item, 0, items.length-1 );
    }

    public static <T extends Comparable<T>> int index( T[] items, T key, int low, int high )
    {
        if ( key == null )
            return -1;

        if( low > high  )
            return -1;

        int mid = low+(high-low)/2;

        if( key.compareTo( items[mid] ) > 0 )
            return index(items, key, mid+1, high);
        else if( key.compareTo( items[mid] ) < 0 )
            return index( items, key, low, mid-1 );
        else
            return mid;
    }

    public static void main(String[] args) {

        Integer[] items = {22, 55, 66, 11, 32, 56, 67, 89, 95, 10};

        Arrays.sort(items);
        System.out.print("Sorted Integer Array = ");
        for (Integer item : items) {
            System.out.print(item + " ");
        }

        int foundIndex = index(items, Integer.valueOf(22));
        System.out.println("\nInteger Array Contains item 22 at index = " + foundIndex);

        foundIndex = index(items, Integer.valueOf(11));
        System.out.println("Integer Array Contains item 11 at index = " + foundIndex);

        foundIndex = index(items, Integer.valueOf(67));
        System.out.println("Integer Array Contains item 67 at index = " + foundIndex);

        foundIndex = index(items, Integer.valueOf(10));
        System.out.println("Integer Array Contains item 10 at index = " + foundIndex);

        foundIndex = index(items, Integer.valueOf(101));
        System.out.println("Integer Array Contains item 101 at index = " + foundIndex);

        foundIndex = index(items, null);
        System.out.println("Integer Array Contains item null at index = " + foundIndex);
    }

}
