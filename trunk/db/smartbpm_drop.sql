
    alter table Attribute 
        drop constraint FK7839CA7CFF53CA06;

    alter table Attribute 
        drop constraint FK7839CA7C665F6387;

    alter table Attribute 
        drop constraint FK7839CA7CE43C3C4E;

    alter table Node 
        drop constraint FK252222F70A9E0E;

    alter table Process 
        drop constraint FK50C5B64FFF53CA06;

    alter table Process 
        drop constraint FK50C5B64FF722607B;

    alter table Process 
        drop constraint FK50C5B64F7F4D93AD;

    alter table node_attribute_type 
        drop constraint FKFEE29ADAFF53CA06;

    alter table node_attribute_type 
        drop constraint FKFEE29ADA665F6387;

    alter table process_type_node 
        drop constraint FK439C6617FF53CA06;

    alter table process_type_node 
        drop constraint FK439C66177F4D93AD;

    drop table Attribute;

    drop table Node;

    drop table Process;

    drop table State;

    drop table attribute_type;

    drop table node_attribute_type;

    drop table process_type;

    drop table process_type_node;

    drop table user_acc;

    drop sequence SEQ_BBBPM restrict;

    drop table hibernate_sequences;
