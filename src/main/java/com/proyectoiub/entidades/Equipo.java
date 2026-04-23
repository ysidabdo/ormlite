package com.proyectoiub.entidades;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.Data;

@Data
@DatabaseTable
public class Equipo {
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String nombre;

    @DatabaseField
    private String deporte;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Grupo grupo;

    public Equipo ActualizarDatos(String nombre, String deporte) {
        this.nombre = nombre;
        this.deporte = deporte;
        return this;
    }
}