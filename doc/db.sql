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
'����Ա��Ϣ��';

comment on column admin.st_id is
'����';

comment on column admin.st_name is
'����Ա�˻���';

comment on column admin.st_pwd is
'����Ա�˻�����';
