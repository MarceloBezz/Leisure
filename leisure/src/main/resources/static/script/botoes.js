const btnFiltro = document.querySelector('#btnFiltro')
const filtro = document.querySelector('.resultado-pesquisa__filtro')
const btnLogout = document.querySelector('.logout');
const listaLogout = document.querySelector('.logout__lista');

window.onload = menu();

function menu (){
    if(window.innerWidth < 768){
        listaLogout.style.display = 'block'
    }else{
        listaLogout.style.display = 'none'
    }
}

btnLogout.addEventListener('click', () => {
    if(window.innerWidth > 767){
        listaLogout.style.display === 'none' ? listaLogout.style.display = 'block' : listaLogout.style.display = 'none';
    }
    
        // if(window.innerWidth > 767){
        //     listaLogout.classList.toggle('hidden')
        // }else {
        //     listaLogout.classList.remove('hidden')
        // }
    
})


btnFiltro.addEventListener('click', () => {
    filtro.classList.toggle('hidden')
});
