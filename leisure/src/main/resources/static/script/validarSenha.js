const senha = document.querySelector('#senha')
const senha2 = document.querySelector('#senha2')
const mensagem = document.querySelector('.cadastro__container__validacaoSenha')

senha2.addEventListener('blur', () => {
    senha.value != senha2.value ? 
    (mensagem.style.color = 'red', mensagem.innerHTML = '<i class="fa-regular fa-circle-exclamation"></i> As senhas não conforem.') :
    (mensagem.style.color = 'green', mensagem.innerHTML = '<i class="fa-solid fa-check"></i> Senhas conferem')
})