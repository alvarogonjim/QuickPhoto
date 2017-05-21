<%@include file="includes/app/head.jsp"%>
<%@include file="includes/app/body-header.jsp"%>
<script type="text/javascript"src="js/uploadFile.js"></script>
<script type="text/javascript"src="https://apis.google.com/js/client.js?onload=handleClientLoad"></script>
<main>
   <%@include file="includes/app/body-nav.jsp"%>
   <div id="editor" class="aviary-app-container">
      <%@include file="includes/app/descriptions/cresult-desc.jsp"%>
      <div class="row" style="text-align: center;">
         <div class="col s10 offset-s1">
            <div class="card grey lighten-3">
               <div class="card-content compress_t">
                  <p class="card-title">
                    <i class="fa fa-compress" aria-hidden="true"></i> Información:
                  </p>
               </div>
               <div class="card-action">
               <center>
                  <img src="${ inputURL }" style="max-width: 45%; height: auto;" />
                  <img src="${ output.url }" style="max-width: 45%; height: auto;" />
                  </center>
                  <div class="chip" ><b>Original:</b> <span id="inputSize">Bytes</span></div>
                  <div class="chip" ><b>Comprimida:</b> <span id="outputSize">Bytes</span></div>
                  <br>
                  <div class="chip" ><b>Ratio de compresión:</b> ${(100-output.ratio)*100}%</div>
               </div>
            </div>
         </div>
      </div>
      <div class="row" style="text-align: center;">
         <div class="col s12 m6 offset-m3">
            <div class="card grey lighten-3">
               <div class="card-content upload_t">
              <a href="${ output.url }" download class="waves-effect waves-light btn green lighten-1" style="margin-top:10px;">DESCARGA DIRECTA <i class="fa fa-download" aria-hidden="true"></i></a>
            </div>
         </div>
      </div>
   </div>
</main>
<script>
function formatBytes(a,b){if(0==a)return"0 Bytes";var c=1e3,d=b||2,e=["Bytes","KB","MB","GB","TB","PB","EB","ZB","YB"],f=Math.floor(Math.log(a)/Math.log(c));return parseFloat((a/Math.pow(c,f)).toFixed(d))+" "+e[f]}
document.getElementById("inputSize").innerHTML = formatBytes(${input.size}, 2);
document.getElementById("outputSize").innerHTML = formatBytes(${output.size}, 2);
</script>
<%@include file="includes/app/footer.jsp"%>