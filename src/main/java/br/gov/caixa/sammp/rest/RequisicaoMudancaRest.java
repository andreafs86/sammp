package br.gov.caixa.sammp.rest;

import java.net.URI;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.caixa.sammp.dto.RequisicaoMudancaDTO;
import br.gov.caixa.sammp.entity.RequisicaoMudanca;
import br.gov.caixa.sammp.repository.RequisicaoMudancaRepository;
import br.gov.caixa.sammp.util.Util;

@RestController
@RequestMapping("rm")
@CrossOrigin(origins = "http://localhost:4200")
public class RequisicaoMudancaRest {
	
    Logger logger = Logger.getLogger(RequisicaoMudancaRest.class.getName());
    
    @Autowired
    private RequisicaoMudancaRepository rmRepository;
    
	@PostMapping
	@Transactional
	public ResponseEntity<?> merge(@RequestBody RequisicaoMudancaDTO dto, UriComponentsBuilder uriBuilder) throws Exception{
		logger.info("entrou no merge de Requisição de mudança");
		
		RequisicaoMudanca rm;
		
		if(dto.getNumeroRtc() != null && dto.getNumeroRtc() == 0) {
			dto.setNumeroRtc(null);
		}
		
		if(dto.getNumeroRtc() != null) {
			List<RequisicaoMudanca> rms = rmRepository.findByNumeroRtc(dto.getNumeroRtc());
			
			if(rms != null) {
				for(RequisicaoMudanca rmRtc : rms) {
					if(!rmRtc.getId().equals(dto.getId())) {
						throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe este número de RTC em outro cadastro");
					}
				}
			}
		}
		
		if(dto.getId() == null) {
			rm = dto.getRM();
			rmRepository.save(rm);
		}else {
			Optional<RequisicaoMudanca> opRm = rmRepository.findById(dto.getId());
			rm = opRm.get();
			rm.setDto(dto);
		}
		
		DecimalFormat df = new DecimalFormat("#");
		URI uri = uriBuilder.path("/rm/{rtc}").buildAndExpand(df.format(rm.getId())).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@GetMapping("{rtc}")
	public ResponseEntity<RequisicaoMudancaDTO> detalhar(@PathVariable Long id) {
		Optional<RequisicaoMudanca> optional = rmRepository.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get().getDto());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public List<RequisicaoMudancaDTO> find(
			@RequestParam(required = false) String dataInicio,
			@RequestParam(required = false) String dataFim) throws Exception {
		
		List<RequisicaoMudancaDTO> retorno = new ArrayList<>();
		
		if(dataInicio == null || dataFim == null) {
			rmRepository.findAll().iterator().forEachRemaining(rm -> {
				retorno.add(rm.getDto());
			});
			logger.info("listar RM com sucesso");
		}else {
			LocalDate dataInicioParam = LocalDate.parse(dataInicio, Util.formatter);
			LocalDate dataFimParam = LocalDate.parse(dataFim, Util.formatter);
			
			rmRepository.findByDataInicioAndDataFim(dataInicioParam, dataFimParam).forEach(rm -> {
				retorno.add(rm.getDto());
			});
			logger.info("listar RM com sucesso para filtros de data");
		}
		
		return retorno;
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<RequisicaoMudanca> optional = rmRepository.findById(id);
		
		if(optional.isPresent()) {
			rmRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
