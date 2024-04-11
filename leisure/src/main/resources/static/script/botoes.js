const btnFiltro = document.querySelector('#btnFiltro')
const filtro = document.querySelector('.resultado-pesquisa__filtro')

btnFiltro.addEventListener('click', () => {
    filtro.classList.toggle('hidden')
})