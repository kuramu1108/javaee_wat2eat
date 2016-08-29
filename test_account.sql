/**
 * Author:  mac
 * Created: 2016/8/19
 */

insert into w.ACCOUNT (id, password, gender, age, nationality)
values ('kuramu1108', '4ac1a11e2411b1ad6361357c564ffd5a3df39fc9950abc9059e1d7afcf0bcd02', 'M', 20, 'Taiwanese');

insert into w.ACCOUNT (id, password, gender, age, nationality)
values ('aiptest', '0b701ae5359a99012edb0176db64939c133aa09b8ea72e6b8af76c8a3ad18038', 'M', 18, 'Australian');

insert into w.REVIEW (title, comment, rating, restaurantid, userid, reviewdate)
values ('Not bad', 'this is not a bod place to go', 5, 1, 'kuramu1108',  {d'2016-08-21'});
