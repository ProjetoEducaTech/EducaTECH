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

	var abas = document.getElementsByClassName("aba");
	if ((aba - 1) >= 0)
		abas[aba - 1].firstElementChild.nextElementSibling.remove();

	var div = document.createElement("div");
	div.className = "passos";

	for (var i = 0; i < abas.length; i++) {

		var novaDiv = document.createElement("div");
		novaDiv.className = "passo";
		div.appendChild(novaDiv);
	}

	abas[aba].firstElementChild.nextElementSibling.before(div);

	var passos = document.getElementsByClassName("passo");
	passos[aba].className += " active";
}   