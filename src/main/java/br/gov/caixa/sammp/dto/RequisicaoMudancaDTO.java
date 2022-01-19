package br.gov.caixa.sammp.dto;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.gov.caixa.sammp.entity.RequisicaoMudanca;
import br.gov.caixa.sammp.util.Util;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequisicaoMudancaDTO {

	@JsonIgnore
	private Logger logger = Logger.getLogger(RequisicaoMudancaDTO.class.getName());
	
	private Long id;
	private Double numeroRtc;
	private String siglaSistema;
	private String resumo;
	@JsonIgnore
	private LocalDate dataEntrega;
	@JsonIgnore
	private LocalDate dataCrq;
	@JsonIgnore
	private LocalDate dataPrevista;
	@JsonIgnore
	private LocalDate dataImplantacao;
	private String detalhe;
	
	public String getDataEntregaString() {
		if(dataEntrega != null) {
			return dataEntrega.format(Util.formatter);
		}
		return "";
	}
	public void setDataEntregaString(String dataEntregaString) {
		try {
			if(dataEntregaString != null && !dataEntregaString.equals("")) {
				dataEntrega = LocalDate.parse(dataEntregaString, Util.formatter);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
	public String getDataCrqString() {
		if(dataCrq != null) {
			return dataCrq.format(Util.formatter);
		}
		return "";
	}
	public void setDataCrqString(String dataCrqString) {
		try {
			if(dataCrqString != null && !dataCrqString.equals("")) {
				dataCrq = LocalDate.parse(dataCrqString, Util.formatter);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
	public String getDataPrevistaString() {
		if(dataPrevista != null) {
			return dataPrevista.format(Util.formatter);
		}
		return "";
	}
	public void setDataPrevistaString(String dataPrevistaString) {
		try {
			if(dataPrevistaString != null && !dataPrevistaString.equals("")) {
				dataPrevista = LocalDate.parse(dataPrevistaString, Util.formatter);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
	public String getDataImplantacaoString() {
		if(dataImplantacao != null) {
			return dataImplantacao.format(Util.formatter);
		}
		return "";
	}
	public void setDataImplantacaoString(String dataImplantacaoString) {
		try {
			if(dataImplantacaoString != null && !dataImplantacaoString.equals("")) {
				dataImplantacao = LocalDate.parse(dataImplantacaoString, Util.formatter);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
	public Double getNumeroRtc() {
		return numeroRtc;
	}
	public void setNumeroRtc(Double numeroRtc) {
		this.numeroRtc = numeroRtc;
	}
	public String getSiglaSistema() {
		return siglaSistema;
	}
	public void setSiglaSistema(String siglaSistema) {
		this.siglaSistema = siglaSistema;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public LocalDate getDataCrq() {
		return dataCrq;
	}
	public void setDataCrq(LocalDate dataCrq) {
		this.dataCrq = dataCrq;
	}
	public LocalDate getDataPrevista() {
		return dataPrevista;
	}
	public void setDataPrevista(LocalDate dataPrevista) {
		this.dataPrevista = dataPrevista;
	}
	public LocalDate getDataImplantacao() {
		return dataImplantacao;
	}
	public void setDataImplantacao(LocalDate dataImplantacao) {
		this.dataImplantacao = dataImplantacao;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	
	@JsonIgnore
	public RequisicaoMudanca getRM() {
		RequisicaoMudanca rm = new RequisicaoMudanca();
		rm.setNumeroRtc(numeroRtc);
		rm.setSiglaSistema(siglaSistema);
		rm.setResumo(resumo);
		rm.setDataEntrega(dataEntrega);
		rm.setDataCrq(dataCrq);
		rm.setDataPrevista(dataPrevista);
		rm.setDataImplantacao(dataImplantacao);
		rm.setDetalhe(detalhe);
		rm.setId(id);
		
		return rm;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
