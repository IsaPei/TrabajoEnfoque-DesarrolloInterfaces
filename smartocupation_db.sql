-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-01-2026 a las 09:27:23
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `smartocupation_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alquileres`
--

CREATE TABLE `alquileres` (
  `id_alquiler` int(11) NOT NULL,
  `id_vivienda` int(11) NOT NULL,
  `num_expediente` int(11) NOT NULL,
  `fecha_entrada` date DEFAULT NULL,
  `tiempo_estimado` int(11) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `nombre_cliente` varchar(40) NOT NULL,
  `dni_cliente` varchar(9) DEFAULT NULL,
  `correo_cliente` varchar(100) NOT NULL,
  `telefono_cliente` int(9) NOT NULL,
  `facturacion` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alquileres`
--

INSERT INTO `alquileres` (`id_alquiler`, `id_vivienda`, `num_expediente`, `fecha_entrada`, `tiempo_estimado`, `estado`, `nombre_cliente`, `dni_cliente`, `correo_cliente`, `telefono_cliente`, `facturacion`) VALUES
(8001, 4001, 400210, '2025-01-13', 12, 'pagado', 'Federica García', '12312312F', 'federica80garcia@gmail.com', 658469371, 8400.00),
(8002, 4002, 400211, '2025-10-25', 12, 'sin pagar', 'Mercedes Perez', '45645645M', 'mercedes95perez@gmail.com', 657125489, 7440.00),
(8003, 4003, 400212, '2025-09-23', 12, 'pagado', 'Ignacio Ruiz', '78978978I', 'ignacio70ruiz@gmail.com', 686496273, 10206.00),
(8004, 4004, 400213, '2025-11-04', 12, 'pagado', 'Camila Blazquez', '14714714C', 'camila84blazquez@gmail.com', 616743985, 7680.00),
(8005, 4005, 400214, '2025-09-18', 12, 'pagado', 'Armando Velazquez', '25825825A', 'armando68velazquez@gmail.com', 664912735, 8640.00),
(8006, 4006, 400215, '2025-02-14', 12, 'pagado', 'Sagrario Gomez', '36936936S', 'sagrario79gomez@gmail.com', 634368227, 11760.00),
(8007, 4007, 400216, '2025-08-23', 12, 'pagado', 'Fernando Martinez', '15915915F', 'fernando87martinez@gmail.com', 634675575, 7446.00),
(8008, 4008, 400217, '2025-11-08', 12, 'pagado', 'Lorenzo Torres', '35735735L', 'lorenzo72torres@gmail.com', 694247646, 10200.00),
(8009, 4009, 400218, '2025-09-07', 12, 'sin pagar', 'Andrea Alonso', '84284284A', 'andrea94alonso@gmail.com', 618157449, 8640.00),
(8010, 4010, 400219, '2025-07-11', 12, 'sin pagar', 'Pedro Fernandez', '64964964P', 'pedro99fernandez@gmail.com', 634978215, 14400.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vivienda`
--

CREATE TABLE `vivienda` (
  `id_vivienda` int(11) NOT NULL,
  `cod_referencia` varchar(100) NOT NULL,
  `ubicacion` varchar(100) NOT NULL,
  `metros_cuadrados` int(11) NOT NULL,
  `num_habitaciones` int(11) DEFAULT NULL,
  `num_banos` int(11) DEFAULT NULL,
  `precio_mes` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vivienda`
--

INSERT INTO `vivienda` (`id_vivienda`, `cod_referencia`, `ubicacion`, `metros_cuadrados`, `num_habitaciones`, `num_banos`, `precio_mes`) VALUES
(4001, 'v6001', 'Calle El padrino 4', 80, 3, 1, 700),
(4002, 'v6002', 'Calle Casablanca 24', 65, 2, 1, 620),
(4003, 'v6003', 'Calle Matrix 13', 95, 3, 2, 850.5),
(4004, 'v6004', 'Calle Amelie 44', 75, 2, 1, 640),
(4005, 'v6005', 'Calle Star Wars 38', 85, 3, 1, 720),
(4006, 'v6006', 'Calle Toy Story 9', 95, 3, 2, 980),
(4007, 'v6007', 'Calle Cantando bajo la lluvia, 52', 65, 1, 2, 620.5),
(4008, 'v6008', 'Calle Requiem por un sueño, 20', 80, 2, 2, 850),
(4009, 'v6009', 'Calle El submarino, 81', 75, 3, 1, 720),
(4010, 'v6010', 'Calle Coco, 17', 100, 3, 2, 1200);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alquileres`
--
ALTER TABLE `alquileres`
  ADD PRIMARY KEY (`id_alquiler`),
  ADD KEY `fk_alquileres_vivienda` (`id_vivienda`);

--
-- Indices de la tabla `vivienda`
--
ALTER TABLE `vivienda`
  ADD PRIMARY KEY (`id_vivienda`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alquileres`
--
ALTER TABLE `alquileres`
  ADD CONSTRAINT `fk_alquileres_vivienda` FOREIGN KEY (`id_vivienda`) REFERENCES `vivienda` (`id_vivienda`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
