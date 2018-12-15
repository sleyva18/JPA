-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-12-2018 a las 16:44:42
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `notas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `CODPER` int(11) NOT NULL,
  `NOMPER` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `APEPER` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `DNIPER` char(8) COLLATE utf8_unicode_ci NOT NULL,
  `DIRPER` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`CODPER`, `NOMPER`, `APEPER`, `DNIPER`, `DIRPER`) VALUES
(1, 'Sebastian Randoll', 'Leyva Chumpitaz', '73183531', 'Jr. San Pablo Mz. 1'),
(2, 'Antonio	Araveli', 'Araujo Veliz', '73183532', 'Jr. San Pablo Mz. 2'),
(3, 'Cristhian	Alexánder ', 'Antonio Alcalá', '73183533', 'Jr. San Pablo Mz. 3'),
(4, 'Daniel Emilio', 'QUISPE MARTINEZ', '73183534', 'Jr. San Pablo Mz. 3'),
(5, 'Joel	Antonio', 'Cuadros Mesajil', '73183535', 'Jr. San Pablo Mz. 5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clase`
--

CREATE TABLE `clase` (
  `CODCLAS` int(11) NOT NULL,
  `CODCUREDET` int(11) NOT NULL,
  `CODPER_ALU` int(11) NOT NULL,
  `NOTACLAS` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `FECHCLAS` date NOT NULL,
  `ASISCLAS` char(1) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `clase`
--

INSERT INTO `clase` (`CODCLAS`, `CODCUREDET`, `CODPER_ALU`, `NOTACLAS`, `FECHCLAS`, `ASISCLAS`) VALUES
(1, 1, 1, '14', '2018-12-14', 'A'),
(2, 2, 1, '0', '2018-12-14', 'F'),
(3, 3, 1, '16', '2018-12-14', 'A'),
(4, 1, 2, '17', '2018-12-13', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `CODCUR` int(11) NOT NULL,
  `NOMCUR` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`CODCUR`, `NOMCUR`) VALUES
(1, 'Taller de programación'),
(2, 'Liderazgo y trabajo en equipo'),
(3, 'Sistema distribuido');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso_det`
--

CREATE TABLE `curso_det` (
  `CODCUREDET` int(11) NOT NULL,
  `CODCUR` int(11) NOT NULL,
  `CODPROF` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `curso_det`
--

INSERT INTO `curso_det` (`CODCUREDET`, `CODCUR`, `CODPROF`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `CODPROF` int(11) NOT NULL,
  `NOMPROF` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `APEPROF` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `DNIPROF` char(8) COLLATE utf8_unicode_ci NOT NULL,
  `DIRPROF` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`CODPROF`, `NOMPROF`, `APEPROF`, `DNIPROF`, `DIRPROF`) VALUES
(1, 'Giancarlo', 'Valencia Sotomayor', '73183536', 'Jr. San Pablo Mz. 6'),
(2, 'Luis', 'Manzo Candela', '73183537', 'Jr. San Pablo Mz. 7'),
(3, 'Jesus ', 'Canales Guando', '73183538', 'Jr. San Pablo Mz. 8');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `CODUSU` int(11) NOT NULL,
  `USUUSU` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `PASUSU` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`CODUSU`, `USUUSU`, `PASUSU`) VALUES
(1, 'admin', 'admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`CODPER`);

--
-- Indices de la tabla `clase`
--
ALTER TABLE `clase`
  ADD PRIMARY KEY (`CODCLAS`),
  ADD KEY `CLAS_CUR_DET_COD` (`CODCUREDET`),
  ADD KEY `CLAS_PER_CODPER_ALU` (`CODPER_ALU`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`CODCUR`);

--
-- Indices de la tabla `curso_det`
--
ALTER TABLE `curso_det`
  ADD PRIMARY KEY (`CODCUREDET`),
  ADD KEY `CURSO_DET_PROF_CODPROF` (`CODPROF`),
  ADD KEY `CUR_DET_CURSO_CODCUR` (`CODCUR`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`CODPROF`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`CODUSU`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clase`
--
ALTER TABLE `clase`
  ADD CONSTRAINT `CLAS_CUR_DET_COD` FOREIGN KEY (`CODCUREDET`) REFERENCES `curso_det` (`CODCUREDET`),
  ADD CONSTRAINT `CLAS_PER_CODPER_ALU` FOREIGN KEY (`CODPER_ALU`) REFERENCES `alumno` (`CODPER`);

--
-- Filtros para la tabla `curso_det`
--
ALTER TABLE `curso_det`
  ADD CONSTRAINT `CURSO_DET_PROF_CODPROF` FOREIGN KEY (`CODPROF`) REFERENCES `profesor` (`CODPROF`),
  ADD CONSTRAINT `CUR_DET_CURSO_CODCUR` FOREIGN KEY (`CODCUR`) REFERENCES `curso` (`CODCUR`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
