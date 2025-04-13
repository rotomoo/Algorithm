# [medium] Encryption

[문제 링크](https://www.hackerrank.com/challenges/encryption/problem?isFullScreen=true)

An English text needs to be encrypted using the following encryption scheme.
First, the spaces are removed from the text. Let  be the length of this text.
Then, characters are written into a grid, whose rows and columns have the following constraints:

Example


After removing spaces, the string is  characters long.  is between  and , so it is written in the form of a grid with 7 rows and 8 columns.

ifmanwas  
meanttos          
tayonthe  
groundgo  
dwouldha  
vegivenu  
sroots
Ensure that
If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. .
The encoded message is obtained by displaying the characters of each column, with a space between column texts. The encoded message for the grid above is:

imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau

Create a function to encode a message.

Function Description

Complete the encryption function in the editor below.

encryption has the following parameter(s):

string s: a string to encrypt
Returns

string: the encrypted string
Input Format

One line of text, the string

Constraints


contains characters in the range ascii[a-z] and space, ascii(32).

Sample Input

haveaniceday
Sample Output 0

hae and via ecy
Explanation 0

,  is between  and .
Rewritten with  rows and  columns:

have
anic
eday
Sample Input 1

feedthedog    
Sample Output 1

fto ehg ee dd
Explanation 1

,  is between  and .
Rewritten with  rows and  columns:

feed
thed
og
Sample Input 2

chillout
Sample Output 2

clu hlt io
Explanation 2

,  is between  and .
Rewritten with  columns and  rows ( so we have to use .)

chi
llo
ut