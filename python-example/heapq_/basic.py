#!/usr/bin/python
# -*- coding: utf-8 -*-

from __future__ import print_function
from __future__ import division

import heapq

heap = [1, 3, 5, 7, 9, 2, 4, 6, 8, 0]

print("<<heapify>>")
heapq.heapify(heap)
print(heap)

print("<<heappush>>")
heapq.heappush(heap, -1)
print(heap)

print("<<heappop>>")
print(heapq.heappop(heap))

print("<<heappushpop>>")
print(heapq.heappushpop(heap, -1))

print("<<heapreplace>>")
print(heapq.heapreplace(heap, -1))

print("<<merge>>")
merge_0 = [1,3,5]
merge_1 = [2,4]
print(list(heapq.merge(merge_0, merge_1)))

print("<<nlargest>>")
print(heapq.nlargest(3, heap))

print("<<nsmallest>>")
print(heapq.nsmallest(3, heap))
