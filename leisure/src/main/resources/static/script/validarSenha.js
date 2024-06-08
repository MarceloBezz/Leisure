const senha = document.querySelector('#senha')
const senha2 = document.querySelector('#senha2')
const mensagem = document.querySelector('.cadastro__container__validacaoSenha')


senha2.addEventListener('blur', () => {
    senha.value != senha2.value ? 
    (mensagem.style.color = 'red', mensagem.innerHTML = '<i class="fa-regular fa-circle-exclamation"></i> As senhas não conferem.') :
    (mensagem.style.color = 'green', mensagem.innerHTML = '<i class="fa-solid fa-check"></i> Senhas conferem')})

    function senhaValidation(){
    if(senha.value == senha2.value){
        return true
    }else{
        return false
    }
    }


function checkIguality(field) {
	var inputField = document.getElementById(field);
	var value = inputField.value;
	var feedback = document.getElementById(field + "-feedback");
	var minLength = inputField.getAttribute('minlength');

	// Verifica se o campo tem o comprimento mínimo
	if (value.length < minLength) {
		feedback.textContent = `O campo ${field} deve ter pelo menos ${minLength} caracteres.`;
		feedback.style.color = "blue";
		return;
	}else{
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
			}else {
				feedback.textContent = `${field.charAt(0).toUpperCase() + field.slice(1)} válido.`;
				feedback.style.color = "green";
			}
		}
	};

	 xhr.send(JSON.stringify({field: field, value: value}));
    }
}	

//FUNÇÃO PARA VERIFICAR TODOS OS CAMPOS
    function checkAllFields() {
        var emailField = $('#email');
        var telefoneField = $('#telefone');
        var cpfField = $('#cpf');
		var dataValidacao = dataValidation();
        var senhaValidacao = senhaValidation();
        var nome = document.getElementById("cadastroNome").value;
        
        var nomeValid = nomeValidation(nome);
        var emailValid = emailField.val().length >= emailField.attr("minLength") && $('#email-feedback').css("color") === "rgb(0, 128, 0)"; // Verde
        var telefoneValid = telefoneField.val().length >= telefoneField.attr("minLength") && $('#telefone-feedback').css("color") === "rgb(0, 128, 0)"; // Verde
        var cpfValid = cpfField.val().length >= cpfField.attr("minLength") && $('#cpf-feedback').css("color") === "rgb(0, 128, 0)"; // Verde

        if (emailValid && telefoneValid && cpfValid && dataValidacao && senhaValidacao && nomeValid) { //Se todos estiverem corretos
            return true;
        } else {
            return false;
        }
    }

function dataValidation() {
    var dataFeedback = $('#data-feedback');
    var dataValue = $('#data').val();

    var data = new Date(dataValue);
    var ano = data.getFullYear();
    var mes = data.getMonth() + 1;
    var dia = data.getDate();

    var today = new Date();
    var anoAtual = today.getFullYear();
    var mesAtual = today.getMonth() + 1; // Os meses começam de 0
    var diaAtual = today.getDate();

    // Verifica se o campo data está preenchido corretamente
    if (!isNaN(data.getTime())) {
        var idade = anoAtual - ano;

        if (mesAtual < mes || (mesAtual === mes && diaAtual < dia)) {
            idade--;
        }

		if(idade < 0 || idade > 120){
			dataFeedback.text("Data inválida.");
			dataFeedback.css("color", "red");
			return false;
		}
       else if (idade >= 18) {
            dataFeedback.text("Data válida.");
            dataFeedback.css("color", "green");
			return true;
        } else if(idade < 18){
            dataFeedback.text("Você deve ter pelo menos 18 anos.");
            dataFeedback.css("color", "red");
			return false;
        }
	}
}

function validationLength(field){
	var value = field.split(/[()\-]/).join('');

	if(value < 11){
		return false;
	}else{
		return true;
	}
}

document.getElementById("formCadastro").addEventListener("submit",function(event){
    var verificar = checkAllFields()
    if(verificar === true){
        if(window.confirm("Deseja confirmar seu cadastro?")){
            
        }else{
            alert("Cadastro cancelado");
            event.preventDefault();
        }
    }else{
        alert("Preencha o formulário corretamente");
        event.preventDefault();
    }
})

function nomeValidation(nome){
    if(isNaN(nome)){
        return true;
    }else{
        return false;
    }
}