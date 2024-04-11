const input = document.querySelectorAll('input');
const option = document.querySelectorAll('select');
const btnMenu = document.querySelector('#menu');
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

const btnLogout = document.querySelector('.logout');

document.addEventListener('keydown', event =>{
    if(event.keyCode === 9){
        event.preventDefault();
    }
})

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

// btnSubmenuDownload.addEventListener('click', () => {
// 	listasubMenuDownload.forEach(click => {
// 		click.classList.toggle('hidden');
// 	});
// 	btnArrowReplaceDownload.classList.toggle('fa-chevron-right');
// 	btnArrowReplaceDownload.classList.toggle('fa-chevron-down');
// });

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

btnMenu.addEventListener('change', () => {
	btnMenuIcone.classList.toggle('fa-bars');
	btnMenuIcone.classList.toggle('fa-xmark');
});

btnLogout.addEventListener('click', () => {
	const menuLogout = document.querySelector('.logout__lista');
	menuLogout.classList.toggle('hidden');
})