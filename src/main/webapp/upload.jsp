<%@include file="includes/app/head.jsp"%>
<%@include file="includes/app/body-header.jsp"%>
<script type="text/javascript"src="js/uploadFile.js"></script>
<script type="text/javascript"src="https://apis.google.com/js/client.js?onload=handleClientLoad"></script>
<main>
   <%@include file="includes/app/body-nav.jsp"%>
   <div id="editor" class="aviary-app-container">
      <%@include file="includes/app/descriptions/upload-desc.jsp"%>
      <div class="row" style="text-align: center;">
         <div class="col s10 offset-s1">
            <div class="card grey lighten-3">
               <div class="card-content upload_t">
                  <p class="card-title">
                     <i class="fa fa-google fa-lg" aria-hidden="true"></i> Google Drive
                     Estadisticas
                  </p>
               </div>
               <div class="card-action">
                  <span class="upload_t"> 16GB totales</span>
                  <div class="progress  cyan lighten-4">
                     <div class="determinate red" style="width: 70%"></div>
                     <div class="determinate upload" style="width: 60%"></div>
                  </div>
                  <div class="chip upload_t">
                     9,6GB<span style="color: rgba(0, 0, 0, 0.87);"> Archivos</span>
                  </div>
                  <div class="chip red-text">
                     1,6GB<span style="color: rgba(0, 0, 0, 0.87);"> QuickPhoto</span>
                  </div>
                  <div class="chip cyan-text">
                     4,8GB<span style="color: rgba(0, 0, 0, 0.87);"> Libre</span>
                  </div>
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
                  <a id="uploadButton" style="display: none" class="waves-effect waves-light btn upload">SUBIR <i class="fa fa-cloud-upload" aria-hidden="true"></i></a>
               </div>
            </div>
         </div>
      </div>
   </div>
</main>
<%@include file="includes/app/footer.jsp"%>