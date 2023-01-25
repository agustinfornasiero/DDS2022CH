create table consultor(
id serial primary key,
usuario varchar(50) unique not null,
apellido varchar(50) not null,
nombre varchar(50) not null

);

create table registro_ejecucion(
id serial primary key,
fecha_hora date not null,
accion varchar(100) not null);

create table parametros_del_sistema(
id serial primary key,
instrucciones varchar(250) not null,
cant_preguntas integer not null,
accesos_permitidos integer not null,
tiempo_maximo_permitido integer not null,
tiempo_maximo_activo_permitido integer not null);

create table registro_auditoria(
id serial primary key,
fecha_eliminacion date not null,
tipo_entidad varchar(50) not null,
id_consultor integer references consultor(id));



create table puesto(
id serial primary key,
codigo integer unique not null,
nombre varchar(50) unique not null,
descripcion varchar(200) not null,
empresa varchar(50) not null,
eliminado boolean not null,
id_registro_auditoria integer references registro_auditoria(id));

create table competencia(
id serial primary key,
codigo integer unique not null,
nombre varchar(50) unique not null,
descripcion varchar(200) not null,
tipo_competencia varchar(50) not null,
eliminado boolean not null,
id_registro_auditoria integer references registro_auditoria(id));

create table puntuacion(
id serial primary key,
id_puesto integer references puesto(id),
id_competencia integer references competencia(id) not null,
puntaje_minimo integer not null,
unique (id_puesto, id_competencia));

create table factor(
id serial primary key,
codigo integer unique not null,
nombre varchar(50) unique not null,
descripcion varchar(200) not null,
orden integer not null,
eliminado boolean not null,
id_competencia integer references competencia(id) not null,
id_registro_auditoria integer references registro_auditoria(id));

create table opcion_respuesta(
id serial primary key,
nombre varchar(50) unique not null,
descripcion varchar(200) not null,
eliminado boolean not null,
id_registro_auditoria integer references registro_auditoria(id));

create table pregunta(
id serial primary key,
nombre varchar(50) unique not null,
pregunta varchar(200) unique not null,
descripcion varchar(200) not null,
eliminado boolean not null,
id_factor integer references factor(id) not null,
id_opcion_respuesta integer references opcion_respuesta(id) not null,
id_registro_auditoria integer references registro_auditoria(id));

create table item_opcion_respuesta(
id serial primary key,
descripcion varchar(200) not null,
orden_visualizacion integer not null,
id_opcion_respuesta integer references opcion_respuesta(id) not null);

create table ponderacion(
id serial primary key,
id_pregunta integer references pregunta(id),
id_item_opcion_respuesta integer references item_opcion_respuesta(id) not null,
ponderacion integer not null,
unique (id_pregunta, id_item_opcion_respuesta));

create table puesto_evaluacion(
id serial primary key,
codigo integer not null,
nombre varchar(50) not null,
descripcion varchar(200) not null,
empresa varchar(50) not null,
eliminado boolean not null,
id_puesto integer references puesto(id) not null);

create table competencia_evaluacion(
id serial primary key,
codigo integer not null,
nombre varchar(50) not null,
descripcion varchar(200) not null,
tipo_competencia varchar(50) not null,
eliminado boolean not null,
puntaje_minimo integer,
id_competencia integer references competencia(id) not null,
id_puesto_evaluacion integer references puesto_evaluacion(id) not null);

create table factor_evaluacion(
id serial primary key,
codigo integer not null,
nombre varchar(50) not null,
descripcion varchar(200) not null,
orden integer not null,
eliminado boolean not null,
id_competencia_evaluacion integer references competencia_evaluacion(id) not null,
id_factor integer references factor(id) not null);

create table opcion_respuesta_cuestionario(
id serial primary key,
nombre varchar(50) not null,
descripcion varchar(200) not null,
eliminado boolean not null,
id_opcion_respuesta integer references opcion_respuesta(id) not null);

create table item_opcion_respuesta_cuestionario(
id serial primary key,
descripcion varchar(200) not null,
orden_visualizacion integer not null,
id_opcion_respuesta_cuestionario integer references opcion_respuesta_cuestionario(id) not null,
id_item_opcion_respuesta integer references item_opcion_respuesta(id) not null);

create table evaluacion(
id serial primary key,
fecha_hora_inicio date not null,
fecha_hora_fin date not null,
id_puesto_evaluacion integer references puesto_evaluacion(id) not null);

create table cuestionario(
id serial primary key,
clave varchar(50) not null,
estado varchar(50) not null,
puntaje_obtenido decimal,
tiempo_maximo_permitido integer not null,
fecha_hora_inicio date,
fecha_hora_fin date,
fecha_hora_no_finalizacion date,
accesos_permitidos integer not null,
veces_accedidos integer not null,
instrucciones varchar(250) not null,
id_evaluacion integer references evaluacion(id) not null,
id_registro_ejecucion integer references registro_ejecucion(id),
id_candidato integer not null);


create table candidato(
id serial primary key,
numero_candidato integer unique not null,
tipo_documento varchar(50) not null,
documento varchar(50) not null,
apellido varchar(50) not null,
nombre varchar(50) not null,
fecha_nac date not null,
nacionalidad varchar(50) not null,
email varchar(50) not null,
escolaridad varchar(50) not null,
eliminado boolean not null,
id_cuestionario_actual integer references cuestionario(id));

alter table cuestionario
add constraint cuestionario_id_candidato_fkey foreign key (id_candidato)
references candidato(id);



create table puntaje(
id serial primary key,
id_cuestionario integer references cuestionario(id),
id_competencia_evaluacion integer references competencia_evaluacion(id) not null,
puntaje decimal,
unique (id_cuestionario, id_competencia_evaluacion));

create table bloque_preguntas(
id serial primary key,
numero integer not null,
estado varchar(50) not null,
cant_preguntas integer not null,
bloque_final boolean not null,
id_cuestionario integer references cuestionario(id) not null);

create table pregunta_cuestionario(
id serial primary key,
nombre varchar(50) not null,
pregunta varchar(200) not null,
descripcion varchar(200) not null,
eliminado boolean not null,
id_factor_evaluacion integer references factor_evaluacion(id) not null,
id_pregunta integer references pregunta(id) not null,
id_opcion_respuesta_cuestionario integer references opcion_respuesta_cuestionario(id) not null,
id_bloque_preguntas integer references bloque_preguntas(id) not null);

create table respuesta(
id serial primary key,
id_pregunta_cuestionario integer references pregunta_cuestionario(id) not null,
id_item_opcion_respuesta_cuestionario integer references item_opcion_respuesta_cuestionario(id) not null);

create table ponderacionCuestionario(
id serial primary key,
id_pregunta_cuestionario integer references pregunta_cuestionario(id),
id_item_opcion_respuesta_cuestionario integer references item_opcion_respuesta_cuestionario(id),
ponderacion integer,
unique (id_pregunta_cuestionario, id_item_opcion_respuesta_cuestionario));

