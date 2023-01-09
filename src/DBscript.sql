CREATE DATABASE  IF NOT EXISTS `amgp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `amgp`;

DROP TABLE IF EXISTS `circuito`;
CREATE TABLE `circuito` (
  `idcircuito` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sede` varchar(45) NOT NULL,
  `lunghezza` double NOT NULL,
  `meteo` varchar(45) NOT NULL,
  `tpm` double NOT NULL,
  `rpm` double NOT NULL,
  `umidita` double NOT NULL,
  `ngiri` int(11) NOT NULL,
  `foto` longblob,
  PRIMARY KEY (`idcircuito`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Un Circuito del Campionato.';



DROP TABLE IF EXISTS `curva`;
CREATE TABLE `curva` (
  `idcurva` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `angolo` float NOT NULL,
  `fk_circuito` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcurva`),
  KEY `fk_circuito_idx` (`fk_circuito`),
  CONSTRAINT `fk_circuito` FOREIGN KEY (`fk_circuito`) REFERENCES `circuito` (`idcircuito`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




DROP TABLE IF EXISTS `utente`;
CREATE TABLE `utente` (
  `id` char(14) NOT NULL,
  `password` varchar(125) NOT NULL,
  `ruolo` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Utente del Sistema.';


DROP TABLE IF EXISTS `messaggio`;
CREATE TABLE `messaggio` (
  `idmessaggio` int(11) NOT NULL AUTO_INCREMENT,
  `oggetto` varchar(45) NOT NULL,
  `corpo` mediumtext NOT NULL,
  `idDestinatario` varchar(45) NOT NULL,
  `idMittente` varchar(45) NOT NULL,
  PRIMARY KEY (`idmessaggio`),
  KEY `idMittente_idx` (`idMittente`),
  KEY `idDestinatario_idx` (`idDestinatario`),
  CONSTRAINT `idDestinatario` FOREIGN KEY (`idDestinatario`) REFERENCES `utente` (`id`),
  CONSTRAINT `idMittente` FOREIGN KEY (`idMittente`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Un Messaggio inviato da un Utente ad un altro Utente.';


DROP TABLE IF EXISTS `pilota`;
CREATE TABLE `pilota` (
  `fk_utente` char(14) NOT NULL,
  `punteggio` int(11) NOT NULL,
  `numvittorie` int(11) NOT NULL,
  `numpole` int(11) NOT NULL,
  `numpiazz` int(11) NOT NULL,
  `numritiri` int(11) NOT NULL,
  PRIMARY KEY (`fk_utente`),
  KEY `fk_utente_idx` (`fk_utente`),
  CONSTRAINT `fk_utente` FOREIGN KEY (`fk_utente`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




DROP TABLE IF EXISTS `rettilineo`;
CREATE TABLE `rettilineo` (
  `idrettilineo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `lunghezza` double NOT NULL,
  `fk_circuito` int(11) DEFAULT NULL,
  PRIMARY KEY (`idrettilineo`),
  KEY `fk_circuito_idx` (`fk_circuito`),
  CONSTRAINT `fk_circuito2` FOREIGN KEY (`fk_circuito`) REFERENCES `circuito` (`idcircuito`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Un Rettilineo di un circuito';



DROP TABLE IF EXISTS `setup`;
CREATE TABLE `setup` (
  `idSetup` int(11) NOT NULL AUTO_INCREMENT,
  `caricoaerodinant` double NOT NULL,
  `caricoaerodinpost` double NOT NULL,
  `campanaturaant` double NOT NULL,
  `campanaturapost` double NOT NULL,
  `convergenzaant` double NOT NULL,
  `convergenzapost` double NOT NULL,
  `pressionefreni` double NOT NULL,
  `barraantirollant` double NOT NULL,
  `barraantirollpost` double NOT NULL,
  `userAutore` char(14) NOT NULL,
  `idCircuito` int(11) NOT NULL,
  `date` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idSetup`),
  KEY `idCircuito_idx` (`idCircuito`),
  KEY `userAutore_idx` (`userAutore`),
  CONSTRAINT `idCircuito` FOREIGN KEY (`idCircuito`) REFERENCES `circuito` (`idcircuito`),
  CONSTRAINT `userAutore` FOREIGN KEY (`userAutore`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


