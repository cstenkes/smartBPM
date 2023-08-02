
    create table Attribute (
        attribute_id bigint not null,
        boolean_value smallint,
        date_value timestamp,
        int_value integer,
        order_by integer,
        string_value varchar(255),
        attribute_type_id bigint not null,
        node_id bigint not null,
        process_id bigint,
        primary key (attribute_id)
    );

    create table Node (
        node_id bigint not null,
        order_by integer,
        valid_from timestamp,
        state_id bigint not null,
        primary key (node_id)
    );

    create table Process (
        process_id bigint not null,
        description varchar(100),
        name varchar(25),
        node_id bigint,
        process_type_id bigint not null,
        useracc_id bigint not null,
        primary key (process_id)
    );

    create table State (
        state_id bigint not null,
        description varchar(100),
        name varchar(25),
        primary key (state_id)
    );

    create table attribute_type (
        attribute_type_id bigint not null,
        description varchar(100),
        name varchar(50),
        value_type integer,
        primary key (attribute_type_id)
    );

    create table node_attribute_type (
        node_id bigint not null,
        attribute_type_id bigint not null
    );

    create table process_type (
        process_type_id bigint not null,
        description varchar(100),
        name varchar(25),
        primary key (process_type_id)
    );

    create table process_type_node (
        process_type_id bigint not null,
        node_id bigint not null
    );

    create table user_acc (
        user_acc_id bigint not null,
        email varchar(100),
        first_name varchar(50),
        last_name varchar(50),
        name varchar(25),
        password varchar(25),
        phone varchar(25),
        primary key (user_acc_id)
    );

    alter table Attribute 
        add constraint FK7839CA7CFF53CA06 
        foreign key (node_id) 
        references Node;

    alter table Attribute 
        add constraint FK7839CA7C665F6387 
        foreign key (attribute_type_id) 
        references attribute_type;

    alter table Attribute 
        add constraint FK7839CA7CE43C3C4E 
        foreign key (process_id) 
        references Process;

    alter table Node 
        add constraint FK252222F70A9E0E 
        foreign key (state_id) 
        references State;

    alter table Process 
        add constraint FK50C5B64FFF53CA06 
        foreign key (node_id) 
        references Node;

    alter table Process 
        add constraint FK50C5B64FF722607B 
        foreign key (useracc_id) 
        references user_acc;

    alter table Process 
        add constraint FK50C5B64F7F4D93AD 
        foreign key (process_type_id) 
        references process_type;

    alter table node_attribute_type 
        add constraint FKFEE29ADAFF53CA06 
        foreign key (node_id) 
        references Node;

    alter table node_attribute_type 
        add constraint FKFEE29ADA665F6387 
        foreign key (attribute_type_id) 
        references attribute_type;

    alter table process_type_node 
        add constraint FK439C6617FF53CA06 
        foreign key (node_id) 
        references Node;

    alter table process_type_node 
        add constraint FK439C66177F4D93AD 
        foreign key (process_type_id) 
        references process_type;

    create sequence SEQ_BBBPM;

    create table hibernate_sequences (
         sequence_name varchar(255),
         sequence_next_hi_value integer 
    ) ;
