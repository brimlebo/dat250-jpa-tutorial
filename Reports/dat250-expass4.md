# DAT250 Experiment Assignment 4 - report

[Code for the experiment](../src/main/java/no/hvl/dat250/jpa/tutorial/creditcards) <br>

The assignment went fairly well, and I only had a few issues to iron out.

Also changed the code from java to kotlin (other than the test) as it made for less work and a cleaner look.

A note, me and Kristoffer Jensvoll-Johnsen live together and met the same problems so we worked it out.

## Issues and troubles:

### 1. Testing using Sets for expected outcomes
>- **Issue**: In the tests it uses Set.of() to check functions that return Collections, however these do not compare well, apparently.
>- **Solution(s**): Changed the relevant variables from `Collection<...>` to `Set<...>`

### 2. toString() and hashCode()
>- **Issue**: The domain classes would give a stack overflow
>- **Solution(s)**: Overwrote the functions in order to avoid the infinite recursion that would happen

