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

function abc(){
  document.getElementById("getdesc1").innerHTML=localStorage.guardarNome;
}

function descricao(){ //funçao para adicionar descrição
  var descricao = prompt('Digite a descrição do seu perfil')
  var msg = document.getElementById("getdesc1");

  msg = descricao;
  document.getElementById("getdesc1").innerHTML = msg;
  // alert(descricao);
  localStorage.guardarNome = descricao;
}

var botaoAnunciar = document.querySelector(".frame-anunciar"),
botaoMeusAnuncios = document.querySelector(".frame-meus-anuncios"),
botaoMeusDados = document.querySelector(".frame-meus-dados"),
botaoAnunciarMini = document.querySelector(".frame-anunciar-mini"),
botaoMeusAnunciosMini = document.querySelector(".frame-meus-anuncios-mini"),
botaoMeusDadosMini = document.querySelector(".frame-meus-dados-mini")

function anunciar()
{
  botaoAnunciar.style.display = "block",
  botaoMeusAnuncios.style.display = "none",
  botaoMeusDados.style.display = "none"
}

function anunciarMini()
{
  botaoAnunciarMini.style.display = "block",
  botaoMeusAnunciosMini.style.display = "none",
  botaoMeusDadosMini.style.display = "none"
}

function meusAnuncios()
{
  botaoAnunciar.style.display = "none",
  botaoMeusAnuncios.style.display = "block",
  botaoMeusDados.style.display = "none"
}

function meusAnunciosMini()
{
  botaoAnunciarMini.style.display = "none",
  botaoMeusAnunciosMini.style.display = "block",
  botaoMeusDadosMini.style.display = "none"
}

function meusDados()
{
  botaoAnunciar.style.display = "none",
  botaoMeusAnuncios.style.display = "none",
  botaoMeusDados.style.display = "block"
}

function meusDadosMini()
{
  botaoAnunciarMini.style.display = "none",
  botaoMeusAnunciosMini.style.display = "none",
  botaoMeusDadosMini.style.display = "block"
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
    parent.location.reload();
}