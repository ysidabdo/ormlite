package com.proyectoiub;

import com.j256.ormlite.dao.Dao;
import com.proyectoiub.entidades.Departamento;
import com.proyectoiub.entidades.Empresa;
import com.proyectoiub.entidades.Equipo;
import com.proyectoiub.entidades.Grupo;
import com.proyectoiub.entidades.Organizacion;
import com.proyectoiub.entidades.Proyecto;
import com.proyectoiub.infraestructure.DatabaseConfig;
import com.proyectoiub.servicios.Servicios;

public class Main {
    public static void main(String[] args) throws Exception {
        // Inicializar base de datos
        DatabaseConfig dbConfig = new DatabaseConfig();

        // Obtener DAOs
        var usuarioDao = dbConfig.getUsuarioDao();
        var empresaDao = dbConfig.getEmpresaDao();
        var proyectoDao = dbConfig.getProyectoDao();
        var departamentoDao = dbConfig.getDepartamentoDao();
        var equipoDao = dbConfig.getEquipoDao();
        var grupoDao = dbConfig.getGrupoDao();
        var organizacionDao = dbConfig.getOrganizacionDao();

        // 4. Crear y guardar instancias con relaciones lógicas
        //Empresa empresa = Servicios.crearEmpresa(empresaDao);
       // Departamento departamento = Servicios.crearDepartamento(departamentoDao, empresa);
        //Proyecto proyecto = Servicios.crearProyecto(proyectoDao, empresa, departamento);
       // Organizacion organizacion = Servicios.crearOrganizacion(organizacionDao, empresa);
        //Grupo grupo = Servicios.crearGrupo(grupoDao, departamento);
        //Equipo equipo = Servicios.crearEquipo(equipoDao, grupo);
        
        //Servicios.crearUsuario(usuarioDao, empresa, proyecto, departamento, equipo);

        System.out.println("¡Todas las entidades guardadas con éxito!");
        
        dbConfig.cerrar();
    }
}