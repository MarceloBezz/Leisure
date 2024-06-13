const btnCadastro = document.querySelector('[data-acesso="btn-cadastro"]')
const btnLogin = document.querySelector('[data-acesso="btn-login"]')
const campoLogin = document.querySelector('[data-acesso="login"]')
const campoCadastro = document.querySelector('[data-acesso="cadastro"]')

btnCadastro.addEventListener('click', () => {
    campoLogin.style.display = 'none'
    campoCadastro.style.display = 'block'
})

btnLogin.addEventListener('click', () => {
    campoCadastro.style.display = 'none'
    campoLogin.style.display = 'block'
});
