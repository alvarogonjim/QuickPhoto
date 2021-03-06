 var CLIENT_ID = '153251456115-pnvd8tnkt7f47rg5300hscqn6eadr1sc.apps.googleusercontent.com';
 var SCOPES = 'https://www.googleapis.com/auth/drive';

 /**
  * Called when the client library is loaded to start the auth flow.
  */
 function handleClientLoad() {
     window.setTimeout(checkAuth, 1);
 }

 /**
  * Check if the current user has authorized the application.
  */
 function checkAuth() {
     gapi.auth.authorize({
             'client_id': CLIENT_ID,
             'scope': SCOPES,
             'immediate': true
         },
         handleAuthResult);
 }

 /**
  * Called when authorization server replies.
  *
  * @param {Object} authResult Authorization result.
  */
 function handleAuthResult(authResult) {
     var authButton = document.getElementById('authorizeButton');
     var filePicker = document.getElementById('filePicker');
     var uploadButton = document.getElementById('uploadButton');
     authButton.style.display = 'none';
     filePicker.style.display = 'none';
     uploadButton.style.display = 'none';
     if (authResult && !authResult.error) {
         // Access token has been successfully retrieved, requests can be sent to the API.
         filePicker.style.display = 'block';
         filePicker.onchange = loadImageFile;
         uploadButton.onclick = newUploadFile;
     } else {
         // No access token could be retrieved, show the button to start the authorization flow.
         authButton.style.display = 'block';
         authButton.onclick = function() {
             gapi.auth.authorize({
                     'client_id': CLIENT_ID,
                     'scope': SCOPES,
                     'immediate': false
                 },
                 handleAuthResult);
         };
     }
 }

 function newUploadFile(evt) {
     gapi.client.load('drive', 'v2', function() {
         var theImage = document.getElementById('editedImage');
         var fileTitle = theImage.getAttribute('fileName');
         var mimeType = theImage.getAttribute('mimeType');
         var metadata = {
             'title': fileTitle,
             'mimeType': mimeType
         };
         var pattern = 'data:' + mimeType + ';base64,';
         var base64Data = theImage.src.replace(pattern, '');
         newInsertFile(base64Data, metadata);
     });
 }
 /**
  * Insert new file.
  *
  * @param {Image} Base 64 image data
  * @param {Metadata} Image metadata
  * @param {Function} callback Function to call when the request is complete.
  */
 function newInsertFile(base64Data, metadata, callback) {
     const boundary = '-------314159265358979323846';
     const delimiter = "\r\n--" + boundary + "\r\n";
     const close_delim = "\r\n--" + boundary + "--";
     var contentType = metadata.mimeType || 'application/octet-stream';
     var multipartRequestBody =
         delimiter +
         'Content-Type: application/json\r\n\r\n' +
         JSON.stringify(metadata) +
         delimiter +
         'Content-Type: ' + contentType + '\r\n' +
         'Content-Transfer-Encoding: base64\r\n' +
         '\r\n' +
         base64Data +
         close_delim;

     var request = gapi.client.request({
         'path': '/upload/drive/v2/files',
         'method': 'POST',
         'params': {
             'uploadType': 'multipart'
         },
         'headers': {
             'Content-Type': 'multipart/mixed; boundary="' + boundary + '"'
         },
         'body': multipartRequestBody
     });
     if (!callback) {
         callback = function(file) {
        	 document.getElementById("loading").style = "display: none;";
        	 Materialize.toast('<i class="fa fa-cloud-upload fa-lg" aria-hidden="true"></i> Imagen subida correctamente', 6000);
        	 document.getElementById("uploadButton").style = "display: none;";
        	 document.getElementById("resultsDiv").style = "display: none;";
        	 document.getElementById("filePicker").style = "display: none;";
        	 window.location.replace("/GoogleDriveFileNew");
        	 Materialize.toast('<i class="fa fa-circle-o-notch fa-spin fa-lg fa-fw"></i><span class="sr-only">Loading...</span>  Redirigiendo a la selección...', 6000);
         };
     }
     document.getElementById("loading").style = "";
     request.execute(callback);
 }

 function loadImageFile(evt) {
     var file = evt.target.files[0];
     var reader = new FileReader();
     reader.file = file;
     reader.onload = onImageReaderLoad;
     reader.readAsDataURL(file);
 }

 function onImageReaderLoad(evt) {
     var file = this.file;
     var mimeType = file.type;
     writeSomeText(file.name, file.type, evt.target.result);
 }
 /**
  * Write some Hello World text on an image using the canvas.
  *
  * @param {File Name} The name of the image file
  * @param {MimeType} The mime type of the image e.g. image/png
  * @param {Image} The image data
  */
 function writeSomeText(sourceImageName, mimeType, sourceImage) {
     var resultsDiv = document.getElementById('resultsDiv');
     var sourceImg = document.createElement('img');
     var resultImg = document.createElement('img');
     var canvas = document.createElement('canvas');
     sourceImg.onload = function(evt) {
         canvas.width = this.width;
         canvas.height = this.height;
         var ctx = canvas.getContext('2d');
         ctx.drawImage(this, 0, 0, canvas.width, canvas.height);
         ctx.restore();
         resultImg.onload = function(evt2) {
             resultImg.setAttribute('id', 'editedImage');
             resultImg.setAttribute('mimeType', mimeType);
             resultImg.setAttribute('fileName', sourceImageName);
             resultsDiv.appendChild(resultImg);
             var uploadButton = document.getElementById('uploadButton');
             uploadButton.style.display = 'block';
         };
         resultImg.src = canvas.toDataURL(mimeType);
     };
     sourceImg.src = sourceImage;
 }