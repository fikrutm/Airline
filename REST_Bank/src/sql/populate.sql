INSERT INTO `rest_bank`.`address` (`id`, `version`, `city`, `state`, `street`, `zip`) VALUES ('1', '0', 'Fairfield', 'IA', '1000 N', '52557');
INSERT INTO `rest_bank`.`customer` (`id`, `version`, `birthDate`, `email`, `name`, `address_ID`) VALUES ('1', '0', '2016-12-01', 'sndmsg2jo@gmail.com', 'Jo', '1');
INSERT INTO `rest_bank`.`account` (`id`, `version`, `accountNumber`, `balance`) VALUES ('1', '0', '123', '200000.00');
INSERT INTO `rest_bank`.`account_customer` (`Customer_ID`, `AccountNumber`) VALUES ('1', '1');
INSERT INTO `rest_bank`.`checkingaccount` (`id`) VALUES ('1');
INSERT INTO `rest_bank`.`subscription` (`id`, `version`, `subscriptionType`) VALUES (1, 0, 'mailChannel');
INSERT INTO `rest_bank`.`subscription` (`id`, `version`, `subscriptionType`) VALUES (2, 0, 'smsChannel');
INSERT INTO `rest_bank`.`account_subscription` (`Account_id`, `subscriptions_id`) VALUES (1, 1);
INSERT INTO `rest_bank`.`account_subscription` (`Account_id`, `subscriptions_id`) VALUES (1, 2);

INSERT INTO `rest_bank`.`address` (`id`, `version`, `city`, `state`, `street`, `zip`) VALUES ('2', '0', 'Des moines', 'IA', '1000 N 4th', '55557');
INSERT INTO `rest_bank`.`customer` (`id`, `version`, `birthDate`, `email`, `name`, `address_ID`) VALUES ('2', '0', '2016-12-01', 'esehakahmedin@gmail.com', 'Esehak', '2');
INSERT INTO `rest_bank`.`account` (`id`, `version`, `accountNumber`, `balance`) VALUES ('2', '0', '0100', '400000.00');
INSERT INTO `rest_bank`.`account_customer` (`Customer_ID`, `AccountNumber`) VALUES ('2', '2');
INSERT INTO `rest_bank`.`checkingaccount` (`id`) VALUES ('2');
INSERT INTO `rest_bank`.`subscription` (`id`, `version`, `subscriptionType`) VALUES (3, 0, 'smsChannel');
INSERT INTO `rest_bank`.`account_subscription` (`Account_id`, `subscriptions_id`) VALUES (2, 3);

INSERT INTO `rest_bank`.`address` (`id`, `version`, `city`, `state`, `street`, `zip`) VALUES ('3', '0', 'Des moines', 'IA', '1000 N 4th', '55557');
INSERT INTO `rest_bank`.`customer` (`id`, `version`, `birthDate`, `email`, `name`, `address_ID`) VALUES ('3', '0', '2016-12-01', 'Tamrat@gmail.com', 'Tam', '3');
INSERT INTO `rest_bank`.`account` (`id`, `version`, `accountNumber`, `balance`) VALUES ('3', '0', '0100', '10000.00');
INSERT INTO `rest_bank`.`account_customer` (`Customer_ID`, `AccountNumber`) VALUES ('3', '3');
INSERT INTO `rest_bank`.`checkingaccount` (`id`) VALUES ('3');
INSERT INTO `rest_bank`.`subscription` (`id`, `version`, `subscriptionType`) VALUES (4, 0, 'mailChannel');
INSERT INTO `rest_bank`.`account_subscription` (`Account_id`, `subscriptions_id`) VALUES (3, 4);