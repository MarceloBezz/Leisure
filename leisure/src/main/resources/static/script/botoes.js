const btnHamburguer = document.querySelector('.container__rotulo i')
const menuLateral = document.querySelector('.lista-menu')
const btnMenuLateralClose = document.querySelector('.home label')
const btnFiltro = document.querySelector('#btnFiltro')
const btnFiltroClose = document.querySelector('#btnFiltroClose')
const filtro = document.querySelector('.resultado-pesquisa__filtro')

btnFiltro.addEventListener('click', () => {
    filtro.style.left = '0';
    menuLateral.style.left = '-600px';
})

btnFiltroClose.addEventListener('click', () => {
    filtro.style.left = '-600px';
})

btnHamburguer.addEventListener('click', () => {
    menuLateral.style.left < '0'
    ? menuLateral.style.left = '0' || btnMenuIcone.classList.remove('fa-bars') || btnMenuIcone.classList.add('fa-xmark') 
    : menuLateral.style.left = '-600px' || btnMenuIcone.classList.remove('fa-xmark') || btnMenuIcone.classList.add('fa-bars');
})

btnMenuLateralClose.addEventListener('click', () => {
    menuLateral.style.left = '-600px';
    btnMenuIcone.classList.remove('fa-xmark');
    btnMenuIcone.classList.add('fa-bars');
})
