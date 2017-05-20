<%@include file="includes/app/head.jsp"%>
<%@include file="includes/app/body-header.jsp"%>
<script type="text/javascript"src="js/uploadFile.js"></script>
<script type="text/javascript"src="https://apis.google.com/js/client.js?onload=handleClientLoad"></script>
<script>
function getBase64FromImageUrl(url, type) {
	   var img = new Image();

	   img.setAttribute('crossOrigin', 'anonymous');

	   img.onload = function () {
	       var canvas = document.createElement("canvas");
	       canvas.width =this.width;
	       canvas.height =this.height;

	       var ctx = canvas.getContext("2d");
	       ctx.drawImage(this, 0, 0);

	       var dataURL = canvas.toDataURL(type);

	  //     var url= dataURL.replace(/^data:image\/(png|jpg);base64,/, "");
	   };

	   newUploadFile_own(dataURL, type, "comprimida")
	}
</script>
<main>
   <%@include file="includes/app/body-nav.jsp"%>
   <div id="editor" class="aviary-app-container">
      <%@include file="includes/app/descriptions/upload-desc.jsp"%>
      <div class="row" style="text-align: center;">
         <div class="col s10 offset-s1">
            <div class="card grey lighten-3">
               <div class="card-content upload_t">
                  <p class="card-title">
                    <i class="fa fa-compress" aria-hidden="true"></i> Resultado
                  </p>
               </div>
               <div class="card-action">
               <center>
                  <img src="${ inputURL }" style="max-width: 45%; height: auto;" />
                  <img src="${ output.url }" style="max-width: 45%; height: auto;" />
                  </center>
                  <span>Original: ${input.size} Bytes </span> 
                  <span>Comprimida: ${output.size} Bytes </span>
                  <span>Ratio de compresión de mejora: ${output.ratio} Bytes </span>
               </div>
            </div>
         </div>
      </div>
      <div class="row" style="text-align: center;">
         <div class="col s12 m6 offset-m3">
            <div class="card grey lighten-3">
               <div class="card-content upload_t">
                  <!--Add a file picker for the user to choose an image file to be edited -->
                  <center><input type="file" id="filePicker" class="file-path validate" style="display: none" /></center>
                  <input type="button" id="authorizeButton" style="display: none"
                     value="Authorize" />
                     <br>
                  <h5 class="upload_" id="success" style="display: none;">Imagen subida correctamente</h5>
                  <div id="loading" style="display: none;">
                     <div class="preloader-wrapper small active">
                        <div class="spinner-layer spinner-blue-only">
                           <div class="circle-clipper left">
                              <div class="circle"></div>
                           </div>
                           <div class="gap-patch">
                              <div class="circle"></div>
                           </div>
                           <div class="circle-clipper right">
                              <div class="circle"></div>
                           </div>
                        </div>
                     </div>
                     <span>subiendo...</span>
                  </div>
                  <!-- div placeholder for displaying the edited image -->
                  <div id="resultsDiv" class="resultDiv"></div>
               </div>
               <div class="card-action">
                  <a  onclick="getBase64FromImageUrl(${output.url}, ${output.type})" class="waves-effect waves-light btn upload">SUBIR <i class="fa fa-cloud-upload" aria-hidden="true"></i></a>
               </div>
            </div>
         </div>
      </div>
   </div>
</main>
<%@include file="includes/app/footer.jsp"%>