function confirma(){
	var password = document.getElementById("senha");
	var password2 = document.getElementById("senhaConfirm");
	
	
	 if(document.getElementById("email").value=="" ){
		 alert("preencha o e-mail");
		 return false;
	 }
	 if(document.getElementById("senha").value==""){
		 alert("preencha a senha");
		 return false;
	 }
	 if(document.getElementById("primeiroNome").value==""){
		 alert("preencha o primeiro nome");
		 return false;
	 }
	 if(document.getElementById("ultimoNome").value=="" ){
		 alert("preencha o ultimo nome");
		 return false;
	 }
	 if(document.getElementById("chechbox").value=="" ){
		 alert("Aceite o termo");
		 return false;
	 }
	 if (password2.value != password.value) {
         alert ("senhas diferentes");
         return false;
     }
	 return true;
	alert("oi");
	
}