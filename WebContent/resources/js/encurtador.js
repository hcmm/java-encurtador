/**
 * 
 */
function getUrlEncurtada() {
   var urlGrande = $("#url").val();
   alert('chegou ate aqui!');
   $.ajax({ 
       type: 'POST', 
       url: 'http://localhost:8080/java-encurtador/rest/url/', 
       data: { url: urlGrande }, 
       success: function (retorno) { 
           alert('retornado do java: '+retorno);
       }
});
}