-- Create table
create table MAPSDETAIL
(
  mapid     NUMBER not null,
  image     BLOB,
  time      TIMESTAMP(6),
  address   VARCHAR2(100),
  longitude NUMBER(10,5),
  latitude  NUMBER(10,5),
  magnitude NUMBER,
  intensity NUMBER,
  depth     NUMBER(12,7)
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
comment on column MAPSDETAIL.time
  is '时间';
comment on column MAPSDETAIL.address
  is '地点';
comment on column MAPSDETAIL.longitude
  is '经度';
comment on column MAPSDETAIL.latitude
  is '纬度';
comment on column MAPSDETAIL.magnitude
  is '震级';
comment on column MAPSDETAIL.intensity
  is '震中烈度';
comment on column MAPSDETAIL.depth
  is '震源深度';
-- Create/Recreate primary, unique and foreign key constraints 
alter table MAPSDETAIL
  add constraint PK_MAPID primary key (MAPID)
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
