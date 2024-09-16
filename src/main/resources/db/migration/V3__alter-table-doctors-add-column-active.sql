ALTER TABLE doctors add active tinyint;
update doctors set active = 1;