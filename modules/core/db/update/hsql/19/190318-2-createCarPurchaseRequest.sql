alter table CARDEALER_CAR_PURCHASE_REQUEST add constraint FK_CARDEALER_CAR_PURCHASE_REQUEST_ON_CAR foreign key (CAR_ID) references CARDEALER_CAR(ID);
alter table CARDEALER_CAR_PURCHASE_REQUEST add constraint FK_CARDEALER_CAR_PURCHASE_REQUEST_ON_PERSON foreign key (PERSON_ID) references CARDEALER_PERSON(ID);
alter table CARDEALER_CAR_PURCHASE_REQUEST add constraint FK_CARDEALER_CAR_PURCHASE_REQUEST_ON_MANAGER foreign key (MANAGER_ID) references SEC_USER(ID);
create index IDX_CARDEALER_CAR_PURCHASE_REQUEST_ON_CAR on CARDEALER_CAR_PURCHASE_REQUEST (CAR_ID);
create index IDX_CARDEALER_CAR_PURCHASE_REQUEST_ON_PERSON on CARDEALER_CAR_PURCHASE_REQUEST (PERSON_ID);
create index IDX_CARDEALER_CAR_PURCHASE_REQUEST_ON_MANAGER on CARDEALER_CAR_PURCHASE_REQUEST (MANAGER_ID);
