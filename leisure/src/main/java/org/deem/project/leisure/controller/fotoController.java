package org.deem.project.leisure.controller;

import java.io.IOException;


import org.deem.project.leisure.service.FotoService;
import org.deem.project.leisure.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.core.io.Resource;




@Controller
public class fotoController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    FotoService fotoService;

    
    @GetMapping("/fotoTeste")
    public String getMethodName() {
        return "fotoTeste";
    }


    @PostMapping("/fotoTeste/enviar")
	public String salvar(
			@Validated ModelMap model,
            @RequestParam("image") MultipartFile file,
            RedirectAttributes redirectAttributes,
            BindingResult bindingResult) {
 
	        // VAI USAR ESSE TRECHO 
	        try {
	            String imageUrl = fotoService.uploadImageToApiPic(file,2,"fotoPerfil");
	            redirectAttributes.addFlashAttribute("serverMessage", "Imagem enviada e URL salva com sucesso!");
                model.addAttribute("link", imageUrl);
                return "redirect:/fotoTeste";
	        } catch (IOException e) {
	            e.printStackTrace();
	            // Redireciona com uma mensagem de erro
	            redirectAttributes.addFlashAttribute("serverMessage", "Falha ao enviar a imagem!");
	        }
            return "fotoTeste";
        }

        @GetMapping("/foto")
        public ResponseEntity<Resource> downloadImage() {
            String imageUrl = "https://suntech.eco.br/api/uploads/fotoPerfil2.png";
            Resource image = fotoService.getImageFromApi(imageUrl);
    
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "image/png"); // Ajuste o tipo de conteúdo conforme necessário
    
            return new ResponseEntity<>(image, headers, HttpStatus.OK);
        }
    }      
    
