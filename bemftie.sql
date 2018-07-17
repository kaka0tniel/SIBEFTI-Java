/*
SQLyog Community v11.24 (32 bit)
MySQL - 10.1.16-MariaDB : Database - bemftie
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bemftie` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bemftie`;

/*Table structure for table `aspirasi` */

DROP TABLE IF EXISTS `aspirasi`;

CREATE TABLE `aspirasi` (
  `id_aspirasi` int(5) NOT NULL AUTO_INCREMENT,
  `nim` int(8) NOT NULL,
  `aspirasi` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_aspirasi`),
  KEY `aspirasi` (`nim`),
  CONSTRAINT `aspirasi` FOREIGN KEY (`nim`) REFERENCES `mahasiswa_ftie` (`nim`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `aspirasi` */

insert  into `aspirasi`(`id_aspirasi`,`nim`,`aspirasi`) values (1,11315024,'Berikan kami crabby patty'),(3,11315012,'sdaas'),(4,11315024,'Mohon agar goreng yang disediakan tidak bersisa'),(5,11315024,'Bring your own bottle'),(6,11315014,'Anda harusnya makan banyak');

/*Table structure for table `departemen_humas` */

DROP TABLE IF EXISTS `departemen_humas`;

CREATE TABLE `departemen_humas` (
  `id_humas` int(20) NOT NULL AUTO_INCREMENT,
  `nim` int(8) NOT NULL,
  `jabatan` varchar(30) NOT NULL,
  PRIMARY KEY (`id_humas`),
  KEY `nim2` (`nim`),
  CONSTRAINT `nim2` FOREIGN KEY (`nim`) REFERENCES `mahasiswa_ftie` (`nim`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `departemen_humas` */

insert  into `departemen_humas`(`id_humas`,`nim`,`jabatan`) values (2,11315024,'anggota');

/*Table structure for table `departemen_ketertiban` */

DROP TABLE IF EXISTS `departemen_ketertiban`;

CREATE TABLE `departemen_ketertiban` (
  `id_ketertiban` int(20) NOT NULL AUTO_INCREMENT,
  `nim` int(8) NOT NULL,
  `jabatan` varchar(30) NOT NULL,
  PRIMARY KEY (`id_ketertiban`),
  KEY `nim4` (`nim`),
  CONSTRAINT `nim4` FOREIGN KEY (`nim`) REFERENCES `mahasiswa_ftie` (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `departemen_ketertiban` */

/*Table structure for table `departemen_pendidikan` */

DROP TABLE IF EXISTS `departemen_pendidikan`;

CREATE TABLE `departemen_pendidikan` (
  `id_pendidikan` int(20) NOT NULL AUTO_INCREMENT,
  `nim` int(8) NOT NULL,
  `jabatan` varchar(30) NOT NULL,
  PRIMARY KEY (`id_pendidikan`),
  KEY `nim3` (`nim`),
  CONSTRAINT `nim3` FOREIGN KEY (`nim`) REFERENCES `mahasiswa_ftie` (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `departemen_pendidikan` */

/*Table structure for table `departemen_sarpras` */

DROP TABLE IF EXISTS `departemen_sarpras`;

CREATE TABLE `departemen_sarpras` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `nim` int(8) NOT NULL,
  `jabatan` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sarpras` (`nim`),
  CONSTRAINT `sarpras` FOREIGN KEY (`nim`) REFERENCES `mahasiswa_ftie` (`nim`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `departemen_sarpras` */

insert  into `departemen_sarpras`(`id`,`nim`,`jabatan`) values (1,11315013,'Koordinator');

/*Table structure for table `event_dep_humas_ftie` */

DROP TABLE IF EXISTS `event_dep_humas_ftie`;

CREATE TABLE `event_dep_humas_ftie` (
  `id_event` varchar(3) NOT NULL,
  `nama_event` varchar(25) NOT NULL,
  `start_event` varchar(25) NOT NULL,
  `end_event` varchar(25) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  PRIMARY KEY (`id_event`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `event_dep_humas_ftie` */

insert  into `event_dep_humas_ftie`(`id_event`,`nama_event`,`start_event`,`end_event`,`deskripsi`) values ('1','gathering day','20-10-2017','29-10-2017','Happy'),('11','y','29-01-2017','29-02-2017','ssss'),('13','fds','29-08-2017','29-09-2017','gfdx'),('2','Markaroan','10-11-2017','12-10-2017','Selamat Hans'),('3','Uye','27-10-2017','30-10-2017','Sabar Otnil'),('9','aku','01-01-2017','02-02-2017','kamu');

/*Table structure for table `event_dep_ketertiban_ftie` */

DROP TABLE IF EXISTS `event_dep_ketertiban_ftie`;

CREATE TABLE `event_dep_ketertiban_ftie` (
  `id_event` varchar(3) NOT NULL,
  `nama_event` varchar(25) NOT NULL,
  `start_event` varchar(25) NOT NULL,
  `end_event` varchar(25) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  PRIMARY KEY (`id_event`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `event_dep_ketertiban_ftie` */

insert  into `event_dep_ketertiban_ftie`(`id_event`,`nama_event`,`start_event`,`end_event`,`deskripsi`) values ('1','gathering day','20-10-2017','29-10-2017','Happy'),('11','y','29-01-2017','29-02-2017','ssss'),('13','fds','29-08-2017','29-09-2017','gfdx'),('2','Markaroan','10-11-2017','12-10-2017','Selamat Hans'),('3','Uye','27-10-2017','30-10-2017','Sabar Otnil'),('9','aku','01-01-2017','02-02-2017','kamu');

/*Table structure for table `event_dep_pendidikan__ftie` */

DROP TABLE IF EXISTS `event_dep_pendidikan__ftie`;

CREATE TABLE `event_dep_pendidikan__ftie` (
  `id_event` varchar(3) NOT NULL,
  `nama_event` varchar(25) NOT NULL,
  `start_event` varchar(25) NOT NULL,
  `end_event` varchar(25) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  PRIMARY KEY (`id_event`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `event_dep_pendidikan__ftie` */

insert  into `event_dep_pendidikan__ftie`(`id_event`,`nama_event`,`start_event`,`end_event`,`deskripsi`) values ('1','gathering day','20-10-2017','29-10-2017','Happy'),('11','y','29-01-2017','29-02-2017','ssss'),('13','fds','29-08-2017','29-09-2017','gfdx'),('2','Markaroan','10-11-2017','12-10-2017','Selamat Hans'),('3','Uye','27-10-2017','30-10-2017','Sabar Otnil'),('9','aku','01-01-2017','02-02-2017','kamu');

/*Table structure for table `event_dep_sarpras_ftie` */

DROP TABLE IF EXISTS `event_dep_sarpras_ftie`;

CREATE TABLE `event_dep_sarpras_ftie` (
  `id_event` varchar(3) NOT NULL,
  `nama_event` varchar(25) NOT NULL,
  `start_event` varchar(25) NOT NULL,
  `end_event` varchar(25) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  PRIMARY KEY (`id_event`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `event_dep_sarpras_ftie` */

insert  into `event_dep_sarpras_ftie`(`id_event`,`nama_event`,`start_event`,`end_event`,`deskripsi`) values ('11','y','29-01-2017','29-02-2017','ssss'),('13','fds','29-08-2017','29-09-2017','gfdx'),('2','Markaroan','10-11-2017','12-10-2017','Selamat Hans'),('3','Uye','27-10-2017','30-10-2017','Sabar Otnil'),('9','aku','01-01-2017','02-02-2017','kamu');

/*Table structure for table `event_ftie` */

DROP TABLE IF EXISTS `event_ftie`;

CREATE TABLE `event_ftie` (
  `id_event` varchar(3) NOT NULL,
  `nama_event` varchar(25) NOT NULL,
  `start_event` varchar(25) NOT NULL,
  `end_event` varchar(25) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  PRIMARY KEY (`id_event`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `event_ftie` */

insert  into `event_ftie`(`id_event`,`nama_event`,`start_event`,`end_event`,`deskripsi`) values ('2','Markaroan','10-11-2017','12-10-2017','Selamat Hans'),('9','aku','01-01-2017','02-02-2017','kamu');

/*Table structure for table `fotobemfftie` */

DROP TABLE IF EXISTS `fotobemfftie`;

CREATE TABLE `fotobemfftie` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `foto` blob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `fotobemfftie` */

/*Table structure for table `galeri` */

DROP TABLE IF EXISTS `galeri`;

CREATE TABLE `galeri` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `image` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `galeri` */

insert  into `galeri`(`id`,`title`,`image`) values (2,'orc','warcraft_orc.jpg'),(3,'Matanya bertanduk','sketch_by_thevampiredio.jpg');

/*Table structure for table `mahasiswa_ftie` */

DROP TABLE IF EXISTS `mahasiswa_ftie`;

CREATE TABLE `mahasiswa_ftie` (
  `nim` int(8) NOT NULL,
  `nama` varchar(64) NOT NULL,
  `password` varchar(20) NOT NULL,
  `tempat_lahir` varchar(20) NOT NULL,
  `tanggal_lahir` datetime NOT NULL,
  `role_id` int(2) NOT NULL,
  PRIMARY KEY (`nim`),
  KEY `bemftie3` (`role_id`),
  CONSTRAINT `bemftie3` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mahasiswa_ftie` */

insert  into `mahasiswa_ftie`(`nim`,`nama`,`password`,`tempat_lahir`,`tanggal_lahir`,`role_id`) values (11315000,'Hulli','hul','Bar','2017-01-02 00:00:00',2),(11315012,'Otniel','otniel1','Siantar','1997-12-14 00:00:00',1),(11315013,'Yosua','yosua','Konohagakure','1998-01-03 08:31:56',5),(11315014,'Asido','asido','Medan Perang','1998-01-30 09:16:27',7),(11315015,'Juliana','julee','Arab','1997-02-04 00:00:00',2),(11315021,'Rocto','rocto','Kumogakure','1997-02-27 08:55:16',6),(11315024,'Hans','cuitanmu','Balige','1998-01-01 00:00:00',3),(11315025,'Vedtra','vedtra','Sunagakure','1996-02-02 00:00:00',4);

/*Table structure for table `pengumuman_ftie` */

DROP TABLE IF EXISTS `pengumuman_ftie`;

CREATE TABLE `pengumuman_ftie` (
  `id_pengumuman` varchar(3) NOT NULL,
  `judul` varchar(25) NOT NULL,
  `penulis` varchar(25) NOT NULL,
  `konten` text NOT NULL,
  `status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id_pengumuman`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pengumuman_ftie` */

insert  into `pengumuman_ftie`(`id_pengumuman`,`judul`,`penulis`,`konten`,`status`) values ('11','Read Me','BEM FTIE','Kepada seluruh mahasiswa yang terkasih, diharapkan berkumpul di luar kampus dikarenakan hari sudah libur',1),('12','Makan','Ketua BEM','Dihimbau kepada seluruh mahasiswa agar makan di kantin dengan tertib',NULL),('13','Finding Putri','Ketua BEM','Dimohonkan kepada setiap mahasiswa agar menempati ruang mandiri malamnya masing-masing.\nWaktu mandiri diperpanjang hingga pukul 3 pagi',NULL),('17','PBO_KUIS','[AsdosPBO]','Mahasiswa peserta mata kuliah PBO diharapkan untuk mempersiapkan diri dikarenakan akan diadakan kuis',NULL),('9','New Year','Uvuewevwe onye Ossas','Happy New Year',NULL);

/*Table structure for table `polling` */

DROP TABLE IF EXISTS `polling`;

CREATE TABLE `polling` (
  `polling_id` int(10) NOT NULL AUTO_INCREMENT,
  `option` varchar(30) NOT NULL,
  `poll_category` varchar(20) NOT NULL,
  `poll_amount` int(7) NOT NULL,
  PRIMARY KEY (`polling_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `polling` */

insert  into `polling`(`polling_id`,`option`,`poll_category`,`poll_amount`) values (1,'topi_merah','sample',21),(2,'topi_biru','sample',17),(3,'topi hitam','sample',22);

/*Table structure for table `profilbem_ftie` */

DROP TABLE IF EXISTS `profilbem_ftie`;

CREATE TABLE `profilbem_ftie` (
  `id_profil` int(2) NOT NULL AUTO_INCREMENT,
  `ketua` varchar(20) NOT NULL,
  `wakil_ketua` varchar(20) NOT NULL,
  `visi` varchar(100) NOT NULL,
  `misi1` varchar(100) NOT NULL,
  `misi2` varchar(100) DEFAULT NULL,
  `misi3` varchar(100) DEFAULT NULL,
  `misi4` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_profil`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `profilbem_ftie` */

insert  into `profilbem_ftie`(`id_profil`,`ketua`,`wakil_ketua`,`visi`,`misi1`,`misi2`,`misi3`,`misi4`) values (1,'Ricky Andika','Chandra Hutauruk','Bersama membangun','Menjadikan FTIE sebagai sumber solusi dan aspirasi','Meningkatkan kreativitas dan jiwa kompetitif','Membangun hubungan yang harmonis dan sinergitas baik dalam FTIE','Menjalankan program kerja BEM FTIE sesuai dengan aspirasi');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(2) NOT NULL,
  `role_name` varchar(10) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`role_id`,`role_name`) values (1,'admin'),(2,'ketua_bem'),(3,'mahasiswa'),(4,'kDepHumas'),(5,'kDepSarpra'),(6,'kDepKetert'),(7,'kDepPendid');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
