-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-01-2022 a las 08:56:31
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `salud`
--
CREATE DATABASE IF NOT EXISTS `salud` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `salud`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ambulatorios`
--

DROP TABLE IF EXISTS `ambulatorios`;
CREATE TABLE `ambulatorios` (
  `ncodigo` int(11) NOT NULL,
  `cnombre` varchar(50) NOT NULL,
  `cdireccion` varchar(100) NOT NULL,
  `ctelefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
CREATE TABLE `pacientes` (
  `nsip` int(11) NOT NULL,
  `cnombre` varchar(20) NOT NULL,
  `capellidos` varchar(50) NOT NULL,
  `nedad` int(11) NOT NULL,
  `nambulatorio` int(11) NOT NULL,
  `bfoto` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacunas`
--

DROP TABLE IF EXISTS `vacunas`;
CREATE TABLE `vacunas` (
  `ncodigo` int(11) NOT NULL,
  `cnombre` varchar(50) NOT NULL,
  `bcomposicion` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vacunas`
--

INSERT INTO `vacunas` (`ncodigo`, `cnombre`, `bcomposicion`) VALUES
(1, 'Varicela', 0xaced0005737200134d6f64656c6f732e436f6d706f736963696f6e0f2f6e17033d786902000449000863616e746964616449000e706f7263656e74616a65426173654c0004626173657400124c6a6176612f6c616e672f537472696e673b4c000f7072696e636970696f41637469766f71007e00017870000000170000000a740007616c636f686f6c74000b616c656772696e65646f6c),
(2, 'Moderna', 0xaced0005737200134d6f64656c6f732e436f6d706f736963696f6e0f2f6e17033d786902000449000863616e746964616449000e706f7263656e74616a65426173654c0004626173657400124c6a6176612f6c616e672f537472696e673b4c000f7072696e636970696f41637469766f71007e000178700000005700000019740007616c636f686f6c740009616e7469636f766964),
(3, 'Gripe', 0xaced0005737200134d6f64656c6f732e436f6d706f736963696f6e0f2f6e17033d786902000449000863616e746964616449000e706f7263656e74616a65426173654c0004626173657400124c6a6176612f6c616e672f537472696e673b4c000f7072696e636970696f41637469766f71007e000178700000001c00000013740007616c636f686f6c740003726f6e);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna_paciente`
--

DROP TABLE IF EXISTS `vacuna_paciente`;
CREATE TABLE `vacuna_paciente` (
  `npaciente` int(11) NOT NULL,
  `nvacuna` int(11) NOT NULL,
  `ndosis` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ambulatorios`
--
ALTER TABLE `ambulatorios`
  ADD PRIMARY KEY (`ncodigo`);

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`nsip`),
  ADD KEY `nambulatorio` (`nambulatorio`);

--
-- Indices de la tabla `vacunas`
--
ALTER TABLE `vacunas`
  ADD PRIMARY KEY (`ncodigo`);

--
-- Indices de la tabla `vacuna_paciente`
--
ALTER TABLE `vacuna_paciente`
  ADD PRIMARY KEY (`npaciente`,`nvacuna`),
  ADD KEY `vacuna_paciente_ibfk_2` (`nvacuna`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `vacunas`
--
ALTER TABLE `vacunas`
  MODIFY `ncodigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD CONSTRAINT `pacientes_ibfk_1` FOREIGN KEY (`nambulatorio`) REFERENCES `ambulatorios` (`ncodigo`);

--
-- Filtros para la tabla `vacuna_paciente`
--
ALTER TABLE `vacuna_paciente`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`npaciente`) REFERENCES `pacientes` (`nsip`),
  ADD CONSTRAINT `fk2` FOREIGN KEY (`nvacuna`) REFERENCES `vacunas` (`ncodigo`);
COMMIT;
