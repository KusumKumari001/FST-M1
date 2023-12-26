
-- Write an SQL statement to know which salesman are working for which customer.
SELECT c.customer_name, s.name FROM customers c
INNER JOIN salesman s ON c.salesman_id = s.salesman_id;


-- Write an SQL statement to make a list in ascending order for the customer who holds a grade less than 300 and works either through a salesman
SELECT c.customer_name, c.city, c.grade, s.name AS "Salesman", s.city FROM customers c 
LEFT OUTER JOIN salesman s ON c.salesman_id=s.salesman_id WHERE c.grade<300 
ORDER BY c.customer_id;


-- Write an SQL statement to find the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12%.
SELECT c.customer_name AS "Customer Name", s.name AS "Salesman", s.commission FROM customers c 
INNER JOIN salesman s ON c.salesman_id=s.salesman_id 
WHERE s.commission>12;

-- Write an SQL statement to find the details of a order i.e. order number, order date, amount of order, which customer gives the order and which salesman works for that customer and commission rate he gets for an order.
SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, c.name AS "Salesman", c.commission FROM orders a 
INNER JOIN customers b ON a.customer_id=b.customer_id 
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;
