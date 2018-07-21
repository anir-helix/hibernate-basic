# hibernate-basic
hibernate-101, basic coding function like CRUD operation with details steps. The Purpose of this project is to understand hibernate with simple and live example.

##Feature:
This is basic Java Hibernate project where we have used a table called Student. and we enter and manupulate DB table data by using this code.

###Steps to Configure Project:

1. Open folder "***starter_db_files/***"
2. Open your MySql Workbench
3. open sql file "***starter_db_files/01-create-user.sql***", to create new user account. If you wish to use your own credentials then you need to change in code.
4. Open "***starter_db_files/02-student-tracker.sql***", this will create Student Table.
5. Next Open Eclipse IDE installed in your system.
6. Import the Project in to you system.
7. Need to add Lib jar into classpath, those Jar files are provided under following folder:  "***lib***".
8. Now right click on project root in Eclipse, and go to properties. 
9. Select "*Java Build Path*" and the select tab "***Libraries***"
10. Click on "*Add JARs...*" button and got to project based "**lib**" folder and select the all the jar files and add., '*Apply and Close*'
11. Run the project

#### Explore Project:

All the application are avaiable under package named "crudops".

##### CRUD ops :
**CreateStudentsForPrimarykeyDemo.java**	--> For Create Operation 
**DeleteStudent.java**						--> For Delete Operation
**GetStudent.java**							--> For Read Operation
**UpdateStudent.java**						--> For Update Operation
**UpdateBulkStudent.java**					--> For Bulk Update Operations using Custom Query object
**HBQueryingStudentDemo.java**				--> Example of using Custom Query Object

## Add on feature:

We have added a bonus part. for table Student data manipulation and ***How to handle SQL Date format using hibenate Code.***

###### Bonus Application :
CreateStudent.java			--> This Application will handle SQL Date format as Student DOB.
> Note: Note: But to be noted our current student table we have created using "starter_db_files/02-student-tracker.sql" doesn't contain DOB attribute for Student table.
Thus we need to import another sql file provide to alter the same table. "starter_db_files/add_DOB_user.sql.sql" .

> Only after importing this file run the Application CreateStudent else it'll give you a error.

## Bonus:

Our project we have used SQL Auto-increment feature to generate id. but there are 2 questions every programmer ask everytime he used this feature.
> 1. How do I change the auto increment values to any value?
> 2.How to clean out my database and I want to start the auto increments from 1?

Both of thease question answer can be find under following:
> starter_db_files/autoIncrementValueChangeCommand.txt

## Creators
Anirban Maiti:
- https://github.com/anir-helix
- https://in.linkedin.com/in/anirban24maiti



