
#       This is a basic project created with TestNG based on POM
##      Used Technologies : Java, OOP, TestNG, Maven Repository, log4j  
##      !! Warning => If you want to run Case_1, run it by entering the required account information and password in the Case_1.xml file and run it from xml.

####    Test Classes package :
####  - The part where the test case is written. The steps here are detailed with string expressions and automation codes are completed with the methods created in the classes in the "Web Element Pages" package.

####    Utilities package :
#### -  DriverManager => Contains the start and end operations and the browser installation.

#### -  Log           => Contains simple log methods.

#### -  TestListener  => Contains common Logging methods that are run before and after tests.
#### -  Tools         => Contains methods that we need to repeat many times while writing our code. Only what is required for this test has been written, adding many methods will be very useful for large-scale frameworks.


####    WebElementPages => This package classes allows test actions to be performed after Web elements are located and string definitions from "Test Classes" are passed to methods.

####    XML            => You can run tests by entering the parameters in the xml files in this package. And you can create and run many tests for many parameters only from here. 
####    Logs           => The package with the file where you can check the log information.