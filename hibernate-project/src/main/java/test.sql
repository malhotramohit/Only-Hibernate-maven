
CREATE SEQUENCE USER_DETAILS_SEQ;
CREATE SEQUENCE VEHICLE_SEQ;

CREATE SEQUENCE CLIENT_SEQ
CREATE SEQUENCE POST_SEQ

drop sequence USER_DETAILS_SEQ;
drop sequence POST_SEQ;
drop sequence CLIENT_SEQ;


create sequence POST_SEQ
       MINVALUE 1 
       MAXVALUE 9999999
       START WITH 1
       INCREMENT BY 1 ;
       

create sequence CLIENT_SEQ
       MINVALUE 1 
       MAXVALUE 9999999
       START WITH 1
       INCREMENT BY 1 ;

select * from vehicle;

 vehicleid vehiclename
 --------- -----------
         1 Bullet
         2 Dzire
   
select * from USER_DETAILS;

  userid description username
 ------ ----------- --------
      3 Coder       Mohit
      4 CA          Rohit




select * from VEHICLE_USER_DETAILS;

 vehicle_vehicleid userdetailslist_userid
 ----------------- ----------------------
                 1                      3
                 1                      4
                 2                      3
                 2                      4
