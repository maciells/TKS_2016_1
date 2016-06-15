
		/*
		Função que bloqueia os carateres que são digitados, só aceita letras para campo 
	*/
		function restringiCaracter(e,args){           	
			if (document.all){
			var evt=event.keyCode;
			} // caso seja IE
			
			else{var evt = e.charCode;
			} 	// do contrário deve ser Mozilla
			
			var valid_chars = 'abcdefghijlmnopqrstuvxzwykABCDEFGHIJLMNOPQRSTUVXZWYK-_/^~´`@.'+args;      // criando a lista de teclas permitidas
			var chr= String.fromCharCode(evt);      // pegando a tecla digitada
			if (valid_chars.indexOf(chr)>-1 ){
			return true;
			} // se a tecla estiver na lista de permissão permite-a
			// para permitir teclas como <BACKSPACE> adicionamos uma permissão para 
			// códigos de tecla menores que 09 por exemplo (geralmente uso menores que 20)
			if (valid_chars.indexOf(chr)>-1 || evt < 9){
			return true;
			} 
			if (valid_chars.indexOf(chr)>30 || evt <35){
			return true;
			} //permite a tecla espaço
			
			return false;   // do contrário nega
		}

	
	/*
		Função que bloqueia as letras que são digitadas, só aceita numeros para campo 
	*/		
		function Onlynumbers(e){
			var tecla=new Number();
			if(window.event) {
				tecla = e.keyCode;
			}
			else if(e.which) {
				tecla = e.which;
			}
			else {
				return true;
			}
			if((tecla >= "97") && (tecla <= "122")){
				return false;
			}
		}
		
	
	/*
		Função que traz a data do pc para uma tag input, que esta divida em 3 inputs dia, mes, ano
	*/
		function Data() {
				var mes = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];
				
                data = new Date();
                dia_semana = data.getDate();
				if(dia_semana < 10){
					dia_semana = "0"+dia_semana ;
				}
                mes = (mes[data.getMonth()]);
                ano = data.getFullYear();
                dataCompleta = dia_semana+' /'+mes+' /'+ano;

                return dataCompleta;
        }
		 
		function mascara_data_atual() {
			if(document.getElementById("dataInscricao").value.length == 2) {
				document.getElementById("dataInscricao").value += '/';
			}
			if(document.getElementById("dataInscricao").value.length == 5) {
				document.getElementById("dataInscricao").value += '/';
			}
		}
	
	
	/*
		Função que valida a data de nascimento
	*/
		function validaData(obj){
			var data = obj.value;
			var dia = data.substring(0,2)
			var mes = data.substring(3,5)
			var ano = data.substring(6,10)
		 
			//Criando um objeto Date usando os valores ano, mes e dia.
			var novaData = new Date(ano,(mes-1),dia);
		 
			var mesmoDia = parseInt(dia,10) == parseInt(novaData.getDate());
			var mesmoMes = parseInt(mes,10) == parseInt(novaData.getMonth())+1;
			var mesmoAno = parseInt(ano) == parseInt(novaData.getFullYear());
		 
			if (!((mesmoDia) && (mesmoMes) && (mesmoAno))){
				document.getElementById("dataNascimentoErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("dataNascimento").style.backgroundColor = "#FFDA6C";
				document.getElementById("dataNascimentoErrado").innerHTML = "<font color='#FFBF00' size='4,5' >Por favor, informe seu nome completo!<br></font>";
				return false;
			}
				document.getElementById("dataNascimentoErrado").style.textShadow = "";
				document.getElementById("dataNascimento").style.backgroundColor = "";
				document.getElementById("dataNascimentoErrado").innerHTML = "";
				return true;
		}
	
		function mascara_data() {
			if(document.getElementById("dataNascimento").value.length == 2) {
			   document.getElementById("dataNascimento").value += '/';
			}
			if(document.getElementById("dataNascimento").value.length == 5) {
			   document.getElementById("dataNascimento").value += '/';
			}
		}
		
		
	/*
		Função que  verficar se o campo nome tem mais de 8 caracteres 
	*/
		function checaNome(){
			var formulario = document.getElementById('cadForm');
			var nome = formulario.nome.value;
			if(nome.length < 8){
				document.getElementById("nomeErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("nomeP").style.backgroundColor = "#FFDA6C";
				document.getElementById("nomeErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe seu nome completo!<br></font>";
				document.cadForm.nome.focus();
				return false;
			}else{
				document.getElementById("nomeErrado").style.textShadow = "";
				document.getElementById("nomeP").style.backgroundColor = "";
				document.getElementById("nomeErrado").innerHTML = "";
			}
		}
		
	
	/*
		Função que  verficar se o campo nome da mae tem mais de 8 caracteres 
	*/
		function checaNomeMae(){
			var formulario = document.getElementById('cadForm');
			var nomeMae = formulario.nomeMae.value;
			if(nomeMae.length < 8){
				document.getElementById("maeErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("nomeMae").style.backgroundColor = "#FFDA6C";
				document.getElementById("maeErrado").innerHTML = "<font color='#FFBF00' size='4,5' >Por favor, informe o nome completo de sua mãe!<br></font>";
				document.getElementById("nomeMae").focus();
				return false;
			}else{
				document.getElementById("maeErrado").style.textShadow = "";
				document.getElementById("nomeMae").style.backgroundColor = "";
				document.getElementById("maeErrado").innerHTML = "";
			}
		}
	

	/*
		Função que  verficar se o campo nome do pai tem mais de 8 caracteres 
	*/
		function checaNomePai(){
			var formulario = document.getElementById('cadForm');
			var nomePai = formulario.nomePai.value;
			if(nomePai.length < 8){
				document.getElementById("paiErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("nomePai").style.backgroundColor = "#FFDA6C";
				document.getElementById("paiErrado").innerHTML = "<font color='#FFBF00' size='4,5' >Por favor, informe o nome completo de seu pai!<br></font>";
				document.getElementById("nomePai").focus();
				return false;
			}else{
				document.getElementById("paiErrado").style.textShadow = "";
				document.getElementById("nomePai").style.backgroundColor = "";
				document.getElementById("paieErrado").innerHTML = "";
			}
		}
		
	
	/*
		Função que valida CPF  e formatar com mascara
	*/	
		function validarCPF( cpf ){
			var filtro = /^\d{3}.\d{3}.\d{3}-\d{2}$/i;
			
			if(!filtro.test(cpf)){
				document.getElementById("cpfErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("cpf").style.backgroundColor = "#FFDA6C";
				document.getElementById("cpfErrado").innerHTML = "<font color='#FFBF00' size='4,5' >Por favor, informe seu CPF!<br></font>";
				document.getElementById("cpf").focus();
				return false;
			}else{
				document.getElementById("cpfErrado").style.textShadow = "";
				document.getElementById("cpf").style.backgroundColor = "";
				document.getElementById("cpfErrado").innerHTML = "";
			}
		   
			cpf = remove(cpf, ".");
			cpf = remove(cpf, "-");
			
			if(cpf.length != 11 || cpf == "00000000000" || cpf == "11111111111" ||
				cpf == "22222222222" || cpf == "33333333333" || cpf == "44444444444" ||
				cpf == "55555555555" || cpf == "66666666666" || cpf == "77777777777" ||
				cpf == "88888888888" || cpf == "99999999999"){
				document.getElementById("cpfErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("cpf").style.backgroundColor = "#FFDA6C";
				document.getElementById("cpfErrado").innerHTML = "<font color='#FFBF00' size='4,5' >CPF inválido!<br></font>";
				document.getElementById("cpf").focus();
				return false;
		    }else{
				document.getElementById("cpfErrado").style.textShadow = "";
				document.getElementById("cpf").style.backgroundColor = "";
				document.getElementById("cpfErrado").innerHTML = "";
			}

			soma = 0;
			for(i = 0; i < 9; i++)
			{
				soma += parseInt(cpf.charAt(i)) * (10 - i);
			}
			
			resto = 11 - (soma % 11);
			if(resto == 10 || resto == 11)
			{
				resto = 0;
			}
			if(resto != parseInt(cpf.charAt(9))){
				document.getElementById("cpfErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("cpf").style.backgroundColor = "#FFDA6C";
				document.getElementById("cpfErrado").innerHTML = "<font color='#FFBF00' size='4,5' >CPF inválido!<br></font>";
				document.getElementById("cpf").focus();
				return false;
			}else{
				document.getElementById("cpfErrado").style.textShadow = "";
				document.getElementById("cpf").style.backgroundColor = "";
				document.getElementById("cpfErrado").innerHTML = "";
			}
			
			soma = 0;
			for(i = 0; i < 10; i ++){
				soma += parseInt(cpf.charAt(i)) * (11 - i);
			}
			resto = 11 - (soma % 11);
			if(resto == 10 || resto == 11){
				resto = 0;
			}
			
			if(resto != parseInt(cpf.charAt(10))){
				document.getElementById("cpfErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("cpf").style.backgroundColor = "#FFDA6C";
				document.getElementById("cpfErrado").innerHTML = "<font color='#FFBF00' size='4,5' >CPF inválido!<br></font>";
				document.getElementById("cpf").focus();
				return false;
			}else{
				document.getElementById("cpfErrado").style.textShadow = "";
				document.getElementById("cpf").style.backgroundColor = "";
				document.getElementById("cpfErrado").innerHTML = "";
			}
			
			return true;
				document.getElementById("cpfErrado").style.textShadow = "";
				document.getElementById("cpf").style.backgroundColor = "";
				document.getElementById("cpfErrado").innerHTML = "";
		}
 
		function remove(str, sub) {
			i = str.indexOf(sub);
			r = "";
			
			if (i == -1) return str;
			{
				r += str.substring(0,i) + remove(str.substring(i + sub.length), sub);
			}
			
			return r;
		}
		//* MASCARA ( mascara(o,f) e execmascara() ) CRIADAS POR ELCIO LUIZ
		//* elcio.com.br
		function mascara(o,f){
			v_obj=o
			v_fun=f
			setTimeout("execmascara()",1)
		}

		function execmascara(){
			v_obj.value=v_fun(v_obj.value)
		}

		function cpf_mask(v){
			v=v.replace(/\D/g,"")                 //Remove tudo o que não é dígito
			v=v.replace(/(\d{3})(\d)/,"$1.$2")    //Coloca ponto entre o terceiro e o quarto dígitos
			v=v.replace(/(\d{3})(\d)/,"$1.$2")    //Coloca ponto entre o setimo e o oitava dígitos
			v=v.replace(/(\d{3})(\d)/,"$1-$2")   //Coloca ponto entre o decimoprimeiro e o decimosegundo dígitos
			return v
		}

	
	/*
		Função mascara para telefone
	*/
		function mascara(o,f){
			v_obj=o
			v_fun=f
			setTimeout("execmascara()",1)
		}
		
		function execmascara(){
			v_obj.value=v_fun(v_obj.value)
		}
		
		function mtel(v){
			v=v.replace(/\D/g,"");             //Remove tudo o que não é dígito
			v=v.replace(/^(\d{2})(\d)/g,"($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
			v=v.replace(/(\d)(\d{4})$/,"$1-$2");    //Coloca hífen entre o quarto e o quinto dígitos
			return v;
		}
	
	
	
	/*
		Função que  verficar se o campo email tem @ e se tem . ponto 
	*/ 
		function checarEmail(){
			var formulario = document.getElementById('cadForm');
			var email = formulario.email.value;
			if(email.indexOf('@')==-1 || email.indexOf('.')==-1 ){
				document.getElementById("emailErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("email").style.backgroundColor = "#FFDA6C";
				document.getElementById("emailErrado").innerHTML = "<font color='#FFBF00' size='4,5' >Por favor, informe um email válido!<br></font>";
				document.cadForm.email.focus();
				   return false;
			}else{
				document.getElementById("emailErrado").style.textShadow = "";
				document.getElementById("email").style.backgroundColor = "";
				document.getElementById("emailErrado").innerHTML = "";
			}
		}
	
	
	
	/*
		Função que tras o endereço quando for digitado o cep
	*/
		function atualizacep(cep){
		    cep = cep.replace(/\D/g,"")
		    url="http://cep.correiocontrol.com.br/"+cep+".js"
		    s = document.createElement('script')
		    s.setAttribute('charset','utf-8')
		    s.src=url
		    document.querySelector('head').appendChild(s)
		}

		function correiocontrolcep(valor){
			if (valor.erro) {
				document.getElementById("cepErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("cep").style.backgroundColor = "#FFDA6C";
				document.getElementById("cepErrado").innerHTML = "<font color='#FFBF00' size='4,5' >CEP errado!<br></font>";
				
				return;
			};
			document.getElementById("cep").style.backgroundColor = "";
			document.getElementById("cepErrado").innerHTML="";
			
			document.getElementById('logradouro').value = valor.logradouro
			document.getElementById('bairro').value = valor.bairro
			document.getElementById('cidade').value = valor.localidade
		    document.getElementById('estado').value = valor.uf
			
		}
	
		function mascara_cep() {
			if(document.getElementById("cep").value.length == 5) {
			   document.getElementById("cep").value += '-';
			}
		}
	
	
	
	/*
		Função para verficar o tamanho da senha e se são iguais
	*/	
		function tamanho(){
			var comprimento = document.getElementById("senha").value.length;
			if (comprimento<6 || comprimento>14){
				document.getElementById("senhaErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("senha").style.backgroundColor = "#FFDA6C";
				document.getElementById("senhaErrado").innerHTML = "<font color='#FFBF00' size='4,5' >Sua senha deve ter entre 6 e 14 digitos!<br></font>";
				document.getElementById("senha").focus();
				return false;
			} else {
				document.getElementById("senhaErrado").style.textShadow = "";
				document.getElementById("senha").style.backgroundColor = "";
				document.getElementById("senhaErrado").innerHTML = "";
			}
		}
		
		function iguais(){
			var campo1 =document.getElementById("senha").value;
			var campo2 = document.getElementById("repitaSenha").value;	
			if(campo1 != campo2){
				document.getElementById("repitaSenhaErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("repitaSenha").style.backgroundColor = "#FFDA6C";
				document.getElementById("repitaSenhaErrado").innerHTML = "<font color='#FFBF00' size='4,5' >As senhas não são iguais!<br></font>";
				document.getElementById("repitaSenha").focus();
				return false;
			}else{
				document.getElementById("repitaSenhaErrado").style.textShadow = "";
				document.getElementById("repitaSenha").style.backgroundColor = "";
				document.getElementById("repitaSenhaErrado").innerHTML = "";
			}
		}
		

	/*
		Função que verifica se algum campo do formulario está vazio
	*/ 
		function verificaFormulario(){
				
		//verifica se o campo data de inscrição  esta preenchido ou vazio
			if(	document.getElementById("dataInscricao").value == ""){
				document.getElementById("dataInscricao").focus();
				document.getElementById("dataInscricaoErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("dataInscricao").style.backgroundColor = "#FFDA6C";
				document.getElementById("dataInscricaoErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, a data de inscrição!<br></font>";
				return false;	
			}else{
				document.getElementById("dataInscricaoErrado").style.textShadow = "";
				document.getElementById("dataInscricao").style.backgroundColor = "";
				document.getElementById("dataInscricaoErrado").innerHTML = "";
			}
		
		//verifica se o campo nome  esta preenchido ou vazio
			if(	document.getElementById("nomeP").value == ""){
				document.getElementById("nomeP").focus();
				document.getElementById("nomeErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("nomeP").style.backgroundColor = "#FFDA6C";
				document.getElementById("nomeErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe seu nome!<br></font>";
				return false;	
			}else{
				document.getElementById("nomeErrado").style.textShadow = "";
				document.getElementById("nomeP").style.backgroundColor = "";
				document.getElementById("nomeErrado").innerHTML = "";
			}
			
		//verifica se o campo idade esta preenchido ou vazio
			if(	document.getElementById("idade").value == ""){
				document.getElementById("idade").focus();
				document.getElementById("idadeErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("idade").style.backgroundColor = "#FFDA6C";
				document.getElementById("idadeErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe sua idade!<br></font>";
				return false;	
			}else{
				document.getElementById("idadeErrado").style.textShadow = "";
				document.getElementById("idade").style.backgroundColor = "";
				document.getElementById("idadeErrado").innerHTML = "";
			}	
			
		
			
		//verifica se o campo data de nascimento esta preenchido ou vazio
			if(	document.getElementById("dataNascimento").value == ""){
				document.getElementById("dataNascimento").focus();
				document.getElementById("dataNascimentoErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("dataNascimento").style.backgroundColor = "#FFDA6C";
				document.getElementById("dataNascimentoErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe sua data de nascimento!<br></font>";
				return false;	
			}else{
				document.getElementById("dataNascimentoErrado").style.textShadow = "";
				document.getElementById("dataNascimento").style.backgroundColor = "";
				document.getElementById("dataNascimentoErrado").innerHTML = "";
			}		
		
		//verifica se o campo nome da mãe esta preenchido ou vazio
			if(	document.getElementById("nomeMae").value == ""){
				document.getElementById("nomeMae").focus();
				document.getElementById("maeErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("nomeMae").style.backgroundColor = "#FFDA6C";
				document.getElementById("maeErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe o nome de sua mãe!<br></font>";
				return false;	
			}else{
				document.getElementById("maeErrado").style.textShadow = "";
				document.getElementById("nomeMae").style.backgroundColor = "";
				document.getElementById("maeErrado").innerHTML = "";
			}

		//verifica se o campo nome da pai esta preenchido ou vazio
			if(	document.getElementById("nomePai").value == ""){
				document.getElementById("nomePai").focus();
				document.getElementById("paiErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("nomePai").style.backgroundColor = "#FFDA6C";
				document.getElementById("paiErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe o nome do seu pai!<br></font>";
				return false;	
			}else{
				document.getElementById("paiErrado").style.textShadow = "";
				document.getElementById("nomePai").style.backgroundColor = "";
				document.getElementById("paiErrado").innerHTML = "";
			}		
		
		//verifica se o campo cpf esta preenchido ou vazio
			if(	document.getElementById("cpf").value == ""){
				document.getElementById("cpf").focus();
				document.getElementById("cpfErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("cpf").style.backgroundColor = "#FFDA6C";
				document.getElementById("cpfErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe seu CPF!<br></font>";
				return false;	
			}else{
				document.getElementById("cpfErrado").style.textShadow = "";
				document.getElementById("cpf").style.backgroundColor = "";
				document.getElementById("cpfErrado").innerHTML = "";
			}		
		
		//verifica se o campo email esta preenchido ou vazio
			if(	document.getElementById("email").value == ""){
				document.getElementById("email").focus();
				document.getElementById("emailErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("email").style.backgroundColor = "#FFDA6C";
				document.getElementById("emailErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe seu email!<br></font>";
				return false;	
			}else{
				document.getElementById("emailErrado").style.textShadow = "";
				document.getElementById("email").style.backgroundColor = "";
				document.getElementById("emailErrado").innerHTML = "";
			}

		//verifica se o campo telefone esta preenchido ou vazio
			if(	document.getElementById("telefone").value == ""){
				document.getElementById("telefone").focus();
				document.getElementById("telefoneErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("telefone").style.backgroundColor = "#FFDA6C";
				document.getElementById("telefoneErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe seu telefone!<br></font>";
				return false;	
			}else{
				document.getElementById("telefoneErrado").style.textShadow = "";
				document.getElementById("telefone").style.backgroundColor = "";
				document.getElementById("telefoneErrado").innerHTML = "";
			}		
		
		
			
		//verifica se o campo tipo de logradouro esta preenchido ou vazio
			if(	document.getElementById("tipoLogradouro").value == ""){
				document.getElementById("tipoLogradouro").focus();
				document.getElementById("tipoLogradouroErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("tipoLogradouro").style.backgroundColor = "#FFDA6C";
				document.getElementById("tipoLogradouroErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe seu logradouro!<br></font>";
				return false;	
			}else{
				document.getElementById("tipoLogradouroErrado").style.textShadow = "";
				document.getElementById("tipoLogradouro").style.backgroundColor = "";
				document.getElementById("tipoLogradouroErrado").innerHTML = "";
			}		
		
		//verifica se o campo  logradouro esta preenchido ou vazio
			if(	document.getElementById("logradouro").value == ""){
				document.getElementById("logradouro").focus();
				document.getElementById("logradouroErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("logradouro").style.backgroundColor = "#FFDA6C";
				document.getElementById("logradouroErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe seu tipo de logradouro!<br></font>";
				return false;	
			}else{
				document.getElementById("logradouroErrado").style.textShadow = "";
				document.getElementById("logradouro").style.backgroundColor = "";
				document.getElementById("logradouroErrado").innerHTML = "";
			}
		
		//verifica se o campo  numero esta preenchido ou vazio
			if(	document.getElementById("numero").value == ""){
				document.getElementById("numero").focus();
				document.getElementById("numeroErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("numero").style.backgroundColor = "#FFDA6C";
				document.getElementById("numeroErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe seu numero!<br></font>";
				return false;	
			}else{
				document.getElementById("numeroErrado").style.textShadow = "";
				document.getElementById("numero").style.backgroundColor = "";
				document.getElementById("numeroErrado").innerHTML = "";
			}

		//verifica se o campo  bairro esta preenchido ou vazio
			if(	document.getElementById("bairro").value == ""){
				document.getElementById("bairro").focus();
				document.getElementById("bairroErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("bairro").style.backgroundColor = "#FFDA6C";
				document.getElementById("bairroErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe seu numero!<br></font>";
				return false;	
			}else{
				document.getElementById("bairroErrado").style.textShadow = "";
				document.getElementById("bairro").style.backgroundColor = "";
				document.getElementById("bairroErrado").innerHTML = "";
			}
		
		//verifica se o campo  cidade esta preenchido ou vazio
			if(	document.getElementById("cidade").value == ""){
				document.getElementById("cidade").focus();
				document.getElementById("cidadeErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("cidade").style.backgroundColor = "#FFDA6C";
				document.getElementById("cidadeErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe sua cidade!<br></font>";
				return false;	
			}else{
				document.getElementById("cidadeErrado").style.textShadow = "";
				document.getElementById("cidade").style.backgroundColor = "";
				document.getElementById("cidadeErrado").innerHTML = "";
			}
		
		//verifica se o campo  estado esta preenchido ou vazio
			if(	document.getElementById("estado").value == ""){
				document.getElementById("estado").focus();
				document.getElementById("estadoErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("estado").style.backgroundColor = "#FFDA6C";
				document.getElementById("estadoErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe seu estado!<br></font>";
				return false;	
			}else{
				document.getElementById("estadoErrado").style.textShadow = "";
				document.getElementById("estado").style.backgroundColor = "";
				document.getElementById("estadoErrado").innerHTML = "";
			}
		
		//verifica se o campo  cep esta preenchido ou vazio
			if(	document.getElementById("cep").value == ""){
				document.getElementById("cep").focus();
				document.getElementById("cepErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("cep").style.backgroundColor = "#FFDA6C";
				document.getElementById("cepErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe seu cep !<br></font>";
				return false;	
			}else{
				document.getElementById("cepErrado").style.textShadow = "";
				document.getElementById("cep").style.backgroundColor = "";
				document.getElementById("cepErrado").innerHTML = "";
			}
			
		//verifica se o campo  login esta preenchido ou vazio
			if(	document.getElementById("login").value == ""){
				document.getElementById("login").focus();
				document.getElementById("loginErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("login").style.backgroundColor = "#FFDA6C";
				document.getElementById("loginErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe um usuário !<br></font>";
				return false;	
			}else{
				document.getElementById("loginErrado").style.textShadow = "";
				document.getElementById("login").style.backgroundColor = "";
				document.getElementById("loginErrado").innerHTML = "";
			}

		//verifica se o campo  senha esta preenchido ou vazio
			if(	document.getElementById("senha").value == ""){
				document.getElementById("senha").focus();
				document.getElementById("senhaErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("senha").style.backgroundColor = "#FFDA6C";
				document.getElementById("senhaErrado").innerHTML = "<font color='#FFBF00' size='4' >Por favor, informe uma senha !<br></font>";
				return false;	
			}else{
				document.getElementById("senhaErrado").style.textShadow = "";
				document.getElementById("senha").style.backgroundColor = "";
				document.getElementById("senhaErrado").innerHTML = "";
			}	
			
		//verifica se o campo  repita a senha esta preenchido ou vazio
			if(	document.getElementById("repitaSenha").value == ""){
				document.getElementById("repitaSenha").focus();
				document.getElementById("repitaSenhaErrado").style.textShadow = "1px 1px #979797";
				document.getElementById("repitaSenha").style.backgroundColor = "#FFDA6C";
				document.getElementById("repitaSenhaErrado").innerHTML = "<font color='#FFBF00' size='4' >As senhas não são iguais!<br></font>";
				return false;	
			}else{
				document.getElementById("repitaSenhaErrado").style.textShadow = "";
				document.getElementById("repitaSenha").style.backgroundColor = "";
				document.getElementById("repitaSenhaErrado").innerHTML = "";
			}
				
		
			
				
		}
		
		
		
	window.onload = function(){   //window.onload - as funções são executadas quando a pagina for totalmente carregada
	
	
		
	/*	
		Chama a Função que joga para nos campos inputs a data que vem do pc que esta divida em 3 inputs dia, mes, ano
	*/
		document.getElementById("dataInscricao").value = Data();
		
		
	/*
		Chama a Função para verificar se o nome, nome da mae e nome do pai estao completos
	*/		
		document.getElementById("nomeP").onblur = function(){
				checaNome();
		}
		
		document.getElementById("nomeMae").onblur = function(){
				checaNomeMae();
		}
		
		document.getElementById("nomePai").onblur = function(){
				checaNomePai();
		}
	
	
	/*
		Chama a Função para verificar se o email é valido
	*/		
		document.getElementById("email").onblur = function(){
				checarEmail();
		}
	
	
	/*
		Chama a Função para verificar se a senha tem o tamanho especificado
	*/	
		document.getElementById("senha").onkeyup = function(){
				tamanho();
		}
	
	/*
		Chama a Função para verificar se as senhas são iguais
	*/	
		document.getElementById("repitaSenha").onkeyup = function(){
				iguais();
		}
	
	
		
	/*	
		função que tira a mensagem e a borda dos campoos  quando são digitados	
	*/
		document.getElementById("dataInscricao").onkeydown = function(){
			mascara_data_atual();
			document.getElementById("dataInscricaoErrado").style.textShadow = "";
			document.getElementById("dataInscricao").style.backgroundColor = "";
			document.getElementById("dataInscricaoErrado").innerHTML = "";
		};
		document.getElementById("nomeP").onkeydown = function(){
			document.getElementById("nomeErrado").style.textShadow = "";
			document.getElementById("nomeP").style.backgroundColor = "";
			document.getElementById("nomeErrado").innerHTML = "";
		};
		document.getElementById("idade").onkeydown = function(){
			document.getElementById("idadeErrado").style.textShadow = "";
			document.getElementById("idade").style.backgroundColor = "";
			document.getElementById("idadeErrado").innerHTML = "";
		};
		
		document.getElementById("dataNascimento").onkeydown = function(){
			mascara_data();
			document.getElementById("dataNascimentoErrado").style.textShadow = "";
			document.getElementById("dataNascimento").style.backgroundColor = "";
			document.getElementById("dataNascimentoErrado").innerHTML = "";
		};
		document.getElementById("nomeMae").onkeydown = function(){
			document.getElementById("maeErrado").style.textShadow = "";
			document.getElementById("nomeMae").style.backgroundColor = "";
			document.getElementById("maeErrado").innerHTML = "";
		};
		document.getElementById("nomePai").onkeydown = function(){
			document.getElementById("paiErrado").style.textShadow = "";
			document.getElementById("nomePai").style.backgroundColor = "";
			document.getElementById("paiErrado").innerHTML = "";
		};
		document.getElementById("cpf").onkeydown = function(){
			document.getElementById("cpfErrado").style.textShadow = "";
			document.getElementById("cpf").style.backgroundColor = "";
			document.getElementById("cpfErrado").innerHTML = "";
		};
		document.getElementById("email").onkeydown = function(){
			document.getElementById("emailErrado").style.textShadow = "";
			document.getElementById("email").style.backgroundColor = "";
			document.getElementById("emailErrado").innerHTML = "";
		};
		document.getElementById("telefone").onkeydown = function(){
			document.getElementById("telefoneErrado").style.textShadow = "";
			document.getElementById("telefone").style.backgroundColor = "";
			document.getElementById("telefoneErrado").innerHTML = "";
		};
		
		document.getElementById("tipoLogradouro").onkeydown = function(){
			document.getElementById("tipoLogradouroErrado").style.textShadow = "";
			document.getElementById("tipoLogradouro").style.backgroundColor = "";
			document.getElementById("tipoLogradouroErrado").innerHTML = "";
		};
		document.getElementById("logradouro").onkeydown = function(){
			document.getElementById("logradouroErrado").style.textShadow = "";
			document.getElementById("logradouro").style.backgroundColor = "";
			document.getElementById("logradouroErrado").innerHTML = "";
		};
		document.getElementById("numero").onkeydown = function(){
			document.getElementById("numeroErrado").style.textShadow = "";
			document.getElementById("numero").style.backgroundColor = "";
			document.getElementById("numeroErrado").innerHTML = "";
		};
		document.getElementById("bairro").onkeydown = function(){
			document.getElementById("bairroErrado").style.textShadow = "";
			document.getElementById("bairro").style.backgroundColor = "";
			document.getElementById("bairroErrado").innerHTML = "";
		};
		document.getElementById("cidade").onkeydown = function(){
			document.getElementById("cidadeErrado").style.textShadow = "";
			document.getElementById("cidade").style.backgroundColor = "";
			document.getElementById("cidadeErrado").innerHTML = "";
		};
		document.getElementById("estado").onkeydown = function(){
			document.getElementById("estadoErrado").style.textShadow = "";
			document.getElementById("estado").style.backgroundColor = "";
			document.getElementById("estadoErrado").innerHTML = "";
		};
		document.getElementById("cep").onkeydown = function(){
			document.getElementById("cepErrado").style.textShadow = "";
			document.getElementById("cep").style.backgroundColor = "";
			document.getElementById("cepErrado").innerHTML = "";
		};
		document.getElementById("login").onkeydown = function(){
			document.getElementById("loginErrado").style.textShadow = "";
			document.getElementById("login").style.backgroundColor = "";
			document.getElementById("loginErrado").innerHTML = "";
		};
		document.getElementById("senha").onkeydown = function(){
			document.getElementById("senhaErrado").style.textShadow = "";
			document.getElementById("senha").style.backgroundColor = "";
			document.getElementById("senhaErrado").innerHTML = "";
		};
		document.getElementById("repitaSenha").onkeydown = function(){
			document.getElementById("repitaSenhaErrado").style.textShadow = "";
			document.getElementById("repitaSenha").style.backgroundColor = "";
			document.getElementById("repitaSenhaErrado").innerHTML = "";
		};
	
	/*
		Chama a Função para verificar se algum campo do formulario esta vazio
	*/
		document.getElementById("cadForm").onsubmit = function(){
				return verificaFormulario();
		}
		
	}