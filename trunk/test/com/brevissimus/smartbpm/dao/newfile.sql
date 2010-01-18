select
  attribute0_.attribute_id as attribute1_0_,
  attribute0_.attribute_type_id as attribute7_0_,
  attribute0_.boolean_value as boolean2_0_,
  attribute0_.date_value as date3_0_,
  attribute0_.int_value as int4_0_,
  attribute0_.node_id as node8_0_,
  attribute0_.order_by as order5_0_,
  attribute0_.process_id as process9_0_,
  attribute0_.string_value as string6_0_,
  process2_.process_id
  
 from
  Attribute attribute0_,
  user_acc user1_,
  Process process2_
 where
  process2_.useracc_id=user1_.user_acc_id 
  and user1_.user_acc_id=1
  and process2_.process_id=1 
  and attribute0_.process_id=process2_.process_id 
  and attribute0_.node_id=process2_.node_id;


select from Attribute

select * from attribute

delete from attribute where attribute_id>0

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
