x=5
def handleX():
	print(x)
	print(x+1)
	return x+1
def printNumbers():
	for num in range(1,5):
		print(num)
def addNumbers(num1, num2):
	sum = num1+num2
	print(sum)
def printTwoNumbers(num1=10,num2=20):
	print(num1)
	print(num2)
def printNumber(num1):
        print(num1)
x=handleX()
print(x)
printNumbers()
addNumbers(10,11)
printTwoNumbers(num2=1)
