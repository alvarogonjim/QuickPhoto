<%@include file="includes/app/head.jsp"%>
<%@include file="includes/app/body-header.jsp"%>
<main>
   <%@include file="includes/app/body-nav.jsp"%>
   <!-- Contenido para incrustar API -->
   <a class="btn-floating btn-large waves-effect waves-light red inmersive-mode-btn" onclick="return launchEditor('editableimage1', 
      'http://www.sevilla-airport.com/images/sevilla-rio.jpg');"><i class="fa fa-arrows-alt" aria-hidden="true"></i></a>
   <div id="editor" class="aviary-app-container">
   <%@include file="includes/app/descriptions/edit-desc.jsp"%>
   				<!-- PAGINA DE EJEMPLO DEL EDITOR, LE PASAMOS UNA FOTO DE SEVILLA PUBLICA, LA EDITAMOS 
Y CUANDO LE DAMOS A GUARDAR DEVUELVE LA IMAGEN EDITADA A LA PAGINA -->

<!-- Para cargar el Widget -->
<script type="text/javascript" src="http://feather.aviary.com/imaging/v3/editor.js"></script>


<!-- De aqui le tenemos que pasar la imagen del Google Drive (Importante el ID y el URL) -->
<img id="editableimage1" src="http://www.sevilla-airport.com/images/sevilla-rio.jpg"/>
 

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
        featherEditor.launch({
            image: id,
            url: src
        });
        return false;
    }

</script>                         

<!-- Un boton que llama a la funcion del editor con la imagen que le pasamos arriba (Debe de tener el mismo ID y el URL debe ser publica) -->    
    
<a href="#" onclick="return launchEditor('editableimage1', 
    'http://www.sevilla-airport.com/images/sevilla-rio.jpg');">Edita la Imagen!</a>
   </div>
</main>
<%@include file="includes/app/footer.jsp"%>



