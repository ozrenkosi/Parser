Parser
============

Solution for the fourth lab at "Introduction to Theoretical Computer Science" course - Recursive descent parser.

    S -> aAB | bBA
    A -> bC | a
    B -> ccSbc | ϵ
    C -> AA

Example 1
------

Input

    aa

Output

    SAB
    YES

Example 2
------

Input

    bccaabcbaa

Output

    SBSABACAA
    YES

Example 3
------

Input

    bbaab

Output

    SBACAA
    NO

Output format is simply all the processed symbols and `YES/NO` which indicates if the input sequence is in the language
or not.
If input sequence is not a part of the language, program immediately returns (as soon as it recognize)
with `NO` as the last line.
