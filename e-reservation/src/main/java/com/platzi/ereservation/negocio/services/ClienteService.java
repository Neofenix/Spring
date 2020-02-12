package com.platzi.ereservation.negocio.services;


import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.negocio.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Clase para definir los servicios de cliente
 */
@Service
@Transactional(readOnly = true)
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    /**
     * Metodo para realizar la operacion de guardar un cliente
     * @param cliente
     * @return
     */
    public Cliente create(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    /**
     * Metodo para realizar la operacion de actualizar un cliente
     * @param cliente
     * @return
     */
    public Cliente update(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    /**
     * Metodo para realizar la operacion de eliminar un cliente
     * @param cliente
     */
    public void deelete(Cliente cliente){
        this.clienteRepository.delete(cliente);
    }

    /**Metodo para consultar un cliente por su identificacion**
     *
     * @param identificacionCli
     * @return
     */
    public Cliente findByIdentificacion(String identificacionCli){
        return this.clienteRepository.findByIdentificacion(identificacionCli);
    }


}
