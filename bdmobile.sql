-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-12-2016 a las 10:10:51
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bdmobile` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bdmobile`;

--
-- Base de datos: `bdmobile`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `rut_cliente` varchar(11) NOT NULL,
  `clave` varchar(100) NOT NULL,
  `nombre` varchar(10) NOT NULL,
  `apellido_paterno` varchar(15) NOT NULL,
  `apellido_materno` varchar(25) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `numeracion` int(11) NOT NULL,
  `id_comuna` int(20) DEFAULT NULL,
  `telefono` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`rut_cliente`, `clave`, `nombre`, `apellido_paterno`, `apellido_materno`, `direccion`, `numeracion`, `id_comuna`, `telefono`) VALUES
('18467705-9', '202cb962ac59075b964b07152d234b70', 'camilo', 'barahona', 'contreras', 'psj.angamos', 2014, 36, 66019776);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comunas`
--

CREATE TABLE `comunas` (
  `id_comuna` int(11) NOT NULL,
  `nombre_comuna` varchar(35) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `comunas`
--

INSERT INTO `comunas` (`id_comuna`, `nombre_comuna`) VALUES
(1, 'Colina'),
(2, 'Lampa'),
(3, 'Tiltil'),
(4, 'Pirque'),
(5, 'Puente Alto'),
(6, 'San José de Maipo'),
(7, 'Buin'),
(8, 'Calera de Tango'),
(9, 'Paine'),
(10, 'San Bernardo'),
(11, 'Alhué'),
(12, 'Curacaví'),
(13, 'María Pinto'),
(14, 'Melipilla'),
(15, 'San Pedro'),
(16, 'Cerrillos'),
(17, 'Cerro Navia'),
(18, 'Conchalí'),
(19, 'El Bosque'),
(20, 'Estación Central'),
(21, 'Huechuraba'),
(22, 'Independencia'),
(23, 'La Cisterna'),
(24, 'La Granja'),
(25, 'La Florida'),
(26, 'La Pintana'),
(27, 'La Reina'),
(28, 'Las Condes'),
(29, 'Lo Barnechea'),
(30, 'Lo Espejo'),
(31, 'Lo Prado'),
(32, 'Macul'),
(33, 'Maipú'),
(34, 'Ñuñoa'),
(35, 'Pedro Aguirre Cerda'),
(36, 'Peñalolén'),
(37, 'Providencia'),
(38, 'Pudahuel'),
(39, 'Quilicura'),
(40, 'Quinta Normal'),
(41, 'Recoleta'),
(42, 'Renca'),
(43, 'San Miguel'),
(44, 'San Joaquín'),
(45, 'San Ramón'),
(46, 'Santiago'),
(47, 'Vitacura'),
(48, 'El Monte'),
(49, 'Isla de Maipo'),
(50, 'Padre Hurtado'),
(51, 'Peñaflor'),
(52, 'Talagante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuota`
--

CREATE TABLE `cuota` (
  `id_cuota` int(11) NOT NULL,
  `descripcion_cuota` varchar(35) DEFAULT NULL,
  `precio_cuota` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cuota`
--

INSERT INTO `cuota` (`id_cuota`, `descripcion_cuota`, `precio_cuota`) VALUES
(1, '5 Gigas', 4000),
(2, '7 Gigas', 6000),
(3, '10 Gigas', 8000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `minutos`
--

CREATE TABLE `minutos` (
  `id_minutos` int(11) NOT NULL,
  `descripcion_minutos` varchar(35) DEFAULT NULL,
  `precio_minutos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `minutos`
--

INSERT INTO `minutos` (`id_minutos`, `descripcion_minutos`, `precio_minutos`) VALUES
(1, '800', 1000),
(2, '2000', 3000),
(3, '3000', 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

CREATE TABLE `solicitud` (
  `id_solicitud` int(11) NOT NULL,
  `rut_cliente` varchar(11) DEFAULT NULL,
  `id_cuota` int(11) DEFAULT NULL,
  `id_minutos` int(11) DEFAULT NULL,
  `entrega` varchar(100) DEFAULT NULL,
  `total` int(15) DEFAULT NULL,
  `fechaHora` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `solicitud`
--

INSERT INTO `solicitud` (`id_solicitud`, `rut_cliente`, `id_cuota`, `id_minutos`, `entrega`, `total`, `fechaHora`) VALUES
(1, '18467705-9', 1, 2, 'Entrega del Chip a domicilio', 7000, '2016-12-04 04:51:31'),
(2, '18467705-9', 1, 1, 'Retiro del Chip En Sucursal', 5000, '2016-12-04 05:50:14');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`rut_cliente`),
  ADD KEY `id_comuna` (`id_comuna`);

--
-- Indices de la tabla `comunas`
--
ALTER TABLE `comunas`
  ADD PRIMARY KEY (`id_comuna`);

--
-- Indices de la tabla `cuota`
--
ALTER TABLE `cuota`
  ADD PRIMARY KEY (`id_cuota`);

--
-- Indices de la tabla `minutos`
--
ALTER TABLE `minutos`
  ADD PRIMARY KEY (`id_minutos`);

--
-- Indices de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD PRIMARY KEY (`id_solicitud`),
  ADD KEY `rut_cliente` (`rut_cliente`),
  ADD KEY `id_cuota` (`id_cuota`),
  ADD KEY `id_minutos` (`id_minutos`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comunas`
--
ALTER TABLE `comunas`
  MODIFY `id_comuna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;
--
-- AUTO_INCREMENT de la tabla `cuota`
--
ALTER TABLE `cuota`
  MODIFY `id_cuota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `minutos`
--
ALTER TABLE `minutos`
  MODIFY `id_minutos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  MODIFY `id_solicitud` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_comuna`) REFERENCES `comunas` (`id_comuna`);

--
-- Filtros para la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD CONSTRAINT `solicitud_ibfk_1` FOREIGN KEY (`rut_cliente`) REFERENCES `cliente` (`rut_cliente`),
  ADD CONSTRAINT `solicitud_ibfk_2` FOREIGN KEY (`id_cuota`) REFERENCES `cuota` (`id_cuota`),
  ADD CONSTRAINT `solicitud_ibfk_3` FOREIGN KEY (`id_minutos`) REFERENCES `minutos` (`id_minutos`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
