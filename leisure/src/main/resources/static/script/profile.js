//VARIAVEIS DO CADASTRO DE IMOVEIS

var barra = document.querySelector('.anunciar__conteudo__progresso-barra');
const listaBtnAnterior = document.querySelectorAll('.anunciar__conteudo__botao-anterior');
const listaBtnProximo = document.querySelectorAll('.anunciar__conteudo__botao-proximo');
const listaQuestao = document.querySelectorAll('[data-profile="question"]')
const formBox = document.querySelectorAll('.anunciar__conteudo__box');
const valorInput = document.querySelectorAll('.anunciar__conteudo__input');
const endereco = document.querySelectorAll('[data-anunciar="endereco"]')
const validarValorNegativoELetras = document.querySelectorAll('[data-profile="imputValida"]')
var progresso = 0;
var i = 0;

//IMAGEM PERFIL

const autoSubmitDaImagem = document.querySelector('[data-input-imagem]');

try{
const id = document.getElementById("id_usuario").value;
}catch(error){

}

const imagemPerfil = document.querySelector('.meusdados__imagem label');
const btnPerfil = document.querySelector('.container__usuario-imagem');


//INPUT IMAGEM PERFIL
try {
	autoSubmitDaImagem.addEventListener('change', () => {
		const form = document.querySelector('[data-form-imagem]');
		form.submit();
		loading();
	})
}catch (error) {
	
}

//FUNÇAO BOTAO ANTERIOR E PROXIMO DO CADASTRO DE IMOVEIS
	try{
		listaBtnProximo.forEach(function (botao){
			botao.addEventListener('click', function (){
				const index = Array.from(listaBtnProximo).indexOf(this);
				i = index;
				function proximoForm (){
					formBox[i].style.left = '-450px';
					i = i+1;
					progresso += 26;
					formBox[i].style.left = '40px';
					barra.style.width = `${progresso}px`;
				}
				valorInput.forEach(valor => {
					valor = valorInput.value;
				})
				if(index < formBox.length || valor !=''){
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
					progresso -= 26;
					barra.style.width = `${progresso}px`;
				}
				if(index){
					anteriorForm();
				}
			})
		});
	}catch {
		
	}

//CADASTRO DOS IMÓVEIS
endereco.forEach(contexto => {
	contexto.addEventListener('blur', () => {
		const text = contexto.value;
		const resultado = text.split(' ');
		const arr = resultado.map(input => input.substring(0,1).toUpperCase() + input.substring(1,input.length).toLowerCase());
		contexto.value = arr.join(' ');
	})
})

//PÁGINA DE ADM
function deletarUsuario(id){
	var xhttp = new XMLHttpRequest();
	xhttp.open("POST", "/usuario/deletar/" + id, true)

	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			var response = JSON.parse(xhttp.responseText);
			window.alert(response.mensagem);
			window.location.reload();
		}
	}
	
	xhttp.send(JSON.stringify({id: id}));
}

//VALIDAR VALOR NEGATIVO E LETRAS

// validarValorNegativoELetras.forEach(validacao => {
// 	validacao.addEventListener('change', (event) => {
// 		const valor = event.target.value;

// 		isNaN(valor) || parseFloat(valor) < 0 ?
// 		event.target.classList.add('invalid') :
// 		event.target.classList.remove('invalid')
// 	})
// 	document.querySelector('[data-profile="formAnunciar"]').addEventListener('submit', (event) => {
// 		validacao.classList.contains('invalid') ?
// 		event.preventDefault() : null;
// 		alert('inserir valores valido')
// 	})
// })

