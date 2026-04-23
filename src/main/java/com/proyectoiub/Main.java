package com.proyectoiub;

import com.j256.ormlite.dao.Dao;
import com.proyectoiub.entidades.Departamento;
import com.proyectoiub.entidades.Empresa;
import com.proyectoiub.entidades.Equipo;
import com.proyectoiub.entidades.Grupo;
import com.proyectoiub.entidades.Organizacion;
import com.proyectoiub.entidades.Proyecto;
import com.proyectoiub.entidades.Usuario;
import com.proyectoiub.infraestructure.DatabaseConfig;

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
        Empresa empresa = crearEmpresa(empresaDao);
        Departamento departamento = crearDepartamento(departamentoDao, empresa);
        Proyecto proyecto = crearProyecto(proyectoDao, empresa, departamento);
        Organizacion organizacion = crearOrganizacion(organizacionDao, empresa);
        Grupo grupo = crearGrupo(grupoDao, departamento);
        Equipo equipo = crearEquipo(equipoDao, grupo);
        
        crearUsuario(usuarioDao, empresa, proyecto, departamento, equipo);

        System.out.println("¡Todas las entidades guardadas con éxito!");
        
        dbConfig.cerrar();
    }

    private static Empresa crearEmpresa(Dao<Empresa, Integer> dao) throws Exception {
        Empresa empresa = new Empresa();
        empresa.setNombre("TechCorp");
        empresa.setSector("Tecnología");
        dao.create(empresa);
        return empresa;
    }

    private static Proyecto crearProyecto(Dao<Proyecto, Integer> dao, Empresa empresa, Departamento departamento) throws Exception {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre("Proyecto Alpha");
        proyecto.setDescripcion("Desarrollo de software innovador");
        proyecto.setEmpresa(empresa);
        proyecto.setDepartamento(departamento);
        dao.create(proyecto);
        return proyecto;
    }

    private static Departamento crearDepartamento(Dao<Departamento, Integer> dao, Empresa empresa) throws Exception {
        Departamento departamento = new Departamento();
        departamento.setNombre("Recursos Humanos");
        departamento.setUbicacion("Oficina Central");
        departamento.setEmpresa(empresa);
        dao.create(departamento);
        return departamento;
    }

    private static Equipo crearEquipo(Dao<Equipo, Integer> dao, Grupo grupo) throws Exception {
        Equipo equipo = new Equipo();
        equipo.setNombre("Equipo de Fútbol");
        equipo.setDeporte("Fútbol");
        equipo.setGrupo(grupo);
        dao.create(equipo);
        return equipo;
    }

    private static Grupo crearGrupo(Dao<Grupo, Integer> dao, Departamento departamento) throws Exception {
        Grupo grupo = new Grupo();
        grupo.setNombre("Grupo de Estudio");
        grupo.setCategoria("Educación");
        grupo.setDepartamento(departamento);
        dao.create(grupo);
        return grupo;
    }

    private static Organizacion crearOrganizacion(Dao<Organizacion, Integer> dao, Empresa empresa) throws Exception {
        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("ONG Ayuda");
        organizacion.setTipo("Sin fines de lucro");
        organizacion.setEmpresa(empresa);
        dao.create(organizacion);
        return organizacion;
    }

    private static void crearUsuario(Dao<Usuario, Integer> usuarioDao, Empresa empresa, Proyecto proyecto, 
                                     Departamento departamento, Equipo equipo) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setEmail("juan@example.com");
        usuario.setEmpresa(empresa);
        usuario.setProyecto(proyecto);
        usuario.setDepartamento(departamento);
        usuario.setEquipo(equipo);
        
        usuarioDao.create(usuario);
    }
}