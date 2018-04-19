DROP TABLE IF EXISTS PUBLIC.user_account;
CREATE TABLE PUBLIC."user_account"
(
	"user_name"		VARCHAR(40) 	NOT NULL						PRIMARY KEY,
	"password"		VARCHAR(40),
	"full_name"		VARCHAR(60),
	"email"				VARCHAR(120) 	UNIQUE,
	"telephone"		VARCHAR(20),
	"status"			VARCHAR(10) 	DEFAULT 'active'		NOT NULL
);

INSERT INTO PUBLIC."user_account" ("user_name", "password", "full_name", "email", "telephone") VALUES
('111','111','111','111@111.111','111'),
('222','222','222','222@222.222','222');

DROP TABLE IF EXISTS PUBLIC."account_type";
CREATE TABLE PUBLIC."account_type"
(
	"id"					VARCHAR(10)		PRIMARY KEY,
	"name"				VARCHAR(30),
	"note"				VARCHAR(100),
	"status"			VARCHAR(10)		DEFAULT 'active'		NOT NULL
);

INSERT INTO PUBLIC."account_type" ("id", "name", "note") VALUES
('TYP1547632', 'Cash', ''),
('TYP1348267', 'Bank account', ''),
('TYP3548279', 'ATM', ''),
('TYP1582349', 'Deposit account', ''),
('TYP4512543', 'Save account', ''),
('TYP0123458', 'Other', '');

DROP TABLE IF EXISTS PUBLIC."account";
CREATE TABLE PUBLIC."account"
(
	"owner"				VARCHAR(40) 	NOT NULL,
	"type_id"			VARCHAR(10)		NOT NULL,
	"name"				VARCHAR(30),
	"price_in"		FLOAT8,
	"price_out"		FLOAT8,
	"note"				VARCHAR(100),
	"status"			VARCHAR(10)		DEFAULT 'active'		NOT NULL,
	PRIMARY KEY("owner", "type_id")
);

INSERT INTO PUBLIC."account" ("owner", "type_id", "name", "price_in", "price_out", "note") VALUES
('111', 'ACC0000001', 'Wallet', 500000, 500000, 'Current money in wallet'),
('111', 'ACC0000002', 'Bank account', 3250000, 3250000, 'Total money in bank account'),
('111', 'ACC0000003', 'Deposit account', 0, 0, '');

DROP TABLE IF EXISTS PUBLIC."expend_type";
CREATE TABLE PUBLIC."expend_type"
(
	"id"					VARCHAR(10)		PRIMARY KEY,
	"name"				VARCHAR(30),
	"note"				VARCHAR(100),
	"type"				VARCHAR(20),
	"id_parent"		VARCHAR(10),
	"owner"				VARCHAR(40),
	"status"			VARCHAR(10)		DEFAULT 'active'		NOT NULL
);

INSERT INTO PUBLIC."expend_type" ("id", "name", "note", "type", "id_parent", "owner") VALUES
('PAR0000001', 'Food and Dining', '', 'Expense', NULL, NULL),
('PAR0000002', 'Utilities', '', 'Expense', NULL, NULL),
('PAR0000003', 'Auto & Transport', '', 'Expense', NULL, NULL),
('PAR0000004', 'Kids', '', 'Expense', NULL, NULL),
('PAR0000005', 'Clothing', '', 'Expense', NULL, NULL),
('PAR0000006', 'Gift & Donations', '', 'Expense', NULL, NULL),
('PAR0000007', 'Health & Fitness', '', 'Expense', NULL, NULL),
('PAR0000008', 'Home', '', 'Expense', NULL, NULL),
('PAR0000009', 'Entertainment', '', 'Expense', NULL, NULL),
('PAR0000010', 'Personal', '', 'Expense', NULL, NULL),
('OTH0000001', 'Lend', '', 'Expense', NULL, NULL),
('OTH0000002', 'Repayment', '', 'Expense', NULL, NULL),

('PAR0000011', 'Salary', '', 'Income', NULL, NULL),
('PAR0000012', 'Bonus', '', 'Income', NULL, NULL),
('PAR0000013', 'Awarded', '', 'Income', NULL, NULL),
('PAR0000014', 'Interest', '', 'Income', NULL, NULL),
('PAR0000015', 'Other', '', 'Income', NULL, NULL),
('PAR0000016', 'Savings interest', '', 'Income', NULL, NULL),
('OTH0000003', 'Borrow', '', 'Income', NULL, NULL),
('OTH0000004', 'Collecting debts', '', 'Income', NULL, NULL),

('CHD0000001', 'Groceries', '', 'Expense', 'PAR0000001', NULL),
('CHD0000002', 'Restaurant', '', 'Expense', 'PAR0000001', NULL),
('CHD0000003', 'Bars & Coffee', '', 'Expense', 'PAR0000001', NULL),
('CHD0000004', 'Water', '', 'Expense', 'PAR0000002', NULL),
('CHD0000005', 'Electricity', '', 'Expense', 'PAR0000002', NULL),
('CHD0000006', 'Internet', '', 'Expense', 'PAR0000002', NULL),
('CHD0000007', 'Gas', '', 'Expense', 'PAR0000002', NULL),
('CHD0000008', 'Cable TV', '', 'Expense', 'PAR0000002', NULL),
('CHD0000009', 'Mobile Phone', '', 'Expense', 'PAR0000002', NULL),
('CHD0000010', 'Home Phone', '', 'Expense', 'PAR0000002', NULL),
('CHD0000011', 'Hiring maid', '', 'Expense', 'PAR0000002', NULL),
('CHD0000012', 'Fuel', '', 'Expense', 'PAR0000003', NULL),
('CHD0000013', 'Service & Parts', '', 'Expense', 'PAR0000003', NULL),
('CHD0000014', 'Repair vehicles', '', 'Expense', 'PAR0000003', NULL),
('CHD0000015', 'Parking', '', 'Expense', 'PAR0000003', NULL),
('CHD0000016', 'Car wash', '', 'Expense', 'PAR0000003', NULL),
('CHD0000017', 'Taxi', '', 'Expense', 'PAR0000003', NULL),
('CHD0000018', 'Tuition', '', 'Expense', 'PAR0000004', NULL),
('CHD0000019', 'Books', '', 'Expense', 'PAR0000004', NULL),
('CHD0000020', 'Baby Supplies', '', 'Expense', 'PAR0000004', NULL),
('CHD0000021', 'Toys', '', 'Expense', 'PAR0000004', NULL),
('CHD0000022', 'Allowance', '', 'Expense', 'PAR0000004', NULL),
('CHD0000023', 'Clothes', '', 'Expense', 'PAR0000005', NULL),
('CHD0000024', 'Shoes', '', 'Expense', 'PAR0000005', NULL),
('CHD0000025', 'Accessories', '', 'Expense', 'PAR0000005', NULL),
('CHD0000026', 'Marriages', '', 'Expense', 'PAR0000006', NULL),
('CHD0000027', 'Funerals', '', 'Expense', 'PAR0000006', NULL),
('CHD0000028', 'Charity', '', 'Expense', 'PAR0000006', NULL),
('CHD0000029', 'Gifts', '', 'Expense', 'PAR0000006', NULL),
('CHD0000030', 'Doctor', '', 'Expense', 'PAR0000007', NULL),
('CHD0000031', 'Pharmacy', '', 'Expense', 'PAR0000007', NULL),
('CHD0000032', 'Sports', '', 'Expense', 'PAR0000007', NULL),
('CHD0000033', 'Furnishing', '', 'Expense', 'PAR0000008', NULL),
('CHD0000034', 'Repair of buildings', '', 'Expense', 'PAR0000008', NULL),
('CHD0000035', 'Home services', '', 'Expense', 'PAR0000008', NULL),
('CHD0000036', 'Music', '', 'Expense', 'PAR0000009', NULL),
('CHD0000037', 'Travel', '', 'Expense', 'PAR0000009', NULL),
('CHD0000038', 'Make up', '', 'Expense', 'PAR0000009', NULL),
('CHD0000039', 'Movies & DVDs ', '', 'Expense', 'PAR0000009', NULL),
('CHD0000040', 'Cosmetic', '', 'Expense', 'PAR0000009', NULL),
('CHD0000041', 'Education', '', 'Expense', 'PAR0000010', NULL),
('CHD0000042', 'Hobbies', '', 'Expense', 'PAR0000010', NULL);

DROP TABLE IF EXISTS PUBLIC."expend";
CREATE TABLE PUBLIC."expend"
(
	"date_expend"	TIMESTAMP 		NOT NULL		DEFAULT CURRENT_TIMESTAMP,
	"owner"				VARCHAR(40)		NOT NULL,
	"type_id"			VARCHAR(10)		NOT NULL,
	"expend_type"	VARCHAR(10),
	"type"				VARCHAR(20),
	"price"				FLOAT8,
	"note"				VARCHAR(100),
	"person"			VARCHAR(100),
	PRIMARY KEY (date_expend, owner, type_id)
);

INSERT INTO PUBLIC."expend" ("owner", "type_id", "expend_type", "type", "price", "note", "person") VALUES
('111', 'CHD0000001', 'ACC0000001', 'Expense', 50000, 'Buy food for me and Mr. A', 'Me and Mr. A');
INSERT INTO PUBLIC."expend" ("owner", "type_id", "expend_type", "type", "price", "note", "person") VALUES
('111', 'OTH0000004', 'ACC0000001', 'Income', 25000, 'Mr. A payback', 'Mr. A');

DROP TABLE IF EXISTS PUBLIC."log";
CREATE TABLE PUBLIC."log"
(
	"date_log"		TIMESTAMP			PRIMARY KEY		DEFAULT CURRENT_TIMESTAMP,
	"who"					VARCHAR(40),
	"act"					VARCHAR(10),
	"old_data"		TEXT,
	"new_data"		TEXT
);
