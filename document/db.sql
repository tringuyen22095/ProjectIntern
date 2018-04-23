DROP TABLE IF EXISTS PUBLIC.user_account;
CREATE TABLE PUBLIC."user_account"
(
	"user_name"		VARCHAR(40) 	NOT NULL						PRIMARY KEY,
	"password"		VARCHAR(40),
	"full_name"		VARCHAR(60),
	"email"				VARCHAR(120) 	UNIQUE,
	"telephone"		VARCHAR(20),
	"status"			VARCHAR(10) 	DEFAULT 'active'
);

DROP TABLE IF EXISTS PUBLIC."account_type";
CREATE TABLE PUBLIC."account_type"
(
	"id"					VARCHAR(10)		PRIMARY KEY,
	"name"				VARCHAR(30)
);

DROP TABLE IF EXISTS PUBLIC."account";
CREATE TABLE PUBLIC."account"
(
	"owner"				VARCHAR(40) 	NOT NULL,
	"account_type"			VARCHAR(10)		NOT NULL,
	"name"				VARCHAR(30),
	"ini"		FLOAT8,
	"rmn"		FLOAT8,
	"note"				VARCHAR(100),
	"status"			VARCHAR(10)		DEFAULT 'active',
	PRIMARY KEY("owner", "account_type")
);

DROP TABLE IF EXISTS PUBLIC."transaction_type";
CREATE TABLE PUBLIC."transaction_type"
(
	"id"					VARCHAR(10)		PRIMARY KEY,
	"name"				VARCHAR(30),
	"note"				VARCHAR(100),
	"type"				VARCHAR(20),
	"id_parent"		VARCHAR(10),
	"owner"				VARCHAR(40),
	"create_date"	TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
	"status"			VARCHAR(10)		DEFAULT 'active'
);

DROP TABLE IF EXISTS PUBLIC."transaction";
CREATE TABLE PUBLIC."transaction"
(
	"date_transaction"	TIMESTAMP 		NOT NULL		DEFAULT CURRENT_TIMESTAMP,
	"owner"				VARCHAR(40)		NOT NULL,
	"account_type"			VARCHAR(10)		NOT NULL,
	"transaction_type"	VARCHAR(60),
	"type"				VARCHAR(20),
	"price"				FLOAT8,
	"note"				VARCHAR(100),
	"person"			VARCHAR(100),
	"status"			VARCHAR(10)		DEFAULT 'active',
	PRIMARY KEY ("date_transaction", "owner", "account_type")
);

DROP TABLE IF EXISTS PUBLIC."log";
CREATE TABLE PUBLIC."log"
(
	"date_log"		TIMESTAMP			PRIMARY KEY		DEFAULT CURRENT_TIMESTAMP,
	"who"					VARCHAR(40),
	"act"					VARCHAR(10),
	"old_data"		TEXT,
	"new_data"		TEXT
);


INSERT INTO PUBLIC."user_account" ("user_name", "password", "full_name", "email", "telephone") VALUES
('111','111','111','111@111.111','111');
INSERT INTO PUBLIC."user_account" ("user_name", "password", "full_name", "email", "telephone") VALUES
('222','222','222','222@222.222','222');

INSERT INTO PUBLIC."account_type" VALUES
('TYP1547632', 'Cash');
INSERT INTO PUBLIC."account_type" VALUES
('TYP1348267', 'Bank account');
INSERT INTO PUBLIC."account_type" VALUES
('TYP3548279', 'ATM');
INSERT INTO PUBLIC."account_type" VALUES
('TYP1582349', 'Deposit account');
INSERT INTO PUBLIC."account_type" VALUES
('TYP4512543', 'Save account');
INSERT INTO PUBLIC."account_type" VALUES
('TYP0123458', 'Other');

INSERT INTO PUBLIC."account" ("owner", "account_type", "name", "ini", "rmn", "note") VALUES
('111', 'ACC1', 'Wallet', 500000, 500000, 'Current money in wallet');
INSERT INTO PUBLIC."account" ("owner", "account_type", "name", "ini", "rmn", "note") VALUES
('111', 'ACC2', 'Bank account', 3250000, 3250000, 'Total money in bank account');
INSERT INTO PUBLIC."account" ("owner", "account_type", "name", "ini", "rmn", "note") VALUES
('111', 'ACC3', 'Deposit account', 0, 0, '');

INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR1', 'Food and Dining', '', 'Expense', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR2', 'Utilities', '', 'Expense', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR3', 'Auto & Transport', '', 'Expense', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR4', 'Kids', '', 'Expense', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR5', 'Clothing', '', 'Expense', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR6', 'Gift & Donations', '', 'Expense', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR7', 'Health & Fitness', '', 'Expense', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR8', 'Home', '', 'Expense', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR9', 'Entertainment', '', 'Expense', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR10', 'Personal', '', 'Expense', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('OTH1', 'Lend', '', 'Expense', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('OTH2', 'Repayment', '', 'Expense', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR11', 'Salary', '', 'Income', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR12', 'Bonus', '', 'Income', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR13', 'Awarded', '', 'Income', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR14', 'Interest', '', 'Income', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR15', 'Other', '', 'Income', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR16', 'Savings interest', '', 'Income', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('OTH3', 'Borrow', '', 'Income', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('OTH4', 'Collecting debts', '', 'Income', NULL, NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD1', 'Groceries', '', 'Expense', 'PAR1', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD2', 'Restaurant', '', 'Expense', 'PAR1', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD3', 'Bars & Coffee', '', 'Expense', 'PAR1', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD4', 'Water', '', 'Expense', 'PAR2', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD5', 'Electricity', '', 'Expense', 'PAR2', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD6', 'Internet', '', 'Expense', 'PAR2', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD7', 'Gas', '', 'Expense', 'PAR2', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD8', 'Cable TV', '', 'Expense', 'PAR2', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD9', 'Mobile Phone', '', 'Expense', 'PAR2', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD10', 'Home Phone', '', 'Expense', 'PAR2', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD11', 'Hiring maid', '', 'Expense', 'PAR2', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD12', 'Fuel', '', 'Expense', 'PAR3', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD13', 'Service & Parts', '', 'Expense', 'PAR3', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD14', 'Repair vehicles', '', 'Expense', 'PAR3', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD15', 'Parking', '', 'Expense', 'PAR3', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD16', 'Car wash', '', 'Expense', 'PAR3', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD17', 'Taxi', '', 'Expense', 'PAR3', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD18', 'Tuition', '', 'Expense', 'PAR4', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD19', 'Books', '', 'Expense', 'PAR4', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD20', 'Baby Supplies', '', 'Expense', 'PAR4', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD21', 'Toys', '', 'Expense', 'PAR4', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD22', 'Allowance', '', 'Expense', 'PAR4', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD23', 'Clothes', '', 'Expense', 'PAR5', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD24', 'Shoes', '', 'Expense', 'PAR5', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD25', 'Accessories', '', 'Expense', 'PAR5', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD26', 'Marriages', '', 'Expense', 'PAR6', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD27', 'Funerals', '', 'Expense', 'PAR6', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD28', 'Charity', '', 'Expense', 'PAR6', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD29', 'Gifts', '', 'Expense', 'PAR6', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD30', 'Doctor', '', 'Expense', 'PAR7', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD31', 'Pharmacy', '', 'Expense', 'PAR7', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD32', 'Sports', '', 'Expense', 'PAR7', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD33', 'Furnishing', '', 'Expense', 'PAR8', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD34', 'Repair of buildings', '', 'Expense', 'PAR8', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD35', 'Home services', '', 'Expense', 'PAR8', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD36', 'Music', '', 'Expense', 'PAR9', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD37', 'Travel', '', 'Expense', 'PAR9', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD38', 'Make up', '', 'Expense', 'PAR9', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD39', 'Movies & DVDs ', '', 'Expense', 'PAR9', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD40', 'Cosmetic', '', 'Expense', 'PAR9', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD41', 'Education', '', 'Expense', 'PAR10', NULL);
INSERT INTO PUBLIC."transaction_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('CHD42', 'Hobbies', '', 'Expense', 'PAR10', NULL);

INSERT INTO PUBLIC."transaction" ("owner", "transaction_type", "account_type", "type", "price", "note", "person") VALUES
('111', 'CHD1', 'ACC1', 'Expense', 50000, 'Buy food for me and Mr. A', 'Me and Mr. A');
INSERT INTO PUBLIC."transaction" ("owner", "transaction_type", "account_type", "type", "price", "note", "person") VALUES
('111', 'OTH4', 'ACC1', 'Income', 25000, 'Mr. A payback', 'Mr. A');