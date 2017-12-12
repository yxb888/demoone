prompt PL/SQL Developer import file
prompt Created on 2017Äê11ÔÂ13ÈÕ by Administrator
set feedback off
set define off
prompt Disabling triggers for S_USER...
alter table S_USER disable all triggers;
prompt Deleting S_USER...
delete from S_USER;
commit;
prompt Loading S_USER...
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (103, '9222', '22999', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (104, '992299', '29', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (105, '9', '99', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (1, 'YXB', '0', '18301113987');
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (2, 'sys', 'sys', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (3, 'root', 'root', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (4, 'admin', 'admin', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (5, '123', '123', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (6, 'lou', 'lou', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (7, '321', '321', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (8, 'kkk', 'kkk', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (9, 'www', 'www', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (10, '1', '7', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (11, '2', '6', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (12, '3', '5', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (13, '4', '4', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (14, '5', '3', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (15, '6', '2', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (16, '7', '1', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (100, '11', '111', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (101, '111', '11', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (102, '111', '111', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (106, 'q', 'w', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (107, 'w', 'q', null);
insert into S_USER (USERID, USERNAME, USERPWD, USERMOBILE)
values (108, 'qq', 'ww', null);
commit;
prompt 25 records loaded
prompt Enabling triggers for S_USER...
alter table S_USER enable all triggers;
set feedback on
set define on
prompt Done.
