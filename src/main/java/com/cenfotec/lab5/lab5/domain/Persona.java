package com.cenfotec.lab5.lab5.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private Date dob;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    public Persona(){}

    public Persona(String nombre, String ap1, String ap2, String direccion, Date dob) throws ParseException{
        this.nombre = nombre;
        this.apellido1 = ap1;
        this.apellido2 = ap2;
        this.direccion = direccion;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date DOB) {
        this.dob = DOB;
    }

    public String getFechaNac(){
        return format.format(dob);
    }

    public String toString(){
        StringBuilder value = new StringBuilder("Nueva Persona");
        value.append("Nombre: ");
        value.append(nombre);
        value.append("Apellidos: ");
        value.append(apellido1 + " " + apellido2);
        value.append("Direccion: ");
        value.append(direccion);
        value.append("Fecha de nacimiento: ");
        value.append(getFechaNac());

        return value.toString();
    }

}
