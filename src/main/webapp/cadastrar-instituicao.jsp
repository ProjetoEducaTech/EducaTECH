<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title> Cadastro aluno | EducaTECH</title>
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<style>
  * {
    box-sizing: border-box;
  }

  body {
    background-color: #ecf0f3;
  }

  #regForm {
    background-color: #fff;
    margin: 100px auto;
    font-family: Raleway;
    padding: 40px;
    width: 70%;
    min-width: 300px;
  }

  h1 {
    text-align: center;
  }

  input {
    padding: 10px;
    width: 100%;
    font-size: 17px;
    font-family: Raleway;
    border: 1px solid #aaaaaa;
  }

  /* Mark input boxes that gets an error on validation: */
  input.invalid {
    background-color: #ffdddd;
  }

  /* Hide all steps by default: */
  .tab {
    display: none;
  }

  button {
    background-color: #04AA6D;
    color: #ffffff;
    border: none;
    padding: 10px 20px;
    font-size: 17px;
    font-family: Raleway;
    cursor: pointer;
  }

  button:hover {
    opacity: 0.8;
  }

  #prevBtn {
    background-color: #bbbbbb;
  }

  /* Make circles that indicate the steps of the form: */
  .step {
    height: 15px;
    width: 15px;
    margin: 0 2px;
    background-color: #bbbbbb;
    border: none;
    border-radius: 50%;
    display: inline-block;
    opacity: 0.5;
  }

  .step.active {
    opacity: 1;
  }

  /* Mark the steps that are finished and valid: */
  .step.finish {
    background-color: #04AA6D;
  }
</style>

<body>

  <form id="regForm" action="/action_page.php">
    <h1>Seja Bem Vindo!</h1>
    <!-- One "tab" for each step in the form: -->
    <div class="tab">
      <label for="nome">Nome da Instituição<em>*</em></label>
      <input type="text" id="nome" placeholder="Digite sua razão social" maxlength="50" required>
      <label for="cnpj">CNPJ<em>*</em></label>
      <input type="number" id="cnpj" placeholder="Digite seu CNPJ" title="CNPJ" required>
      <label for="email">E-mail corporativo<em>*</em></label>
      <input type="email" id="email" placeholder="Digite seu e-mail corporativo"
        pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" maxlength="100" required>
    </div>
    <div class="tab">
      <label for="telefone">Telefone<em>*</em></label>
      <input type="tel" id="telefone" placeholder="(xx) xxxx-xxxx" minlength="10" maxlength="10" required>
      <label for="celular">Celular</label>
      <input type="tel" id="celular" placeholder="(xx) xxxxx-xxxx" minlength="11" maxlength="11"
        pattern="\([0-9]{2}\)[\s][0-9]{5}-[0-9]{4}" required>
    </div>
    <div class="tab" <label for="senha">Senha<em>*</em></label>
      <input type="password" id="senha" placeholder="Crie uma senha" pattern="{8,}" title="Oito ou mais digitos"
        required>
      <label for="confirmarSenha">Repita a Senha<em>*</em></label>
      <input type="password" id="confirmarSenha" placeholder="Digite a senha novamente" pattern="{8,}"
        title="Repita a senha" required>
    </div>
    <div class="tab">
      <label for="logradouro">Logradouro<em>*</em></label>
      <input type="text" id="logradouro" placeholder="Digite seu logradouro" maxlength="50" required>
      <label for="bairro">Bairro<em>*</em></label>
      <input type="text" id="bairro" placeholder="Digite seu bairro" minlength="5" required>
      <label for="numero">Número<em>*</em></label>
      <input type="number" id="numero" placeholder="Número">
    </div>
    <div class="tab">
      <label for="cidade">Cidade<em>*</em></label>
      <input type="text" id="cidade" placeholder="Digite sua cidade" minlength="3" maxlength="30" required>
      <label>Estado<em>*</em></label>
      <select name="estado">
        <option selected disabled value="">Selecione uma opção</option>
      </select>
    </div>
    <div class="tab">
      <label for="codPostal">CEP<em>*</em></label>
      <input type="text" id="codPostal" placeholder="xxxxx-xxx" minlength="8" maxlength="8"
        pattern="\([0-9]{5}\)[\s][0-9]{3}" required>
      <label for="referencia">Referência:</label>
      <input type="text" id="referencia" maxlength="50">
    </div>
    <div style="overflow:auto;">
      <div style="float:right;">
        <button type="button" id="prevBtn" onclick="nextPrev(-1)">Voltar</button>
        <button type="button" id="nextBtn" onclick="nextPrev(1)">Próximo</button>
      </div>
    </div>
    <div class="container">
      <p class="possuiConta">
        Possui uma conta? <a href="login-instituicao.html">Entre aqui</a>
      </p>
    </div>
     <div style="text-align:center;margin-top:40px;">
      <span class="step"></span>
      <span class="step"></span>
      <span class="step"></span>
      <span class="step"></span>
      </div>
  </form>

  <script>
    var currentTab = 0; // Current tab is set to be the first tab (0)
    showTab(currentTab); // Display the current tab

    function showTab(n) {
      // This function will display the specified tab of the form...
      var x = document.getElementsByClassName("tab");
      x[n].style.display = "block";
      //... and fix the Previous/Next buttons:
      if (n == 0) {
        document.getElementById("prevBtn").style.display = "none";
      } else {
        document.getElementById("prevBtn").style.display = "inline";
      }
      if (n == (x.length - 1)) {
        document.getElementById("nextBtn").innerHTML = "Submit";
      } else {
        document.getElementById("nextBtn").innerHTML = "Next";
      }
      //... and run a function that will display the correct step indicator:
      fixStepIndicator(n)
    }

    function nextPrev(n) {
      // This function will figure out which tab to display
      var x = document.getElementsByClassName("tab");
      // Exit the function if any field in the current tab is invalid:
      if (n == 1 && !validateForm()) return false;
      // Hide the current tab:
      x[currentTab].style.display = "none";
      // Increase or decrease the current tab by 1:
      currentTab = currentTab + n;
      // if you have reached the end of the form...
      if (currentTab >= x.length) {
        // ... the form gets submitted:
        document.getElementById("regForm").submit();
        return false;
      }
      // Otherwise, display the correct tab:
      showTab(currentTab);
    }

    function validateForm() {
      // This function deals with validation of the form fields
      var x, y, i, valid = true;
      x = document.getElementsByClassName("tab");
      y = x[currentTab].getElementsByTagName("input");
      // A loop that checks every input field in the current tab:
      for (i = 0; i < y.length; i++) {
        // If a field is empty...
        if (y[i].value == "") {
          // add an "invalid" class to the field:
          y[i].className += " invalid";
          // and set the current valid status to false
          valid = false;
        }
      }
      // If the valid status is true, mark the step as finished and valid:
      if (valid) {
        document.getElementsByClassName("step")[currentTab].className += " finish";
      }
      return valid; // return the valid status
    }
  </script>

</body>

</html>