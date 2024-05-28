package org.deem.project.leisure.service;

import java.util.List;

import org.deem.project.leisure.model.Imovel;
import org.deem.project.leisure.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FiltroService {
 
    @Autowired
    private ImovelRepository repository;

    public List<Imovel> filtragemDeImoveis(String tipo, Double precoMinimo, Double precoMaximo, String cidade, String bairro, Integer numQuartos){
		Specification<Imovel> spec = Specification.where(null);
		
		if(tipo != null && !tipo.isEmpty()) {
			spec = spec.and((root, query, builder) -> builder.equal(root.get("tipo"), tipo));
		}
		
		if(cidade != null && !cidade.isEmpty()) {
			spec = spec.and((root, query, builder) -> builder.like(root.get("cidade"),"%" + cidade + "%"));
		}
		
		if(bairro != null && !bairro.isEmpty()) {
			spec = spec.and((root, query, builder) -> builder.equal(root.get("bairro"),"%" + bairro + "%"));
		}
		
		if(numQuartos != null) {
			spec = spec.and((root, query, builder) -> builder.greaterThanOrEqualTo(root.get("numQuartos"), numQuartos));
		}
		
	    if (precoMinimo != null && precoMaximo != null) {
	        spec = spec.and((root, query, builder) -> builder.between(root.get("preco"), precoMinimo, precoMaximo));
	    } else if (precoMinimo != null) {
	        spec = spec.and((root, query, builder) -> builder.greaterThanOrEqualTo(root.get("preco"), precoMinimo));
	    } else if (precoMaximo != null) {
	        spec = spec.and((root, query, builder) -> builder.lessThanOrEqualTo(root.get("preco"), precoMaximo));
	    }
		
		
		return repository.findAll(spec);
	}

    

}
