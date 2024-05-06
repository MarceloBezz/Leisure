const mascaras = document.querySelectorAll('[data-cadastro]');
    
mascaras.forEach(campo => {
    campo.addEventListener('keypress', () => {
        let dataAtribute = campo.getAttribute('data-cadastro')
        let inputLength = campo.value.length;

// MASCARA CPF
        dataAtribute === 'cadastroCpf' ?
            inputLength === 3 || inputLength === 7 ?
            campo.value += '.' : 
            inputLength === 11 ?
            campo.value += '-' : null
        : null;

// MASCARA TELEFONE
        dataAtribute === 'cadastroTelefone' ?
            inputLength === 0 ?
            campo.value += '(' :
            inputLength === 3 ?
            campo.value += ') ' :
            inputLength === 10 ?
            campo.value += '-' : null
        : null;
    })
})
