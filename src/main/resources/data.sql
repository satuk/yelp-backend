insert into users(id, email, first_name, last_name, password) values(1,'example@email.com','Petra','Pistalu','password');

insert into reviews(id, date_created, rating, text, user_id) values(2,10,2,'great',1);

insert into restaurants(id, address, email, logo, name, phone, url) values(3,'zurich','rest@email.com','logo','Petra','021','http');

insert into restaurants_reviews(restaurant_id, reviews_id) values (3,2);
