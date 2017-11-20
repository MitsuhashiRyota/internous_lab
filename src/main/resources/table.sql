DROP TABLE IF EXISTS m_user;

CREATE TABLE m_user(
 id varchar(100) PRIMARY KEY,
 login_id varchar(16) NOT NULL,
 password varchar(16) NOT NULL,
 user_name varchar(50) NOT NULL,
 login_flg tinyint DEFAULT 0,
 insert_date datetime,
 update_date datetime
);

DROP TABLE if EXISTS m_user_type;

CREATE TABLE m_user_type(
 id varchar(100) PRIMARY KEY,
 m_user_id varchar(100) NOT NULL,
 type_name varchar(20) NOT NULL,
 type_description varchar(100) NOT NULL,
 insert_date datetime NOT NULL,
 update_date datetime NOT NULL,

 FOREIGN KEY(m_user_id) REFERENCES m_user(id)
);
