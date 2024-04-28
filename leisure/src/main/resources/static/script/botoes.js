//BOTOES FILTRO DA PAGINA DE PESQUISA
    const btnFiltro = document.querySelectorAll('[data-filtro]');

    const filtro = document.querySelector('.filtro__filtro')
    const menuLateral = document.querySelector('.lista-menu')
    const btnHamburguer = document.querySelector('.container__rotulo i')
    const btnMenuLateralClose = document.querySelector('.home label')

    const btnSubmenu = document.querySelectorAll('[data-menu]');
    const btnSubmenuLista = document.querySelectorAll('[data-submenu]');
    const btnArrow = document.querySelectorAll('[data-arrow]');

//BOTAO CATEGORIAS E NOSSO APP
    try{
        btnSubmenu.forEach((botao, index) => {
            botao.addEventListener('click', () => {
                btnSubmenuLista[index].classList.toggle('hidden');
                btnArrow[index].classList.toggle('fa-chevron-right');
                btnArrow[index].classList.toggle('fa-chevron-down');
            })
        })
    }catch {

    }

//BOTAO PERFIL
    const btnPerfilLista = document.querySelector('.logout__lista')

    try {
        btnPerfil.addEventListener('click', function(event) {
            event.stopPropagation();
            btnPerfilLista.classList.toggle('hidden')
        })
        function closeClick(event) {
            // if(btnPerfilLista && ! btnPerfilLista.contains(event.target)) {
            //     btnPerfilLista.classList.add('hidden');
            // }
            btnPerfilLista && ! btnPerfilLista.contains(event.target) ? btnPerfilLista.classList.add('hidden') : null;
        }
        
        document.addEventListener('click', closeClick)
    } catch {
        
    }
//FIM

    btnFiltro.forEach(botao => {
        botao.addEventListener('click', () => {
            const btnFiltroAtributo = botao.getAttribute('data-filtro');
            btnFiltroAtributo === "filtrar" ? (filtro.style.left = '0', menuLateral.style.left = '-600px') : null;
            btnFiltroAtributo === "filtrarClose" ? filtro.style.left = '-600px' : null;
        })
    });
    
    try {
        btnHamburguer.addEventListener('click', () => {
            menuLateral.style.left < '0'
            ? (menuLateral.style.left = '0', btnMenuIcone.classList.remove('fa-bars'), btnMenuIcone.classList.add('fa-xmark')) 
            : (menuLateral.style.left = '-600px', btnMenuIcone.classList.remove('fa-xmark'), btnMenuIcone.classList.add('fa-bars'));
        })
    }catch {

    }

    try {
        btnMenuLateralClose.addEventListener('click', () => {
            menuLateral.style.left = '-600px';
            btnMenuIcone.classList.remove('fa-xmark');
            btnMenuIcone.classList.add('fa-bars');
        })
    }catch {

    }
//FIM
