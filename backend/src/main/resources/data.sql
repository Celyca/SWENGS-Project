/* USER IMAGES */

INSERT INTO user_image (id, content_type, original_file_name, jhi_size, version)
VALUES (1, "image/png", "admin.png", 13052, 0);

INSERT INTO user_image (id, content_type, original_file_name, jhi_size, version)
VALUES (2, "image/png", "glitchbasket.png", 213797, 0);

INSERT INTO user_image (id, content_type, original_file_name, jhi_size, version)
VALUES (3, "image/png", "celyca.png", 57509, 0);

INSERT INTO user_image (id, content_type, original_file_name, jhi_size, version)
VALUES (4, "image/png", "flamingo25.png", 34748, 0);

INSERT INTO user_image (id, content_type, original_file_name, jhi_size, version)
VALUES (5, "image/png", "wannabe.png", 1553, 0);

INSERT INTO user_image (id, content_type, original_file_name, jhi_size, version)
VALUES (6, "image/jpeg", "cookiemonster25.jpg", 56745, 0);

/* USER */

INSERT INTO user (admin, employee, password, username, version, image_id, user_profile_id)
VALUES (1,1,"123456","admin",0,1,1);

INSERT INTO user (admin, employee, password, username, version, image_id, user_profile_id)
VALUES (0,1,"123456","bobek",0,2,2);

INSERT INTO user (admin, employee, password, username, version, image_id, user_profile_id)
VALUES (0,1,"123456","patrik",0,3,3);

INSERT INTO user (admin, employee, password, username, version, image_id, user_profile_id)
VALUES (0,1,"123456","liski",0,4,4);

INSERT INTO user (admin, employee, password, username, version, image_id, user_profile_id)
VALUES (0,0,"123456","wannabe",0,5,5);

INSERT INTO user (admin, employee, password, username, version, image_id, user_profile_id)
VALUES (0,0,"123456","flauschi16",0,6,6);

/* OFFERS */

INSERT INTO offer (description, duration, version, employee_id, location_id, species_id)
VALUES ("Let's Talk about Fluff", 120, 0, 1, 1, 1);

INSERT INTO offer (description, duration, version, employee_id, location_id, species_id)
VALUES ("I'm too Fluffy", 180, 0, 1, 1, 4);

INSERT INTO offer (description, duration, version, employee_id, location_id, species_id)
VALUES ("Fluffy Dirtbag", 180, 0, 1, 2, 4);

INSERT INTO offer (description, duration, version, employee_id, location_id, species_id)
VALUES ("I will always fluff you", 180, 0, 1, 3, 4);

INSERT INTO offer (description, duration, version, employee_id, location_id, species_id)
VALUES ("Rolling in the Fluff", 60, 0, 1, 2, 3);

INSERT INTO offer (description, duration, version, employee_id, location_id, species_id)
VALUES ("Bohemian Fluffody", 180, 0, 1, 3, 2);

/* USERPROFILE */

INSERT INTO user_profile (address, city, day_of_birth, email, first_name, phone, last_name, version, zip)
VALUES ("Alte Poststraße 147", "Graz", "1990-12-25", "felix@hauer.at", "Felix", 06641234567, "Hauer", 0, 8020);

INSERT INTO user_profile (address, city, day_of_birth, email, first_name, phone, last_name, version, zip)
VALUES ("Eckerstraße 30i/3/10", "Graz", "1980-03-14", "sandra@maier.at", "Sandra", 06647654321, "Maier", 0, 8020);

INSERT INTO user_profile (address, city, day_of_birth, email, first_name, phone, last_name, version, zip)
VALUES ("Alte Poststraße 147", "Graz", "1983-08-18", "patrik@rauche.at", "Patrik", 066434001193, "Rauche", 0, 8020);

INSERT INTO user_profile (address, city, day_of_birth, email, first_name, phone, last_name, version, zip)
VALUES ("Grazer Straße 18/3", "Weiz", "1994-09-01", "eliska@kra.at", "Liska", 06649482059, "Kra", 0, 8160);

INSERT INTO user_profile (address, city, day_of_birth, email, first_name, phone, last_name, version, zip)
VALUES ("Europaplatz 12", "Graz", "1981-04-10", "sven@neubauer.at", "Sven", 067629384578, "Neubauer", 0, 8010);

INSERT INTO user_profile (address, city, day_of_birth, email, first_name, phone, last_name, version, zip)
VALUES ("Weizer Straße 17b", "Gleisdorf", "1991-11-28", "sue@hello.at", "Sue", 066022948294, "Hue", 0, 8200);


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

/* ANIMAL IMAGES */

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (1, "image/jpeg", "kiki.jpg", 146764, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (2, "image/jpeg", "scoobie.jpg", 65837, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (3, "image/jpeg", "bessie.jpg", 54626, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (4, "image/jpeg", "cosmo.jpg", 127366, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (5, "image/jpeg", "snorre.jpg", 148760, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (6, "image/jpeg", "poci.jpg", 59510, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (7, "image/jpeg", "jimmy.jpg", 58703, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (8, "image/jpeg", "olga.jpg",85873, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (9, "image/jpeg", "garfield.jpg", 77840, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (10, "image/jpeg", "mogli.jpg", 108768, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (11, "image/jpeg", "papagei.jpg", 79557, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (12, "image/jpeg", "wilma.jpg", 54893, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (13, "image/jpeg", "banja.jpg", 71950, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (14, "image/jpeg", "bobek.jpg", 114531, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (15, "image/jpeg", "alpaka1.jpg", 85538, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (16, "image/jpeg", "alpaka2.jpg", 70036, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (17, "image/jpeg", "alpaka3.jpg", 51114, 0);

INSERT INTO animal_image (id, content_type, original_file_name, jhi_size, version)
VALUES (18, "image/jpeg", "pepper.jpg", 83264, 0);

/*   TIERE    */

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (0, "Australian Shepherd", "Blue Merle", "Kiki ist ein wunderschönes Australian Shepherd Mädchen, welches sehr zutraulich ist. Natürlich ist sie auch sehr flauschig.", "Weiblich", "Kiki", 0, 1, 1, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (3, "Mischling", "Braun, Weiß", "Scoobie ist ein Jack Russell Mix. Durch ihr offenes Wesen kommt sie mit jedem klar.", "Weiblich", "Scoobie", 0, 2, 2, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (2, "Mischling", "Schwarz", "Bessie ist eine wundervolle, freundliche Hundedame, die es liebt, bschäftigt zu werden. Sie verzaubert mit ihrem Wesen jeden Menschen.", "Weiblich", "Bessie", 0, 3, 3, 1);


INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (5, "Berner-Sennenhund", "Schwarz, Weiß", "Cosmo ist einsehr aktiver, freundlicher Berner-Sennenhund.Mit seiner freundlichen Art trotz seiner Größe macht ersich äußerst Beliebt.", "Männlich", "Cosmo", 0, 4, 1, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (8, "Mischling", "Goldbraun", "Snorre ist ein Hund, der durch seine Tricks begeistert. Neben Saltos und Film-Tricks ist er aber auch ein flauschiger Therapiehund.", "Männlich", "Snorre", 0, 5, 2, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (13, "Katze", "Schwarz", "Poci ist eine Katze, die sich ganz besonders über Kuscheleinheiten freut.", "Weiblich", "Poci", 0, 6, 3, 2);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (4, "Terrier-Mix", "Schwarz, Grau, Braun", "Jimmy ist ein sehr zutraulicher, verspielter und auch sturer Kurzhaar-Terrier-Mix.", "Männlich", "Jimmy", 0, 7, 1, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (4, "Meerschweinchen", "Schwarz", "Olga wird dieses Meerschweinchen genannt, das sich wie alle unsere Tiere durch die extreme Flauschigkeit auszeichnet.", "Weiblich", "Olga", 0, 8, 2, 3);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (12, "Kater", "Orange", "Garfield ist ein zurückhaltender Kater, der jedoch immer für eine Streicheleinheit zu haben ist.", "Männlich", "Garfield", 0, 9, 3, 2);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (2, "Kater", "Schwarz", "Mogli ist ein sehr flauschiger Kater.", "Männlich", "Mogli", 0, 10, 1, 2);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (3, "Papagei", "Blau, Gelb","Carlos ist ein Papagei. Mit seinen lockeren Sprüchen kann er jede Person aufheitern.", "Männlich", "Carlos", 0, 11, 2, 3);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (2, "Katze", "Getigert", "Wilma ist eine Katze, dir immer auf der Suche nach zuneigung ist.", "Weiblich", "Wilma", 0, 12, 3, 2);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (6, "Westie", "Weiß", "Banja ist eine sehr verspielte Westie-Dame, welche ebenso verschmust wie aufgeweckt ist. Sie lässt auch stundenlange Streicheleinheiten über sich ergehen.", "Weiblich", "Banja", 0, 13, 1, 1);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (3, "Waschbär", "Schwarz, Grau, Weiß","Bobek ist der wohl zutraulichste Waschbär, den man sich vorstellen kann. Mit dem Typisch, zutraulichen Waschbär-Wesen nimmt er dir alle Sorgen.", "Männlich", "Bobek", 0, 14, 2, 3);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (2, "Alpaka", "Weiß", "Karl mag alle Menschen und ist ein flauschiges Alpaka, das.", "Männlich", "Karl", 0, 15, 1, 4);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (2, "Alpaka", "Weiß", "Paul findet die Therapien toll und ist ein flauschiges Alpaka.", "Männlich", "Paul", 0, 16, 2, 4);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (2, "Alpaka", "Weiß", "Tina ist ein flauschiges Alpaka, das nur selten spuckt und meistens grinst.", "Männlich", "Tina", 0, 17, 3, 4);

INSERT INTO animal (age, breed, color, description, gender, `name`, version, image_id, location_id, species_id)
VALUES (2, "Jack Russell", "Tricolor", "Pepper liebt jeden Menschen und ist nicht wählerisch bei der Wahl ihrer Therapie-Kunden.", "Weiblich", "Pepper", 0, 18, 3, 1);



/* USERS_LOCATIONS */

INSERT INTO users_locations (user_id, location_id) VALUES (1,1);

INSERT INTO users_locations (user_id, location_id) VALUES (2,1);

INSERT INTO users_locations (user_id, location_id) VALUES (3,2);

INSERT INTO users_locations (user_id, location_id) VALUES (4,3);



/* EVENTS */

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-30", 0, 1, 1, 1);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-29", 0, 3, 1, 2);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-28", 0, 5, 1, 3);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-27", 0, 7, 1, 4);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-26", 0, 9, 6, 5);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-25", 0, 2, 1, 6);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-26", 0, 4, 1, 6);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-27", 0, 6, 1, 6);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-28", 0, 8, 5, 6);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-29", 0, 10, 6, 5);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-30", 0, 11, 5, 5);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-28", 0, 13, 1, 5);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-20", 0, 15, 2, 1);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-21", 0, 17, 3, 2);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-22", 0, 12, 6, 3);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-23", 0, 14, 5, 4);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-24", 0, 16, 4, 6);

INSERT INTO event (event, version, animal_id, offer_id, user_id)
VALUES ("2019-01-25", 0, 18, 1, 1);


