const ad = document.querySelector('[data-ad="ad-app"]')
const btnClose = document.querySelector('[data-ad="close"]')

btnClose.addEventListener('click', () => {
    ad.style.display = 'none';
})