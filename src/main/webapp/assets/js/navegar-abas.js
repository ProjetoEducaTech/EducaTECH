var abaAtual = 0;
mostrarAba(abaAtual);

function mostrarAba(aba) {

	var abas = document.getElementsByClassName("aba");
	abas[aba].style.display = "block";

	if (aba == 0)
		document.getElementById("botao-voltar").style.display = "none";
	else
		document.getElementById("botao-voltar").style.display = "inline";

	if (aba == (abas.length - 1))
		document.getElementById("botao-proximo").innerHTML = "Cadastrar-se";
	else
		document.getElementById("botao-proximo").innerHTML = "Próximo";

	ajustarIndicadorPasso(aba)
}

function navegarAba(aba) {

	var abas = document.getElementsByClassName("aba");
	if (aba == 1 && !validarFormulario()) return false;

	abas[abaAtual].style.display = "none";
	abaAtual = abaAtual + aba;

	if (abaAtual >= abas.length) {

		document.getElementById("formulario").submit();
		return false;
	}

	mostrarAba(abaAtual);
}

function validarFormulario() {

	var valid = true;
	var abas = document.getElementsByClassName("aba");
	var inputs = abas[abaAtual].getElementsByTagName("input");

	for (i = 0; i < inputs.length; i++) {

		if (inputs[i].value == "") {

			inputs[i].className += " invalid";
			valid = false;
		}
	}

	if (valid)
		document.getElementsByClassName("passo")[abaAtual].className += " finish";

	return valid;
}

function ajustarIndicadorPasso(aba) {

	var passos = document.getElementsByClassName("passo");
	
	for (i = 0; i < passos.length; i++)
		passos[i].className = passos[i].className.replace(" active", "");

	passos[aba].className += " active";
}   