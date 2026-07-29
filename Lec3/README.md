# Resolving conflicts using open addressing

Highlight - It does not require any additional datastructure to hold collided keys, making them super space efficient

Topic covered: core idea, foundations for probing functions, understand how the implementation of hashMap functions changes

Conflicts are inevitible
i.e  different keys can map to the same location in the array

Ways to avoid collisions are:
1. Chaining
2. open addressing

But chaining requires auxillary Data structure (LinkedList) open addressing does not

## Core idea
Why to use auxillary data structre when the array iteslf has empty slots

So when there is a collision happens we need to find a slot for the second key

The way we find a empty slot should be deterministic in nature and cannot just be random linear search as theat would defeat the purpose of the hashmap lookup being constant

Probing helps here

### Probing
Probing is a function on which open addressing is based

probing strategy - ***j = p(k, i) that spits out the new index where key k can be placed at attempt i***

j E [0,m)  i E [0,m) where m -> size of the hashTable or the array

hence fisrt insert at j = p(k,0), if that is occoupied then try
                    at j = p(k,1), if that is occoupied then try
                    at j = p(k,2), if that is occoupied then try
                    at j = p(k,3), if that is occoupied then try
                    .
                    .
                    .
                    at j = p(k,m-1), if that is occoupied then *increase size*
        
Good probing function:
should generate the permutation of numbers [0,m-1] so as to cover the entire space eventually

So that we find the empty slot in atleast one of the attempt if the array is empty

implemetations:
1. mathematical
2. algorithmic


Deterministic: 
For a particular key k the order should be the same everytime


## HashTable opearations

### Adding a key
Until we find a free slot
keep probing and checking 
at the first free slot put the key

### lookup
similar to adding

using probing function try finding key in slots initially(j = p(k,0))
itteration stops when we find the key
                or we stumble upon an empty slot (as empty siginfies that there is nothing further)
                or we exhaust itterating over all the slots (i.e at attempt m)

### deleting *(impressive: soft delete)*
When we delete a key we do not empty a slot
So a slot has 3 stated **empty, filled and deleted**

This is because of the discovery mechanism

eg. 3 keys hashed at the same index and are then placed at
j = p(k1,0) = 5
j = p(k2,1) = 7
j = p(k3,2) = 2

Problem : *If we hard delete k2 then the slot becomes empty and then if we lookup for k3 then we run into a empty slot at index 7 which stops lookup*

Hence we need to differentiate a free and a deleted slot


## Limitations of open addresssing

- Max Number of keys = # of slots in array
- 
