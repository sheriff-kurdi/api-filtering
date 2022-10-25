INSERT INTO "languages" ("language_code", "language_name") VALUES
                                                               ('ar',	'arabic'),
                                                               ('en',	'english');

INSERT INTO "users" ("id", "age") VALUES
                                      (1,	20),
                                      (2,	22);

INSERT INTO "users_details" ("id", "name", "language_code", "user_id") VALUES
                                                                           (3,	'شريف',	'ar',	1),
                                                                           (4,	'منه',	'ar',	2),
                                                                           (1,	'sheriff',	'en',	1),
                                                                           (2,	'menna',	'en',	2);