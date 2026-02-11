package com.devsuperior.exercicio_spring3.services;

import com.devsuperior.exercicio_spring3.dto.ClientDTO;
import com.devsuperior.exercicio_spring3.entities.Client;
import com.devsuperior.exercicio_spring3.repositories.ClientRepository;
import com.devsuperior.exercicio_spring3.services.exceptions.DatabaseException;
import com.devsuperior.exercicio_spring3.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllClients(Pageable pageable) {
        Page<Client> client = clientRepository.findAll(pageable);
        return client.map(x -> new ClientDTO(x));
    }

    //Caso o ID não existe, lançar uma exception, retorna um 404
    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Cliente não encontrado " + id));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = new Client();
        copyDtoToEntity(clientDTO, client);
        clientRepository.save(client);

        return new ClientDTO(client);
    }

    //Captura a exception EntityNotFoundException caso o ID não exista, e transforma em ResourceNotFoundException lançando a mensagem
    //Retornando um erro 404
    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {

        try {
            Client client = clientRepository.getReferenceById(id);
            copyDtoToEntity(clientDTO, client);
            clientRepository.save(client);
            return new ClientDTO(client);
        }catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        }
    //Caso o ID não exista, lançara uma exception EmptyResultDataAccessException, transformo ela em ResourceNotFoundException
    //Caso houver violação de integridade no banco, transforma DataIntegrityViolationException em DatabaseException
    @Transactional

    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            clientRepository.deleteById(id);

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integridade violada");
        }
    }



    private void copyDtoToEntity(ClientDTO clientDTO, Client client) {
    client.setName(clientDTO.getName());
    client.setCpf(clientDTO.getCpf());
    client.setBirthDate(clientDTO.getBirthDate());
    client.setIncome(clientDTO.getIncome());
    client.setChildren(clientDTO.getChildren());
}

}
