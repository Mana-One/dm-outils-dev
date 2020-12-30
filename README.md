# Author
Paolo Manaois 3AL1
<br><br>
Each commit is the solution for a specific smell or optimization : the smells are corrected in the order defined in the array below, the same goes for optimizations, however between two smell solutions, an optimization may be applied though these should be commonly found as the last commits.
<br><br>

# Smells detected
Smell identified | Refactoring technique(s) used | Benefits of refactoring
 --- | --- | --- 
Object-orientation abuser : complex switch statement in Customer class | <ul><li>Creation of subclasses of Movie</li><li>Usage of polymorphism</li></ul> | The creation of subclasses gets rid of another smell : Primitive obsession with constants in Movie class.<br>The customer class no longer handles the calculation of rental prices, each subclass of Movie has its own method.<br>The same applies to the calculation of rental points.<br>Overall, the code is cleaner since it is shorter and a new behaviour (i.e subclass of Movie) will not compromise the statement method in Customer.
Dispensable : Rental is a Data Class | <ul><li>Hide method of movie instance in a Rental</li></ul> | The Rental class now has other functionalities than simply returning data.<br>The method calls to calculate prices and points in the statement method of Customer class are simpler and more readable.
<br><br><br>

# Optimizations
Description | Benefits of this method
 --- | --- 
Replaced Vector by ArrayList | Using an array list is more convenient when iterating over its elements : the code has been reduced a little in the statement method of the Customer class.