Spring 2023 Project
Indiana University Southeast
INFO-451
Inventory Application
Olaf Carlson
ocarlson@iu.edu

Objective: Development of a plug in Inventory Management Application that works in the field for your technicians to speed up your inventory validation across your Network Infrastructure saving your corporation time and money.  Technicians need a inventory system that will keep track of actionable inventory that is user friendly, efficient and accurate to have that equipment on hand for your customers. 

Use Cases: 
Login/Logout using corporate logins and passwords.
Search and display your Inventory.
Create Inventory
Remove Inventory
Change Inventory Quantity Counts and Status’s

How to run the code in its current form:
Run the HelloApplication.java file

Will need an IDE to run the code in and establish the backend in Docker creating MySQL database mydatabase with table Inventory includes buildingLocation, HECI, description, cost, bayLocation, status and quantity.  A mydatabase Schema with two tables Inventory and loginPassword is utilized.

The final project is developed utilizing IntelliJ with MySQL for the front end of the application utilizing Scene Builder to create GUI.  
Here are the GUI Selections:

Initial Front End of application is Login and Password screen which will utilize your corporate login and password.  
	Username/Password	Input Username and Password
				a. If Username and Password are correct will take you to Search Inventory Window.
				b. If your Username and Password are not correct will advise you to try again.
				c.  If press cancel will exit you from application.
	Search Inventory	Input Building Location and HECI
				a.  If Building Location and HECI are found will take you to Building Inventory List Window.
				b.  If Building Location and HECI are not found will advise you to Try Again.
				c.  Pressing the Exit Button will shut down the application.

	Inventory List 	a.  Pressing the Exit Button will shut down the application.
				b.  Pressing Add Button will take you to Add Inventory Window
				c.  Changing Status and or Quantity text field and pressing Change Button will Change Status and or Quantity in the Inventory.
				d.  Pressing Delete button will remove Inventory from database and update list.
				e.  Pressing Return to Search Button will take you back to Search Inventory Window.
				f.  Can scroll through inventory by sliding scroll bar to right of Inventory List.
	Add Inventory	a.  Inputting includes buildingLocation, HECI, description, cost, bayLocation, status and quantity will add to Inventory database.  Will advise Congratulations 					Inventory Added!
				b.  No input into all search queries will advise Not Valid Try Again!
				c.  If incorrect inputs will not update Inventory.
				d.  Pressing Exit Button will shut down application.
				e.  Pressing Return to Search Page Button will take you back to Inventory Search Window.




