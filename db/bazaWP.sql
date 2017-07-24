
DROP TABLE IF EXISTS `kategorija`;

CREATE TABLE `kategorija` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `nazivKategorije` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `knjiga`;
CREATE TABLE `knjiga` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `knjiga_naziv` varchar(60),
  `knjiga_izdavac` varchar(50),
  `knjiga_autor` varchar(70) ,
  `knjiga_godina_izdanja` varchar(20),
  `knjiga_opis` varchar(250),
  `knjiga_kategorija` int(5) ,
  `knjiga_raspoloziva_kolicina` int(5),
  `knjiga_cena` double,
  `knjiga_slika_url` varchar(110),
  `knjiga_stanje` tinyint(4),
  PRIMARY KEY (`id`),
  KEY `knjigaKategorijaFK_idx` (`knjiga_kategorija`),
  CONSTRAINT `knjigaKategorijaFK` FOREIGN KEY (`knjiga_kategorija`) REFERENCES `kategorija` (`id`) /*ON UPDATE NO ACTION*/
);

DROP TABLE IF EXISTS `porudzbina_status`;
CREATE TABLE `porudzbina_status` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `tip_porudzbine` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
);



DROP TABLE IF EXISTS `porudzbina`;

CREATE TABLE `porudzbina` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `kupac_ime` varchar(30) NOT NULL,
  `kupac_prezime` varchar(30) NOT NULL,
  `kupac_adresa` varchar(75) NOT NULL ,
  `ukupan_iznos` double NOT NULL,
  `datum` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `porudzbina_status` int(5) NOT NULL ,
  PRIMARY KEY (`id`),
  KEY `porudzbinaStatusFK_idx` (`porudzbina_status`),
  CONSTRAINT `porudzbinaStatusFK` FOREIGN KEY (`porudzbina_status`) REFERENCES `porudzbina_status` (`id`) /*ON UPDATE NO ACTION*/
);


DROP TABLE IF EXISTS `tip_korisnika`;

CREATE TABLE `tip_korisnika` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `tip_naziv` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
);



DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `korisnicko_ime` varchar(30) NOT NULL unique, 
  `lozinka` varchar(30) NOT NULL,
  `tip_korisnika` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`tip_korisnika`) REFERENCES `tip_korisnika` (`id`) /*ON UPDATE NO ACTION*/
);

DROP TABLE IF EXISTS `narucene_knjige`;

create table `narucene_knjige`(
	`id_porudzbine` int(5) NOT NULL,
    `id_knjige` int(5) NOT NULL,
    `kolicina` int(5) NOT NULL,
    FOREIGN KEY (`id_porudzbine`) REFERENCES `porudzbina` (`id`),
    FOREIGN KEY (`id_knjige`) REFERENCES `knjiga` (`id`)
    );

insert into tip_korisnika values(1, 'poslovodja'),(2, 'administrator');

insert into porudzbina_status values(1, 'naruceno'),(2, 'poslato'),(3,'isporuceno'),(4,'otkazano');

insert into  korisnik values(1, 'ime', 'prezime', 'admin', 'pass', 2),(2, 'ime1', 'prezime1', 'poslovodja', 'pass', 1);

insert into kategorija values(1, 'Beletristika'),(2, 'Horor'),(4, 'Triler'),(5, 'Istorijski'), (6, 'Epska fantastika'), (7 , 'Autobiografija');

insert into knjiga values(1, 'Besnilo', 'BIGZ', 'Borislav Pekic', '1988', 'opis knjige', 4, 45, 890, 'images/books/1.jpg', 1),
(2, 'Isijavanje', 'Delfi', 'Stiven King', '2002', 'opis knjige', 2, 21, 990, 'images/books/2.jpg', 1),
(3, 'Groblje kucnih ljubimaca', 'Delfi', 'Stiven King', '2006', 'opis knjige', 2, 9, 990, 'images/books/3.jpg', 1),
(4, 'Ime ruze', 'Novosti', 'Umberto Eko', '1994', 'opis knjige', 1, 19, 490, 'images/books/4.jpg', 1),
(5, 'Grof Monte Kristo', 'Delfi', 'Aleksandar Dima', '2008', 'opis knjige', 1, 9, 599, 'images/books/5.jpg', 1),
(6, 'Majstor i Margarita', 'BIGZ', 'Mihail Bulgakov', '1988', 'opis knjige', 1, 9, 455, 'images/books/6.jpg', 1),
(7, 'Atlantida', 'Znanje', 'Borislav Pekic', '1990', 'opis knjige', 4, 45, 790, 'images/books/7.jpg', 1),
(8, '1984', 'Kontrast', 'Dzordz Orvel', '2000', 'opis knjige', 1, 45, 790, 'images/books/8.jpg', 1),
(9, 'Zlatno runo 1', 'Laguna', 'Borislav Pekic', '2006', 'opis knjige', 5, 5, 840, 'images/books/9.jpg', 1),
(10, 'Godine koje su pojeli skakavci 1', 'BIGZ', 'Borislav Pekic', '1986', 'opis knjige', 7, 15, 690, 'images/books/10.jpg', 1),
(11, 'Nezavrsene price', 'Delfi', 'Dz. R.R. Tolkin', '2009', 'opis knjige', 6, 13, 760, null , 1);


insert into porudzbina values(1, 'kupacIme', 'kupacPrezime', 'kupacAdresa', 2470, '2015-02-01 19:08:19',3),
(2, 'kupacIme1', 'kupacPrezime1', 'kupacAdresa1', 1600, '2015-02-14 19:08:19',2),
(3, 'kupacIme2', 'kupacPrezime2', 'kupacAdresa2', 490, '2015-05-01 19:08:19',3),
(4, 'kupacIme3', 'kupacPrezime3', 'kupacAdresa3', 910, '2015-05-07 19:08:19',3),
(5, 'kupacIme4', 'kupacPrezime4', 'kupacAdresa4', 2570, '2015-08-13 19:08:19',4),
(6, 'kupacIme', 'kupacPrezime', 'kupacAdresa', 1380, '2015-08-12 19:08:19',3),
(7, 'kupacIme', 'kupacPrezime', 'kupacAdresa', 2620, '2015-09-01 19:08:19',3),
(8, 'kupacIme', 'kupacPrezime', 'kupacAdresa', 1980, '2015-06-01 19:08:19',3);

insert into narucene_knjige values(1, 1, 1),(1, 7, 2),
(2, 11, 1),(2, 9, 1),
(3, 4, 1),
(4, 6, 2),
(5, 8, 1),(5,1, 2),
(6,10, 2),
(7, 9, 1),(7,3, 1),(7, 7,1),
(8, 3, 1), (8,2,1);
