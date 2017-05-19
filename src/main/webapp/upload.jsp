<%@include file="includes/app/head.jsp"%>
<%@include file="includes/app/body-header.jsp"%>
<main> <%@include file="includes/app/body-nav.jsp"%>
<!-- Contenido para incrustar API --> <a
	class="btn-floating btn-large waves-effect waves-light red inmersive-mode-btn"
	onclick="return launchEditor('editableimage1', 
      'http://www.sevilla-airport.com/images/sevilla-rio.jpg');"><i
	class="fa fa-arrows-alt" aria-hidden="true"></i></a>
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
			<!--          <form action="/GoogleDriveFileNew" method="get" id="uploadfile">
            <div class="card grey lighten-3">
               <div class="card-content upload_t">
               <input type="file" name="file" id="file" rows="4" cols="50">
               <input type="textarea"  name="file" id="file">
               <input type="hidden" value="" id="bytes" name="bytes">
               </div>
               <div class="card-action">
               </div>
            </div>
          </form>
 -->
			<p>Select a File to Load:</p>

			<input id="inputFileToLoad" type="file" />


			<p>File Contents as DataURL:</p>
<form action="/GoogleDriveFileNew" method="post" id="uploadfile"> 
			<input type="text" id="bytes" name ="bytes" style="width: 640; height: 240"></textarea>
             <button onclick="loadImageFileAsURL()" class="waves-effect  red btn"><i class="fa fa-cloud-upload right" aria-hidden="true"></i>SUBIR</button>

</form>
			<script type="text/javascript">
 
function loadImageFileAsURL()
{
    var filesSelected = document.getElementById("inputFileToLoad").files;
    if (filesSelected.length > 0)
    {
        var fileToLoad = filesSelected[0];
 
        var fileReader = new FileReader();
 
        fileReader.onload = function(fileLoadedEvent) 
        {
            var textAreaFileContents = document.getElementById("bytes");
            textAreaFileContents.value = fileLoadedEvent.target.result;
            document.getElementById("uploadfile").submit();
        };

        
        fileReader.readAsDataURL(fileToLoad);
        
    }
}
 
</script>


		</div>
	</div>
</div>
</main><!-- 
<script type="text/javascript">
function readBytes()
{
    var file = document.getElementById('file');
    if(file.files.length)
    {
        var reader = new FileReader();
        reader.onload = function(e)
        {
            document.getElementById("bytes").value = e.target.result;
            alert(document.getElementById("bytes").value);
        };
        reader.readAsBinaryString(file.files[0]);
        document.getElementById("uploadfile").submit();
          
    }
   
}
</script> -->
<%@include file="includes/app/footer.jsp"%>