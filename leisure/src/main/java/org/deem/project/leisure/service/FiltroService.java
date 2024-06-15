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

    public List<Imovel> filtragemDeImoveis(String tipo, Double precoMinimo, Double precoMaximo, String cidade, String bairro, Integer numQuartos,
											String sustentabilidade,Double area, Integer vagasGaragem){
		Specification<Imovel> spec = Specification.where(null);
		boolean add = false;
		
		if(tipo != null && !tipo.isEmpty()) {
			spec = spec.and((root, query, builder) -> builder.equal(root.get("tipo"), tipo));
			add = true;
		}
		
		if(cidade != null && !cidade.isEmpty()) {
			spec = spec.and((root, query, builder) -> builder.like(root.get("cidade"),"%" + cidade + "%"));
			add = true;
		}
		
		if(bairro != null && !bairro.isEmpty()) {
			spec = spec.and((root, query, builder) -> builder.like(root.get("bairro"),"%" + bairro + "%"));
			add = true;
		}
		
		if(numQuartos != null) {
			spec = spec.and((root, query, builder) -> builder.equal(root.get("numQuartos"), numQuartos));
			add = true;
		}
		
	    if (precoMinimo != null && precoMaximo != null) {
	        spec = spec.and((root, query, builder) -> builder.between(root.get("preco"), precoMinimo, precoMaximo));
			add = true;
	    } else if (precoMinimo != null) {
	        spec = spec.and((root, query, builder) -> builder.greaterThanOrEqualTo(root.get("preco"), precoMinimo));
			add = true;
	    } else if (precoMaximo != null) {
	        spec = spec.and((root, query, builder) -> builder.lessThanOrEqualTo(root.get("preco"), precoMaximo));
			add = true;
	    }

		if(sustentabilidade != null && !sustentabilidade.isEmpty()) {
			spec = spec.and((root, query, builder) -> builder.equal(root.get("sustentabilidade"), sustentabilidade));
			add = true;
		}

		if(area != null) {
			spec = spec.and((root, query, builder) -> builder.greaterThanOrEqualTo(root.get("area"),area));
			add = true;
		}

		if(vagasGaragem != null) {
			spec = spec.and((root, query, builder) -> builder.equal(root.get("vagasGaragem"),vagasGaragem));
			add = true;
		}
		
		if(add == false){
			return repository.findAll();
		}else{
		return repository.findAll(spec);
		}
	}

    
}
