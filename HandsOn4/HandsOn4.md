<b>Problem 1</b><br><br>
A. The time complexity of merge array:<br>
* N is a size of each array.
* K is the number of sorted arrays.
1. O(logK) time has been taken after each insertion and deletion of element <br>
2. Total number of elements are N*K.
3. So, total time complexity of merge array is O((N*K) * logK).<br>

B. I personally believed that one improvement could be when we merging the two arrays simultaneously, same as merge step in merge sort. At each step, this would decreased the decrease the height of heap.Although it coudn't resulted as potential reduce in time complexity and it is same as O((N*K) * logK).<br><br>
<b> Problem 2 </b><br><br>
A. The time complexity after removing duplicates from array:<br>
* The overall time complexity of this soltion is O(N), 
* Where N = the number of elements in the array
* The loop iterates through the entire array N-1 times<br>
<br>

B. We can modify the original array instead of creating new array it will help to reduce the space complexity and time complexity.
<br>
 If the array is already sorted, you could use binary search to find the next unique element, Binary search could be faster for arrays with many duplicates.

