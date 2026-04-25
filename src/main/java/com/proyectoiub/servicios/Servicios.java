/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoiub.servicios;

import com.j256.ormlite.dao.Dao;
import com.proyectoiub.entidades.Departamento;
import com.proyectoiub.entidades.Empresa;
import com.proyectoiub.entidades.Equipo;
import com.proyectoiub.entidades.Grupo;
import com.proyectoiub.entidades.Organizacion;
import com.proyectoiub.entidades.Proyecto;
import com.proyectoiub.entidades.Usuario;

/**
 *
 * @author Yesid
 */
public class Servicios {
     public static Empresa crearEmpresa(Dao<Empresa, Integer> dao, Empresa empresa) throws Exception {
        dao.create(empresa);
        return empresa;
    }

    public static Proyecto crearProyecto(Dao<Proyecto, Integer> dao, Empresa empresa, Departamento departamento) throws Exception {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre("Proyecto Alpha");
        proyecto.setDescripcion("Desarrollo de software innovador");
        proyecto.setEmpresa(empresa);
        proyecto.setDepartamento(departamento);
        dao.create(proyecto);
        return proyecto;
    }

    public static Departamento crearDepartamento(Dao<Departamento, Integer> dao, Empresa empresa) throws Exception {
        Departamento departamento = new Departamento();
        departamento.setNombre("Recursos Humanos");
        departamento.setUbicacion("Oficina Central");
        departamento.setEmpresa(empresa);
        dao.create(departamento);
        return departamento;
    }

    public static Equipo crearEquipo(Dao<Equipo, Integer> dao, Grupo grupo) throws Exception {
        Equipo equipo = new Equipo();
        equipo.setNombre("Equipo de Fútbol");
        equipo.setDeporte("Fútbol");
        equipo.setGrupo(grupo);
        dao.create(equipo);
        return equipo;
    }

    public static Grupo crearGrupo(Dao<Grupo, Integer> dao, Departamento departamento) throws Exception {
        Grupo grupo = new Grupo();
        grupo.setNombre("Grupo de Estudio");
        grupo.setCategoria("Educación");
        grupo.setDepartamento(departamento);
        dao.create(grupo);
        return grupo;
    }

    public static Organizacion crearOrganizacion(Dao<Organizacion, Integer> dao, Empresa empresa) throws Exception {
        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("ONG Ayuda");
        organizacion.setTipo("Sin fines de lucro");
        organizacion.setEmpresa(empresa);
        dao.create(organizacion);
        return organizacion;
    }

    public static void crearUsuario(Dao<Usuario, Integer> usuarioDao, Empresa empresa, Proyecto proyecto, 
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
