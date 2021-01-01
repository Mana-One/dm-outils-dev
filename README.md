# Author
Paolo Manaois 3AL1
<br><br>

# Summary
Each commit is the solution for a specific smell, an optimization or a new feature.<br>
Smells and refactoring techniques here are those described by [Refactoring Guru](https://refactoring.guru), other fixes will be counted as optimizations.<br><br>
Smells count : 5<br>
Refactoring techniques used : 5<br>
Optimizations : 4<br>
New features (tests) : 7<br>
<br><br>

# Smells detected
Smell identified | Refactoring technique(s) used | Benefits of refactoring
 --- | --- | --- 
Object-orientation abuser : complex switch statement in Customer class | <ul><li>Replace type code with subclasses</li><li>Replace conditional with polymorphism</li></ul> | The creation of subclasses gets rid of <b>another smell</b> : <b>Primitive obsession</b> with constants in Movie class.<br>The customer class no longer handles the calculation of rental prices, each subclass of Movie has its own method.<br>The same applies to the calculation of rental points.<br>Overall, the code is cleaner since it is shorter and a new behaviour (i.e subclass of Movie) will not compromise the statement method in Customer.
Dispensable : Rental is a Data Class | <ul><li>Hide method</li></ul> | The Rental class now has other functionalities than simply returning data.<br>The method calls to calculate prices and points in the statement method of Customer class are simpler and more readable.
Coupler : Message Chain in statement method of Customer class | <ul><li>Hide delegate</li></ul> | The Rental class no longer returns its movie instance.<br>Just like in the previous smell correction, the method call to get a title from a rental in the statement method of Customer class is simpler and more readable.<br>Since the movie instance in a rental is no longer fetchable, it is not possible to modify it by mistake which adds a layer of security for the application.
Dispensable : Dead Code in Customer Class | <ul><li>Code removal</li></ul> | The getName method in Customer was never used.

<br><br><br>

# Optimizations
Description | Benefits of this method
 --- | --- 
Replaced Vector by ArrayList | Using an array list is more convenient when iterating over its elements : the code has been reduced a little in the statement method of the Customer class.
Modified string handling | The concat method is stricter than the '+' operator.<br>The format method is a cleaner way to concatenate string and non-string elements.
Changed statement method name to getRentalHistory | The purpose of this method is more explicit through its name.
Created private methods to handle the string generation of the history in Customer class. | The code is more flexible since the format of the strings can be modified without having to change the getRentalHistory method.

<br><br><br>

# New Features
<ul>
<li>No rental statement test</li>
<li>Single regular movie statement test</li>
<li>Single regular movie more than 2 days statement test</li>
<li>Single new release movie 1 day statement test</li>
<li>Single children movie more than 3 days statement test</li>
<li>Multiple children movies statement test</li>
<li>Multiple movies statement test</li>
</ul>