$(document).on("click","#btnagregar", function(){
    $("#txtnombre").val("");
    $("#txtapellido").val("");
    $("#txtusuario").val("");
     $("#txtusuario").prop('readonly',true);
    $("#txtemail").val("");
    $("#txtemail").prop('readonly',true);
    $("#hddusuario").val("0");
    $("#switchusuario").hide();
    $("#cbactivo").prop("checked", false)
    $("#divmsgpassword").show();
    $("#btnenviar").hide();
    $("#modalusuario").modal("show");
})

$(document).on("click",".btnactualizar", function(){
    $.ajax({
        type: "GET",
        url: "/seguridad/usuario/" + $(this).attr("data-usuid"),
        dataType: "json",
        success: function(resultado){
            $("#txtnombre").val(resultado.nombres);
            $("#txtapellido").val(resultado.apellidos);
            $("#txtusuario").val(resultado.nomusuario);
            $("#txtusuario").prop('readonly',true);
            $("#txtemail").val(resultado.email);
            $("#txtemail").prop('readonly',true);
            $("#txtpassword").hide();
            $("#hddusuario").val(resultado.idusuario);
            $("#switchusuario").show();
            $("#divmsgpassword").hide();
            $("#btnenviar").show();

            if(resultado.activo)
                $("#cbactivo").prop("checked", true)
            else
                $("#cbactivo").prop("checked", false)
        }
    })

    $("#modalusuario").modal("show");
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
            if(resultado.respuesta){
                listarProductos();
            }
            alert(resultado.mensaje)
        }
   });
   $("#modalproduct").modal("hide");
});

function listarProductos(){
    $.ajax({
        type: "GET",
        url: "/product/list",
        dataType: "json",
        success: function(resultado){
            $("#tblproducto > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblproducto > tbody").append(`<tr>` +
                `<td>${value.productoid}</td>` +
                `<td>${value.product_name}</td>` +
                `<td>${value.unitprice}</td>` +
                `<td>${value.category.category_name}</td>` +
                `<td>${value.supplier.companyname}</td>` +
                `<td><button type='button' class='btn btn-primary btnactualizar'` +
                    `data-prodcod="${value.productoid}" ` +
                    `data-prodname="${value.product_name}" ` +
                    `data-produnit="${value.unitprice}" ` +
                    `data-prodcat="${value.category.categoryid}" ` +
                    `data-prodsupp="${value.supplier.supplierid}" ` +
                    `data-proddiscont="${value.discontinued}">Actualizar` +
                `</button></td>` +
                `</tr>`)
            });
        }
    });
}
