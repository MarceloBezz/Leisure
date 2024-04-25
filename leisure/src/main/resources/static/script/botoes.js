//BOTOES FILTRO DA PAGINA DE PESQUISA
    const btnFiltro = document.querySelector('#btnFiltro')
    const filtro = document.querySelector('.filtro__filtro')
    const menuLateral = document.querySelector('.lista-menu')
    const btnFiltroClose = document.querySelector('#btnFiltroClose')
    const btnHamburguer = document.querySelector('.container__rotulo i')
    const btnMenuLateralClose = document.querySelector('.home label')

//BOTAO PERFIL
    const btnPerfilLista = document.querySelector('.logout__lista')

    try {
        btnPerfil.addEventListener('click', function(event) {
            event.stopPropagation();
            btnPerfilLista.classList.toggle('hidden')
        })
        function closeClick(event) {
            if(btnPerfilLista && ! btnPerfilLista.contains(event.target)) {
                btnPerfilLista.classList.add('hidden');
            }
        }
        
        document.addEventListener('click', closeClick)
    } catch (error) {
        
    }
//FIM

    try {
        btnFiltro.addEventListener('click', () => {
            filtro.style.left = '0';
            menuLateral.style.left = '-600px';
        })
    }catch (error) {

    }

    try {
        btnFiltroClose.addEventListener('click', () => {
            filtro.style.left = '-600px';
        }) 
    }catch (error) {

    }
    
    try {
        btnHamburguer.addEventListener('click', () => {
            menuLateral.style.left < '0'
            ? menuLateral.style.left = '0' || btnMenuIcone.classList.remove('fa-bars') || btnMenuIcone.classList.add('fa-xmark') 
            : menuLateral.style.left = '-600px' || btnMenuIcone.classList.remove('fa-xmark') || btnMenuIcone.classList.add('fa-bars');
        })
    }catch (error) {

    }

    try {
        btnMenuLateralClose.addEventListener('click', () => {
            menuLateral.style.left = '-600px';
            btnMenuIcone.classList.remove('fa-xmark');
            btnMenuIcone.classList.add('fa-bars');
        })
    }catch (error) {

    }
//FIM
