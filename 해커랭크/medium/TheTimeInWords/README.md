# [medium] The Time in Words

[문제 링크](https://www.hackerrank.com/challenges/the-time-in-words/problem?isFullScreen=true)

Given the time in numerals we may convert it into words, as shown below:

At , use o' clock. For , use past, and for  use to. Note the space between the apostrophe and clock in o' clock. Write a program which prints the time in words for the input given in the format described.

Function Description

Complete the timeInWords function in the editor below.

timeInWords has the following parameter(s):

int h: the hour of the day
int m: the minutes after the hour
Returns

string: a time string as described
Input Format

The first line contains , the hours portion The second line contains , the minutes portion

Constraints

Sample Input 0

5
47
Sample Output 0

thirteen minutes to six
Sample Input 1

3
00
Sample Output 1

three o' clock
Sample Input 2

7
15
Sample Output 2

quarter past seven