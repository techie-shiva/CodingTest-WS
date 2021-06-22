# CodingTest-WS

PROBLEM

Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that
produces the minimum number of ranges required to represent the same restrictions as the input.

Approach:
  Created temporary csv file for zip range input under src/main/resources. Filename is "RestrictedZipRangeCodes.csv"
  Created an interface RangeValidatorService and created a method to validate and read input to Node model.
  Created implementation class (ZipRangeValidatorServiceImpl.java) and provided  method for processing data to minimize the zip range.
  Provided default method under FileUtil Class for reading input from csv and some of the validation methods for filtering the input data. 
  Created main class where instanstianted zip range validation services, invoke process data to get a minimized zip range .
  If range is not provided correctly, We are ignorning the line.

Note:
I have provided zip range implementation, where as we can utilize range validation service to have several implementations for country specific zip or any price range validation etc.

Technologies:
 Java 1.8, Maven
 
Execution Flow:
Go to ZipRangeExecutor.java class under "src/main/java/com/ws/codingtest/services/" and exucute main method as java application.
 
 
 Input File:
 CSV file under : src/main/resources/RestrictedZipCodeRanges.csv

Input/Output:
Input restricted range data :[[94133 94133], [94200 94799], [94266 94699], [91000 91999], [91100 92000], [91109 91111], [91111 91122], [91100 92000], [93300 93355], [93357 93367], [82222 83333], [81111 83311], [98745 98799]]
Minimized output Zip range :[[81111 83333], [91000 91999], [93300 93355], [93357 93367], [94133 94133], [94200 94799], [98745 98799]]


We can also add different restricted ranges in the CSV file and test.


