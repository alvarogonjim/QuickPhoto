<%@include file="includes/app/head.jsp"%>
<%@include file="includes/app/body-header.jsp"%>
<main>
   <%@include file="includes/app/body-nav.jsp"%>
   <!-- Contenido para incrustar API -->
   <a class="btn-floating btn-large waves-effect waves-light red inmersive-mode-btn" onclick="return launchEditor('editableimage1', 
      'http://www.sevilla-airport.com/images/sevilla-rio.jpg');"><i class="fa fa-arrows-alt" aria-hidden="true"></i></a>
   <div id="editor" class="aviary-app-container">
   <%@include file="includes/app/descriptions/select-desc.jsp"%>   
   <div class="row" style="padding: 0px 50px 0px 50px;">
      <c:forEach items="${requestScope.files}" var="file">
         <c:if test="${fn:contains(file.mimeType, 'image/')}">
            <div class="col s12 m6 l4 xl2">
               <div class="card">
                  <div class="card-image" style="height: 200px">
                     <div class="thumb" style="height: 200px; background-image: url('${file.thumbnailLink}'); "></div>
                     <span class="card-title">
                        <div class="chip">${file.fileSize} B <i class="fa fa-times" aria-hidden="true"></i></div>
                        <div class="chip">${file.modifiedDate} <i class="fa fa-times" aria-hidden="true"></i></div>
                     </span>    
                     <a class="btn-floating halfway-fab waves-effect waves-light pink" onClick="return launchEditor('${ file.id }', '${ file.webContentLink }');">      
                     	<i class="fa fa-pencil" aria-hidden="true"></i>
                     </a>
                     <td>
					<a href="GoogleDriveFileDelete?id=${file.id}"><img src="https://superrepo.org/static/images/icons/original/xscript.delete.files.png.pagespeed.ic.TF1iwtyDDU.png" width="30px"></a>
					</td>
                  </div>
                  <div class="card-content">
                     <p>${file.title}</p>
                  </div>
               </div>
            </div>
         </c:if>
      </c:forEach>
   </div>
   
     <!-- EDITOR -->

  	<!-- PAGINA DE EJEMPLO DEL EDITOR, LE PASAMOS UNA FOTO DE SEVILLA PUBLICA, LA EDITAMOS 
Y CUANDO LE DAMOS A GUARDAR DEVUELVE LA IMAGEN EDITADA A LA PAGINA -->
<!-- Para cargar el Widget -->
<script type="text/javascript" src="http://feather.aviary.com/imaging/v3/editor.js"></script>

  
<!-- De aqui le tenemos que pasar la imagen del Google Drive (Importante el ID y el URL) -->
<img class="modify" id="modify" src="" style="display:none;"/>
 

<!-- Esto es para instanciarlo -->
<script type="text/javascript">

    var featherEditor = new Aviary.Feather({
        apiKey: '1234567',
        appendTo: 'editor',
        language: 'es',
        onSave: function(imageID, newURL) {
            var img = document.getElementById(imageID);
            img.src = newURL;
        }
    });

    function launchEditor(id, src) {
    	 var img2 = document.getElementsByClassName("modify")[0];
         img2.id = id;
         img2.src = src;
        featherEditor.launch({
            image: id,
            url: src
        });
        return false;
    }
</script>                  
   <!--  FIN EDITOR -->
   
</main>
<%@include file="includes/app/footer.jsp"%>



