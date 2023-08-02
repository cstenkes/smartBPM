--user
insert into user_acc (user_acc_id,email,first_name,last_name,name,password,phone) values 
(1,'csaba.tenkes@brevissimus.eu','csaba','tenkes','zafir','zafir','+36309816178');

insert into user_acc (user_acc_id,email,first_name,last_name,name,password,phone) values 
(2,'jimi@aol.com','james marshall','hendrix','jmi','jmi','+4242424242');

insert into user_acc (user_acc_id,email,first_name,last_name,name,password,phone) values 
(3,'rp@aol.com','robert','plant','robert','robert','+4243434343');

insert into user_acc (user_acc_id,email,first_name,last_name,name,password,phone) values 
(4,'jp@aol.com','james patrick','page','jimmy','jimmy','+4244444444');

insert into user_acc (user_acc_id,email,first_name,last_name,name,password,phone) values
(5,'ig@aol.com','ian','gillen','ian','ian','+4245454545');

-- state

insert into state (state_id , description , name ) values 
(1,'calling for tender','calling for tender(start)');

insert into state (state_id , description , name ) values 
(2,'consideration','consideration of tender');

insert into state (state_id , description , name ) values 
(3,'winner enachtment','winner enachtement(end)');

-- process_type
insert into process_type (process_type_id , description , name ) values 
(1,'tendering process','tendering process');

--attribute_type
-- types - step 1
insert into attribute_type (attribute_type_id, description , name, value_type ) values 
(1,'deadline','deadline',4);

insert into attribute_type (attribute_type_id, description , name, value_type ) values 
(2,'tendering amount','tendering amount',2);

insert into attribute_type (attribute_type_id, description , name, value_type ) values 
(3,'application url','application url',3);

insert into attribute_type (attribute_type_id, description , name, value_type ) values 
(4,'tendering form','tendering form', 3);

-- types - step 2
insert into attribute_type (attribute_type_id, description , name, value_type ) values 
(5,'firm name','firm name', 3);
insert into attribute_type (attribute_type_id, description , name, value_type ) values 
(6,'firm application url','firm application url', 3);

-- types - step 3
insert into attribute_type (attribute_type_id, description , name, value_type ) values 
(7,'winner firm name','winner firm name', 3);
insert into attribute_type (attribute_type_id, description , name, value_type ) values 
(8,'amount send','amount send', 2);
insert into attribute_type (attribute_type_id, description , name, value_type ) values 
(9,'amount send date','amount send date', 4);


-- Node
insert into Node (node_id, order_by,valid_from, state_id ) values 
(1,10,'2009-11-11 10:10:10.123456', 1);

insert into Node (node_id, order_by, valid_from, state_id ) values 
(2,20,'2009-11-11 10:10:10.123456', 2);

insert into Node (node_id, order_by,valid_from, state_id ) values 
(3,30,'2009-11-11 10:10:10.123456', 3);

--process_type_node    
insert into process_type_node (process_type_id,node_id) values 
(1,1);
insert into process_type_node (process_type_id,node_id) values 
(1,2);
insert into process_type_node (process_type_id,node_id) values 
(1,3);

--node_attribute_type
insert into node_attribute_type (node_id, attribute_type_id) values 
(1,1);
insert into node_attribute_type (node_id, attribute_type_id) values 
(1,2);
insert into node_attribute_type (node_id, attribute_type_id) values 
(1,3);
insert into node_attribute_type (node_id, attribute_type_id) values 
(1,4);

insert into node_attribute_type (node_id, attribute_type_id) values 
(2,5);
insert into node_attribute_type (node_id, attribute_type_id) values 
(2,6);

insert into node_attribute_type (node_id, attribute_type_id) values 
(3,7);
insert into node_attribute_type (node_id, attribute_type_id) values 
(3,8);
insert into node_attribute_type (node_id, attribute_type_id) values 
(3,9);
    
    
-- process

insert into process (process_id ,name ,description , node_id, process_type_id , useracc_id) values 
(1,'concrate tender process 1','concrate tender process1',1,1,1);
insert into process (process_id ,name ,description , node_id, process_type_id , useracc_id) values 
(2,'concrate tender process 2','concrate tender process2',null,1,2);


-- attributes
insert into attribute (attribute_id,process_id, node_id, attribute_type_id, date_value) values 
(1,1,1,1,'2010-11-11 10:10:10.123456');
insert into attribute (attribute_id,process_id, node_id, attribute_type_id,int_value) values 
(2,1,1,2,1000000);
insert into attribute (attribute_id,process_id, node_id, attribute_type_id,string_value) values 
(3,1,1,3,'http://www.brevissimus.eu');
insert into attribute (attribute_id,process_id, node_id, attribute_type_id,string_value) values 
(4,1,1,4,'sinergy');

insert into attribute (attribute_id, process_id, node_id, attribute_type_id,string_value) values 
(5,1,2,5, 'CoCa Cola Inc.');
insert into attribute (attribute_id, process_id, node_id, attribute_type_id,string_value) values 
(6,1,2,6,'http://aaaa.bbb/');

insert into attribute (attribute_id, process_id, node_id, attribute_type_id,string_value) values 
(7,1,3,7,'Coco Cola Inc.');
insert into attribute (attribute_id, process_id, node_id, attribute_type_id,int_value) values 
(8,1,3,8,580000);
insert into attribute (attribute_id, process_id, node_id, attribute_type_id, date_value) values 
(9,1,3,9,'2011-01-01 01:01:01.123456');
