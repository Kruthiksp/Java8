# Java8
Solving one Java8 questions daily starting from very basic to advance covering all the features.

<h2>Daily Problem Statements</h2>
<pre>
01. Given a list of integers, use Java 8 Stream API to filter out the even numbers and collect them into a new list.
02. Given a list of integers, use Java 8 Stream API and map() to square each number and collect the results into a new list.
03. Given a list of integers,
    Filter only the odd numbers
    Square each of those odd numbers
    Collect the result into a new list.
04. Given a list of lowercase strings, use Java 8 Stream and map() to convert each string to uppercase and collect the result into a new list.
05. Given a list of strings, sort them in ascending order of their lengths using Java 8 features.
06. Given a list of Person Object,
    Sort the list of Person objects by age in ascending order
    Then by name in alphabetical order if ages are equal.
07. Given a list of Product Object,
    Filter the products that cost more than ₹1000
    Collect the result into a new List
    Print the filtered list.
08. Given a list of Product Object,
    Convert this list into a Map<String, Double> where
        -> Key = Product name
        -> Value = Product price
    If the product names are duplicated
        -> Use  "Merge Function".
09. Given a Map<String, Integer> representing products and their stock quantities
    Filter products where the stock is less than 100.
    Sort the result by stock quantity (ascending).
    Collect into a new LinkedHashMap (to maintain sort order).
    Print the result.
10. Given a list of Transaction objects
	Group the transactions by category
	Find the total amount spent in each category
	Store the result in a Map<String, Double>
	Print the final grouped totals
11. Given a list of Order objects.
    Each order contains a list of Items.
    create a List<String> containing the names of all items from all orders.
12. Given a list of Department objects.
    Each department has a name and a list of employees.
    From the list of departments
        -> Extract names of employees who have a salary greater than ₹50,000
        -> Avoid duplicates (assume multiple departments can have employees with the same name).
        -> Sort the names alphabetically.
        -> Collect into a List<String>.
13. You are given a list of Department objects. Each Department has a list of Employee objects.
	Get a Map where:
		Key: Department name
		Value: List of names of employees in that department who earn more than ₹60,000
	The employee names should be sorted alphabetically.
14. You are given a list of Order objects.
    Flatten all items from all orders
	Group the items by their name
	Calculate the total price for each item name
	Store the result in a Map<String, Double> where key = item name, value = total price
15. Given a list of Book objects, group the books by author and then collect the book titles (as a list) for each author.
16. You are given a list of Department objects. 
        Each department has a name and a list of Employee objects.
        Each employee has a name, department, and salary
    From all employees in all departments:
        Group employees by department name.
        For each department, find the highest-paid employee.
        Return a Map<String, Employee> where key is department name, and value is the highest-paid employee of that department.	
17. You are given a list of Transaction objects.
    Each transaction has: category, paymentMethod, amount.
        Group the transactions by category.
        Then group each category’s transactions by paymentMethod.
        Sum the total amount spent per payment method per category.
</pre>

<h2>Bonus Problem Statements</h2>
<pre>
01. Given a list of Employee Objects,
    Sort the list of Employee objects by department.
02. Given a list of Product Objects,
    find the product with Maximum price.
03. Given a List<Student>,
	extract all unique course names (i.e., no duplicates).
	sort them alphabetically.
	Collect the result into a List<String>.
</pre>
