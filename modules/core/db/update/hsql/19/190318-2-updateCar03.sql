alter table CARDEALER_CAR add constraint FK_CARDEALER_CAR_ON_EQUIPMENT foreign key (EQUIPMENT_ID) references CARDEALER_EQUIPMENT(ID);
create index IDX_CARDEALER_CAR_ON_EQUIPMENT on CARDEALER_CAR (EQUIPMENT_ID);
