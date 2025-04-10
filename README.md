# Java QuickSelect Algorithm Implementation with Median of Medians Pivot Selection

This application implements the **QuickSelect algorithm** in Java, utilizing a **"Median of Medians" strategy for pivot selection**. 

The program provides an interface for users to input the number of array sets they wish to examine along with the length and the elements of each array set. Subsequently, users can also specify the number of queries they would like to execute, where each query aims to find the **k-th smallest element** in the array.

The **QuickSelect algorithm** used in this application finds the k-th smallest element **without requiring a full array sort**. The pivot is chosen using **the "Median of Medians" algorithm**, enhancing performance and guaranteeing **linear worst-case time complexity**. 

If k happens to be outside the bounds of the array, the program will print "out of range". Otherwise, it will output the k-th smallest element in the array.
