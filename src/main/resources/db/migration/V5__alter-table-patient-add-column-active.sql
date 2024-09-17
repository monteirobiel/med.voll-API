ALTER TABLE patients add active tinyint;
update patients set active = 1;