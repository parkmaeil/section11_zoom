<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${cpath}/resources/css/style.css">
<script src="${cpath}/resources/js/detail.js"></script>
<script src="${cpath}/resources/js/delete.js"></script>
<script src="${cpath}/resources/js/update.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
     restProductDetails("${product_number}"); // 함수 호출
</script>
</head>
<body>

    <div class="container mt-3">
        <h2>Spring기반 RESTful API SOA 서비스 개발</h2>
        <div class="card">
            <div class="card-header">
               <div class="row">
                   <div class="col-4">Welcome, GUEST님 / 적립금 : 0원</div>
                   <div class="col-8">
                         <form class="form-inline" action="로그인경로" method="post">
                                        <label for="text">아이디:</label>
                                        <input type="text" class="form-control" placeholder="Enter username" id="username" name="username">
                                        <label for="pwd">패스워드:</label>
                                         <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
                                         <button type="submit" class="btn btn-primary">로그인</button>
                         </form>
                   </div>
               </div>
            </div>
            <div class="card-body">
            <h5>제품 상세보기</h5>
            <div id="productDetails">
               <!-- 여기에 REST를 이용해서 상세보기 데이터를 가져와 동적으로 페이지를 만들어 주면된다. -->
            </div>
            <div class="text-center">
                  <button class="btn btn-sm btn-info" onclick="goUpdate(${product_number})">수정</button>
                  <button class="btn btn-sm btn-info" onclick="goDel(${product_number})">삭제</button>
                  <button class="btn btn-sm btn-info" onclick="location.href='${cpath}/list'">목록</button>
            </div>
            </div>
            <div class="card-footer">Spring기반 RESTful API SOA 서비스 개발_박매일</div>
        </div>
    </div>

</body>
</html>

