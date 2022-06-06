# BLOOD BANK MINI PROJECT USING JDBC AND MYSQL

 -> This is a blood_bank CLI based mini project done using jdbc and mysql.
 
 <hr>
 

# DESCRIPTION

-> This is a command line application built using java and MySql API.<br>
-> This program automatically creates a database named "bloodbank" in the local host having a default port number 3306 and uses that databases. <br>

Before running the application:<br>
<img src ="img_src/before_database.png">

After running the application:<br>
<img src = "img_src/after_database.png">

-> The program also creates 3 tables in that database named Admin, Donor and Seeker. <br>

<img src = "img_src/show_tables.png">

-> It has two login featurs : Admin Login and User Login. <br>
-> The default admin username is "admin" and password is "admin" case sensitive. <br>

<img src = "img_src/admin_user_login.png">

<hr>

# FEATURES OF USING THIS PROGRAM

# ADMIN FEATURES
 
-> The admin must first login using default username and password (username and password are case senstitive). <br>
-> Then it will show a list of actions that an admin can do. <br>

<img src = "img_src/admin_features.png" >

-> The admin can view and delete donor details  <br>

<img src = "img_src/view_delete_donor.png">

-> Similarly admin can view and delete seeker details. <br>

<img src = "img_src/view_delete_seeker.png">

-> Blood Details option enables admin to see <br>
    1) Donor - Seeker matching based on their blood group <br>
    2) Donor full details<br>
    3) Seeker full details<br>
    
 <img src = "img_src/blood_details.png">
 <img src = "img_src/donor_seeker_matching.png">
 <img src = "img_src/unit_blood.png">
 <img src = "img_src/display_person.png">
 
 -> Admin can create new login.
 
 -> Admin can see all the list of usernames and password who can login to the application. <br>

# DONOR FEATURES

-> The donors can create their entry for donating the blood. <br>

<img src = "img_src/donor_insertion.png">

-> The seeker can also create their entry requesting for blood. <br>

<img src = "img_src/seeker_insertion.png">

<hr>

# HOW TO RUN THIS APPLICATION?

-> Install MySql and Java<br>
-> Install mysql-connector-java.jar file to connect Java with MySql<br>
-> Create java project <br>
-> Add mysql-connector-java.jar as referenced library to the java project <br>
-> Copy this code to the main file <br>
-> Run java code <br>
-> Hurray! Code got run.
