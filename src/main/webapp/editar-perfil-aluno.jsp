%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Editar Perfil Aluno| EducaTECH</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
  <link rel="stylesheet" href="style.css">
  <link rel="icon"
    href="https://senacsc754-my.sharepoint.com/:i:/g/personal/emylli_lima_alunos_sc_senac_br/EXnGEpmRShROuAsMIKeNpc8Bsmr60tIhGd2Kie21LcKtnA"
    sizes="32x32" />
<script type="text/javascript" src="https://gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js?attr=EZ59VnD1uOKQo0IVnFiChVADX2T3WlHgDEi_hzSJq937pjWIh4zblKzvvYs-YxyRO4pv6dO4I_pc-ENfFkHLf1_YcBT1P50i5V_tz1CHEEpdxXfANG4X79m8uJVLqMV3Icia_xQHeV1F8w3EHbHeAfmolOtEABga35sVZa0-TSqmg3p9V1sTp6JsIKkaW-NWnLdA6PtnttwLds1qdjF0pVfFBvto0jC4aUc2y_MGs6ywX2YTGjHfNl6RecRNainI3-nP6NXNRhGO8u0POpKQ03H950K7lDN4uRDr0GixzKOq86hoS3tepHOerwxUIk0-qGnO5cYo1eCcXfiv62HeMWWGwh9Xmy2yys9toJgajNc" charset="UTF-8"></script></head>

<body>

	<form class="form-editar-perfil" action="atualizar-aluno" method="post">

  <div>
    <h1>Minha Conta</h1>
    <div>
      <a href="#minha" class="nav-link">Alterar dados</a>
      <a href="#usuario"><img src="" alt=""></a>
      </div>
    </div>
   
    <div>
        <label>Gênero<em>*</em></label>
        <select name="genero" id="genero">
          <option value="0">Masculino</option>
          <option value="1">Feminino</option>
          <option value="2">Outro</option>
        </select>
        
      <label for="pronome">Pronome<em>*</em></label>
      <select>
        <option value="0">Ele/Dele</option>
        <option value="1">Ela/Dela</option>
        <option value="2">Elu/Delu</option>
      </select>
    </div>
    
    <div>
      <label for="email">E-mail</label>
      <input type="email" id="email" value="<c:out value='${contato.email}' />" placeholder="Digite seu e-mail"
        pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" maxlength="100" required>
      <label for="celular">Celular</label>
      <input type="tel" id="celular" placeholder="(xx) xxxxx-xxxx" value="<c:out value='${contato.celular}' />" minlength="11" maxlength="11"
        pattern="\([0-9]{2}\)[\s][0-9]{5}-[0-9]{4}" required>
      <label for="telefone">Telefone<em>*</em></label>
      <input type="tel" id="telefone" placeholder="(xx) xxxx-xxxx" value="<c:out value='${contato.telefone}' />" minlength="10" maxlength="10"
        pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}" required>
    </div>
    <div>
      <label for="biografia">Biografia<em>*</em></label>
      <input type="text" id="biografia"  value="<c:out value='${aluno.biografia}' />" placeholder="Digite sua Biografia">
    </div>
    
    <div>
      <label for="alterar-foto">*Alterar Foto<em>*</em></label>
      <input type="file" id="alterar-foto" value="<c:out value='${usuario.foto}' />" placeholder="Altere sua Foto*" >
    </div>

  <div>
    <input class="button-cancel" type="button" value="Cancelar">

    <input class="button-save" type="submit" value="Salvar alteraçoes">
  </div>
	</form>


</body>

</html>