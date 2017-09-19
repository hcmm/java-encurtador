function exibeUrl (data) {
	if($.isArray(data)){
		$("#retorno").empty();
		$.each(data, function(index, value){
			$("#retorno").prepend("Id: " + value.id + "<br>Pagina: " + value.url+ "<br>Url Encurtada: " + value.urlCurta + 
					"<br>Url Encurtada>"+ value.alias + "<br><br>");
		});
	}else{
		$("#retorno").html("Id: " + data.id + "<br>Pagina: " + data.url+ "<br>Url Encurtada: " + data.urlCurta + 
				"<br>Url Encurtada>"+ data.alias + "<br><br>");
	}
	$("#loading").empty();
}

function aguardarUrl () {
	$("#loading").html("<img style='width: 55px; height: 55px;' src='image/giphy.gif' alt='loading'></img>");
}

function exibeErroUrl () {
	$("#retorno").html("Ops, Algo acontecendo de errado, vamos ver com o estágiario.");
	$("#loading").empty();
}

function getUrlEncurtada(){
	var urlGrande = $("#id_url").val();
	alert("passou");
	$.ajax({
		  url: "http://localhost:8080/java-encurtador/rest/url/add?url=" + urlGrande,
		  global: false,
		  type: "POST",
		  success: function(){
			  alert("Sucesso");
		  },
		  error: function(){
			  alert("Erro")
		  }
		});
		
}
$(document).ready(function() {
	$("#enviar").on('click', getUrlEncurtada);
});
