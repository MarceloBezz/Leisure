const btnRodape = document.querySelectorAll('[data-rodape="link"]');

btnRodape.forEach(btn =>{
    btn.addEventListener('click', () => {
        const rodapeSubmit = btn.querySelector('[data-rodape="form"]');
        rodapeSubmit.submit();
    })
})
