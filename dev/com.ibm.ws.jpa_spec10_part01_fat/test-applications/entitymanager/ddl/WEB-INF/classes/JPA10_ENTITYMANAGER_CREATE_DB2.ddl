CREATE TABLE ${schemaname}.JPA10EntityManagerEntityA (id INTEGER NOT NULL, strData VARCHAR(254), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.JPA10EntityManagerEntityA_JPA10EntityManagerEntityB (ENTITYALIST_ID INTEGER, ENTITYBLIST_ID INTEGER);
CREATE TABLE ${schemaname}.JPA10EntityManagerEntityB (id INTEGER NOT NULL, strData VARCHAR(254), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.JPA10EntityManagerEntityC (id INTEGER NOT NULL, strData VARCHAR(254), ENTITYA_ID INTEGER, ENTITYALAZY_ID INTEGER, PRIMARY KEY (id));
CREATE INDEX I_JP20TYB_ELEMENT ON ${schemaname}.JPA10EntityManagerEntityA_JPA10EntityManagerEntityB (ENTITYBLIST_ID);
CREATE INDEX I_JP20TYB_ENTITYALIST_ID ON ${schemaname}.JPA10EntityManagerEntityA_JPA10EntityManagerEntityB (ENTITYALIST_ID);
CREATE INDEX I_JP20TYC_ENTITYA ON ${schemaname}.JPA10EntityManagerEntityC (ENTITYA_ID);
CREATE INDEX I_JP20TYC_ENTITYALAZY ON ${schemaname}.JPA10EntityManagerEntityC (ENTITYALAZY_ID);