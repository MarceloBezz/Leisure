const mascaras = document.querySelectorAll('[data-cadastro]');
    
mascaras.forEach(campo => {
    campo.addEventListener('keypress', () => {
        let dataAtribute = campo.getAttribute('data-cadastro')
        let inputLength = campo.value.length;

// MASCARA CPF
        dataAtribute === 'cadastroCpf' ?
            inputLength === 3 || inputLength === 7 ?
            campo.value += '.' : 
            inputLength === 11 ?
            campo.value += '-' : null
        : null;

// MASCARA TELEFONE
        // dataAtribute === 'cadastroTelefone' ?
        //     inputLength === 0 ?
        //     campo.value += '(' :
        //     inputLength === 3 ?
        //     campo.value += ') ' :
        //     inputLength === 10 ?
        //     campo.value += '-' : null
        // : null;
    })
})
// var tel = document.getElementById("telefone");
document.addEventListener('DOMContentLoaded', function () {
    const phoneInput = document.getElementById('telefone');

    phoneInput.addEventListener('input', function (e) {
      let value = e.target.value.replace(/\D/g, ''); // Remove tudo que não for dígito

      if (value.length > 11) {
        value = value.slice(0, 11); // Limita a entrada a 11 dígitos
      }

      const formattedValue = formatPhone(value);
      e.target.value = formattedValue;
    });

    function formatPhone(value) {
      let formattedValue = value;
      if (value.length > 0) {
        formattedValue = '(' + value.substring(0, 2) + ')';
      }
      if (value.length > 2) {
        formattedValue += value.substring(2, 7);
      }
      if (value.length > 7) {
        formattedValue += '-' + value.substring(7, 11);
      }
      return formattedValue;
    }
  });
