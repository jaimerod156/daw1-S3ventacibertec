$(document).on("click","#btnagregar", function(){
    $("#txtnomproduct").val("");
    $("#txtunitprice").val("");
    $("#hddproducto").val("0");
    $("#cbocategory").empty();
    $("#cbosupplier").empty();
    listarCboCategorySupplier(0,0);
    $("#switchproducto").hide();
    $("#cbodiscontinued").prop("checked", false)
  $("#modalproduct").modal("show");
})

$(document).on("click",".btnactualizar", function(){
    $("#txtnomproduct").val($(this).attr("data-prodname"));
    $("#txtunitprice").val($(this).attr("data-produnit"));
    $("#hddproducto").val($(this).attr("data-prodcod"));
    $("#cbocategory").empty();
    $("#cbosupplier").empty();
    $("#switchproducto").show();

    if($(this).attr("data-proddiscont") === "true"){
        $("#cbodiscontinued").prop("checked", true)
    }else{
        $("#cbodiscontinued").prop("checked", false)
    }
    listarCboCategorySupplier($(this).attr("data-prodcod"),$(this).attr("data-prodsupp"));

    $("#modalproduct").modal("show");
})

$(document).on("click", "#btnguardar", function(){
   $.ajax({
        type:"POST",
        url: "/product/register",
        contentType: "application/json",
        data: JSON.stringify({
            productId: $("#hddproducto").val(),
            productname: $("#txtnomproduct").val(),
            unitprice: $("#txtunitprice").val(),
            categoryid: $("#cbocategory").val(),
            supplierid: $("#cbosupplier").val(),
            discontinued: $("#cbodiscontinued").prop("checked")
        }),
        success: function(resultado){
            alert(resultado.mensaje)
        }
   });
   $("#modalproduct").modal("hide");

});
function listarCboCategorySupplier(idCategory, idSupplier){
    $.ajax({
        type: "GET",
        url:"/category/get",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbocategory").append(
                     `<option value="${value.categoryid}">${value.category_name}</option>`
                 )
            });
            if(idCategory > 0){
                $("#cbocategory").val(idCategory);
            }
              $.ajax({
                 type: "GET",
                 url:"/supplier/get",
                 dataType: "json",
                 success: function(resultado){
                     $.each(resultado, function(item, value){
                          $("#cbosupplier").append(
                               `<option value="${value.supplierid}">${value.companyname}</option>`
                               )
                          });
                          if(idSupplier > 0){
                             $("#cbosupplier").val(idSupplier)
                          }
                        }
                     });
         }
     })
}