const btnMenuIcone = document.querySelector('.container__rotulo i');
const btnModal = document.querySelector('[data-modal]');
const modalLogin = document.querySelector('.modal__login');
const btnLogin = document.querySelector('.btn-login');
const btnCadastrar = document.querySelector('.btn-cadastrar');
const loadingScreen = document.querySelector('.loading')

function loading() {
	loadingScreen.style.display = 'block';

	window.addEventListener('load', () => {
		loadingScreen.style.display = 'none';
	})
}
document.addEventListener('DOMContentLoaded', () => {
	loadingScreen.style.display = 'block';
})

window.addEventListener('load', () => {
	loadingScreen.style.display = 'none';
})

document.addEventListener('keydown', event =>{
    if(event.keyCode === 9){
        event.preventDefault();
    }
})

if(btnLogin){
	btnLogin.addEventListener('click', () =>{
		btnModal.classList.toggle('hidden');
		modalLogin.classList.toggle('hidden');
	});
}else{

};

if(btnCadastrar){
	btnCadastrar.addEventListener('click', () =>{
		btnModal.classList.toggle('hidden');
		modalLogin.classList.toggle('hidden');
	});
}else{

};
