package com.platzi.ereservation.negocio.repository;


import com.platzi.ereservation.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface para definir las operaciones de bdd relacionadas con cliente
 */
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    /**
     * Definicion de metodo para buscar los clientes por su apellido
     * @param apellidoCli
     * @return
     */
    public List<Cliente> findByApellidoCli(String apellidoCli);

    public Cliente findByIdentificacion(String identificacionCli);


}
