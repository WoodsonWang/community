create table comment
(
	id bigint auto_increment,
	question_id int not null,
	type int,
	comment_creator int,
	gmt_create bigint,
	gmt_modified bigint,
	like_count int,
	constraint comment_pk
		primary key (id)
);