INSERT INTO competencia
    VALUES
        (11, 2001, 'Project Manager', 'Lider de proyecto blockchain', 'ACTITUDINAL', false),
        (21, 2011, 'QA Tester', 'Tester funcional conocimientos en SQL Testim', 'TECNICA', false),
        (31, 2021, 'Software Developer', 'Programador Jr. .NET', 'TECNICA', true),
        (41, 2031, 'Backend Developer', 'Programador Backend Ssr, Java', 'TECNICA', false),
        (51, 2041, 'FrontEnd Developer', 'Programador FrontEnd, manejo de framework Angular, js', 'TECNICA', false);
    
	
INSERT INTO consultor
	VALUES 
		( 1, 'USER1', 'WUABISZOVICH', 'LEANDRO', 'contra1' ),
		( 2, 'USER2', 'FIORIUS', 'SCHENZEN', 'contra2' ),
		( 3, 'USER3', 'HERGARD', 'AMELIA', 'contra3' ),
		( 4, 'USER4', 'HORIA', 'SUSANA', 'contra4' ),
		( 5, 'USER5', 'PEREZ', 'HERMENEGILDO', 'contra5' ),
		( 6, 'USER6', 'ALONSO', 'FERNANDO', 'contra6'),
		( 7, 'USER7', 'GALENO', 'LEOPOLDO', 'contra7');
		
Insert into candidato
values  
		(1, 1, 'DNI', 1000000, 'PEREZ','JOSE','1998-03-02','ARGENTINA', 'notnod@gmail.com','TERCIARIO',FALSE);
		
//hasta aca esta todo cargado




INSERT INTO cuestionario
values
(1, 'clave1','ACTIVO',0, 120,'2022-12-12','2022-12-13','2022-12-13',4,1,'cada pregunta vale 2 puntos')

INSERT INTO candidato 
	VALUES (1, 'DNI', '1000000', 'PEREZ', 'JOSE', '1998-03-02', 'ARGENTINA', 'notnod@gmail.com', 'TERCIARIO', false, NULL),
		(2, 'DNI', '2000000', 'MARTINEZ', 'JUAN', '2000-12-21', 'PERUANO', 'peru@gmail.com', 'SECUNDARIO', false, NULL),
		(3, 'DNI', '3000000', 'MARTINEZ', 'LAURA', '2010-12-21', 'ARGENTINA', 'aaaaaaaaaaaaa', 'aaaaaaaaa', false, NULL),
		(4, 'DNI', '4000000', 'MARTINEZ', 'PABLO', '2002-12-21', 'aaaaaaaaaa', 'aaaaaa', 'aaaaaaaa', false, NULL),
		(5, 'DNI', '5000000', 'BOOL', 'JUAN', '2002-11-21', 'qqqqqqqqqq', 'qqqqqqqqqqq', 'qqqqqqqqqqq', false, NULL),
		(6, 'DNI', '6000000', 'SUAREZ', 'ROBERTO', '2002-11-21', 'PERUANO', 'NN', 'BACHILLER', false, NULL),
		(7, 'DNI', '000000', 'KIEL', 'NICO', '2002-11-21', 'ALEMAN', 'NN', 'BACHILLER', false, NULL);
		(8, 'DNI', '8000000', 'JOLIN', 'JOSEPH', '1999-04-02', 'ARGENTINA', 'que@gmail.com', 'SECUNDARIO', false, NULL),
        (9, 'DNI', '9000000', 'GIOVANI', 'STEPHEN', '2001-11-20', 'BOLIVIANA', 'bue@gmail.com', 'SECUNDARIO', false, NULL),
        (10, 'DNI', '9100000', 'RAMIREZ', 'AMALIA', '2010-10-21', 'CHILENA', 'no@gmail.coma', 'TERCEARIO', false, NULL);
		(11, 'DNI', '9200000', 'RAMIREZ', 'JOAQUIN', '2010-10-21', 'RUSA', 'no@gmail.coma', 'TERCEARIO', false, NULL),
		(12, 'DNI', '9300000', 'MONSALVE', 'SALVADOR', '2010-10-21', 'CHILENA', 'no@gmail.coma', 'TERCEARIO', false, NULL),
		(13, 'DNI', '9400000', 'RODRIGUEZ', 'AMALIA', '2010-10-21', 'BOLIVIANA', 'no@gmail.coma', 'UNIVERSITARIO', false, NULL),
		(14, 'DNI', '9500000', 'PUPPO', 'JAVA', '2010-10-21', 'LIECHTENSTIANIANA', 'no@gmail.coma', 'DOCTORADO', false, NULL),
		(15, 'DNI', '9600000', 'DICAPRIO', 'SAUL', '2010-10-21', 'SUIZA', 'no@gmail.coma', 'TERCEARIO', false, NULL);
INSERT INTO cuestionario  
	VALUES ('clave1', 'ACTIVO', 0, 120, '2022-12-12', '2022-12-13', '2022-12-13', 4, 1, 'cada pregunta vale 2 puntos', NULL, NULL, 1),
		('clave2', 'ACTIVO', 0, 120, '2022-12-12', '2022-12-13', '2022-12-13', 4, 1, 'cada pregunta vale 2 puntos', NULL, NULL, 2),
		('clave3', 'EN_PROCESO', 0, 120, '2022-12-12', '2022-12-13', '2022-12-13', 4, 1, 'cada pregunta vale 2 puntos', NULL, NULL, 4),
		('clave4', 'FINALIZADO', 0, 120, '2022-12-12', '2022-12-13', '2022-12-13', 4, 1, 'cada pregunta vale 2 puntos', NULL, NULL, 5);



INSERT INTO puesto 
	VALUES (1234, 'NOMBREA', 'DESC1', 'EMPRESAA', false, NULL)
		(2, 'NOMBREB', 'DESCRIPCION2', 'EMPRESAB', false, NULL),
		(3, 'NOMBREC', 'DESCRIPCION3', 'EMPRESAB', false, NULL),
		(4, 'NOMBRED', 'DESCRIPCION4', 'EMPRESAB', false, NULL),
		(5, 'NOMBREE', 'DESCD', 'EMPRESAD', false, NULL),
		(7, 'NOMBREF', 'DESC6', 'EMPRESAF', false, NULL);


INSERT INTO competencia
	VALUES (2001, 'Project Manager', 'Lider de proyecto blockchain', 'ACTITUDINAL', false, NULL),
		(2011, 'QA Tester', 'Tester funcional conocimientos en SQL Testim', 'TECNICA', false, NULL),
		(2021, 'Software Developer', 'Programador Jr. .NET', 'TECNICA', true, NULL),
		(2031, 'Backend Developer', 'Programador Backend Ssr, Java', 'TECNICA', false, NULL),
		(2041, 'FrontEnd Developer', 'Programador FrontEnd, manejo de framework Angular, js', 'TECNICA', false, NULL);


INSERT INTO factor 
	VALUES (1, 'FACTORA', 'DESCRIPCIONA', 1, false, 11, NULL),
		(2, 'FACTORB', 'DESCB', 2, false, 11, NULL),
		(3, 'FACTORC', 'DESCC', 3, false, 41, NULL);


INSERT INTO pregunta
	VALUES 
		( 5, 'NOMBRED', 'PREGUNTD', 'DESCC',false, 1,NULL,NULL),
		( 6, 'NOMBREE', 'PREGUNTE', 'DESCD',false, 1,NULL,NULL ),
		( 7, 'NOMBREF', 'PREGUNTF', 'DESCE',false, 1,NULL,NULL),
		( 8, 'NOMBREG', 'PREGUNTG', 'DESCF',false, 1,NULL,NULL);


INSERT INTO ponderacion 
	VALUES (1,3, 1, 50),
 		(2,3, 2, 20),
 		(3,3, 3, 10),
 		(4,3, 4, 10),
 		(5 ,4, 1, 50),
 		(6, 5, 1, 50);

INSERT INTO opcion_respuesta 
	VALUES (1,'nombre1', 'desc1', false, NULL), 
 		(2,'nombre2', 'desc2', false, NULL), 
		(3,'nombre3', 'desc3', false, NULL), 
		(4,'nombre4', 'desc4', false, NULL); 

--hacer el update de pregunta manualmente a la columna id opcion_respuesta de pregunta
UPDATE EN PREGUNTA PARA ASIGNARLE LOS ID DE OPCION_RESPUESTA, 
preguntaid =1, id_or=1
preguntaid =2, id_or=2
preguntaid =5, id_or=3
preguntaid =6, id_or=4

INSERT INTO item_opcion_respuesta 
	VALUES (1,'desc1', 1, 1),
		(2,'desc2', 2, 1),
		(3,'desc3', 3, 1),
		(4,'desc1', 1, 2),
		(5,'desc2', 2, 2),
		(6,'desc1', 1, 3),
		(7,'desc7', 1, 4);
