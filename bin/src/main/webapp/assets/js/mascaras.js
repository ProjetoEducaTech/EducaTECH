function mascaraTelefone(){
		
	const telefone = document.getElementById("telefone");
	let telefoneFormatado = telefone.value;
	
	telefoneFormatado = telefoneFormatado.replace(/\D/g,""); 
    telefoneFormatado = telefoneFormatado.replace(/^(\d{2})(\d)/g,"($1) $2");
    telefoneFormatado = telefoneFormatado.replace(/(\d)(\d{4})$/,"$1-$2");
  
  telefone.value = telefoneFormatado;
}
