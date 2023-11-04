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
    1920: {
      slidesPerView: 5,
    },
    2560: {
      slidesPerView: 7,
    },
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
    "\nDados atualizados com sucesso")
    location.href = "perfil.html"
}

function deletarDados(){
var resposta = confirm(
    "\nTem certeza que deseja deletar seu cadastro?"+
    "\nUma vez deletado você perderá todos seus dados e sua reputação em nosso site.\n"+
    "\nDeseja continuar?\n")

    if(resposta == true)
    {
    alert(
      "\nDados deletados com sucesso");
      parent.location.href = "index.html";
    }else{
      parent.location.href = "perfil.html";
    }
}
// window.sr = ScrollReveal({reset:true});
// sr.reveal('#anuncios-area, #carouselExampleAutoplaying, #offGrandeL, #sobre2', {duration: 500});
// sr.reveal('#carouselExampleAutoplaying, #sobre2, #sobre3, #time-area2', {delay: 300, duration: 1000});
// sr.reveal('#offGrandeC, #sobre4, #servicos-area2, #dados-area2, #time-area3', {delay: 300, duration:1000});
// sr.reveal('#offGrandeR, #sobre5, #servicos-area3', {delay: 300, duration: 1000});
// sr.reveal('#sobre6, #servicos-area4, #dados-area3, #time-area4', {delay: 400, duration: 1000});
// sr.reveal('#sobre-lista', {delay: 500, duration: 1000});
// sr.reveal('#sobre-lista, #dados-area4, #time-area5', {delay: 600, duration: 1000});
// sr.reveal('#time-area6', {delay: 700, duration: 1000});
// sr.reveal('#time-area6', {delay: 700, duration: 1000});

