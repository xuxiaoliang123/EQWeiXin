-- Create table
create table TABMENUDETAIL
(
  menuid      NUMBER not null,
  menucontent VARCHAR2(100),
  menuexplain VARCHAR2(100),
  status      NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column TABMENUDETAIL.menucontent
  is '�˵�˵��';
comment on column TABMENUDETAIL.menuexplain
  is '�˵���';
comment on column TABMENUDETAIL.status
  is '״̬1���˵�������0���˵������';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TABMENUDETAIL
  add constraint PK_ID1 primary key (MENUID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
