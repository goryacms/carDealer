-- begin CARDEALER_AUTOMAKER
alter table CARDEALER_AUTOMAKER add constraint FK_CARDEALER_AUTOMAKER_ON_COUNTRY foreign key (COUNTRY_ID) references CARDEALER_COUNTRY(ID)^
create unique index IDX_CARDEALER_AUTOMAKER_UNIQ_CODE on CARDEALER_AUTOMAKER (CODE) ^
create unique index IDX_CARDEALER_AUTOMAKER_UNIQ_NAME on CARDEALER_AUTOMAKER (NAME) ^
create index IDX_CARDEALER_AUTOMAKER_ON_COUNTRY on CARDEALER_AUTOMAKER (COUNTRY_ID)^
-- end CARDEALER_AUTOMAKER
-- begin CARDEALER_COLOR
create unique index IDX_CARDEALER_COLOR_UNIQ_CODE on CARDEALER_COLOR (CODE) ^
create unique index IDX_CARDEALER_COLOR_UNIQ_NAME on CARDEALER_COLOR (NAME) ^
-- end CARDEALER_COLOR
-- begin CARDEALER_EQUIPMENT
alter table CARDEALER_EQUIPMENT add constraint FK_CARDEALER_EQUIPMENT_ON_CAR_MODEL foreign key (CAR_MODEL_ID) references CARDEALER_CAR_MODEL(ID)^
create index IDX_CARDEALER_EQUIPMENT_ON_CAR_MODEL on CARDEALER_EQUIPMENT (CAR_MODEL_ID)^
-- end CARDEALER_EQUIPMENT
-- begin CARDEALER_CAR_MODEL
alter table CARDEALER_CAR_MODEL add constraint FK_CARDEALER_CAR_MODEL_ON_AUTOMAKER foreign key (AUTOMAKER_ID) references CARDEALER_AUTOMAKER(ID)^
create index IDX_CARDEALER_CAR_MODEL_ON_AUTOMAKER on CARDEALER_CAR_MODEL (AUTOMAKER_ID)^
-- end CARDEALER_CAR_MODEL
-- begin CARDEALER_CAR
alter table CARDEALER_CAR add constraint FK_CARDEALER_CAR_ON_AUTOMAKER foreign key (AUTOMAKER_ID) references CARDEALER_AUTOMAKER(ID)^
alter table CARDEALER_CAR add constraint FK_CARDEALER_CAR_ON_CAR_MODEL foreign key (CAR_MODEL_ID) references CARDEALER_CAR_MODEL(ID)^
alter table CARDEALER_CAR add constraint FK_CARDEALER_CAR_ON_EQUIPMENT foreign key (EQUIPMENT_ID) references CARDEALER_EQUIPMENT(ID)^
create index IDX_CARDEALER_CAR_ON_AUTOMAKER on CARDEALER_CAR (AUTOMAKER_ID)^
create index IDX_CARDEALER_CAR_ON_CAR_MODEL on CARDEALER_CAR (CAR_MODEL_ID)^
create index IDX_CARDEALER_CAR_ON_EQUIPMENT on CARDEALER_CAR (EQUIPMENT_ID)^
-- end CARDEALER_CAR
-- begin CARDEALER_CAR_PURCHASE_REQUEST
alter table CARDEALER_CAR_PURCHASE_REQUEST add constraint FK_CARDEALER_CAR_PURCHASE_REQUEST_ON_CAR foreign key (CAR_ID) references CARDEALER_CAR(ID)^
alter table CARDEALER_CAR_PURCHASE_REQUEST add constraint FK_CARDEALER_CAR_PURCHASE_REQUEST_ON_PERSON foreign key (PERSON_ID) references CARDEALER_PERSON(ID)^
alter table CARDEALER_CAR_PURCHASE_REQUEST add constraint FK_CARDEALER_CAR_PURCHASE_REQUEST_ON_MANAGER foreign key (MANAGER_ID) references SEC_USER(ID)^
create index IDX_CARDEALER_CAR_PURCHASE_REQUEST_ON_CAR on CARDEALER_CAR_PURCHASE_REQUEST (CAR_ID)^
create index IDX_CARDEALER_CAR_PURCHASE_REQUEST_ON_PERSON on CARDEALER_CAR_PURCHASE_REQUEST (PERSON_ID)^
create index IDX_CARDEALER_CAR_PURCHASE_REQUEST_ON_MANAGER on CARDEALER_CAR_PURCHASE_REQUEST (MANAGER_ID)^
-- end CARDEALER_CAR_PURCHASE_REQUEST
-- begin SEC_USER
alter table SEC_USER add constraint FK_SEC_USER_ON_COUNTRY foreign key (COUNTRY_ID) references CARDEALER_COUNTRY(ID)^
create index IDX_SEC_USER_ON_COUNTRY on SEC_USER (COUNTRY_ID)^
-- end SEC_USER