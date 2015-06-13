INSERT INTO MEMBER (
    MEMBER_NAME,
    EMAIL,
    PASSWORD,
    ROLE
) VALUES
("root","root@toshokan.com", "root", "admin"),
("gondo","gondo@toshokan.com", "gondo", "user"),
("ueda","ueda@toshokan.com", "ueda", "user");

INSERT INTO BOOK (
    TITLE,
    AUTHOR,
    PUBLISHER,
    INS_USER_EMAIL,
    UPD_USER_EMAIL
) VALUES
("title1-1", "author1", "publisher1", "root@toshokan.com", "root@toshokan.com"),
("title2-1", "author2", "publisher1", "root@toshokan.com", "root@toshokan.com"),
("title3-1", "author3", "publisher2", "root@toshokan.com", "root@toshokan.com"),
("title1-2", "author1", "publisher1", "root@toshokan.com", "root@toshokan.com"),
("title3-2", "author3", "publisher1", "root@toshokan.com", "root@toshokan.com"),
("title1-3", "author1", "publisher2", "root@toshokan.com", "root@toshokan.com");

INSERT INTO LIBRARY (
    BOOK_ID,
    INS_USER_EMAIL,
    UPD_USER_EMAIL
) VALUES
("1", "root@toshokan.com", "root@toshokan.com"),
("2", "root@toshokan.com", "root@toshokan.com"),
("3", "root@toshokan.com", "root@toshokan.com"),
("4", "root@toshokan.com", "root@toshokan.com"),
("3", "root@toshokan.com", "root@toshokan.com"),
("1", "root@toshokan.com", "root@toshokan.com"),
("3", "root@toshokan.com", "root@toshokan.com"),
("5", "root@toshokan.com", "root@toshokan.com"),
("2", "root@toshokan.com", "root@toshokan.com");
