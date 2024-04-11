const notCheckedBox = document.querySelector('#menu');

var barra = document.querySelector('.anunciar__conteudo__progresso-barra');
const listaBtnAnterior = document.querySelectorAll('.anunciar__conteudo__botao-anterior');
const listaBtnProximo = document.querySelectorAll('.anunciar__conteudo__botao-proximo');
const formBox = document.querySelectorAll('.anunciar__conteudo__box');
var progresso = 0;
var i = 0;

// IMAGEM PERFIL
const id = document.getElementById("id_usuario").value;
const imagemPerfil = document.querySelector('.meusdados__imagem label');
imagemPerfil.style.backgroundImage = "url('http://localhost:8080/usuario/imagem/" + id + "')";

// NOVA FUNCAO DE PROXIMO/ANTERIOR

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
