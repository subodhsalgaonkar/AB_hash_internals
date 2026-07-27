Collisions happen as we are trying to map huge spaces of application keys in a small array
Ways to solve it:
eg. Chaining, open addressing

##### **Focus of this video is Chaining**

Collisions happen because multiple applications spit out the same hash keys

So both of them have to occoupy the same location - this makes the HashTable lossy

Core idea - put colliding kays in a data structure
Put keys in a auxillary data structure

##### **Common Auxillary DS - linked list**
form a chain of keys that are hashed to the same slot


## Chaining in linked list
Core operations:
1. add a new key to the linked list
2. check if the key is present in the list
3. remove a key from the list

Simplest approach:
Singly linked list


So solution is **Array of Linked List**

Each slot of the array contains the address of the head of the linked list

Each node contains pointer to the actual key and the pointer to the next node

***We need the actual key for identifying the key by comparing***



# operations in the linked list implementation
## Adding a key value pair
1. pass the key through the hash functions and get index i
2. create a new kinked list node with k,v
3. add it to the chain present at index i

Possible implementations:
1. insertion can always happen at the head (fast)
2. insertion can always happen at the tail (fast)
No need to traverse the LL to the end and then store the node, insead we can keep track of the tail as well in the array. So a 2d array
3. insertion can happen as per the sort order (linear iteration)
eg. lexicographical order
a ~~> ant --> apple --> atom

Problem with insertion at head and tail - can have duplicate keys
So we need to check if the key is also already present in the LL

## Deleting a key
1. reach the slot in O(1)
2. itterate through the list and find node where *key == target_key*
3. while itterating keep tarck of previous node
4. adjust the pointers: *prev.next = curr.next*
5. delete the inteded node

## lookup a key
similar to delete
1. reach the slot in O(1)
2. linearly itterate through the list until we find the node where *key == target_key*

If collisions are very high, most of the key value pairs will be in a single LL. So lookup may end up taking ~= O(n)


## Other datastructures for chaining
If collisions are very high then lookups take a lot of time
And hastables are mento to be efficient at lookups

So instead of Linked list we can use a **self balancing binary tree** to store collided K,V pairs

insertions are not O(1) but lookups are O(h)

Threfore Array of self balancing binary trees
insert log(n)
deletes log(n)
lookups log(h) where H is the height of the binary tree

When to use serach trees for chaining?
1. ***when we expect large number of collisions***
2. ***when we cannot resize the array due to some restrictions***

