create table mybank.users (
	"user_id" int DEFAULT nextval('mybank.userid'::regclass),
	"username" text primary key,
	"password" text not null,
	"balance" int,
	"is_employee" text,
	"is_approved" text,
	"account_id" int unique not null DEFAULT nextval('mybank.acc_num'::regclass)
);

CREATE TABLE mybank.accounts(
   account_id int,
   transaction_type text,
   amount numeric(10,2),
   transaction_date timestamp,
   username text REFERENCES mybank.users (username) 
);

CREATE SEQUENCE mybank.userid
  start 1000
  increment 1;

CREATE SEQUENCE mybank.acc_num
  start 406201
  increment 1;