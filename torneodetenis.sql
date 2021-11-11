-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-11-2021 a las 00:37:22
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `torneodetenis`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadio`
--

CREATE TABLE `estadio` (
  `IDEstadio` int(11) NOT NULL,
  `NumeroIdentificador` int(11) NOT NULL,
  `Ciudad` varchar(30) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  `Estado` tinyint(4) NOT NULL,
  `Largo` double NOT NULL,
  `Ancho` double NOT NULL,
  `CantEspectadores` bigint(20) NOT NULL,
  `Categoria` varchar(15) NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `IDJugador` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `DNI` bigint(20) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Altura` double NOT NULL,
  `Peso` double NOT NULL,
  `Estilo` varchar(40) NOT NULL,
  `Diestro` tinyint(1) NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partido`
--

CREATE TABLE `partido` (
  `IDPartido` int(11) NOT NULL,
  `IDTorneo` int(11) NOT NULL,
  `IDJugador1` int(11) NOT NULL,
  `IDJugador2` int(11) NOT NULL,
  `IDEstadio` int(11) NOT NULL,
  `FechaHora` datetime NOT NULL,
  `Estado` varchar(15) NOT NULL DEFAULT 'Programado',
  `IDJugadorGanador` int(11) DEFAULT NULL,
  `Resultado` varchar(50) DEFAULT NULL,
  `InstanciaTorneo` varchar(20) DEFAULT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patrocinador`
--

CREATE TABLE `patrocinador` (
  `IDPatrocinador` int(11) NOT NULL,
  `Marca` varchar(30) NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patrocinio`
--

CREATE TABLE `patrocinio` (
  `IDPatrocinio` int(11) NOT NULL,
  `IDJugador` int(11) NOT NULL,
  `IDPatrocinador` int(11) NOT NULL,
  `Indumentaria` varchar(20) NOT NULL,
  `FechaIniContrato` date NOT NULL,
  `FechaFinContrato` date NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `torneo`
--

CREATE TABLE `torneo` (
  `IDTorneo` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFinalizacion` date NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estadio`
--
ALTER TABLE `estadio`
  ADD PRIMARY KEY (`IDEstadio`),
  ADD UNIQUE KEY `NumeroIdentificador` (`NumeroIdentificador`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`IDJugador`),
  ADD UNIQUE KEY `DNI` (`DNI`);

--
-- Indices de la tabla `partido`
--
ALTER TABLE `partido`
  ADD PRIMARY KEY (`IDPartido`),
  ADD KEY `IDJugador1` (`IDJugador1`,`IDJugador2`),
  ADD KEY `IDEstadio` (`IDEstadio`,`IDJugadorGanador`),
  ADD KEY `IDJugador2` (`IDJugador2`),
  ADD KEY `IDTorneo` (`IDTorneo`),
  ADD KEY `IDJugadorGanador` (`IDJugadorGanador`);

--
-- Indices de la tabla `patrocinador`
--
ALTER TABLE `patrocinador`
  ADD PRIMARY KEY (`IDPatrocinador`),
  ADD UNIQUE KEY `Marca` (`Marca`);

--
-- Indices de la tabla `patrocinio`
--
ALTER TABLE `patrocinio`
  ADD PRIMARY KEY (`IDPatrocinio`),
  ADD KEY `IDJugador` (`IDJugador`,`IDPatrocinador`),
  ADD KEY `IDPatrocinador` (`IDPatrocinador`);

--
-- Indices de la tabla `torneo`
--
ALTER TABLE `torneo`
  ADD PRIMARY KEY (`IDTorneo`),
  ADD UNIQUE KEY `Nombre` (`Nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estadio`
--
ALTER TABLE `estadio`
  MODIFY `IDEstadio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `IDJugador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=204;

--
-- AUTO_INCREMENT de la tabla `partido`
--
ALTER TABLE `partido`
  MODIFY `IDPartido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT de la tabla `patrocinador`
--
ALTER TABLE `patrocinador`
  MODIFY `IDPatrocinador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `patrocinio`
--
ALTER TABLE `patrocinio`
  MODIFY `IDPatrocinio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT de la tabla `torneo`
--
ALTER TABLE `torneo`
  MODIFY `IDTorneo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `partido`
--
ALTER TABLE `partido`
  ADD CONSTRAINT `partido_ibfk_1` FOREIGN KEY (`IDJugador1`) REFERENCES `jugador` (`IDJugador`),
  ADD CONSTRAINT `partido_ibfk_2` FOREIGN KEY (`IDJugador2`) REFERENCES `jugador` (`IDJugador`),
  ADD CONSTRAINT `partido_ibfk_3` FOREIGN KEY (`IDEstadio`) REFERENCES `estadio` (`IDEstadio`),
  ADD CONSTRAINT `partido_ibfk_4` FOREIGN KEY (`IDTorneo`) REFERENCES `torneo` (`IDTorneo`),
  ADD CONSTRAINT `partido_ibfk_5` FOREIGN KEY (`IDJugadorGanador`) REFERENCES `jugador` (`IDJugador`);

--
-- Filtros para la tabla `patrocinio`
--
ALTER TABLE `patrocinio`
  ADD CONSTRAINT `patrocinio_ibfk_1` FOREIGN KEY (`IDPatrocinador`) REFERENCES `patrocinador` (`IDPatrocinador`),
  ADD CONSTRAINT `patrocinio_ibfk_2` FOREIGN KEY (`IDJugador`) REFERENCES `jugador` (`IDJugador`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
