// const notCheckedBox = document.querySelector('#menu');


//VARIAVEIS DO CADASTRO DE IMOVEIS
var barra = document.querySelector('.anunciar__conteudo__progresso-barra');
const listaBtnAnterior = document.querySelectorAll('.anunciar__conteudo__botao-anterior');
const listaBtnProximo = document.querySelectorAll('.anunciar__conteudo__botao-proximo');
const formBox = document.querySelectorAll('.anunciar__conteudo__box');
var progresso = 0;
var i = 0;

//IMAGEM PERFIL
const autoSubmitDaImagem = document.querySelector('#input-file');
const id = document.getElementById("id_usuario").value;
const imagemPerfil = document.querySelector('.meusdados__imagem label');
const btnPerfil = document.querySelector('.container__usuario-imagem');


//IMAGEM PERFIL
	try {
		imagemPerfil.style.backgroundImage = "url('http://localhost:8080/usuario/imagem/" + id + "')";
		btnPerfil.style.backgroundImage = "url('http://localhost:8080/usuario/imagem/" + id + "')";		
		autoSubmitDaImagem.addEventListener('change', () => {
			const form = document.querySelector('#form-imagem')
			form.submit();
		})
	}catch (error) {
		
	}
//FIM

//FUNÇAO BOTAO ANTERIOR E PROXIMO DO CADASTRO DE IMOVEIS
	try{
		listaBtnProximo.forEach(function (botao){
			botao.addEventListener('click', function (){
				const index = Array.from(listaBtnProximo).indexOf(this);
				i = index;
				function proximoForm (){
					formBox[i].style.left = '-450px';
					i = i+1;
					progresso += 30;
					formBox[i].style.left = '40px';
					barra.style.width = `${progresso}px`;
				}
				if(index < formBox.length){
					proximoForm();
				}		
			})
		});
		listaBtnAnterior.forEach(function (botao){
			botao.addEventListener('click', function (){
				const index = Array.from(listaBtnAnterior).indexOf(this);
				i = index;
				function anteriorForm (){
					i =  i-1;
					formBox[i].style.left = '40px';
					i = index;
					formBox[i].style.left = '450px';
					progresso -= 30;
					barra.style.width = `${progresso}px`;
				}
				if(index){
					anteriorForm();
				}
			})
		});
	}catch {
		
	}
//FIM
