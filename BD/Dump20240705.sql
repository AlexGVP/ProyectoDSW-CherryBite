CREATE DATABASE IF NOT EXISTS `cherrybite`;
USE `cherrybite`;

DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `idrol` int NOT NULL AUTO_INCREMENT,
  `nomrol` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
);
INSERT INTO `rol` VALUES (1,'ADMIN'),(2,'Usuario'),(3,'Editor');

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `nomusuario` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `password` varchar(300) DEFAULT NULL,
  `nombres` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
);
INSERT INTO `usuario` VALUES 
(1,'admin','usuario1@example.com','$2a$12$K.SIpaz1KmHTClcRhc1.2u1hkXQpRXhp0o3x6CkHaIkglK3waZSeG','Gibeth','Peña',1),
(2,'ale','usuario2@example.com','$2a$12$s0P1m1lLD7l7bKKDYnwTZOb3HEkX/kbBUsAsTRbhliQ8B.2sGcMEO','María','Querevalu',1),
(3,'maria','usuario3@example.com','$2a$12$VTfCXTWnGcBV6G5.nYowgODiHF8m2bzj8jDbzisLDnwfakwd4nBVS','Alexandra','Vilchez',1);

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `idcategoria` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcategoria`)
);
INSERT INTO `categoria` VALUES (1,'Estudios'),(2,'Salud'),(3,'Ejercicio'),(4,'Cocina'),(5,'Entretenimiento');

DROP TABLE IF EXISTS `grupoalimento`;
CREATE TABLE `grupoalimento` (
  `idgrupoalimento` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idgrupoalimento`)
);
INSERT INTO `grupoalimento` VALUES 
(1,'Frutas'),(2,'Cereales'),(3,'Carnes blancas'),(4,'Lácteos'),(5,'Huevos y lácteos'),
(6,'Verduras'),(7,'Pastas'),(8,'Productos lácteos'),(9,'Pescados y mariscos'),
(10,'Frutas tropicales'),(11,'Carnes rojas'),(12,'Cereales integrales'),(13,'Frutos secos'),
(14,'Vegetales'),(15,'Pan y cereales');

DROP TABLE IF EXISTS `unidadmedida`;
CREATE TABLE `unidadmedida` (
  `idunidadmedida` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idunidadmedida`)
);
INSERT INTO `unidadmedida` VALUES (1,'gramo'),(2,'unidad'),(3,'mililitro');

DROP TABLE IF EXISTS `valornutricional`;
CREATE TABLE `valornutricional` (
  `idvalornutricional` int NOT NULL AUTO_INCREMENT,
  `calorias` decimal(10,2) DEFAULT NULL,
  `proteinas` decimal(10,2) DEFAULT NULL,
  `grasas` decimal(10,2) DEFAULT NULL,
  `carbohidratos` decimal(10,2) DEFAULT NULL,
  `colesterol` decimal(10,2) DEFAULT NULL,
  `sodio` decimal(10,2) DEFAULT NULL,
  `potasio` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idvalornutricional`)
);
INSERT INTO `valornutricional` VALUES 
(1,50.00,2.00,0.50,12.00,0.10,5.00,100.00),(2,120.00,3.00,1.00,25.00,0.20,10.00,150.00),
(3,180.00,25.00,10.00,5.00,0.50,15.00,200.00),(4,90.00,8.00,4.00,15.00,0.30,8.00,120.00),
(5,70.00,6.00,3.00,10.00,0.20,6.00,80.00),(6,30.00,2.00,0.50,5.00,0.10,3.00,50.00),
(7,200.00,12.00,5.00,30.00,0.40,12.00,180.00),(8,150.00,20.00,8.00,10.00,0.30,10.00,160.00),
(9,250.00,30.00,15.00,5.00,0.60,18.00,250.00),(10,60.00,4.00,1.50,10.00,0.20,4.00,70.00),
(11,180.00,22.00,9.00,20.00,0.50,14.00,220.00),(12,160.00,18.00,7.00,25.00,0.40,12.00,200.00),
(13,50.00,3.00,2.00,5.00,0.10,5.00,60.00),(14,40.00,2.00,1.00,7.00,0.10,3.00,40.00),
(15,100.00,5.00,3.00,15.00,0.30,6.00,90.00);

DROP TABLE IF EXISTS `alimento`;
CREATE TABLE `alimento` (
  `idalimento` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `porcion` int DEFAULT NULL,
  `idgrupoalimento` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `imagen` varchar(500) DEFAULT NULL,
  `idvalornutricional` int NOT NULL,
  `idunidadmedida` int NOT NULL,
  PRIMARY KEY (`idalimento`),
  KEY `idgrupoalimento` (`idgrupoalimento`),
  KEY `idvalornutricional` (`idvalornutricional`),
  CONSTRAINT `alimento_ibfk_1` FOREIGN KEY (`idgrupoalimento`) REFERENCES `grupoalimento` (`idgrupoalimento`),
  CONSTRAINT `alimento_ibfk_2` FOREIGN KEY (`idvalornutricional`) REFERENCES `valornutricional` (`idvalornutricional`),
  CONSTRAINT `alimento_ibfk_3` FOREIGN KEY (`idunidadmedida`) REFERENCES `unidadmedida` (`idunidadmedida`)
);
INSERT INTO `alimento` VALUES 
(1,'Manzana',1,1,'Fruta fresca','https://www.prensalibre.com/wp-content/uploads/2023/12/Beneficios-de-comer-una-manzana-diaria.jpg?quality=52',1,2),
(2,'Arroz',50,2,'Arroz blanco cocido','https://cdn.recetasderechupete.com/wp-content/uploads/2023/02/Arroz-sin-almidon.jpg',2,1),
(3,'Pechuga de pollo',100,3,'Pechuga de pollo a la plancha','https://www.recetasderechupete.com/wp-content/uploads/2022/07/Pollo-cocido.jpg',3,1),
(4,'Leche',200,4,'Leche semidesnatada','https://upload.wikimedia.org/wikipedia/commons/0/0e/Milk_glass.jpg',4,3),
(5,'Huevo',1,5,'Huevo cocido','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRn_Hwo9EKUuwIKOU7i3ot38x0ISURkLOF6BQ&usqp=CAU',5,2),
(6,'Zanahoria',2,6,'Zanahoria fresca','https://www.buenosalimentos.com.ar/media/k2/items/cache/91c1689c8fa0c7c1a5a12bde3a37d86e_XL.jpg',6,2),
(7,'Pasta',100,7,'Pasta integral','https://www.rebanando.com/media/pasta-integral_crop.jpg',7,1),
(8,'Yogur',150,8,'Yogur natural','https://estaticos.miarevista.es/media/cache/1140x_thumb/uploads/images/article/60b5a9445bafe83924ec9a00/yogur-natural.jpg',8,1),
(9,'Salmón',120,9,'Salmón a la plancha','https://content-cocina.lecturas.com/medio/2023/07/07/como-hacer-salmon-a-la-plancha_59aeb993_1280x720.jpg',9,1),
(10,'Mango',1,10,'Mango maduro','https://www.lavanguardia.com/files/image_449_220/files/fp/uploads/2022/09/16/6324ff625b7c2.r_d.1939-1331-2390.jpeg',10,2);

DROP TABLE IF EXISTS `habito`;
create table habito
( 
	idhabito             int not null primary key auto_increment,
	descripcion          varchar(45),
	idcategoria          int not null,
	frecuencia           varchar(20),
	horadia              time,
	fechainicio          date,
	fechafin             date,
	progreso             int,
	foreign key (idcategoria) references categoria(idcategoria)
);
INSERT INTO habito (idhabito,descripcion, idcategoria, frecuencia, horadia, fechainicio, fechafin, progreso) VALUES
    (1,'Hábito 1', 1, 'Diario', '08:00:00', '2023-01-01', null, 50),
    (2,'Hábito 2', 2, 'Semanal', '20:00:00', '2023-01-02', '2023-12-31', 75),
    (3,'Hábito 3', 3, 'Diario', '10:00:00', '2023-01-03', '2023-06-30', 60),
    (4,'Hábito 4', 4, 'Quincenal', '09:00:00', '2023-01-04', null, 40),
    (5,'Hábito 5', 5, 'Semanal', '18:00:00', '2023-01-05', '2023-11-30', 80),
    (6,'Hábito 6', 1, 'Diario', '07:00:00', '2023-01-06', '2023-07-31', 55),
    (7,'Hábito 7', 2, 'Mensual', '12:00:00', '2023-01-07', null, 70),
    (8,'Hábito 8', 3, 'Semanal', '19:00:00', '2023-01-08', '2023-10-31', 85),
    (9,'Hábito 9', 4, 'Diario', '06:00:00', '2023-01-09', '2023-08-31', 65),
    (10,'Hábito 10', 5, 'Mensual', '14:00:00', '2023-01-10', null, 45),
    (11,'Hábito 11', 1, 'Semanal', '17:00:00', '2023-01-11', '2023-09-30', 90),
    (12,'Hábito 12', 2, 'Diario', '11:00:00', '2023-01-12', '2023-07-31', 58),
    (13,'Hábito 13', 3, 'Quincenal', '15:00:00', '2023-01-13', null, 35),
    (14,'Hábito 14', 4, 'Semanal', '16:00:00', '2023-01-14', '2023-12-31', 72),
    (15,'Hábito 15', 5, 'Diario', '13:00:00', '2023-01-15', '2023-08-31', 68);

DROP TABLE IF EXISTS `noticia`;
create table noticia
( 
	idnoticia             int not null primary key auto_increment,
	titulo          varchar(45),
	descripcion      varchar(300),
	imagen           varchar(500),
	fecha              date
);
INSERT INTO noticia (titulo, descripcion, imagen, fecha) VALUES
('Beneficios de la Manzana', 'Descubre cómo una manzana al día puede mejorar tu salud.', 'https://www.prensalibre.com/wp-content/uploads/2023/12/Beneficios-de-comer-una-manzana-diaria.jpg?quality=52', '2024-06-01'),
('Superalimentos para el Corazón', 'Alimentos que ayudan a mantener un corazón saludable.', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPzSNQ0ax-kxlZ67FTmwJH6tD_WH2Aj_f5WQ&s', '2024-06-02'),
('Dieta Mediterránea', 'Conoce los beneficios de seguir una dieta mediterránea.', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRiTfirl8DCQr5lnOgYK3p7uBuF7r15y1Ok8Q&s', '2024-06-03'),
('Importancia del Desayuno', '¿Por qué no debes saltarte el desayuno?', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4-tRDfGjZQBaMaALcEm30KuKvJFid4KX7YA&s', '2024-06-04'),
('Alimentos Ricos en Fibra', 'Mejora tu digestión con estos alimentos ricos en fibra.', 'https://i.blogs.es/7dcb4a/fruta-fibra/1366_2000.jpg', '2024-06-05'),
('Reducir el Consumo de Azúcar', 'Consejos para reducir la ingesta de azúcar en tu dieta.', 'https://elcomercio.pe/resizer/873uMQW9ndmWoLXCRvdXTahqMSc=/1200x900/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/A35OONAGORGL3O3S76JMSYH5IQ.jpg', '2024-06-06'),
('Beneficios del Té Verde', 'El té verde y sus propiedades antioxidantes.', 'https://static.tuasaude.com/media/article/yp/dt/beneficios-del-te-verde_17350_l.jpg', '2024-06-07'),
('Pescado: Fuente de Omega-3', 'La importancia de incluir pescado en tu dieta.', 'https://esenciadelmar.es/wp-content/uploads/2023/08/formas-cocinar-pescado-1200x700.jpg', '2024-06-08'),
('Frutas Cítricas y la Vitamina C', 'Cómo las frutas cítricas fortalecen tu sistema inmunológico.', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWi9O5Ho88H0lJngzIPCFUapMDSmzsudXHBg&s', '2024-06-09'),
('Hidratación Adecuada', 'La importancia de mantener una buena hidratación.', 'https://www.pescanova.pe/wp-content/uploads/2021/08/como-hidratarse-en-el-verano-1.jpg', '2024-06-10'),
('Vegetales de Hoja Verde', 'Beneficios de los vegetales de hoja verde en tu dieta.', 'https://www.lavanguardia.com/files/og_thumbnail/uploads/2016/07/15/5fa2cf97121ce.jpeg', '2024-06-11'),
('Comida Rápida Saludable', 'Opciones de comida rápida que no perjudican tu salud.', 'https://www.clarin.com/2022/08/17/QoyfI4ouM_2000x1500__1.jpg', '2024-06-12'),
('Nueces y Semillas', 'Incluye nueces y semillas en tu dieta diaria.', 'https://www.revistamoi.com/wp-content/uploads/2019/08/nueces.jpg', '2024-06-13'),
('Alimentos para la Salud Cerebral', 'Mejora tu memoria con estos alimentos.', 'https://www.mgc.es/wp-content/uploads/2020/12/alimentos-para-la-memoria-THUMBNAIL2-1-1-1200x900.jpg', '2024-06-14'),
('Proteínas Vegetales', 'Alternativas vegetales para obtener proteínas.', 'https://www.kibofoods.com.co/wp-content/uploads/2021/02/ejemplos-de-proteinas-vegetales-para-incluir-en-tu-alimentacion-diaria-.jpg', '2024-06-15'),
('Planificación de Comidas', 'Cómo planificar tus comidas de manera saludable.', 'https://gnd-content.dev/blog/wp-content/uploads/2023/02/MENU-SEMANAL-4.jpg', '2024-06-16'),
('Reducir el Consumo de Sal', 'Consejos para disminuir la sal en tus comidas.', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ34phA9JHOthCyU1Hx6HAMS4p1sRfxmCeDgg&s', '2024-06-17'),
('Beneficios del Agua de Coco', 'Propiedades hidratantes y nutritivas del agua de coco.', 'https://www.clarin.com/2023/05/23/O1ysSpFFh_1200x0__1.jpg', '2024-06-18'),
('Alimentos Probióticos', 'Mejora tu salud intestinal con probióticos.', 'https://statics-cuidateplus.marca.com/cms/images/alimentos-fibra.jpg', '2024-06-19'),
('Hábitos Alimenticios Saludables', 'Consejos para mantener hábitos alimenticios saludables a largo plazo.', 'https://cdn.aarp.net/content/dam/aarp/health/healthy-living/2021/05/1140-health-calendar-reset-esp.jpg', '2024-06-20');

DROP TABLE IF EXISTS `usuario_rol`;
CREATE TABLE `usuario_rol` (
  `idusuario` int NOT NULL,
  `idrol` int NOT NULL,
  PRIMARY KEY (`idusuario`,`idrol`),
  KEY `idrol` (`idrol`),
  CONSTRAINT `usuario_rol_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`),
  CONSTRAINT `usuario_rol_ibfk_2` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`)
);
INSERT INTO `usuario_rol` VALUES (1,1),(2,2),(3,3);

DROP TABLE IF EXISTS `detalle_alimento`;
CREATE TABLE `detalle_alimento` (
  `fecha` date DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `idalimento` int NOT NULL,
  `idusuario` int NOT NULL,
  PRIMARY KEY (`idalimento`,`idusuario`),
  CONSTRAINT `detalle_alimento_ibfk_1` FOREIGN KEY (`idalimento`) REFERENCES `alimento` (`idalimento`),
  CONSTRAINT `detalle_alimento_ibfk_2` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`)
);
INSERT INTO `detalle_alimento` VALUES 
('2024-07-01',2,1,1),('2024-07-01',1,2,2),('2024-07-01',3,3,3);

create table detalle_habito
(
	idusuario            int not null,
	idhabito             int not null,
	realizado            boolean,
    fecha				timestamp default CURRENT_TIMESTAMP,
	foreign key (idusuario) references usuario(idusuario),
	foreign key (idhabito) references habito(idhabito),
    primary key(idusuario,idhabito)
);
INSERT INTO `detalle_habito`(fecha,realizado,idusuario,idhabito) VALUES 
('2024-07-01',1,1,1),('2024-07-01',0,2,2),('2024-07-01',1,3,3);
