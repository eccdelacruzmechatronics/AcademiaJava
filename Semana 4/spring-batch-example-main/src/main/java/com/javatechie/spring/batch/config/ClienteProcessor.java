package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Cliente;
import org.springframework.batch.item.ItemProcessor;

public class ClienteProcessor implements ItemProcessor<Cliente,Cliente> {

    @Override
    public Cliente process(Cliente cliente) throws Exception {
        if(cliente.getPais().equals("Brazil") 
        		&& cliente.getGenero().equals("Female")) {
            return cliente;
        }else{
            return null;
        }
    }
}
