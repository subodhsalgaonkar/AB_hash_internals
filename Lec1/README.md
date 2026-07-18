# Introduction and internal structure of HashTable

Widely used DS
Every lang has it's own impltmentation
- python -> Dictionary 
- Java -> HashMap
- javascript -> Object
- Golang -> Map

Hash tables are also used as building blocks for language runtime
eg. in classes and it's members and functions (mapping name of object to method being invoked and execute this function for the functionName)
eg in variable lookup tables (symbol table)


HashTables are designed to provide ***near constant time insertion, lookups and deletion***



Two Ideas to construct hash tables
1. Application Ke to hashKey [0,N)
        apple --> 12346789
2. hashKey to a smaller range [0,m)             *crux of hash Table implementation*
        12346789 --> 17

Language cannot restrict us for the type of the key, instead it want's to support all types of keys


1. Application Ke to hashKey
We cannot put anything as a key in a HashTable
But language allows to put anything as a key but we need to implement the hashfunction for the same ourselves
```Java
// For java if you do not override the hashCode() method in your custom class, it inherits the default implementation from the java.lang.Object class.

// The JVM generates an integer typically derived from the object's internal memory address.

// The Problem: Two separate instances of your class with the exact same data fields will generate completely different hash codes. This means if you use one instance to put a value into the map, you will not be able to retrieve it using a separate instance with identical data.
```

*for some native types the hash function is internally impelmented*


## Very naive implementation using only idea 1
input *Key k* -> output of idea 1 *int i*

Use a gigantic array and store the value at *index i we got from idea 1*

O(1) insert, update and lookup

Why fails?
works only when range of i [0, N] is small
n = 10 --> 4 x 10 = 40 B
n = 100 --> 4 x 100 = 400 B
n = 1000 --> 4 x 1000 = 4 KB
n = 1M --> 4 x 1M = 4 MB

if N = int32 range --> 4 x 4 billion = 16 Gb

So 16 Gb just to hold an array in memory

Challanges:
1. Finding this big continous allocation of memory is very difficult
2. Lots of space wasted 

So need to find a better way to cinstruct a hashMap
*Idea 2 of convertin the int i to a smaller range using another hash function*

## 2. Mapping hashKey to smaller range
If we are planning to store k keys in the hashtable we have to have an array of sixe m such that
                m E O(k)
This requires us to have a second step that reduces HashKey from range to smaller range.
                [0, N) --> [0, m)


Holding array is called a **bin**

#### What if the number of keys increase?
- The bin grows by double(not always but preferred)
- Then we reallocate and reindex all the keys and then add the new additional key

- This process takes a little time compared to other key, value insertions


#### Why are we even hashing from string to int?
- We are simplifying our problem statement for the second step, making it easier to optimize int -> int distribution

- Allows us to give great abstractions enabling us to support complex data types as keys