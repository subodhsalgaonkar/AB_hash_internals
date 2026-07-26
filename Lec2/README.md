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