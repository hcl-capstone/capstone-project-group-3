SELECT * FROM user;
SELECT * FROM role;
SELECT user.user_id, user.email, role.role_name FROM role_user JOIN user ON user.user_id = role_user.user_id JOIN role ON role.role_id = role_user.role_id;
