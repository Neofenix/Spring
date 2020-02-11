package com.platzi.ereservation.modelo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Clase que representa la tabla Cliente
 * @author jzapata
 */
@Data
@Entity  //Permite que la tabla represente una tabla de datos
@Table(name = "cliente")   //A que tabla se va a mapear
@NamedQuery(name ="Client.findByIdentificacion", query = "Select c from CLiente c where c.identificacionCli = ?1")
public class Cliente {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String idCli;
    private String nombreCli;  //private: opcional por que el Lombok reconoce que es un POJO
    private String apellidoCli;
    private String identificacionCli;
    private String direccionCli;
    private String telefonoCli;
    private String emailCli;
    @OneToMany(mappedBy="cliente")                       //Un cliente tiene muchas reservas
    private Set<Reserva> reservas;

    public Cliente() {
    }

}