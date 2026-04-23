package com.proyectoiub.infraestructure;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.proyectoiub.entidades.Departamento;
import com.proyectoiub.entidades.Empresa;
import com.proyectoiub.entidades.Equipo;
import com.proyectoiub.entidades.Grupo;
import com.proyectoiub.entidades.Organizacion;
import com.proyectoiub.entidades.Proyecto;
import com.proyectoiub.entidades.Usuario;

public class DatabaseConfig {
    private JdbcConnectionSource conexion;
    private Dao<Usuario, Integer> usuarioDao;
    private Dao<Empresa, Integer> empresaDao;
    private Dao<Proyecto, Integer> proyectoDao;
    private Dao<Departamento, Integer> departamentoDao;
    private Dao<Equipo, Integer> equipoDao;
    private Dao<Grupo, Integer> grupoDao;
    private Dao<Organizacion, Integer> organizacionDao;

    public DatabaseConfig() throws Exception {
        inicializarConexion();
        crearTablas();
        crearDAOs();
    }

    private void inicializarConexion() throws Exception {
        String url = "jdbc:sqlite:mi_base_de_datos.db";
        this.conexion = new JdbcConnectionSource(url);
    }

    private void crearTablas() throws Exception {
        TableUtils.createTableIfNotExists(conexion, Usuario.class);
        TableUtils.createTableIfNotExists(conexion, Empresa.class);
        TableUtils.createTableIfNotExists(conexion, Proyecto.class);
        TableUtils.createTableIfNotExists(conexion, Departamento.class);
        TableUtils.createTableIfNotExists(conexion, Equipo.class);
        TableUtils.createTableIfNotExists(conexion, Grupo.class);
        TableUtils.createTableIfNotExists(conexion, Organizacion.class);
    }

    private void crearDAOs() throws Exception {
        this.usuarioDao = DaoManager.createDao(conexion, Usuario.class);
        this.empresaDao = DaoManager.createDao(conexion, Empresa.class);
        this.proyectoDao = DaoManager.createDao(conexion, Proyecto.class);
        this.departamentoDao = DaoManager.createDao(conexion, Departamento.class);
        this.equipoDao = DaoManager.createDao(conexion, Equipo.class);
        this.grupoDao = DaoManager.createDao(conexion, Grupo.class);
        this.organizacionDao = DaoManager.createDao(conexion, Organizacion.class);
    }

    // Getters para todos los DAOs
    public Dao<Usuario, Integer> getUsuarioDao() {
        return usuarioDao;
    }

    public Dao<Empresa, Integer> getEmpresaDao() {
        return empresaDao;
    }

    public Dao<Proyecto, Integer> getProyectoDao() {
        return proyectoDao;
    }

    public Dao<Departamento, Integer> getDepartamentoDao() {
        return departamentoDao;
    }

    public Dao<Equipo, Integer> getEquipoDao() {
        return equipoDao;
    }

    public Dao<Grupo, Integer> getGrupoDao() {
        return grupoDao;
    }

    public Dao<Organizacion, Integer> getOrganizacionDao() {
        return organizacionDao;
    }

    public JdbcConnectionSource getConexion() {
        return conexion;
    }

    public void cerrar() throws Exception {
        if (conexion != null) {
            conexion.close();
        }
    }
}
