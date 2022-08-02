-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-08-2022 a las 12:56:09
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestion_pedidos_poderes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_carritocompra`
--

CREATE TABLE `tb_carritocompra` (
  `id` int(11) NOT NULL,
  `fechacreacion` datetime DEFAULT current_timestamp(),
  `tb_cliente_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_carritopoder`
--

CREATE TABLE `tb_carritopoder` (
  `id` int(11) NOT NULL,
  `tb_carritocompra_id` int(11) NOT NULL,
  `tb_poder_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_cliente`
--

CREATE TABLE `tb_cliente` (
  `id` int(11) NOT NULL,
  `documento` int(11) NOT NULL,
  `tipodocumento` int(2) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `celular` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_envio`
--

CREATE TABLE `tb_envio` (
  `id` int(11) NOT NULL,
  `departamento` varchar(100) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `fechaenvio` datetime NOT NULL,
  `empresamensajeria` varchar(100) NOT NULL,
  `estado` varchar(10) NOT NULL,
  `tb_pedido_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_pago`
--

CREATE TABLE `tb_pago` (
  `id` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `modopago` varchar(55) DEFAULT NULL,
  `tb_pedido_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_pedido`
--

CREATE TABLE `tb_pedido` (
  `id` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  `tb_cliente_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_pedidopoder`
--

CREATE TABLE `tb_pedidopoder` (
  `id` int(11) NOT NULL,
  `tb_pedido_id` int(11) NOT NULL,
  `tb_poder_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_poder`
--

CREATE TABLE `tb_poder` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio` double NOT NULL,
  `duracion` int(11) NOT NULL,
  `imagen` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tb_poder`
--

INSERT INTO `tb_poder` (`id`, `nombre`, `precio`, `duracion`, `imagen`) VALUES
(1, 'Volar', 300000, 24, 'volar.png'),
(2, 'Invisibilidad', 500000, 12, 'invisibilidad.png'),
(3, 'Respirar Bajo Agua', 300000, 6, 'respirar.png'),
(4, 'Super Fuerza', 700000, 48, 'fuerza.png'),
(5, 'Super Velocidad', 800000, 12, 'velocidad.png');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_carritocompra`
--
ALTER TABLE `tb_carritocompra`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tb_carritocompra_tb_cliente1_idx` (`tb_cliente_id`);

--
-- Indices de la tabla `tb_carritopoder`
--
ALTER TABLE `tb_carritopoder`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tb_carritocliente_tb_poder1_idx` (`tb_poder_id`),
  ADD KEY `fk_tb_carritocliente_tb_carritocompra1_idx` (`tb_carritocompra_id`);

--
-- Indices de la tabla `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tb_envio`
--
ALTER TABLE `tb_envio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tb_envio_tb_pedido1_idx` (`tb_pedido_id`);

--
-- Indices de la tabla `tb_pago`
--
ALTER TABLE `tb_pago`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tb_pago_tb_pedido1_idx` (`tb_pedido_id`);

--
-- Indices de la tabla `tb_pedido`
--
ALTER TABLE `tb_pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tb_pedido_tb_cliente1_idx` (`tb_cliente_id`);

--
-- Indices de la tabla `tb_pedidopoder`
--
ALTER TABLE `tb_pedidopoder`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tb_pedidocliente_tb_pedido1_idx` (`tb_pedido_id`),
  ADD KEY `fk_tb_pedidocliente_tb_poder1_idx` (`tb_poder_id`);

--
-- Indices de la tabla `tb_poder`
--
ALTER TABLE `tb_poder`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_carritopoder`
--
ALTER TABLE `tb_carritopoder`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_cliente`
--
ALTER TABLE `tb_cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `tb_envio`
--
ALTER TABLE `tb_envio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_pago`
--
ALTER TABLE `tb_pago`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_pedido`
--
ALTER TABLE `tb_pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_pedidopoder`
--
ALTER TABLE `tb_pedidopoder`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_poder`
--
ALTER TABLE `tb_poder`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_carritocompra`
--
ALTER TABLE `tb_carritocompra`
  ADD CONSTRAINT `fk_tb_carritocompra_tb_cliente1` FOREIGN KEY (`tb_cliente_id`) REFERENCES `tb_cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tb_carritopoder`
--
ALTER TABLE `tb_carritopoder`
  ADD CONSTRAINT `fk_tb_carritocliente_tb_carritocompra1` FOREIGN KEY (`tb_carritocompra_id`) REFERENCES `tb_carritocompra` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_carritocliente_tb_poder1` FOREIGN KEY (`tb_poder_id`) REFERENCES `tb_poder` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tb_envio`
--
ALTER TABLE `tb_envio`
  ADD CONSTRAINT `fk_tb_envio_tb_pedido1` FOREIGN KEY (`tb_pedido_id`) REFERENCES `tb_pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tb_pago`
--
ALTER TABLE `tb_pago`
  ADD CONSTRAINT `fk_tb_pago_tb_pedido1` FOREIGN KEY (`tb_pedido_id`) REFERENCES `tb_pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tb_pedido`
--
ALTER TABLE `tb_pedido`
  ADD CONSTRAINT `fk_tb_pedido_tb_cliente1` FOREIGN KEY (`tb_cliente_id`) REFERENCES `tb_cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tb_pedidopoder`
--
ALTER TABLE `tb_pedidopoder`
  ADD CONSTRAINT `fk_tb_pedidocliente_tb_pedido1` FOREIGN KEY (`tb_pedido_id`) REFERENCES `tb_pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_pedidocliente_tb_poder1` FOREIGN KEY (`tb_poder_id`) REFERENCES `tb_poder` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
