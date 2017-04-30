<%@include file="includes/app/head.jsp"%>
<%@include file="includes/app/body-header.jsp"%>
<main> 
   <%@include file="includes/app/body-nav.jsp"%>
   <!-- Contenido para incrustar API -->
   <a class="btn-floating btn-large waves-effect waves-light red inmersive-mode-btn" onclick="return launchEditor('editableimage1', 
      'http://www.sevilla-airport.com/images/sevilla-rio.jpg');"><i class="fa fa-arrows-alt" aria-hidden="true"></i></a>
   <div id="editor" class="aviary-app-container">
   		<%@include file="includes/app/descriptions/upload-desc.jsp"%>
      <div class="row" style="text-align: center;">
         <div class="col s10 offset-s1">
            <div class="card grey lighten-3">
               <div class="card-content upload_t">
                  <p class="card-title"><i class="fa fa-google fa-lg" aria-hidden="true"></i> Google Drive Estadisticas</p>
               </div>
               <div class="card-action">
                  <span class="upload_t"> 16GB totales</span>
                  <div class="progress  cyan lighten-4">
                     <div class="determinate red" style="width: 70% "></div>
                     <div class="determinate upload" style="width: 60% "></div>
                  </div>
                  <div class="chip upload_t">
                     9,6GB<span style="color: rgba(0,0,0,0.87);"> Archivos</span>
                  </div>
                  <div class="chip red-text">
                     1,6GB<span style="color: rgba(0,0,0,0.87);"> QuickPhoto</span>
                  </div>
                  <div class="chip cyan-text">
                     4,8GB<span style="color: rgba(0,0,0,0.87);"> Libre</span>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <div class="row" style="text-align: center;">
         <div class="col s12 m6 offset-m3">
            <div class="card grey lighten-3">
               <div class="card-content upload_t">
                  <p class="card-title"><i class="fa fa-arrow-right fa-2x" aria-hidden="true"></i><i class="fa fa-file-image-o fa-2x" aria-hidden="true"></i><br>Suelta tus arhivos .png o .jpg aqu�!</p>
               </div>
               <div class="card-action">
                  <a class="waves-effect  red btn"><i class="fa fa-cloud-upload right" aria-hidden="true"></i>SUBIR</a>
               </div>
            </div>
         </div>
      </div>
   </div>
</main>
<%@include file="includes/app/footer.jsp"%>