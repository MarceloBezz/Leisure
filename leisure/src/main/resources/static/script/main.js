const input = document.querySelectorAll('input');
const option = document.querySelectorAll('select');
const btnMenu = document.querySelector('#menu');
const btnMenuIcone = document.querySelector('.container__rotulo i');
const btnSubmenuIndex = document.querySelector('.btn-submenu');
const btnSubmenuDownload = document.querySelector('.btn-download');
const btnArrowReplaceCategoria = document.querySelector('.arrow-replace-categoria');
const btnArrowReplaceDownload = document.querySelector('.arrow-replace-download');
const btnLoginCadastro = document.querySelector('.container__usuario');

const modalCadastrar = document.querySelector('.modal__cadastrar');
const modalLogin = document.querySelector('.modal__login');
const btnLogin = document.querySelector('.btn-login');
const btnCadastrar = document.querySelector('.btn-cadastrar');

// ALTERAR TEMA

const body = document.querySelectorAll('.body');
const btnTrocarTema = document.querySelector('.btnTemaChange');
const iconSol = document.querySelectorAll('.fa-sun');
const iconLua = document.querySelectorAll('.fa-moon');
const header = document.querySelectorAll('.cabecalho');
const listaMenu = document.querySelectorAll('.lista-menu');
const listaMenuItem = document.querySelectorAll('.container__link');
const listaMenuItemSpan = document.querySelectorAll('.container__link span');
const listasubMenuCategoria = document.querySelectorAll('.lista-menu__sublista-categoria');
const listasubMenuDownload = document.querySelectorAll('.lista-menu__sublista-download');
const listaSubMenu = document.querySelectorAll('.lista-menu__sublista-item');
const sobre = document.querySelectorAll('.sobre');
const time = document.querySelectorAll('.time__card');
const cardPremium = document.querySelectorAll('.premium__conteudo__box');
const bgResponsabilidade = document.querySelectorAll('.responsabilidade__conteudo');
const temaLocalStorage = localStorage.getItem('tema');

document.addEventListener('keydown', event =>{
    if(event.keyCode === 9){
        event.preventDefault();
    }
})

if(temaLocalStorage === 'temaDark'){
	aplicarDark();
	btnTrocarTema.checked = true;
}

btnTrocarTema.addEventListener('change', function (){
	if(btnTrocarTema.checked){
		aplicarDark ();
		localStorage.setItem('tema', 'temaDark');
	}else{
		removerDark ();
		localStorage.removeItem('tema');
	}
})

function aplicarDark (){
	input.forEach(tema =>{
		tema.classList.toggle('tema-dark-font');
	})
	option.forEach(tema =>{
		tema.classList.toggle('tema-dark-font');
	})
	iconSol.forEach(tema =>{
		tema.classList.toggle('hidden');
	})
	iconLua.forEach(tema =>{
		tema.classList.toggle('hidden');
	})
	body.forEach(tema => {
		tema.classList.add('tema-dark');
	})
	header.forEach(tema => {
		tema.classList.add('tema-dark');
	})
	listaMenu.forEach(tema => {
		tema.classList.add('tema-dark');
	})
	listaMenuItem.forEach(tema => {
		tema.classList.add('tema-dark');
	})
	listaMenuItemSpan.forEach(tema => {
		tema.classList.add('tema-dark');
	})
	listasubMenuCategoria.forEach(tema => {
		tema.classList.add('tema-dark');
	})
	listasubMenuDownload.forEach(tema => {
		tema.classList.add('tema-dark');
	})
	listaSubMenu.forEach(tema => {
		tema.classList.add('tema-dark');
	})
	sobre.forEach(tema => {
		tema.classList.add('tema-dark-sobre');
	})
	time.forEach(tema => {
		tema.classList.add('tema-dark-sobre');
	})
	cardPremium.forEach(tema => {
		tema.classList.add('tema-dark-sobre');
	})
	if(modalCadastrar || modalLogin){
		modalCadastrar.classList.add('tema-dark-sobre');
		modalLogin.classList.add('tema-dark-sobre');
	}else{}
	bgResponsabilidade.forEach(tema =>{
		tema.setAttribute('style', 'background-image: url("../img/imagem/cidadeFundo.png")');	
	})
}

function removerDark (){
	input.forEach(tema =>{
		tema.classList.toggle('tema-dark-font');
	})
	option.forEach(tema =>{
		tema.classList.toggle('tema-dark-font');
	})
	iconSol.forEach(tema =>{
		tema.classList.toggle('hidden');
	})
	iconLua.forEach(tema =>{
		tema.classList.toggle('hidden');
	})
	body.forEach(tema => {
		tema.classList.remove('tema-dark');
	})
	header.forEach(tema => {
		tema.classList.remove('tema-dark');
	})
	listaMenu.forEach(tema => {
		tema.classList.remove('tema-dark');
	})
	listaMenuItem.forEach(tema => {
		tema.classList.remove('tema-dark');
	})
	listaMenuItemSpan.forEach(tema => {
		tema.classList.remove('tema-dark');
	})
	listasubMenuCategoria.forEach(tema => {
		tema.classList.remove('tema-dark');
	})
	listasubMenuDownload.forEach(tema => {
		tema.classList.remove('tema-dark');
	})
	listaSubMenu.forEach(tema => {
		tema.classList.remove('tema-dark');
	})
	sobre.forEach(tema => {
		tema.classList.remove('tema-dark-sobre');
	})
	time.forEach(tema => {
		tema.classList.remove('tema-dark-sobre');
	})
	cardPremium.forEach(tema => {
		tema.classList.remove('tema-dark-sobre');
	})
	if(modalCadastrar || modalLogin){
		modalCadastrar.classList.remove('tema-dark-sobre');
		modalLogin.classList.remove('tema-dark-sobre');
	}else{}
	bgResponsabilidade.forEach(tema =>{
		tema.setAttribute('style', 'background-image: url("../img/imagem/cidadeFundo3.png")');	
	})
}

const swiper = new Swiper('.swiper', {
	// spaceBetween: 20,
	slidesPerView: 3,
	loop: false,
	breakpoints: {
		768: {
		  slidesPerView: 4,
		//   spaceBetween: 30
		},
		1024: {
			slidesPerView: 5,
		  //   spaceBetween: 30
		  }
	},
	pagination: {
		el: '.swiper-pagination',
	},
	
	navigation: {
		nextEl: '.swiper-button-next',
		prevEl: '.swiper-button-prev',
	},
	
	scrollbar: {
		el: '.swiper-scrollbar',
	},
});	

const swiperDestaques = new Swiper('.swiperDestaques', {
	spaceBetween: 20,
 	slidesPerView: 2,
	loop: true,
	breakpoints: {
		768: {
		  slidesPerView: 3,
		  spaceBetween: 30
		},
		1024: {
			slidesPerView: 4,
			spaceBetween: 30
		  }
	},
	pagination: {
	  el: '.swiper-pagination',
	},
  
	navigation: {
	  nextEl: '.swiper-button-next',
	  prevEl: '.swiper-button-prev',
	},
  
	scrollbar: {
	  el: '.swiper-scrollbar',
	},
});

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

btnSubmenuDownload.addEventListener('click', () => {
	listasubMenuDownload.forEach(click => {
		click.classList.toggle('hidden');
	});
	btnArrowReplaceDownload.classList.toggle('fa-chevron-right');
	btnArrowReplaceDownload.classList.toggle('fa-chevron-down');
});

if(btnLogin){
	btnLogin.addEventListener('click', () =>{
		modalCadastrar.classList.toggle('hidden')
		modalLogin.classList.toggle('hidden')
	});
}else{

};

if(btnCadastrar){
	btnCadastrar.addEventListener('click', () =>{
		modalCadastrar.classList.toggle('hidden')
		modalLogin.classList.toggle('hidden')
	});
}else{

};

btnMenu.addEventListener('change', () => {
	btnMenuIcone.classList.toggle('fa-bars');
	btnMenuIcone.classList.toggle('fa-xmark');
});
