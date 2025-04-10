# **Java QuickSelect Algorithm with Median of Medians Pivot Selection**

This application implements the **QuickSelect** algorithm in Java but improves on the pivot selection process by incorporating a **"Median of Medians"** strategy.

## **Overview**

The program enables users to input multiple sets of arrays with each set containing a distinct number of elements. Users also have the option to run a series of queries with the end goal of finding the **k-th** smallest element in the array.

Despite the fact the QuickSelect mechanism is solely used for determining the **k-th** smallest integer, it does it without a full array sorting requirement. In an effort to optimize performance and confirm **linear worst-case time complexity**, the pivot is selected using the **"Median of Medians"** algorithm.

Should `k` be outside the perimeters of the array, the program will default to print **"out of range"**. However, if it's within bounds, it will successfully output the **k-th** smallest element in the array.

## **Median of Medians Pivot Selection**

The **"Median of Medians"** algorithm is an efficient pivot choice strategy used within the QuickSelect algorithm. It divides the array into small groups, each containing five elements. The median of each group is calculated with a call to the `getMedianVal` function, which sorts the values using a modified insertion sort mechanism and works out the middle index. Such middle index represents the median of this sorted subarray.

Once the medians are obtained, these values are then passed as new input to the `pickThePivot` function. This recurrent process continues until the list of medians is less than five. Upon that, `getMedianVal` function is used to draw the **"median of medians,"** and this value will serve as the pivot for the partitioning phase of the QuickSelect algorithm. 

Choosing the pivot in this manner guarantees a balance among elements disposed on either side of the pivot thus enabling the QuickSelect algorithm to perform in linear time, even under worst-case scenarios.

## **Conclusion**

This method of pivot selection provides a robust implementation for the QuickSelect algorithm and significantly maximizes performance for extensive inputs and worst-case predicaments.
