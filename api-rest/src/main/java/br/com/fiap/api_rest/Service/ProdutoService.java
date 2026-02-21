package br.com.fiap.api_rest.Service;

import br.com.fiap.api_rest.Model.Produto;
import br.com.fiap.api_rest.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    //CRUD

    public Produto create(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto read(UUID id){
        Optional<Produto>produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }
    public List<Produto> read(){
        return produtoRepository.findAll();
    }

    public Produto update(Produto produto){
        return produtoRepository.save(produto);
    }

    public void delete(UUID id){
        produtoRepository.deleteById(id);
    }


}
