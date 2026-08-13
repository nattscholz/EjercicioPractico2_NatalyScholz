/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  natts
 * Created: 12 ago 2026
 */
DROP DATABASE IF EXISTS medicare;

CREATE DATABASE medicare
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

USE medicare;

-- Tabla de roles
CREATE TABLE rol (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE
);

-- Tabla de usuarios
CREATE TABLE usuario (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150),
    email VARCHAR(200) UNIQUE,
    password VARCHAR(255),
    rol_id BIGINT UNSIGNED,
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (rol_id) REFERENCES rol(id)
);

-- Tabla de citas médicas
CREATE TABLE cita_medica (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    paciente_nombre VARCHAR(150),
    especialidad VARCHAR(100),
    fecha DATE,
    costo DOUBLE,
    activa BOOLEAN DEFAULT TRUE
);

-- Roles requeridos
INSERT INTO rol (nombre)
VALUES
('ADMIN'),
('MEDICO'),
('PACIENTE');

-- Usuarios de prueba
INSERT INTO usuario (
    nombre,
    email,
    password,
    rol_id
)
VALUES
(
    'Admin General',
    'admin@medicare.com',
    '12345',
    1
),
(
    'Dr. Roberto',
    'medico@medicare.com',
    '12345',
    2
),
(
    'Paciente Maria',
    'paciente@medicare.com',
    '12345',
    3
);

-- Citas médicas de prueba
INSERT INTO cita_medica (
    paciente_nombre,
    especialidad,
    fecha,
    costo,
    activa
)
VALUES
(
    'Carlos Gómez',
    'Cardiología',
    '2026-05-10',
    45000.0,
    TRUE
),
(
    'Ana Martínez',
    'Dermatología',
    '2026-06-15',
    35000.0,
    TRUE
);

-- Spring Security utiliza contraseñas BCrypt.
-- Los tres usuarios conservan la contraseña: 12345.
UPDATE usuario
SET password = '$2a$10$ts9LacHi77ppcVeEbwJPz.VZmC4xqqRUBeGndJ85i6dglWoARqQ42'
WHERE id IN (1, 2, 3);
