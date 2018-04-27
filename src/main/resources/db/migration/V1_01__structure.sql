DROP TABLE IF EXISTS PUBLIC."user_account";
CREATE TABLE PUBLIC."user_account"
(
	"user_name"					VARCHAR(60) 	NOT NULL						PRIMARY KEY,
	"password"					VARCHAR(60),
	"full_name"					VARCHAR(60),
	"email"							VARCHAR(120) 	UNIQUE,
	"telephone"					VARCHAR(20),
	"status"						VARCHAR(10) 	DEFAULT 'active'
);

DROP TABLE IF EXISTS PUBLIC."account_type";
CREATE TABLE PUBLIC."account_type"
(
	"id"								SERIAL		PRIMARY KEY,
	"name"							VARCHAR(30)
);

DROP TABLE IF EXISTS PUBLIC."account";
CREATE TABLE PUBLIC."account"
(
	"id"								SERIAL		NOT NULL			PRIMARY KEY,
	"owner"							VARCHAR(60),
	"account_type"			VARCHAR(10),
	"name"							VARCHAR(30),
	"ini"								FLOAT8,
	"rmn"								FLOAT8,
	"note"							VARCHAR(100),
	"status"						VARCHAR(10)		DEFAULT 'active'
);

DROP TABLE IF EXISTS PUBLIC."transaction_expense";
CREATE TABLE PUBLIC."transaction_expense"
(
	"id"								SERIAL		PRIMARY KEY,
	"name"							VARCHAR(30),
	"note"							VARCHAR(100),
	"id_parent"					INTEGER,
	"owner"							VARCHAR(60),
	"create_date"					TIMESTAMP		DEFAULT CURRENT_TIMESTAMP,
	"status"						VARCHAR(10)		DEFAULT 'active'
);

DROP TABLE IF EXISTS PUBLIC."transaction_income";
CREATE TABLE PUBLIC."transaction_income"
(
	"id"								SERIAL		PRIMARY KEY,
	"name"							VARCHAR(30),
	"note"							VARCHAR(100),
	"id_parent"					INTEGER,
	"owner"							VARCHAR(60),
	"create_date"					TIMESTAMP		DEFAULT CURRENT_TIMESTAMP,
	"status"						VARCHAR(10)		DEFAULT 'active'
);

DROP TABLE IF EXISTS PUBLIC."transaction";
CREATE TABLE PUBLIC."transaction"
(
	"date_transaction"	TIMESTAMP 		NOT NULL		DEFAULT CURRENT_TIMESTAMP,
	"owner"							VARCHAR(60)		NOT NULL,
	"account_type"			VARCHAR(10)		NOT NULL,
	"transaction_type"	VARCHAR(60),
	"type"							VARCHAR(20),
	"price"							FLOAT8,
	"note"							VARCHAR(100),
	"person"						VARCHAR(100),
	"status"						VARCHAR(10)		DEFAULT 'active',
	PRIMARY KEY ("date_transaction", "owner")
);

DROP TABLE IF EXISTS PUBLIC."log";
CREATE TABLE PUBLIC."log"
(
	"date_log"					TIMESTAMP			PRIMARY KEY		DEFAULT CURRENT_TIMESTAMP,
	"who"								VARCHAR(60),
	"act"								VARCHAR(10),
	"old_data"					TEXT,
	"new_data"					TEXT
);

DROP TABLE IF EXISTS PUBLIC."budget";
CREATE TABLE PUBLIC."budget"
(
	"id"								SERIAL				PRIMARY KEY,
	"owner"							VARCHAR(60),
	"name"							VARCHAR(40),
	"ini"								FLOAT8,
	"rmn"								FLOAT8,
	"date_start"				TIMESTAMP,
	"repeat"						VARCHAR(30),
	"status"						VARCHAR(10)		DEFAULT 'active'
);

DROP TABLE IF EXISTS PUBLIC."budget_trans_detail";
CREATE TABLE PUBLIC."budget_trans_detail"
(
	"id"											SERIAL			PRIMARY KEY,
	"budget_id"								INTEGER,
	"transaction_type_id"			INTEGER
);

DROP TABLE IF EXISTS PUBLIC."budget_acc_detail";
CREATE TABLE PUBLIC."budget_acc_detail"
(
	"id"								SERIAL			PRIMARY KEY,
	"budget_id"					INTEGER,
	"acc_id"						INTEGER
);