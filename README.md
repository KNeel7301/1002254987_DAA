1002254987_DAA
<details>

<summary>HandsOn-2 Assignment</summary>
# Proof of Correctness of selection sort

* Initialization 
At the start of the process; imagine a scenario where one part has all items sorted while the other part holds all items unsorted. 
After each round of the loop, in Selection Sort a specific condition remains true.

* Loop Invariant 
It is for selection sort after each outer iteration
The subarray from the beginning to the position i is sorted. 
The subarray starting from i + 1 to n is not sorted. 

* Maintenance of Invariant
In the process the algorithm locates the element within the section that has not yet been sorted starting index from i to n -1.
It places the element in its proper position (at index i) accomplishing this through swapping. 
Adding one element to the section of the array expands it as the unsorted part shrinks simultaneously. 

* Termination
The whole set has been fully dealt with. 
The section that has been arranged contains all the items. 
The section that needs sorting is currently vacant. 

* Correctness Argument
The inner loop guarantees the discovery of the smallest element, within the portion that is not yet sorted. 
The swapping operation accurately moves the element to the end of the sorted section. 
With each cycle of the loop in action The boundary of the sorted section shifts to the right, by one step Thus expanding its size by one increment. 
When the algorithm keeps running until all elements are arranged in order and the loop invariant remains valid during the process of execution of Selection Sort method; it is established that the array will be correctly sorted at the end. 

# Complexity Analysis
* Time Complexity: Selection Sort has a time complexity of O(n^2), where n is the number of elements. This is due to the nested loops where the inner loop performs approximately n/2 comparisons per iteration, leading to O(n^2) total comparisons.

* Space Complexity: The space complexity is O(1) as it sorts the array in place without requiring extra space beyond a few variables.
</details>


# HandsOn-3

<details>

<summary>HandsOn-3 Assignment</summary>

[`HandsOn-3.md`](HandsOn3/HandsOn3.md)
</details>