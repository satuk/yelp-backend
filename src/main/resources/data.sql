INSERT INTO users(id, email, first_name, last_name, password) VALUES (1,'34@satuk.ch','Satuk','Kolan', 'password');
INSERT INTO users(id, email, first_name, last_name, password) VALUES (2,'satuk@kolan.ch','Bugra Han','Kolan',
'password');
INSERT INTO users(id, email, first_name, last_name, password) VALUES (3,'info@satuk.ch','Satuk','Kolan', 'password');
INSERT INTO users(id, email, first_name, last_name, password) VALUES (4,'@kolan.ch','Bugra Han','Kolan',
'password');

INSERT INTO restaurants(id, address, email, logo, name, phone, url) VALUES (1,'Pfingstweidstrasse 16, 8005 Zürich',
'lilly@jo.ch','https://zfv.ch/cache/offer/z/zfv_partnerlogo_lilly%20jo.jpg',
'Lilly Jo','043 555 44 33','http://www.lilly-jo.ch');
INSERT INTO restaurants(id, address, email, logo, name, phone, url) VALUES (2,'Nietengasse 18, 8004 Zürich',
'info@gaucho.ch','http://gaucho.ch/wp_live/wp-content/uploads/2016/11/Gaucho_Logo.png',
'Restaurant GAUCHO','044 321 18 18','http://www.gaucho.ch');
INSERT INTO restaurants(id, address, email, logo, name, phone, url) VALUES (3,'Bahnhofstrasse 102, 8001 Zürich',
'info@yooji-s.ch','http://www.twospice.ch/wp-content/uploads/YOO_Logo_Subline_low.jpg',
'Yooji’s','043 555 44 22','http://www.yooji-s.ch');
INSERT INTO restaurants(id, address, email, logo, name, phone, url) VALUES (4,'Bahnhofstrasse 28A, 8001 Zürich',
'info@zeughauskeller.ch','https://poster-auctioneer.com/images/products/200/poster_200401_z.jpg',
'Zeughauskeller','044 222 22 18','http://www.zeughauskeller.ch');

INSERT INTO reviews(id, date_created, rating, text,restaurant_id, user_id) VALUES (1, {ts '2017-01-01 00:00:00.00'}, 3, 'great', 1, 1);
INSERT INTO reviews(id, date_created, rating, text,restaurant_id, user_id) VALUES (2, {ts '2017-01-01 00:00:00.00'}, 5, '!!!great!!!', 2, 2);
INSERT INTO reviews(id, date_created, rating, text,restaurant_id, user_id) VALUES (3, {ts '2017-01-01 00:00:00.00'}, 3, 'great job', 4, 4);
INSERT INTO reviews(id, date_created, rating, text,restaurant_id, user_id) VALUES (4, {ts '2017-01-01 00:00:00.00'}, 1, 'baaaad!!!', 3, 3);

