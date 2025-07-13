$(document).on("click","#btnagregar", function(){
    $("#txtnomproduct").val("");
    $("#txtunitprice").val("");
    $("#hddproducto").val("0");

  $("#modalproduct").modal("show");
})

$(document).on("click",".btnactualizar", function(){
    $("#txtnomproduct").val($(this).attr("data-prodname"));
    $("#txtunitprice").val($(this).attr("data-produnit"));
    $("#hddproducto").val($(this).attr("data-prodcod"));

    $("#modalproduct").modal("show");
})