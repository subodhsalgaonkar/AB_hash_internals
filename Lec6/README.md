# Conflict resolution/Open Addressing/double hashing

Methods seen till now:
- chaining
- open addressing
    - using linear probing
    - using quadratic probing
    - double hashing

Recap:
open addressing uses no additional DS
Find additional empty spot using probing function
linear: 
- p(k,i) = (h(k) + i) % m
- problem: clustered collisions 
and quadratic probing:
- p(k,i) = (h(k) + c1i + c2i^2) % m
- 

## core idea Double hashing
If clustered collisions is the only problem then we can use another hash function applied on the same key instead of a linear or a quadratic probing function

***p(k,i) = (h1(k,i) + i * h2(k)) % m***

So in case of a collision we use another hash function and try to leverage the entire hash table array 

h1() - ensures uniform prob of sitting anywhere in the array
h2() - ensures uniform prob of sitting anywhere in the array in case of collision

So this follows no specific pattern in case of collisions as it depends on the key


## Few considerations to make while choosing second hash function
1. **It shouldnever return 0** - if 0 then it keeps on colliding
2. **It should cycle through the entire slot** - inorder not to keep any slot empty
3. **It should be fast to compute and nearly similar to random num gererator** - t should be a simple mathematical function

## Advantages of double hashing
1. Uniform spread upon collision
2. follows no specific offset pattern
    - purely depends on the key
3. least prone to clustering collisions
    - offset from the primary slot is uniformly distributed
