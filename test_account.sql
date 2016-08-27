/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  mac
 * Created: 2016/8/19
 */

insert into w.ACCOUNT (id, password, gender, age, nationality)
values ('kuramu1108', '4ac1a11e2411b1ad6361357c564ffd5a3df39fc9950abc9059e1d7afcf0bcd02', 'M', 20, 'Taiwanese');

insert into w.REVIEW (title, comment, rating, restaurantid, userid, reviewdate)
values ('Not bad', 'this is not a bod place to go', 5, 1, 'kuramu1108',  {d'2016-08-21'});


select * from w.REVIEW;
