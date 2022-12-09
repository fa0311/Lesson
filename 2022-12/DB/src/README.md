# README

## hsqldb の AUTO_INCREMENT 属性について

```SQL
CREATE TABLE DB_QUIZE(
    Id INTEGER NOT NULL GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1),
    question VARCHAR(300),
    answer INTEGER,
    choices1 VARCHAR(200),
    choices2 VARCHAR(200),
    choices3 VARCHAR(200),
    choices4 VARCHAR(200)
);
```