//----------------- SWIPER -----------------
var swiper = new Swiper(".mySwiper", {
  slidesPerView: 'auto',
  pagination: {
    el: ".swiper-pagination",
    dynamicBullets: true,
  },
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",  
  }, 
  breakpoints: {
    640: {
      slidesPerView: 2,
    },
    854: {
      slidesPerView: 3,
    },
    1280: {
      slidesPerView: 4,
    },
    // 1920: {
    //   slidesPerView: 5,
    // },
    // 2560: {
    //   slidesPerView: 7,
    // },
  },
});

//----------------- LOCALIZAR CEP -----------------
function limpa_formulário_cep() {
  //Limpa valores do formulário de cep.
  document.getElementById('rua').value=("");
  // document.getElementById('bairro').value=("");
  document.getElementById('cidade').value=("");
  document.getElementById('uf').value=("");
  // document.getElementById('ibge').value=("");
}
function meu_callback(conteudo) {
  if (!("erro" in conteudo)) {
  //Atualiza os campos com os valores.
  document.getElementById('rua').value=(conteudo.logradouro);
  // document.getElementById('bairro').value=(conteudo.bairro);
  document.getElementById('cidade').value=(conteudo.localidade);
  document.getElementById('uf').value=(conteudo.uf);
  // document.getElementById('ibge').value=(conteudo.ibge);
  } //end if.
  else {
  //CEP não Encontrado.
  limpa_formulário_cep();
  alert("CEP não encontrado.");
  }
}
function pesquisacep(valor) {
  //Nova variável "cep" somente com dígitos.
  var cep = valor.replace(/\D/g, '');
  //Verifica se campo cep possui valor informado.
  if (cep != "") {
  //Expressão regular para validar o CEP.
  var validacep = /^[0-9]{8}$/;
  //Valida o formato do CEP.
  if(validacep.test(cep)) {
    //Preenche os campos com "..." enquanto consulta webservice.
    document.getElementById('rua').value="...";
    // document.getElementById('bairro').value="...";
    document.getElementById('cidade').value="...";
    document.getElementById('uf').value="...";
    // document.getElementById('ibge').value="...";

    //Cria um elemento javascript.
    var script = document.createElement('script');
    //Sincroniza com o callback.
    script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';
    //Insere script no documento e carrega o conteúdo.
    document.body.appendChild(script);
  }else {
    //cep é inválido.
    limpa_formulário_cep();
    alert("Formato de CEP inválido.");
  }
  }else {
    //cep sem valor, limpa formulário.
    limpa_formulário_cep();
  }
};

//PÁGINA DO PERFIL

var botaoAnunciar = document.querySelector("#anunciar")
botaoMeusAnuncios = document.querySelector("#meus-anuncios")
botaoMeusDados = document.querySelector("#meus-dados")
botaoAnunciarMini = document.querySelector("#anunciar-mini")
botaoMeusAnunciosMini = document.querySelector("#meus-anuncios-mini")
botaoMeusDadosMini = document.querySelector("#meus-dados-mini")
botaoMeusFavoritos = document.querySelector("#favoritos")
botaoMeusFavoritosMini = document.querySelector("#favoritos")

function anunciar()
{
  botaoMeusDados.style.display = "none"
  botaoAnunciar.style.display = "block"
  botaoMeusAnuncios.style.display = "none"
  botaoMeusFavoritos.style.display = "none"
}

function meusAnuncios()
{
  botaoMeusAnuncios.style.display = "block"
  botaoAnunciar.style.display = "none" 
  botaoMeusDados.style.display = "none"
  botaoMeusFavoritos.style.display = "none"
}

function meusDados()
{
  botaoMeusDados.style.display = "block"
  botaoAnunciar.style.display = "none"
  botaoMeusAnuncios.style.display = "none"
  botaoMeusFavoritos.style.display = "none"
}

function favoritos()
{
  botaoMeusFavoritos.style.display = "block"
  botaoAnunciar.style.display = "none"
  botaoMeusAnuncios.style.display = "none"
  botaoMeusDados.style.display = "none"
}

function anunciarMini()
{
  botaoMeusDados.style.display = "none"
  botaoAnunciar.style.display = "block"
  botaoMeusAnuncios.style.display = "none"
  botaoMeusFavoritos.style.display = "none"
}

function meusAnunciosMini()
{
  botaoMeusAnuncios.style.display = "block"
  botaoAnunciar.style.display = "none" 
  botaoMeusDados.style.display = "none"
  botaoMeusFavoritos.style.display = "none"
}

function meusDadosMini()
{
  botaoMeusDados.style.display = "block"
  botaoAnunciar.style.display = "none"
  botaoMeusAnuncios.style.display = "none"
  botaoMeusFavoritos.style.display = "none"
}

function favoritosMini()
{
  botaoMeusFavoritos.style.display = "block"
  botaoAnunciar.style.display = "none"
  botaoMeusAnuncios.style.display = "none"
  botaoMeusDados.style.display = "none"
}

function curriculoEnviado(){
  alert(
    "\nAgradecemos o seu interesse de trabalhar conosco!!!\n"+
    "Seus dados foram enviados com Sucesso!\n\n"+
    "Assim que possivel entraremos em contato com informações sobre sua candidatura.");
    location.reload();
}

function atualizarDados(){
  alert(
    "\nDados atualziados com sucesso");
    location.href = "perfil.html";
}

function deletarDados(userId){
if (confirm(
  "\nTem certeza que deseja deletar seu cadastro?"+
  "\nUma vez deletado você perderá todos seus dados e sua reputação em nosso site.\n"+
  "\nDeseja continuar?\n")){
  alert(
    "\nDados deletados com sucesso");
    parent.location.href = "http://localhost:8080/usuario/deletar/" + userId;
  }else{
    parent.location.href = "http://localhost:8080/usuario/perfil";
  }
}

// ALTERAR TEMA
const $sobre = document.querySelectorAll('.sobreTemaLight');
const $color = document.querySelectorAll('.azulTemaLight');
const $btn = document.querySelectorAll('.btn-outline-primary');
const $bg = document.querySelectorAll('.bg-light');
const $icon = document.querySelectorAll('.fa-sun');
const $font = document.querySelectorAll('.font-light');
const $seta = document.querySelectorAll('.seta-light');
const $cardBorder = document.querySelectorAll('.card-border-light');
const $imgBorder = document.querySelectorAll('.img-border-light');
const $body = document.querySelector('body');
const $checkTema = document.querySelector('#switch');
const savedTheme = localStorage.getItem('theme'); // Verifica se há um tema armazenado no localStorage

// Aplica o tema armazenado, se existir
if (savedTheme === 'dark-mode') {
  applyDarkMode();
  $checkTema.checked = true;
}

$checkTema.addEventListener('change', function () {
  if ($checkTema.checked) {
    applyDarkMode();
    localStorage.setItem('theme', 'dark-mode');
  } else {
    removeDarkMode();
    localStorage.removeItem('theme');
  }
});

function applyDarkMode() {
  $bg.forEach(div => div.classList.add('bg-dark'));
  $font.forEach(div => div.classList.add('font-dark'));
  $btn.forEach(div => div.classList.add('btn-info'));
  $color.forEach(div => div.classList.add('azulTemaDark'));
  $sobre.forEach(div => div.classList.add('sobreTemaDark'));
  $cardBorder.forEach(div => div.classList.add('card-border-dark'));
  $imgBorder.forEach(div => div.classList.add('img-border-dark'));
  $seta.forEach(div => div.classList.add('seta-dark'));
  $icon.forEach(div => div.classList.add('fa-moon'));
  $body.classList.add('bg-dark');
}

function removeDarkMode() {
  $bg.forEach(div => div.classList.remove('bg-dark'));
  $font.forEach(div => div.classList.remove('font-dark'));
  $btn.forEach(div => div.classList.remove('btn-info'));
  $color.forEach(div => div.classList.remove('azulTemaDark'));
  $sobre.forEach(div => div.classList.remove('sobreTemaDark'));
  $cardBorder.forEach(div => div.classList.remove('card-border-dark'));
  $imgBorder.forEach(div => div.classList.remove('img-border-dark'));
  $seta.forEach(div => div.classList.remove('seta-dark'));
  $icon.forEach(div => div.classList.remove('fa-moon'));
  $body.classList.remove('bg-dark');
}

// PAGINA ADM
/*const $consultaGeral = document.querySelector('.consultaGeral')
const $paginaAnuncios = document.querySelector('.paginaAnuncios')
const $paginaPremium = document.querySelector('.paginaPremium')
const $paginaInativos = document.querySelector('.paginaInativos')

document.querySelector('#consultaGeral').addEventListener("click", function(){
  if($consultaGeral.classList.contains('d-block')){
    $consultaGeral.classList.replace('d-block', 'd-none');
  }else{
    $consultaGeral.classList.replace('d-none', 'd-block');
    $paginaAnuncios.classList.replace('d-block', 'd-none')
    $paginaPremium.classList.replace('d-block', 'd-none')
    $paginaInativos.classList.replace('d-block', 'd-none')
  } 
});

document.querySelector("#consultaAnuncios").addEventListener("click", function() {
  if($paginaAnuncios.classList.contains('d-block')){
    $paginaAnuncios.classList.replace('d-block','d-none')
  }else{
    $consultaGeral.classList.replace('d-block', 'd-none')
    $paginaAnuncios.classList.replace('d-none','d-block')
    $paginaPremium.classList.replace('d-block', 'd-none')
    $paginaInativos.classList.replace('d-block', 'd-none')
  }
});

document.querySelector("#consultaPremium").addEventListener("click", function() {
  if($paginaPremium.classList.contains('d-block')){
    $paginaPremium.classList.replace('d-block','d-none')
  }else{
    $consultaGeral.classList.replace('d-block', 'd-none')
    $paginaAnuncios.classList.replace('d-block', 'd-none')
    $paginaPremium.classList.replace('d-none','d-block')
    $paginaInativos.classList.replace('d-block', 'd-none')
  }
});

document.querySelector("#consultaInativos").addEventListener("click", function() {
  if($paginaInativos.classList.contains('d-block')){
    $paginaInativos.classList.replace('d-block','d-none')
  }else{
    $consultaGeral.classList.replace('d-block', 'd-none')
    $paginaAnuncios.classList.replace('d-block', 'd-none')
    $paginaPremium.classList.replace('d-block', 'd-none')
    $paginaInativos.classList.replace('d-none','d-block')
  }
});PÁGINA ADM COMENTADA PARA TESTE*/


// PRE LOAD
// setTimeout(function(){
//   document.querySelector('.pre').style.display = 'none';
// }, 2000);

// setTimeout(function loading(){
//   document.querySelector('.loaded').style.display = 'block';
// }, 2500);


/*const btn = document.querySelector('.btnDetalhes')



btn.addEventListener('click', function(){
  const parent = this.parentNode;
  const acima = parent.closest('.imgDetails')

  const teste = document.querySelector(acima)
  const imgSrc = teste.getAttribute('src')
  
})FUNÇÃO COMENTADA PARA TESTE */

// HABILITAR ESSA FUNÇÃO QUANDO O SITE ESTIVER ONLINE !!!
// function loading(){

//   document.querySelector('.pre').style.display = 'none';
//   document.querySelector('.loaded').style.display = 'block';
// }
