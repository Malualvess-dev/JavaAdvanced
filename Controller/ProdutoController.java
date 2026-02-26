package br.com.fiap.api_rest.Controller;

import br.com.fiap.api_rest.Model.Produto;
import br.com.fiap.api_rest.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    // CRUD - Create, Read, Update, Delete
    // POST, GET, PUT, DELETE


    //Create
    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto){
        Produto produtoSalvo = produtoService.create(produto);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    //GET
    @GetMapping
    public ResponseEntity<Produto> readProduto(@PathVariable UUID id){
        Produto produto = produtoService.read(id);

        if (produto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> readProduto(){
        List<Produto> produtos = produtoService.read();

        if (produtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    //PUT

    @PutMapping
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto){
        Produto produtoExistente = produtoService.update(produto.getId());

        if (produtoExistente == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Produto produtoAtualizado = produtoService.update(produto);
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }

    //DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable UUID id){
        produtoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
