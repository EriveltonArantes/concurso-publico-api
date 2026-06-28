package com.concursopublicoapi.controller;

import com.concursopublicoapi.model.Concurso;
import com.concursopublicoapi.model.Candidato;
import com.concursopublicoapi.model.Inscricao;
import com.concursopublicoapi.model.Resultado;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.concursopublicoapi.repository.ConcursoRepository concursoRepository;

    @Autowired
    private com.concursopublicoapi.repository.CandidatoRepository candidatoRepository;

    @Autowired
    private com.concursopublicoapi.repository.InscricaoRepository inscricaoRepository;

    @Autowired
    private com.concursopublicoapi.repository.ResultadoRepository resultadoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalConcurso", concursoRepository.count());
        resumo.put("somaVagasConcurso", concursoRepository.findAll().stream().filter(e -> e.getVagas() != null).mapToInt(e -> e.getVagas()).sum());
        resumo.put("graficoConcurso", concursoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalCandidato", candidatoRepository.count());
        resumo.put("totalInscricao", inscricaoRepository.count());
        resumo.put("graficoInscricao", inscricaoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalResultado", resultadoRepository.count());
        resumo.put("somaNotaObjetivaResultado", resultadoRepository.findAll().stream().filter(e -> e.getNotaObjetiva() != null).mapToDouble(e -> e.getNotaObjetiva()).sum());
        return resumo;
    }
}
