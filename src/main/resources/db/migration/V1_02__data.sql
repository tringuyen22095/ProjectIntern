/*
INSERT INTO PUBLIC."user_account" ("user_name", "password", "full_name", "email", "telephone") VALUES
('111','111','111','111@111.111','111'),
('222','222','222','222@222.222','222');
*/

INSERT INTO PUBLIC."account_type"("name") VALUES
('Cash'), ('Bank account'), ('ATM'), ('Deposit account'), ('Save account'), ('Other');

/*
INSERT INTO PUBLIC."account" ("owner", "account_type", "name", "ini", "rmn", "note") VALUES
('111', 'ACC1', 'Wallet', 500000, 500000, 'Current money in wallet'),
('111', 'ACC2', 'Bank account', 3250000, 3250000, 'Total money in bank account'),
('111', 'ACC3', 'Deposit account', 0, 0, '');
*/

INSERT INTO PUBLIC."transaction_expense" ("name", "note", "id_parent", "owner") VALUES
('Lend', '', 0, NULL),
('Repayment', '', 0, NULL),
('Food and Dining', '', 0, NULL),
('Utilities', '', 0, NULL),
('Auto & Transport', '', 0, NULL),
('Kids', '', 0, NULL),
('Clothing', '', 0, NULL),
('Gift & Donations', '', 0, NULL),
('Health & Fitness', '', 0, NULL),
('Home', '', 0, NULL),
('Entertainment', '', 0, NULL),
('Personal', '', 0, NULL),
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
('Borrow', '', 0, NULL),
('Collecting debts', '', 0, NULL),
('Salary', '', 0, NULL),
('Bonus', '', 0, NULL),
('Awarded', '', 0, NULL),
('Interest', '', 0, NULL),
('Other', '', 0, NULL),
('Savings interest', '', 0, NULL);