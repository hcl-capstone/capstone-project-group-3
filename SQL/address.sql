SELECT * FROM user;
SELECT * FROM address;
SELECT * FROM user_address JOIN user ON user_address.user_id = user.user_id JOIN address ON user_address.address_id = address.address_id;