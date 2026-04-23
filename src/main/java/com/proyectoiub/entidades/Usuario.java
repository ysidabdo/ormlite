package com.proyectoiub.entidades;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.Data;

@Data
@DatabaseTable
public class Usuario {
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String nombre;

    @DatabaseField
    private String email;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Empresa empresa;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Proyecto proyecto;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Departamento departamento;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Equipo equipo;

    public Usuario Actualizardatos(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        return this;
    }


}