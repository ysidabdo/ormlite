package com.example;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Main {
    public static void main(String[] args) throws Exception {
       // 1. Conexión a SQLite (se crea el archivo si no existe)
        String url = "jdbc:sqlite:mi_base_de_datos.db";
        JdbcConnectionSource conexion = new JdbcConnectionSource(url);

        // 2. Crear la tabla automáticamente si no existe
        TableUtils.createTableIfNotExists(conexion, Usuario.class);

        // 3. El DAO (Da    ta Access Object) es el que hace la magia
        Dao<Usuario, Integer> usuarioDao = DaoManager.createDao(conexion, Usuario.class);

        // 4. Crear y guardar un objeto
        Usuario nuevo = new Usuario();
        nuevo.setNombre("Carlos");
        nuevo.setEmail("carlos@example.com");
        usuarioDao.create(nuevo);

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.Actualizardatos("Carla", "juan@notengo.com");
        usuarioDao.create(nuevoUsuario);

        System.out.println("¡Usuario guardado con éxito!");
        
        conexion.close();
    }
}