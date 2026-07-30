# Open addressing/quadratic probing

p(k,i) = h(k) + c1i + c2i^2 where c2 cannot be 0

Choice for linear or quadratic probing based on the size of the thing we decide to store in the HashMap entry
If entry size is lagre then go for quadratic else linear probing

Because for locality of preference to work the entry size should be small so that the page contains the contents for the subsequent reads.
And locality of reference is more in the case of linear probing compared to quadratic probing where subsequent reads are comparitively dispersed to avoid cascading collisions

## summary
- ***quadratic probing handles cascading collisions better than linear probing***
- ***linear probing handles locality of reference better than quadratic probing***