<%@include file="includes/app/head.jsp"%>
<%@include file="includes/app/body-header.jsp"%>
<main>
   <%@include file="includes/app/body-nav.jsp"%>
   <!-- Contenido para incrustar API -->
   <div class="aviary-app-container">
   <%@include file="includes/app/descriptions/select-desc.jsp"%>

   <div class="row" style="padding: 0px 50px 0px 50px;">
      
      <c:forEach items="${requestScope.files.items}" var="file">
         <c:if test="${fn:contains(file.mimeType, 'image/')}">
         <form action="/hello" method="post">
            <div class="col s12 m6 l4 xl2">
               <div class="card">
                  <div class="card-image" style="height: 200px">
                     <div class="thumb" style="height: 200px; background-image: url('${file.thumbnailLink}'); "></div>
                     <span class="card-title">
                        <div class="chip">${file.fileSize} B <i class="fa fa-times" aria-hidden="true"></i></div>
                        <div class="chip">${file.modifiedDate} <i class="fa fa-times" aria-hidden="true"></i></div>
                     </span>
                     <a class="btn-floating halfway-fab waves-effect waves-light lime" onclick="$(this).closest('form').submit()">
                     	<i class="fa fa-compress" aria-hidden="true"></i>
                     </a>
                  </div>
                  <div class="card-content">
                     <p>${file.title}</p>
                  </div>
               </div>
            </div>
         	<input type="hidden" name="img2compress" value="${file.webContentLink}"></input>
         	<!-- La url que devuelve es demasiado larga y creo que por eso falla
         	 <input type="hidden" name="img2compress" value="${fn:substringBefore(file.downloadUrl, '?')}"></input>  -->
              </form>
         </c:if>
      </c:forEach>
   </div>
</main>
<%@include file="includes/app/footer.jsp"%>



