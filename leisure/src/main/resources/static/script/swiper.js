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