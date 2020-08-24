insert INTO PHARMACY_PRESCRIPTION VALUES ('2', sysdate, sysdate, 'n', 'a002', 'nar0328'); 
commit;

insert INTO PHAR_inbox VALUES (3, 'nar0328', null, 'a001', 'file1', sysdate); 
commit;

select * from phar_inbox;

select 'private ' ||
        decode(lower(data_type), 'number', 'int ', 'String ') ||
        lower(column_name) || ';'
  from cols
 where lower(table_name) = 'phar_inbox';
 
--inventory
insert into medicine_inventory values('1', 'a001', '657200220', 100, 500, '700');
insert into medicine_inventory values('2', 'a002', '642800030', 140, 500, '400');

select * from MEDICINE_INVENTORY;
commit;

insert into PHARMACY_HISTORY VALUES(1,,,,,,1);

create sequence pharm_history
start with 1
increment by 1
maxvalue 10000;

create sequence medi_sale
start with 1
increment by 1
maxvalue 10000;

create sequence history_seq
start with 1
increment by 1
maxvalue 10000;

create sequence prescription_seq
start with 1
increment by 1
maxvalue 10000;

create sequence memInbox_seq
start with 1
increment by 1
maxvalue 10000;

select a.inven_num, a.inven_phid, a.inven_code, a.inven_remain, a.inven_inprice, a.inven_outprice, 
        (select medi_name from medicine b where a.inven_code = b.medi_code)as inven_YakName
		from medicine_inventory a;
        
select a.inven_num, a.inven_phid, a.inven_code, a.inven_remain, a.inven_inprice, a.inven_outprice, 
        (select medi_name from medicine b where a.inven_code = b.medi_code) as inven_YakName
		from medicine_inventory a
		where (select medi_name from medicine b where a.inven_code = b.medi_code) like '%¸®Æä¸®µ·%'
        
insert into medicine_sale values (medi_sale.nextval, ;
        
select sysdate + 365 from dual;

select a.INBOX_NUM, a.INBOX_MEMID, a.INBOX_CHECK, a.INBOX_PHID, a.INBOX_FILE, TO_CHAR(a.INBOX_DATE, 'YYYY-MM-DD')INBOX_DATE,
		(select PHARM_NAME from PHARMACY b where a.INBOX_PHID = b.PHARM_ID) as pharm_name
		FROM MEMBER_INBOX a;
        
select INBOX_NUM, INBOX_MEMID, INBOX_CHECK, INBOX_PHID, INBOX_FILE, to_char(INBOX_DATE, 'YYYY-MM-DD')INBOX_DATE from member_inbox;

select a.INBOX_NUM, a.INBOX_MEMID, a.INBOX_CHECK, a.INBOX_PHID, a.INBOX_FILE, TO_CHAR(a.INBOX_DATE, 'YYYY-MM-DD')INBOX_DATE,
		(select PHARM_NAME from PHARMACY b where a.INBOX_PHID = b.PHARM_ID) as pharm_name, 
		(select app_ph_star from member_approve c where a.inbox_file = c.app_code) as star_rate, 
		(select phpres_persue from pharmacy_prescription d where a.inbox_file = d.phpres_code) as persue
		FROM MEMBER_INBOX a;
        
INSERT INTO member_approve (
    app_code,
    app_date,
    app_cost,
    app_ph_star
) VALUES ('1140', sysdate, 6000, 0);

UPDATE member_approve SET app_ph_star = '2'
		WHERE app_code = '5305';
    