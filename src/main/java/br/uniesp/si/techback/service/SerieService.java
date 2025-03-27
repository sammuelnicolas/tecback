package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Serie;
import br.uniesp.si.techback.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public List<Serie> listarTodos() {
        return repository.findAll();
    }

    public Optional<Serie> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Serie salvar(Serie serie) {
        return repository.save(serie);
    }

    public Serie atualizar(Integer id, Serie serieAtualizada) {
        return repository.findById(id)
                .map(serie -> {
                    serie.setTitulo(serieAtualizada.getTitulo());
                    serie.setDiretor(serieAtualizada.getDiretor());
                    serie.setTemporadas(serieAtualizada.getTemporadas());
                    return repository.save(serie);
                }).orElseThrow(() -> new RuntimeException("Serie não encontrada"));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
