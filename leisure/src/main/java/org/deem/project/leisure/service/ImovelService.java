package org.deem.project.leisure.service;



import org.deem.project.leisure.model.Imovel;
import org.deem.project.leisure.repository.ImovelRepository;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {
	private ImovelRepository repository;
	
	public ImovelService(ImovelRepository repository) {
		this.repository = repository;
	}
	
	/*public List<Imovel> findAll() {
		return repository.findAllByAtivo(true);
	}*/
	
	public Imovel findById(long id) {
		return repository.findById(id);
	}
	
	public Imovel findByUsuario(Imovel imovel) {
		return repository.findByUsuario(imovel.usuario);
	}
	
	public Imovel save(Imovel imovel) {
		return repository.save(imovel);
	}
	
	public boolean existsByCepAndNumero(int cep, int numero) {
		return repository.existsByCepAndNumero(cep, numero);
	}
	

}
