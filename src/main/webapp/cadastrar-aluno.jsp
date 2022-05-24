<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Resultados da busca | EducaTECH</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
  <link rel="stylesheet" href="style.css">
  <link rel="icon"
    href="https://senacsc754-my.sharepoint.com/:i:/g/personal/emylli_lima_alunos_sc_senac_br/EXnGEpmRShROuAsMIKeNpc8Bsmr60tIhGd2Kie21LcKtnA"
    sizes="32x32" />
</head>

<body>

  <header>
    <div class="menu-bg">
      <div class="menu">
        <div class="menu-logo">
          <a href="index.html"><img
              src="https://media.discordapp.net/attachments/705133864745566258/976444152948609034/unknown.png"
              alt="logo"></a>
        </div> <!-- menu_logo -->
        <nav class="nav">
          <ul class="nav-list">
            <a href="#sobre" class="nav-link">Sobre o EducaTECH</a>
            <a href="#sesquisar" class="nav-link">Pesquisar cursos</a>
            <a href="#conheca" class="nav-link">Conheça as faculdades</a>
            <a href="#minha" class="nav-link">Minha conta</a>
          </ul> <!-- nav_list -->
        </nav> <!-- nav -->
        <div class="menu-logo">
          <a href="#usuario"><img src="D:\Users\Vitor\Desktop\Icon_Usuario.png" alt="logo"></a>
        </div> <!-- menu_logo_usuario -->
      </div> <!-- menu -->
    </div> <!-- menu- bg -->
  </header>

  <form class="form-register" action="/action_page.php">

    <h1 class="intro">Seja Bem Vindo!</h1>

    <div class="tab">
      <label for="name">Nome<em>*</em></label>
      <input placeholder="Digite seu nome" oninput="this.className = ''" name="fname">
      <label for="last-name">Sobrenome<em>*</em></label>
      <input placeholder="Digite seu sobrenome" oninput="this.className = ''" name="lname">
      <label for="cpf">CPF<em>*</em></label>
      <input type="string" id="cpf" placeholder="Digite seu CPF">
      <label id="birth-date">Data de Nascimento<em>*</em></label>
      <input type="date">
      <fieldset id="gender">
        <legend>Gênero<em>*</em></legend>
        <input type="radio" name="gender" value="M" checked> Masculino
        <input type="radio" name="gender" value="F"> Feminino
        <input type="radio" name="gender" value="*"> Outros
      </fieldset>
      <p class="has-account">
        Possui uma conta? <a id="redirect-link" href="login-aluno.html">Entre aqui</a>
      </p>
    </div>
    <!--tab-->

    <div class="tab">
      <label for="telephone">Telefone<em>*</em></label>
      <input type="tell" id="telephone" placeholder="(xx) xxxx-xxxx" minlength="10" maxlength="10"
        pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}" required>
      <label for="cellphone">Celular</label>
      <input type="tel" placeholder="(xx) xxxxx-xxxx" minlength="11" maxlength="11"
        pattern="\([0-9]{2}\)[\s][0-9]{5}-[0-9]{4}" required>
      <label for="email">E-mail<em>*</em></label>
      <input type="email" id="email" placeholder="Digite seu e-mail"
        pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" maxlength="100" required>
    </div>
    <!--="tab"-->

    <div class="tab">
      <label for="password">Senha<em>*</em></label>
      <input type="password" id="password" placeholder="Crie uma senha" title=" Oito ou mais digitos" required>
      <label for="confirm-password">Repita a senha<em>*</em></label>
      <input type="password" id="confirm-password" placeholder="Digite a senha novamente" title="Repita a senha"
        required>
    </div>
    <!--="tab"-->

    <div style="overflow:auto;">
      <div style="float:right;">
        <button type="button" id="prevBtn" onclick="nextPrev(-1)">Voltar</button>
        <button class="button-next" type="button" id="nextBtn" onclick="nextPrev(1)">Próximo</button>
      </div>
    </div>

    <div style="text-align:center;margin-top:40px;">
      <span class="step"></span>
      <span class="step"></span>
      <span class="step"></span>
    </div>

  </form>
  <!--form-register-->

  <footer class="footer">
    <div>
      <a href="#instagram"><img src="D:\Users\Vitor\Desktop\Icon_Usuario.png" alt="logo"></a>
    </div> <!-- footer_logo_instagram -->
    <div>
      <a href="#git-hub"><img src="D:\Users\Vitor\Desktop\Icon_Usuario.png" alt="logo"></a>
    </div> <!-- footer_logo_git-hub -->
    <div>
      <a href="#linkedin"><img src="D:\Users\Vitor\Desktop\Icon_Usuario.png" alt="logo"></a>
    </div> <!-- footer_logo_linkedin -->
  </footer>

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
        document.getElementById("nextBtn").innerHTML = "Enviar";
      } else {
        document.getElementById("nextBtn").innerHTML = "Próximo";
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