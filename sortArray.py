# If [a1,a2,a3...,an,b1,b2...bn] is given input change this to 
# [a1,b1,a2,b2.....an,bn] , solution should be in-place

arr = ['a1', 'a2', 'b1', 'b2']

part1 = []
part2 = []
final = []

for i in range(0, len(arr)/2):
	part1.append(arr[i])
for i in range(len(arr)/2, len(arr)):
	part2.append(arr[i])
print part1
print part2
for i in range(0, len(arr)/2):
	final.append(part1[i])
	final.append(part2[i])
print final

