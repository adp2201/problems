#originalList = [1,2,3,4,5,6,7,8,9,10];
readFile = open('numbers.txt', 'r')
var = readFile.readlines()
writeFile = open('newNums.txt','w')
for num in var:
	writeFile.write(str(num))
#fileWrite = open('file2.txt','w')
#fileWrite.write(text)
