-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-05-2021 a las 10:02:34
-- Versión del servidor: 10.4.10-MariaDB
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_servresidencias`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL,
  `noControl` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidoP` varchar(50) NOT NULL,
  `apellidoM` varchar(50) NOT NULL,
  `nombreCompleto` varchar(150) NOT NULL,
  `correo` varchar(80) NOT NULL,
  `pass` text NOT NULL,
  `preguntaSeg` varchar(100) NOT NULL,
  `respuestaSeg` varchar(100) NOT NULL,
  `foto` varchar(300) NOT NULL,
  `idCarrera` int(11) NOT NULL,
  `idSistema` int(11) NOT NULL,
  `idCampus` int(11) NOT NULL,
  `created_atAlumno` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`idAlumno`, `noControl`, `nombre`, `apellidoP`, `apellidoM`, `nombreCompleto`, `correo`, `pass`, `preguntaSeg`, `respuestaSeg`, `foto`, `idCarrera`, `idSistema`, `idCampus`, `created_atAlumno`) VALUES
(10, '142Z0469', 'Josue', 'Cruz', 'Santiago', 'Josue Cruz Santiago', 'j_cruz1997@outlook.es', 'c62dfd15def5665bb581c551874de6a1', '', '', '', 1, 1, 2, '2019-11-12 05:57:41'),
(12, '152Z0177', 'Emir ', 'Morales', 'Rivera', 'Emir  Morales Rivera', 'emir01417@gmail.com', '58a0c91a80d710de88a216368487ab79', '', '', '', 1, 1, 2, '2019-11-12 06:03:30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora_errores`
--

CREATE TABLE `bitacora_errores` (
  `idError` int(11) NOT NULL,
  `tipoError` varchar(50) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ubicacion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora_eventos`
--

CREATE TABLE `bitacora_eventos` (
  `idEvento` int(11) NOT NULL,
  `tipo_evento` varchar(50) NOT NULL,
  `tabla` varchar(30) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `idElemento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bitacora_eventos`
--

INSERT INTO `bitacora_eventos` (`idEvento`, `tipo_evento`, `tabla`, `fecha`, `idElemento`) VALUES
(1, 'Consulta', 'documentacion', '0000-00-00 00:00:00', 0),
(2, 'Consulta', 'documentacion', '0000-00-00 00:00:00', 0),
(3, 'eliminacion', 'alumno', '0000-00-00 00:00:00', 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora_usuarios`
--

CREATE TABLE `bitacora_usuarios` (
  `idLog` int(11) NOT NULL,
  `fecha` int(11) NOT NULL,
  `descripcion` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `campus`
--

CREATE TABLE `campus` (
  `idCampus` int(11) NOT NULL,
  `nombreCampus` varchar(50) NOT NULL,
  `created_atCampus` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `campus`
--

INSERT INTO `campus` (`idCampus`, `nombreCampus`, `created_atCampus`) VALUES
(1, 'Alamo ', '2019-11-12 05:23:30'),
(2, 'Xoyotitla', '2019-11-12 05:23:30'),
(5, 'Tuxpan ', '2019-11-12 05:23:30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera`
--

CREATE TABLE `carrera` (
  `idCarrera` int(11) NOT NULL,
  `nombreCarrera` varchar(100) NOT NULL,
  `created_atCarrera` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `carrera`
--

INSERT INTO `carrera` (`idCarrera`, `nombreCarrera`, `created_atCarrera`) VALUES
(1, 'Ingenieria en Sistemas Computacionales ', '2019-11-12 05:23:55'),
(2, 'Ingenieria Ambiental  ', '2019-11-12 05:23:55'),
(3, 'Ingenieria Industrial', '2019-11-12 05:23:55'),
(9, 'Ingenieria en Industrias alimentarias', '2019-11-12 05:23:55');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documentacion`
--

CREATE TABLE `documentacion` (
  `idDocumento` int(11) NOT NULL,
  `observaciones` varchar(500) NOT NULL,
  `status` varchar(30) NOT NULL,
  `fechaEntrega` varchar(20) NOT NULL,
  `fechaRegistro` varchar(20) NOT NULL,
  `archivo` varchar(300) NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `idTipoDoc` int(11) NOT NULL,
  `created_atDocumentacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sistema`
--

CREATE TABLE `sistema` (
  `idSistema` int(11) NOT NULL,
  `nombreSistema` varchar(50) NOT NULL,
  `created_atSistema` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sistema`
--

INSERT INTO `sistema` (`idSistema`, `nombreSistema`, `created_atSistema`) VALUES
(1, 'Sistema Escolarizado', '2019-11-12 05:25:16'),
(2, 'Sistema Abierto', '2019-11-12 05:25:16');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_documento`
--

CREATE TABLE `tipo_documento` (
  `idTipoDoc` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `created_atTipoDoc` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_documento`
--

INSERT INTO `tipo_documento` (`idTipoDoc`, `descripcion`, `created_atTipoDoc`) VALUES
(1, 'Formato1', '2019-11-12 06:04:06');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `idTipoU` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `created_atTipoU` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`idTipoU`, `tipo`, `created_atTipoU`) VALUES
(1, 'Administrador', '0000-00-00 00:00:00'),
(2, 'Auxiliar', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUser` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` text NOT NULL,
  `nombreUser` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `preguntaSeg` varchar(100) NOT NULL,
  `respuestaSeg` varchar(100) NOT NULL,
  `foto` varchar(500) NOT NULL,
  `status` varchar(50) NOT NULL,
  `idTipoU` int(11) NOT NULL,
  `created_atUsuarios` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUser`, `username`, `password`, `nombreUser`, `email`, `preguntaSeg`, `respuestaSeg`, `foto`, `status`, `idTipoU`, `created_atUsuarios`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', 'j_cruz1997@hotmail.com', '¿Mascota favorita?', 'Rex', 'admin14222315_966538076808003_1042312230962088220_n.jpg', '', 1, '2019-11-12 05:28:09'),
(2, 'Joshuak500', '21232f297a57a5a743894a0e4a801fc3\r\n', 'Josue Cruz Santiagoo', 'j_cruz1997@outlook.es', '¿Primera mascota?', 'Rexx', '', 'Activo', 1, '2019-11-12 05:28:09');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`idAlumno`),
  ADD KEY `idCarrera` (`idCarrera`),
  ADD KEY `idSistema` (`idSistema`),
  ADD KEY `idCampus` (`idCampus`);

--
-- Indices de la tabla `bitacora_errores`
--
ALTER TABLE `bitacora_errores`
  ADD PRIMARY KEY (`idError`);

--
-- Indices de la tabla `bitacora_eventos`
--
ALTER TABLE `bitacora_eventos`
  ADD PRIMARY KEY (`idEvento`),
  ADD KEY `idElemento` (`idElemento`);

--
-- Indices de la tabla `bitacora_usuarios`
--
ALTER TABLE `bitacora_usuarios`
  ADD PRIMARY KEY (`idLog`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `campus`
--
ALTER TABLE `campus`
  ADD PRIMARY KEY (`idCampus`);

--
-- Indices de la tabla `carrera`
--
ALTER TABLE `carrera`
  ADD PRIMARY KEY (`idCarrera`);

--
-- Indices de la tabla `documentacion`
--
ALTER TABLE `documentacion`
  ADD PRIMARY KEY (`idDocumento`),
  ADD KEY `idAlumno` (`idAlumno`),
  ADD KEY `idUser` (`idUser`),
  ADD KEY `idTipoDoc` (`idTipoDoc`);

--
-- Indices de la tabla `sistema`
--
ALTER TABLE `sistema`
  ADD PRIMARY KEY (`idSistema`);

--
-- Indices de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  ADD PRIMARY KEY (`idTipoDoc`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`idTipoU`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUser`),
  ADD KEY `idTipoU` (`idTipoU`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `bitacora_errores`
--
ALTER TABLE `bitacora_errores`
  MODIFY `idError` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `bitacora_eventos`
--
ALTER TABLE `bitacora_eventos`
  MODIFY `idEvento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `bitacora_usuarios`
--
ALTER TABLE `bitacora_usuarios`
  MODIFY `idLog` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `campus`
--
ALTER TABLE `campus`
  MODIFY `idCampus` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `carrera`
--
ALTER TABLE `carrera`
  MODIFY `idCarrera` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `documentacion`
--
ALTER TABLE `documentacion`
  MODIFY `idDocumento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sistema`
--
ALTER TABLE `sistema`
  MODIFY `idSistema` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  MODIFY `idTipoDoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `idTipoU` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
