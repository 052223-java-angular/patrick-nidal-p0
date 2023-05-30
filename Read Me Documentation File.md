Welcome to Ecommerce Project

Please read this document before running the system.

==================================================


1 - Use postgres database to create the required tables and for the compatibility of JDBC driver.



2 - Use ddl.sql and dml.sql in the ./main/resources/db folder to use the required SQL scripts.



3 - Use Java 17 to run the program successfully.



4 - Run App.java in src/main/java/com/revature/p0/App.java



5 - Once App.java runs Home Screen will display.

    A - press 1 for logging in existing user. 

    B - press 2 to register a new user. 

    C - press 3 to exit the system. 



6 - To Log in and existing user press 1 in the Home screen then press Enter.

    A -  Enter the preregistered username when prompt. 

    B - Enter password when prompt. 





7 - To Register a new user press 2 in the Home Screen then press Enter.   

    A - Username should be between 4 and 20 characters with optional dots or underscores. 

    B - Password should be between 4 and 20 characters with optional dots or underscores. 

    C - Reenter the same password to confirm. 

    D - After step c, the username and password entered will display for confirmation. 

    E - Press y then Enter to agree on the new credentials. 



8 - After Log in an existing user or Register a new user Main Menu screen will display and can press  	x the Enter to exit the system.

	User can go to products screen, check the cart, see previous orders and browse reviews if 	enters 	the number corresponding to the one of the previous options. 



9 - On Main Menu, when user choose 1 for products, the Product Screen will display.

    A - User can choose 1 then press enter to browse all products in the database. 

         a - This option will display a list of all the products available. 

         c - User can press the number corresponded to the product to choose the product then press 	Enter. 

         d - When choosing a product, the quantity in stock of the product will display. 

         e - User need to enter the wanted quantity that is less than the quantity in stock to proceed. 

         f - Item will be added to the cart after choosing th quantity wanted. 

    B - User can choose 2 then press enter to search a specific product by name. 

         a - This option will display product searched for. 

         c - User can press the number corresponded to the product to choose the product then press 	Enter. 

         d - When choosing a product, the quantity in stock of the product will display. 

         e - User need to enter the wanted quantity that is less than the quantity in stock to proceed. 

         f - Item will be added to the cart after choosing th quantity wanted. 

    C - User can choose 3 to search products by Category. 

         a - This option will display all available categories in the database and user can choose the 	category based on the corresponding number. 

         b - After choosing the category, a list of the products will display. 

         c - User can press the number corresponded to the product to choose the product then press 	Enter. 

         d - When choosing a product, the quantity in stock of the product will display. 

         e - User need to enter the wanted quantity that is less than the quantity in stock to proceed. 

         f - Item will be added to the cart after choosing th quantity wanted. 

    D - User can choose 4 to search based on range of prices. 

         a - When user choose 4 to search by price range, the system will ask to enter the lowest price 

                and user can enter the low value then press Enter. 

         b - After entering the low value, system will ask for highest value, user can enter the highest 	value then press Enter. 

         c - A list of products will display with prices that are in the price range. 

         d - User can press the number corresponded to the product to choose the product then press 	Enter. 

         e - When choosing a product, the quantity in stock of the product will display. 

         f - User need to enter the wanted quantity that is less than the quantity in stock to proceed. 

         g - Item will be added to the cart after choosing th quantity wanted. 

    E - User can enter x value then Press Enter to close the system. 



10 - On Main Menu, when user presses 2 the screen of cart options will display.

    A - User can choose 1 to add products to the cart. 

        a - When user chooses 1, the Product Screen will display and follow the steps mentioned in 	step 9 in this document to add another product to the cart. 

    B - User can choose 2 then press Enter to remove products from cart. 

        a - When the user chooses 2, a list of all products in the cart will appear. 

        b - User can choose the product wants to remove by selecting the corresponding number 	then press Enter. 

        c - System will ask the user for the quantity they want to remove; user can enter quantity 	value then press Enter. 

        d - User can enter the value of quantity that wants to remove then press Enter 

        e - A removal success statement will appear on screen and the new cart items list. 

        f - User will be redirected to the cart screen. 

        g – Main Menu will appear, and the user can choose one of the options. 

         

    C - User can choose 3 to check out the cart. 

        	a – When the user proceeds to checkout, a list of the product, quantity and price will 		appear and a confirmation statement. 

        	b - User can enter value of "y" to confirm purchase and proceed, or "n" to refuse 
		confirmation and go back to Cart Screen. 
	c - When user enter value of "y", system will proceed to ask to enter the payment 	     amount 

d - The user will enter the amount of the payment then press Enter.

e - System will display order details and redirect the user to the main menu.



11 - On Main Menu, user can enter value of 3 to go to Order Screen.

    A - When go to Order Screen, screen will display current unprocessed orders and orders 	history. The system will automatically redirect the user to the Main Menu  



12 - On Main Menu, user can enter value of 4 then press Enter to go to Reviews Screen.

    A - User can enter value of 1 to add a new review. 

        a - The system will ask the user for product name, user should enter a product name that is 	identitical to the name in the database. 

        b - User can enter rating value that is 5 or less. 

        c - User can enter a comment about the product. 

        d - review will be added successfully and redirect the screen to the Review Screen. 

    B - User can enter value of 2 to browse all reviews. 

        a - This option will display a list of all reviews of all products and their names. 

        b - user can press Enter to go back to the Reviews Screen. 

    C - User can enter value of 2 to browse all reviews based on product name. 

        a - The system will ask the user for product name, user should enter a product name that is 	identitical to the name in the database. 

        b - A list of reviews of the selected product will display on the screen. 

        c - User can press Enter to go back to the Reviews Screen. 

    D - User can enter value of 4 to go back to the Main Menu. 

    E - User can enter value of x to exit to the system. (REMOVE THIS OPTION) 



13 - User can enter value of x then press Enter to go back to Home Screen.

     a - On Home Screen, user can enter a value of x to end the system. 