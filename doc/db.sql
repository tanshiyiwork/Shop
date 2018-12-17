drop table admin cascade constraints;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin  (
   st_id                VARCHAR2(50)                    not null,
   st_name              VARCHAR2(100),
   st_pwd               VARCHAR2(50),
   constraint PK_ADMIN primary key (st_id)
);

comment on table admin is
'管理员信息表';

comment on column admin.st_id is
'主键';

comment on column admin.st_name is
'管理员账户名';

comment on column admin.st_pwd is
'管理员账户密码';
