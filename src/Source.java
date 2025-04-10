import java.util.Scanner;

public class Source {

    // QuickSelect function performs the main logic for finding the k-th smallest element in array.
    private static int Select ( int [] array, int L, int R, int k ) {
        if ( k > 0 && k <= array.length ) {
            if (L < R) {
                int p = pickThePivot(array, L, R);
                int index = partition(array, L, R, p);
                if (index == k - 1) {
                    return array[index];
                } else if (index < k - 1) {
                    return Select(array, index + 1, R, k);
                } else {
                    return Select(array, L, index - 1, k);
                }
            } else {
                return array[L];
            }
        }
        else {
            return Integer.MAX_VALUE;
        }
    }

    // pickThePivot function selects the pivot using the "Median of Medians" strategy.
    private static int pickThePivot(int[] array, int L, int R) {
        if (( R - L ) < 5 )
            return getMedianVal ( array, L, R );
        int counter = L;

        for ( int i = L; i <= R; i =i + 5 ) {
            int tmpR = i + 4;
            if ( R < tmpR )
                tmpR = R;
            int m = getMedianVal( array, i, tmpR );
            swap( array, counter, m );
            counter++;
        }
        return pickThePivot( array, L, counter );
    }

    // partition function reorders the array based on the pivot,
    // elements smaller than pivot come before and elements greater than pivot come after it.
    private static int partition ( int [] array, int L, int R, int pIdx ) {
        swap ( array, pIdx, R );
        int p = array [ R ];
        int left = L;
        int right = R - 1;

        while (left <= right) {
            while (left <= right && array[left] < p) {
                left++;
            }
            while (left <= right && array[right] > p) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        swap(array, left, R);
        return left;
    }

    // getMedianVal function calculates the index of median value in the given sub-array.
    private static int getMedianVal( int[] array, int L, int R ){
        int medianIdx = 0;

        for ( int i = L; i <= R; i++ ) {
            int j = i;
            while ( j > L && array [ j - 1 ] > array [ j ] ) {
                swap( array, j, j - 1 );
                j = j - 1;
            }
        }
        medianIdx = (( R - L ) / 2 );

        return L + medianIdx;
    }

    // swap function swaps the elements of array on given positions.
    private static void swap( int [] array, int x, int y ){
        int tmp = array [ x ];
        array [ x ] = array [ y ];
        array [ y ] = tmp;
    }

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int numOfSets = scanner.nextInt();

        while ( numOfSets --> 0 ) {
            int arrayLength = scanner.nextInt();
            int[] array = new int[arrayLength];

            for ( int i = 0; i < arrayLength; i++ ) {
                array [ i ] = scanner.nextInt();
            }

            int queNumber = scanner.nextInt();

            while ( queNumber --> 0 ) {
                int k = scanner.nextInt();
                int ki = Select( array, 0, array.length - 1, k );
                if ( ki == Integer.MAX_VALUE ) {
                    System.out.println( k + " out of range");
                }
                else
                    System.out.println( k + " " + ki );
            }
        }
    }
}

// input

// 5
// 10
// 25 12 36 9 77 52 41 19 33 47
// 4
// -6 7 -2 9
// 15
// 31 123 12 523 64 38 7 92 20 41 10 73 89 201 235
// 5
// 1 8 6 10 15
// 8
// 52 7 67 -15 26 19 120 88
// 2
// 6 2
// 12
// 33 43 0 62 83 29 56 72 28 65 92 100
// 3
// 4 8 12
// 20
// 14 33 27 51 89 19 47 35 100 77 62 94 81 18 42 32 85 36 190 133
// 5
// 1 7 0 12 17

