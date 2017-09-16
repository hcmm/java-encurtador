/**
 * 
 */
function getUrlEncurtada() {
   var urlGrande = $("#url").val();
   $.ajax({ 
       type: 'POST', 
       url: 'http://example/functions.php', 
       data: { get_param: 'value' }, 
       success: function (data) { 
           var names = data
           $('#cand').html(data);
       }
});
}