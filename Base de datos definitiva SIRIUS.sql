CREATE DATABASE  IF NOT EXISTS `playclassbd` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `playclassbd`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: playclassbd
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `IDCurso` int NOT NULL AUTO_INCREMENT,
  `Nombre_Curso` varchar(100) NOT NULL,
  `Imagen_Curso` varchar(100) NOT NULL,
  `IDEscuela` int NOT NULL,
  PRIMARY KEY (`IDCurso`),
  KEY `FK_IDEscuela_cursos_idx` (`IDEscuela`),
  CONSTRAINT `FK_IDEscuela_cursos` FOREIGN KEY (`IDEscuela`) REFERENCES `escuelas` (`IDEscuela`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'Matemáticas','url',1),(2,'Idiomas','url',1),(3,'Historia','url',1),(4,'Tecnología','url',1);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escuelas`
--

DROP TABLE IF EXISTS `escuelas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `escuelas` (
  `IDEscuela` int NOT NULL,
  `Nombre_Escuela` varchar(100) NOT NULL,
  `IDProfesor` int NOT NULL,
  PRIMARY KEY (`IDEscuela`),
  KEY `IDProfesor_FK_escuelas_idx` (`IDProfesor`),
  CONSTRAINT `FK_IDProfesor_escuelas` FOREIGN KEY (`IDProfesor`) REFERENCES `profesores` (`IDProfesor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escuelas`
--

LOCK TABLES `escuelas` WRITE;
/*!40000 ALTER TABLE `escuelas` DISABLE KEYS */;
INSERT INTO `escuelas` VALUES (1,'Play_Class',1);
/*!40000 ALTER TABLE `escuelas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiantes`
--

DROP TABLE IF EXISTS `estudiantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiantes` (
  `IDEstudiante` int NOT NULL AUTO_INCREMENT,
  `Nombre_Estudiante` varchar(100) NOT NULL,
  `Apellido_Estudiante` varchar(45) NOT NULL,
  `Email_Estudiante` varchar(100) NOT NULL,
  `Teléfono` int NOT NULL,
  `Fecha_de_Inicio` date NOT NULL,
  `IDCurso` int NOT NULL,
  PRIMARY KEY (`IDEstudiante`),
  KEY `FK_IDCurso_estudiantes_idx` (`IDCurso`),
  CONSTRAINT `FK_IDCurso_estudiantes` FOREIGN KEY (`IDCurso`) REFERENCES `cursos` (`IDCurso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiantes`
--

LOCK TABLES `estudiantes` WRITE;
/*!40000 ALTER TABLE `estudiantes` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudiantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecciones`
--

DROP TABLE IF EXISTS `lecciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecciones` (
  `IDLeccion` int NOT NULL,
  `Nombre_Leccion` varchar(100) NOT NULL,
  `Descripcion` varchar(200) NOT NULL,
  `Texto_Explicativo` varchar(200) NOT NULL,
  `Imagen_Portada` varchar(100) NOT NULL,
  `Orden_Leccion` varchar(100) NOT NULL,
  `IDModulo` int NOT NULL,
  `Archivo_Adjunto` varchar(200) NOT NULL,
  PRIMARY KEY (`IDLeccion`),
  KEY `FK_IDModulo_lecciones_idx` (`IDModulo`),
  CONSTRAINT `FK_IDModulo_lecciones` FOREIGN KEY (`IDModulo`) REFERENCES `modulos` (`IDModulo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecciones`
--

LOCK TABLES `lecciones` WRITE;
/*!40000 ALTER TABLE `lecciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `lecciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matriculas`
--

DROP TABLE IF EXISTS `matriculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matriculas` (
  `IDMatricula` int NOT NULL,
  `IDEstudiante` int NOT NULL,
  `IDCurso` int NOT NULL,
  `Fecha_Matricula` date NOT NULL,
  PRIMARY KEY (`IDMatricula`),
  KEY `FK_IDEstudiante_matriculas_idx` (`IDEstudiante`),
  KEY `IDCuros_matriculas_idx` (`IDCurso`),
  CONSTRAINT `FK_IDCuros_matriculas` FOREIGN KEY (`IDCurso`) REFERENCES `cursos` (`IDCurso`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_IDEstudiante_matriculas` FOREIGN KEY (`IDEstudiante`) REFERENCES `estudiantes` (`IDEstudiante`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matriculas`
--

LOCK TABLES `matriculas` WRITE;
/*!40000 ALTER TABLE `matriculas` DISABLE KEYS */;
/*!40000 ALTER TABLE `matriculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulos`
--

DROP TABLE IF EXISTS `modulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modulos` (
  `IDModulo` int NOT NULL,
  `Nombre_Modulo` varchar(100) NOT NULL,
  `Nombre_Submodulo` varchar(100) NOT NULL,
  `Orden_Modulo` varchar(100) NOT NULL,
  `Orden_Submodulo` varchar(100) NOT NULL,
  `IDCurso` int NOT NULL,
  PRIMARY KEY (`IDModulo`),
  KEY `IDCurso_modulos_idx` (`IDCurso`),
  CONSTRAINT `IDCurso_modulos` FOREIGN KEY (`IDCurso`) REFERENCES `cursos` (`IDCurso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulos`
--

LOCK TABLES `modulos` WRITE;
/*!40000 ALTER TABLE `modulos` DISABLE KEYS */;
/*!40000 ALTER TABLE `modulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores`
--

DROP TABLE IF EXISTS `profesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesores` (
  `IDProfesor` int NOT NULL,
  `Nombre_Profesor` varchar(100) NOT NULL,
  `Email_Profesor` varchar(100) NOT NULL,
  PRIMARY KEY (`IDProfesor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores`
--

LOCK TABLES `profesores` WRITE;
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
INSERT INTO `profesores` VALUES (1,'Juan','hola@gmail.com');
/*!40000 ALTER TABLE `profesores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-30 20:34:41
