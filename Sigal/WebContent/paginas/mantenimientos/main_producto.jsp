<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function generarQR(idProd){
	var url = document.URL; 
	url = url.substring(0,url.indexOf("/",8));
	url = url + "/Sigal/leerQR?codProd="+idProd; 
	console.log('utl:'+url);
	var imagen= "<img src='http://www.codigos-qr.com/qr/php/qr_img.php?d="+url+"&s=4&e=' alt='C�digos QR / Qr Codes'/>";
	$("#divMostrarMensaje").html(imagen);
	$('#myImagenQr').modal({
	  keyboard: false
	});  
	
	
// 	http://www.codigos-qr.com/generador-qr-codes.php
// url
// post
// url:"",tipo:"url",elreferer:"http://www.codigos-qr.com/generador-de-codigos-qr/",size:"4"
// 	$.post("http://www.codigos-qr.com/generador-qr-codes.php",{url:"prueba.com",tipo:"url",elreferer:"http://www.codigos-qr.com/generador-de-codigos-qr/",size:"4"},function(data){ 
// 			console.log('vamos peru!');
// 		alert(''+data);
		
// 		//  		$("#divMostrarMensaje").html(data);
// //  		$('#myImagenQr').modal({
// // 		  keyboard: false
// // 		});  
// 	}); 
	
	
	
}
$(document).ready(function() { 
	var numeroPaginas = $("#numeroPaginas").val(); 
    var options = {
     currentPage: 1,
     totalPages: numeroPaginas,
     onPageClicked: function(e,originalEvent,type,page){ 
    	if($("#tagTipoListado").val()==1){
    		$.post("listarProductoPag",{inicio:page},function(data){
         		$("#divTablaPag").html(data);
     		}); 	
    	}else{
    		$.post("buscarProductosXDescProdPag",{inicio:page},function(data){
         		$("#divTablaPag").html(data);
     		}); 	
    	}
     	
     } 
 	}

    $('#divPaginador').bootstrapPaginator(options); 
	setTimeout(function(){ $('.alert').hide(1000); }, 2000); 
}); 
</script>
</head>
<body>  
<h3>Mantenimiento Producto</h3>
<c:if test="${requestScope.rsult!=null}"   >
<c:if test="${requestScope.rsult=='0'}"   >
	<div class="alert alert-success"> 
	<h4>Bien!</h4>
	${requestScope.mensaje}
	</div> 
</c:if>
<c:if test="${requestScope.rsult=='1'}"   >
	<div class="alert alert-error"> 
	<h4>Error!</h4>
	${requestScope.mensaje}
	</div> 
</c:if>

</c:if>
	<form class="form-search"  action="buscarProductosXDescProd" method="post">
	    <input type="text" name="objProducto.desc_producto" class="input-medium search-query" placeholder="Producto" >
	    <button type="submit" class="btn">Buscar</button>
    </form>
    
     
		<div id="divTablaPag">
		<table class="table table-striped table-bordered table-hover">
              <thead>
                <tr> 
                  <th>Producto</th> 
                  <th>U.Medida</th> 
                  <th>Modificar</th>
                  <th>Eliminar</th>
                  <th>Ver QR</th>
                </tr>
              </thead>
              <tbody>
              <c:if test="${requestScope.lstProducto!=null}"   >
			     <c:forEach  items="${requestScope.lstProducto}"  var="row"  >
			     	 <tr> 
	                  <td>${row.desc_producto}</td> 
	                  <td>${row.unidadMedida}</td> 
	                  <td><a href="accionProducto?codProd=${row.cod_producto}">[Modificar]</a></td>
	                  <td><a href="eliminarProducto?codProd=${row.cod_producto}">[Eliminar]</a></td>
	                  <td><a href="#" onclick="javascript:generarQR(${row.cod_producto});">[Ver QR]</a></td>
	                </tr>
			     </c:forEach> 
		      </c:if> 
              </tbody>
		</table>
		</div>	 
		 <s:hidden id="tagTipoListado" name="tagTipoListado"      /> 
         <s:hidden id="numeroPaginas" name="numeroPaginas"      /> 
 	     <div id="divPaginador"></div>    
            
            <a class="btn btn-primary"  href="accionProducto">Nuevo Producto</a>
<!--             <a class="btn btn-primary"  href="productoStocks">Producto con Stocks</a> -->

</body>
</html>





<div id="myImagenQr" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalImagenQR" aria-hidden="true">
<div class="modal-body"> 
      <div id="divMostrarMensaje" align="center">
      </div> 
</div> 
</div>