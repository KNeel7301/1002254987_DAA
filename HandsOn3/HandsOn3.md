function x = f(n) <br>
x = 1;<br>
for i = 1:n<br>
for j = 1:n<br>
x = x + 1;<br><br>
### 1.Find the runtime of the algorithm mathematically<br><b>
![`Ans`](H1.jpg)<br><br><br>
### 2. Time this function for various n e.g. n = 1,2,3.... You should have small values of n all the way up to large values. Plot "time" vs "n" (time on y-axis and n on x-axis). Also, fit a curve to your data, hint it's a polynomial. <br>
Ans
![`Ans`](H2.png)<br><br>
### 3.Find polynomials that are upper and lower bounds on your curve from #2. From this specify a big-O, a big-Omega, and what big-theta is.<br><br>
Ans.<br>
Upper Bound(Big-O) : O(n^2) The runtime is bounded above by a constant multiple of n^2 for large n and based on the quadric nature of the nested loop.<br><br>
Lower Bound(Big-Omega) : Ω(n^2) the runtime is bounded below by a constant multiple of n^2 for large n.<br><br>
Tight Bound(Big-Theta) : Θ(n^2) runtime is asymptotically equivalent to n^2<br><br>    
### 4.Find the approximate (eye ball it) location of "n_0" . Do this by zooming in on your plot and indicating on the plot where n_0 is and why you picked this value. Hint: I should see data that does not follow the trend of the polynomial you determined in #2.<br><br>
Ans<br>
![`Ans`](H3.png)<br>
n_0 =15 is marked because where the measured times start to follow the polynomial fit closely and indicating a constant trend.For small values of 𝑛, the timing data may not follow the quadratic trend due to noise and system overhead.<br><br>
## If I modified the function to be:<br>
x = f(n)<br>
   x = 1;<br>
   y = 1;<br>
   for i = 1:n<br>
        for j = 1:n<br>
             x = x + 1;<br>
        y = i + j;<br><br>
### 4.Will this increate how long it takes the algorithm to run (e.x. you are timing the function like in #2)? <br>
Ans<br>
Due to the additional assignment y = i + j outside the inner loop, we will see the slightly increase runtime.Although, this increased runtime is negligible with compared to the n^2 operations in the nested loops.<br><br>
### 5.Will it effect your results from #1?<br>
Ans<br>
The results from #1 will not be significantly affected due to this modification.However, The Actual messured time might be increased but the runtime complexity remains same as Θ(n^2) it will not be affected, as the additional operation is only performed n times, which is dominated by the n^2 operations in the nested loops.<br><br>
### 6.Implement merge sort, upload your code to github and show/test it on the array [5,2,4,7,1,3,2,6].<br>
Ans<br>
[MergeSort.java](MergeSort.java)<br>
![`Ans`](MergeSort.png)<br>



