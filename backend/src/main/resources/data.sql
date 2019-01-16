/*   TIERARTEN    */
INSERT INTO species (name, version) VALUES ("Hund", 0);
INSERT INTO species (name, version) VALUES ("Katze", 0);
INSERT INTO species (name, version) VALUES ("Kleintier", 0);

/*   ORTE    */

INSERT INTO location (address, city, email, `name`, phone, version, zip)
VALUES ("Test1", "Graz", "G@wd.gmail.com", "WD Graz", "0664/123456789", 0, 8010);

INSERT INTO location (address, city, email, `name`, phone, version, zip)
VALUES ("Test2", "Wien", "W@wd.gmail.com", "WD Wien", "0664/123456789", 0, 5020);

INSERT INTO location (address, city, email, `name`, phone, version, zip)
VALUES ("Test3", "Salzburg", "S@wd.gmail.com", "WD Salzburg", "0664/123456789", 0, 1030);

/*   ANIMALS    */

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (3, "Australian Shepherd", "Red Merle", "Cookie ist eine wunderschöne Australian Shepherd Dame, welche sehr talentiert im Hundesport ist. Sie braucht einen Besitzer, welcher sich gerne aktiv mit ihr beschäftigt.", "Weiblich", "Cookie", 0, null, 1, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (3, "Kleinspitz", "Schwarz", "Cookie ist eine wunderschöne Australian Shepherd Dame, welche sehr talentiert im Hundesport ist. Sie braucht einen Besitzer, welcher sich gerne aktiv mit ihr beschäftigt.", "Männlich", "Aramis", 0, null, 1, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (3, "Jack Russell Terrier", "Tricolor Weiß, Braun, Schwarz", "Mailo ist ein Jack Russell Terrier, der nicht nur optisch ein Traumhund ist. Durch sein offenes Wesen kommt er mit jedem klar, doch man sollte seinen innerlichen Terrier nicht außer Acht lassen.", "Männlich", "Mailo", 0, null, 1, 1);
