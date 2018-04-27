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

/* Data */

INSERT INTO PUBLIC."user_account" ("user_name", "password", "full_name", "email", "telephone") VALUES
('111','111','111','111@111.111','111'),
('222','222','222','222@222.222','222');

INSERT INTO PUBLIC."account_type"("name") VALUES
('Cash'), ('Bank account'), ('ATM'), ('Deposit account'), ('Save account'), ('Other');

INSERT INTO PUBLIC."account" ("owner", "account_type", "name", "ini", "rmn", "note") VALUES
('111', 'ACC1', 'Wallet', 500000, 500000, 'Current money in wallet'),
('111', 'ACC2', 'Bank account', 3250000, 3250000, 'Total money in bank account'),
('111', 'ACC3', 'Deposit account', 0, 0, '');

INSERT INTO PUBLIC."transaction_expense" ("name", "note", "id_parent", "owner") VALUES
('Lend', '', NULL, NULL),
('Repayment', '', NULL, NULL),
('Food and Dining', '', NULL, NULL),
('Utilities', '', NULL, NULL),
('Auto & Transport', '', NULL, NULL),
('Kids', '', NULL, NULL),
('Clothing', '', NULL, NULL),
('Gift & Donations', '', NULL, NULL),
('Health & Fitness', '', NULL, NULL),
('Home', '', NULL, NULL),
('Entertainment', '', NULL, NULL),
('Personal', '', NULL, NULL),
('Groceries', '', 3, NULL),
('Restaurant', '', 3, NULL),
('Bars & Coffee', '', 3, NULL),
('Water', '', 4, NULL),
('Electricity', '', 4, NULL),
('Internet', '', 4, NULL),
('Gas', '', 4, NULL),
('Cable TV', '', 4, NULL),
('Mobile Phone', '', 4, NULL),
('Home Phone', '', 4, NULL),
('Hiring maid', '', 4, NULL),
('Fuel', '', 5, NULL),
('Service & Parts', '', 5, NULL),
('Repair vehicles', '', 5, NULL),
('Parking', '', 5, NULL),
('Car wash', '', 5, NULL),
('Taxi', '', 5, NULL),
('Tuition', '', 6, NULL),
('Books', '', 6, NULL),
('Baby Supplies', '', 6, NULL),
('Toys', '', 6, NULL),
('Allowance', '', 6, NULL),
('Clothes', '', 7, NULL),
('Shoes', '', 7, NULL),
('Accessories', '', 7, NULL),
('Marriages', '', 8, NULL),
('Funerals', '', 8, NULL),
('Charity', '', 8, NULL),
('Gifts', '', 8, NULL),
('Doctor', '', 9, NULL),
('Pharmacy', '', 9, NULL),
('Sports', '', 9, NULL),
('Furnishing', '', 10, NULL),
('Repair of buildings', '', 10, NULL),
('Home services', '', 10, NULL),
('Music', '', 11, NULL),
('Travel', '', 11, NULL),
('Make up', '', 11, NULL),
('Movies & DVDs ', '', 11, NULL),
('Cosmetic', '', 11, NULL),
('Education', '', 12, NULL),
('Hobbies', '', 12, NULL);

INSERT INTO PUBLIC."transaction_income" ("name", "note", "id_parent", "owner") VALUES
('Borrow', '', NULL, NULL),
('Collecting debts', '', NULL, NULL),
('Salary', '', NULL, NULL),
('Bonus', '', NULL, NULL),
('Awarded', '', NULL, NULL),
('Interest', '', NULL, NULL),
('Other', '', NULL, NULL),
('Savings interest', '', NULL, NULL);