/*   TIERARTEN    */
INSERT INTO species (name, version) VALUES ("Hund", 0);
INSERT INTO species (name, version) VALUES ("Katze", 0);
INSERT INTO species (name, version) VALUES ("Kleintier", 0);
INSERT INTO species (name, version) VALUES ("Alpaka", 0);

/*   ORTE    */

INSERT INTO location (address, city, email, `name`, phone, version, zip)
VALUES ("Eckertstraße 30i", "Graz", "graz@wd.gmail.com", "WD Graz", "0664/123456789", 0, 8020);

INSERT INTO location (address, city, email, `name`, phone, version, zip)
VALUES ("Alfred-Adler-Straße 107", "Wien", "vienna@wd.gmail.com", "WD Wien", "0664/123456789", 0, 1010);

INSERT INTO location (address, city, email, `name`, phone, version, zip)
VALUES ("Südtiroler Platz 1", "Salzburg", "salzburg@wd.gmail.com", "WD Salzburg", "0664/123456789", 0, 5020);

/*   ANIMALS    */

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (3, "Kleinspitz", "Schwarz", "Cookie ist eine wunderschöne Australian Shepherd Dame, welche sehr talentiert im Hundesport ist. Natürlich ist sie auch sehr flauschig.", "Männlich", "Aramis", 0, null, 1, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (3, "Jack Russell Terrier", "Tricolor Weiß, Braun, Schwarz", "Mailo ist ein Jack Russell Terrier. Durch sein offenes Wesen kommt er mit jedem klar.", "Männlich", "Mailo", 0, null, 2, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (2, "Mischling", "Schwarz", "Bessie ist eine wundervolle, freundliche Hundedame, die es liebt, bschäftigt zu werden. Sie verzaubert mit ihrem Wesen jeden Menschen.", "Weiblich", "Bessie", 0, null, 3, 1);


INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (5, "Berner-Sennenhund", "Schwarz, Weiß", "Cosmo ist einsehr aktiver, freundlicher Berner-Sennenhund.Mit seiner freundlichen Art trotz seiner Größe macht ersich äußerst Beliebt.", "Männlich", "Cosmo", 0, null, 1, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (8, "Mischling", "Goldbraun", "Snorre ist ein Hund, der durch seine Tricks begeistert. Neben Saltos und Film-Tricks ist er aber auch ein flauschiger Therapiehund.", "Männlich", "Snorre", 0, null, 2, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (13, "Westie", "Weiß", "Elli ist eine ältere Hündin, die sich ganz besonders über Kuscheleinheiten freut.", "Weiblich", "Elli", 0, null, 3, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (4, "Terrier-Mix", "Schwarz, Grau, Braun", "Jimmy ist ein sehr zutraulicher, verspielter und auch sturer Kurzhaar-Terrier-Mix.", "Männlich", "Jimmy", 0, null, 1, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (4, "Meerschweinchen", "Schwarz", "Olga wird dieses Meerschweinchen genannt, das sich wie alle unsere Tiere durch die extreme Flauschigkeit auszeichnet.", "Weiblich", "Olga", 0, null, 2, 3);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (12, "Kater", "Orange", "Garfield ist ein zurückhaltender Kater, der jedoch immer für eine Streicheleinheit zu haben ist.", "Männlich", "Garfield", 0, null, 3, 2);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (2, "Kater", "Schwarz", "Mogli ist ein sehr flauschiger Kater.", "Männlich", "Mogli", 0, null, 1, 2);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (3, "Papagei", "Blau, Gelb","Carlos ist ein Papagei. Mit seinen lockeren Sprüchen kann er jede Person aufheitern.", "Männlich", "Carlos", 0, null, 2, 3);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (2, "Katze", "Getigert", "Wilma ist eine Katze, dir immer auf der Suche nach zuneigung ist.", "Weiblich", "Wilma", 0, null, 3, 2);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (6, "Westie", "Weiß", "Banja ist eine sehr verspielte Westie-Dame, welche ebenso verschmust wie aufgeweckt ist. Sie lässt auch stundenlange Streicheleinheiten über sich ergehen.", "Weiblich", "Banja", 0, null, 1, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (3, "Waschbär", "Schwarz, Grau, Weiß","Bobek ist der wohl zutraulichste Waschbär, den man sich vorstellen kann. Mit dem Typisch, zutraulichen Waschbär-Wesen nimmt er dir alle Sorgen.", "Männlich", "Bobek", 0, null, 2, 3);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (2, "Alpaka", "Braun", "Karl mag alle Menschen und ist ein flauschiges Alpaka, das.", "Männlich", "Karl", 0, null, 3, 4);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (2, "Alpaka", "Braun", "Paul findet die Therapien toll und ist ein flauschiges Alpaka.", "Männlich", "Paul", 0, null, 1, 4);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (2, "Alpaka", "Braun", "Tina ist ein flauschiges Alpaka, das nur selten spuckt und meistens grinst.", "Männlich", "Tina", 0, null, 2, 4);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (2, "Jack Russell", "Tricolor", "Pepper liebt jeden Menschen und ist nicht wählerisch bei der Wahl ihrer Therapie-Kunden.", "Weiblich", "Pepper", 0, null, 3, 1);


/*   OFFERS    */

INSERT INTO offer (description, duration, version, employee_id, location_id, species_id)
VALUES ("FH Prävention", 120, 0, 1, 1, 1);

INSERT INTO offer (description, duration, version, employee_id, location_id, species_id)
VALUES ("Burnout Prävention", 180, 0, 1, 1, 4);

INSERT INTO offer (description, duration, version, employee_id, location_id, species_id)
VALUES ("Burnout Prävention", 180, 0, 1, 2, 4);

INSERT INTO offer (description, duration, version, employee_id, location_id, species_id)
VALUES ("Burnout Prävention", 180, 0, 1, 3, 4);

INSERT INTO offer (description, duration, version, employee_id, location_id, species_id)
VALUES ("Hyperflauschtherapie", 60, 0, 1, 2, 3);

INSERT INTO offer (description, duration, version, employee_id, location_id, species_id)
VALUES ("All about Fluff", 180, 0, 1, 3, 2);

/* UserProfile */

INSERT INTO user_profile (address, city, day_of_birth, email, first_name, phone, last_name, version, zip) VALUES ("Alte Poststraße 147", "Graz", "1990-12-25", "felix@hauer.at", "Felix", 06641234567, "Hauer", 0, 8020);
INSERT INTO user_profile (address, city, day_of_birth, email, first_name, phone, last_name, version, zip) VALUES ("Eckerstraße 30i/3/10", "Graz", "1980-03-14", "sandra@maier.at", "Sandra", 06647654321, "Maier", 0, 8020);
