package org.deem.project.leisure.service;
import java.util.List;

import org.deem.project.leisure.model.Imovel;
import org.deem.project.leisure.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {
	@Autowired
	private ImovelRepository repository;
	
	public ImovelService(ImovelRepository repository) {
		this.repository = repository;
	}
	
	public Imovel findById(long id) {
		return repository.findById(id);
	}
	
	public Imovel findByUsuario(Imovel imovel) {
		return repository.findByUsuario(imovel.usuario);
	}
	
	public Imovel save(Imovel imovel) {
		takeOffMask(imovel);
		return repository.save(imovel);
	}
	
	public boolean existsByCepAndNumero(String cep, int numero) {
		return repository.existsByCepAndNumero(cep, numero);
	}
	
	public List<Imovel> findByUsuarioId(Long id) {
		return repository.findByUsuarioId(id);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Imovel atualizar(Imovel imovelDes, Imovel imovelAtt){
		
		if(imovelDes.getNumQuartos() != null){
			imovelAtt.setNumQuartos(imovelDes.getNumQuartos());
		}
		
		if(imovelDes.getNumBanheiros() != null){
			imovelAtt.setNumBanheiros(imovelDes.getNumBanheiros());
		}
		
		if(imovelDes.getVagasGaragem() != null){
			imovelAtt.setVagasGaragem(imovelDes.getVagasGaragem());
		}
		
		if(imovelDes.getNumero() != null){
			imovelAtt.setNumero(imovelDes.getNumero());
		}
		
		if(imovelDes.getDescricao() != null){
			imovelAtt.setDescricao(imovelDes.getDescricao());
		}
		
		if(imovelDes.getPreco() != null){
			imovelAtt.setPreco(imovelDes.getPreco());
		}

		if(imovelDes.getArea() != null){
			imovelAtt.setArea(imovelDes.getArea());
		}
		
		return repository.save(imovelAtt);
	}
	
	public void takeOffMask(Imovel imovel){
		String cep = imovel.getCep().replaceAll("[^0-9]", "");
		imovel.setCep(cep);
	}

}
