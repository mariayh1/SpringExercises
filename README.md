# SpringExercises

These are excersises for refreshing how to use spring framework

Extra info for DB:

Download MySQL and MySQL workbench.

Installing and Running MySQL on Mac OS X
To manually start MySQL, you can launch the Terminal application found in Applications/Utilities/Terminal. Once the terminal window appears, you can type the following:

cd /usr/local/mysql

Then type the following:

sudo ./bin/mysqld_safe

Enter your password when prompted. At this point, MySQL should be running on your localhost (127.0.0.1) on port 3306.

Then you can connect and use your model from the mysql workbench. 

Execution examples: 
desc offers --> To visualize your table
insert into offers(name, email, text) values ('Manolo', 'mmmv@gmail.com','PHP coding') --> to insert rows
select * from offers --> to do the select operation



Now you can launch RazorSQL to create users for your MySQL instance. The Mac mysql installation includes by default a user named root with no password. You can use this account to connect to MySQL using RazorSQL.

To get connected with RazorSQL, select Connections -> Add Connection Profile, select MySQL from the database type list, and select the Auto Download Driver button to get the MySQL driver. Enter root for the login, nothing for the password, 127.0.0.1 or localhost for the host, and mysql for the database name.

After connecting, you can create a new user using the DB Tools -> Create -> Create User option. If you want the user to be able to access your MySQL instance from other machines, make sure to select the check the "All Domains" option, or else click the "Select Domains" button to add specific ip addresses / hosts.

The create user tool should generate SQL similar to the following:


GRANT ALL PRIVILEGES ON *.* TO 'testuser'@'localhost' 
IDENTIFIED BY 'testpass' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'testuser'@'%' 
IDENTIFIED BY 'testpass' WITH GRANT OPTION;
