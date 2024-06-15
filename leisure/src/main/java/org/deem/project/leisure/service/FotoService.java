package org.deem.project.leisure.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;


@Service
public class FotoService {
   
    private final RestTemplate restTemplate;

    @Autowired
    public FotoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final String apiUrl = "https://suntech.eco.br/api/upload";

    public String uploadImageToApiPic(MultipartFile file, int id, String tipo) throws IOException {
        String imageUrl = "";
        
        // Extrai a extensão do nome original do arquivo
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = tipo + id + extension;
 
        // Salva o arquivo com o novo nome temporariamente
        File tempFile = new File(System.getProperty("java.io.tmpdir") + "/" + newFileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(file.getBytes());
        }
 
        // Chama a API REST /upload para enviar a imagem
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", new FileSystemResource(tempFile)); // Adiciona a imagem ao formulário multipart
 
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
 
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
 
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
 
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            // Se a requisição for bem-sucedida, salva a URL na entidade ImageCliente
            imageUrl = responseEntity.getBody(); // Obtém a URL da imagem da resposta da API
        }
 
        return imageUrl;
    }

    public Resource getImageFromApi(String imageUrl) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Resource> response = restTemplate.exchange(imageUrl, HttpMethod.GET, entity, Resource.class);
        return response.getBody();
    }
    }

