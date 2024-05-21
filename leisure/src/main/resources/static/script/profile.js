//VARIAVEIS DO CADASTRO DE IMOVEIS

var barra = document.querySelector('.anunciar__conteudo__progresso-barra');
const listaBtnAnterior = document.querySelectorAll('.anunciar__conteudo__botao-anterior');
const listaBtnProximo = document.querySelectorAll('.anunciar__conteudo__botao-proximo');
const formBox = document.querySelectorAll('.anunciar__conteudo__box');
const valorInput = document.querySelectorAll('.anunciar__conteudo__input');
const endereco = document.querySelectorAll('[data-anunciar="endereco"]')
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

//CADASTRO DO USUÁRIO

function checkIguality(field) {
	var value = document.getElementById(field).value;
	var feedback = document.getElementById(field + "-feedback");

	//Fazer a requisição AJAX para o servidor
	var xhr = new XMLHttpRequest();
	xhr.open("post", "/leisure/checar", true);
	xhr.setRequestHeader("Content-Type","application/json;charset=UTF-8");

	xhr.onreadystatechange = function() {
		if(xhr.readyState === 4 && xhr.status === 200){
			var response = JSON.parse(xhr.responseText);
			if(response.exists){
				feedback.textContent = `Este ${field} já está cadastrado.`;
				feedback.style.color = "red";
			} else {
				feedback.textContent = `${field.charAt(0).toUpperCase() + field.slice(1)} válido.`;
				feedback.style.color = "green";
			}
		}
	};

	 xhr.send(JSON.stringify({field: field, value: value}));

}	

$(document).ready(function() {
	// Função para verificar todos os campos
    function checkAllFields() {
        var emailField = $('#email');
        var telefoneField = $('#telefone');
        var cpfField = $('#cpf');

        var emailValid = emailField.val().length >= emailField.attr("minlength") && $('#email-feedback').css("color") === "rgb(0, 128, 0)"; // Verde
        var telefoneValid = telefoneField.val().length >= telefoneField.attr("minlength") && $('#telefone-feedback').css("color") === "rgb(0, 128, 0)"; // Verde
        var cpfValid = cpfField.val().length >= cpfField.attr("minlength") && $('#cpf-feedback').css("color") === "rgb(0, 128, 0)"; // Verde

        if (emailValid && telefoneValid && cpfValid) { //Se todos estiverem corretos
            $('#btnCadastro').prop("disabled", false);
        } else {
            $('#btnCadastro').prop("disabled", true);
        }
    }

	setInterval(checkAllFields, 500); //Executar função a cada 0,5 segundos


    // Desabilita o botão no início
    $('#btnCadastro').prop("disabled", false);
});

