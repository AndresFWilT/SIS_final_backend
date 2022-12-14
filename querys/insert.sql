-- Centro comercial
INSERT INTO CENTRO_COMERCIAL (id_comercial, estado_comercial, nombre_cc, ubicacion_cc, direccion_cc) VALUES ('00001','01','Centro comercial richar','san cristobal','calle 52 b sur #11-39');
-- Restaurante
INSERT INTO RESTAURANTE (id_restaurante, id_comercial_res_fk, nombre_restaurante, local_restaurante, estado_restaurante) VALUES ('00001','00001','richisabrosi','LOC-001','01');
-- Tipo producto
INSERT INTO TIPO_PRODUCTO (id_tipo_producto, descripcion_tipo_prod) VALUES ('0000000001','Comida rapida');
-- Plato
INSERT INTO PLATO (id_plato, descripcion_plato) VALUES ('0000000001','Hamburguesa de pollo');
-- Prueba prodcuto
INSERT INTO PRODUCTO p (p.id_producto, p.id_tipo_producto_prod_fk, id_plato_prod_fk, nombre_producto, tiempo_preparacion, costo_producto) VALUES ('0000000001','0000000001','0000000001','Hamburguesa combo 1', TO_DATE('2022/12/13 21:22:45', 'yyyy/mm/dd hh24:mi:ss'),10000);
-- Usuario
INSERT INTO USUARIO u (id_usuario,telefono_usuario,correo_usuario,contrasena_usuario,estado_usuario) VALUES ('1010101010','3001233451','catorcc@correo','12345','01');