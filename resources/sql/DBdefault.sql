BEGIN TRANSACTION
create table if not exists "highscores" (
    "id" integer,
    "username" text,
    "time" text
    primary key(id));
COMMIT;