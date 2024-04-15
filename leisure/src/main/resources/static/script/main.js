const input = document.querySelectorAll('input');
const option = document.querySelectorAll('select');
// const btnMenu = document.querySelector('#menu');
const btnMenuIcone = document.querySelector('.container__rotulo i');
const btnSubmenuIndex = document.querySelector('.btn-submenu');
const btnSubmenuDownload = document.querySelector('.btn-download');
const btnArrowReplaceCategoria = document.querySelector('.arrow-replace-categoria');
const btnArrowReplaceDownload = document.querySelector('.arrow-replace-download');

const modalCadastrar = document.querySelector('.modal__cadastrar');
const modalLogin = document.querySelector('.modal__login');
const btnLogin = document.querySelector('.btn-login');
const btnCadastrar = document.querySelector('.btn-cadastrar');

const listasubMenuCategoria = document.querySelectorAll('.lista-menu__sublista-categoria');
const listasubMenuDownload = document.querySelectorAll('.lista-menu__sublista-download');
const listaSubMenu = document.querySelectorAll('.lista-menu__sublista-item');



document.addEventListener('keydown', event =>{
    if(event.keyCode === 9){
        event.preventDefault();
    }
})


if(btnSubmenuIndex){
	btnSubmenuIndex.addEventListener('click', () => {
		listasubMenuCategoria.forEach(click => {
			click.classList.toggle('hidden');
		})
		btnArrowReplaceCategoria.classList.toggle('fa-chevron-right');
		btnArrowReplaceCategoria.classList.toggle('fa-chevron-down');
	});
}else{

};


if(btnLogin){
	btnLogin.addEventListener('click', () =>{
		modalCadastrar.classList.toggle('hidden');
		modalLogin.classList.toggle('hidden');
	});
}else{

};

if(btnCadastrar){
	btnCadastrar.addEventListener('click', () =>{
		modalCadastrar.classList.toggle('hidden');
		modalLogin.classList.toggle('hidden');
	});
}else{

};

