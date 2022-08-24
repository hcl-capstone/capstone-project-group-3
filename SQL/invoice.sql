SELECT * FROM invoice;
SELECT * FROM product;
SELECT * FROM shopping_cart;
SELECT  invoice.invoice_id, invoice.user_id, shopping_cart.cart_id, product.product_id, product.product_name, shopping_cart.product_quantity 
	FROM shopping_cart JOIN invoice ON invoice.invoice_id = shopping_cart.invoice_id JOIN product ON shopping_cart.product_id = product.product_id;

SELECT * FROM user;
SELECT * FROM invoice order by user_id;
SELECT user.user_id, user.email, invoice.invoice_id, invoice.total_price, invoice.order_status FROM user CROSS JOIN invoice ON user.user_id = invoice.user_id;
