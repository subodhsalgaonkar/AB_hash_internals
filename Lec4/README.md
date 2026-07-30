# Linear probing for open addressing

topics: What is linear probing, how has table operations happen with it, what makes it efficient and simple, challanges

Linear probing is based on a technique called open addressing

## What is linear probing

Probing function:
pobing function is defined as p(k,i) = j
we use it to find the first available slot
The same function is used during lookups

Linear probing:
p(k,i) = (h(k) + i) % m
m - size of the array
i - attempt number
h() - hash function
k - application key

***We search linearly from the hashed index until the end of the table and then wrap from the start***

## How hash table operations work with linear probing

### Adding a key
we invoke the probing function to find the slot in the hash table, if that slot is occoupied we traverse the hash table and find the first available slot.

***It's like linear search from the hashed index***


### lookup
invoke probing function to get the slot
If key there return
If not traverse
If again at the hased index return null

worst case: O(m)

### deleting a key
*Has to be soft delete*
start from index and traverse till we find the key and change the status to deleted

## Why fast?
*But isn't linearly tarversing slow?*
Not really because we leverage ***localised access***

OS concept:
locality of preference: When we try to access any location from RAM the CPU uses a system call to fetch a block that holds the particular location and it's cached on the CPU
Os works in block level (eg. blocks of 1 KB)

So subsequent access are served from the CPU cache

***Thus linear probing gives a constant time performance for average cases - mathematically proven***
*But worst case is painful*


## Challanges
#### bad hash function makes linear probing a full hash table search and inefficient
As many keys would map to the same initial index
***Murmur hash is perfect choice***

#### It suffers from clustered collisions
If k1 hashes to 2
k2 hashes to 2
k3 hashes to 3

k3's primary slot is already occoupied!!
clustered collision: because of prior key collision it is affecting the key getting hashed nearby

Thus a uniform hash function is essential for linear probing