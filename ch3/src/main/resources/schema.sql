create table board (
	SEQ INT PRIMARY KEY,
	TITLE VARCHAR(200),
	WRITER VARCHAR(20),
	CONTENT VARCHAR(2000),
	CREATEDATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CNT INT DEFAULT 0
);

create table boardvo (
    seq integer not null,
    cnt bigint,
    content varchar(255),
    create_date date,
    title varchar(255),
    writer varchar(255),
    primary key (seq)
);