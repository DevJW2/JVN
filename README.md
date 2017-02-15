# JVN
Hw#07

https://docs.google.com/document/d/1s7OjcDA96sR8Jg14F3D2g_ePtzLhL2ksDIj_sAz0qu0/pub

Classification for MergeSort as nlog(n):

### Hypothesis:
The recursive MergeSort algorithm can be broken down into
levels, with each level representing a new series of recursive calls.

(level) [1 2 3 4]
(level) [1 2] [3 4]
(level) [1] [2] [3] [4]

The recursive calling will repeatedly call sort() on lists of half-size
until a size of one is reached. Thus the number of levels is log base 2
of n, much like the action in binary search, in which each pass acted on
half the size before it.

ex:
A list of 100 elements will require ~eight levels, with each level handling
lists of following size:
100, 50, 25, 13, 7, 4, 2, 1

Once the recursive calling has reached size 1 lists, it will be time to
return and slowly reconstitute the sorted list step-by-step. At each level, merge() must be called on pairs of pre-sorted lists. Merge() itself is linear based on the size of its two paramater lists. The number of times it is called will be halved each time a recursive call returns.

ex:
For a list of 100 elements
at 1 element list level, it will be called 50 times
at 2 element list level, it will be called 25 times
However, the number of elements merge() is handling doubles. In the end, the calls halve each level, but the n doubles. The result is that each recursive level is a linear function of n.

Because there are log(n) recursive levels each operating at linear n time, the overall efficiency is n * log(n).
