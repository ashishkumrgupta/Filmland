INSERT INTO FILMLAND_USERS VALUES('testuser1@sogeti.com', 'testen#1');
INSERT INTO FILMLAND_USERS VALUES('testuser2@sogeti.com', 'testen#2');
INSERT INTO FILMLAND_USERS VALUES('testuser3@sogeti.com', 'testen#2');

INSERT INTO AVAILABLE_CATEGORIES VALUES('Dutch Films','4','10');
INSERT INTO AVAILABLE_CATEGORIES VALUES('Dutch Series','20','6');
INSERT INTO AVAILABLE_CATEGORIES VALUES('International Films','5','8');

INSERT INTO USER_SUBSCRIBED_CATEGORIES VALUES('101','testuser1@sogeti.com','International Films','5','2010-01-01','10','Y','N');
INSERT INTO USER_SUBSCRIBED_CATEGORIES VALUES('102','testuser2@sogeti.com','Dutch Films','2','2010-01-01','6','N','Y');
INSERT INTO USER_SUBSCRIBED_CATEGORIES VALUES('103','testuser3@sogeti.com','International Films','5','2010-01-01','10','Y','Y');