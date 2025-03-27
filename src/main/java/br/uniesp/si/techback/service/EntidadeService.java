package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.EntidadeBase;
import br.uniesp.si.techback.repository.EntidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntidadeService {

    @Autowired
    EntidadeRepository repository;

    public List<EntidadeBase> listarTodos() {
        return repository.findAll();
    }

    public Optional<EntidadeBase> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public EntidadeBase salvar(EntidadeBase entidade) {
        return repository.save(entidade);
    }

    public EntidadeBase atualizar(Integer id, EntidadeBase entidadeAtualizada) {
        return repository.findById(id)
                .map(entidade -> {
                    entidade.setNome(entidadeAtualizada.getNome());
                    entidade.setAno(entidadeAtualizada.getAno());
                    return repository.save(entidade);
                }).orElseThrow(() -> new RuntimeException("Entidade não encontrada"));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
