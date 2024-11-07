function restProductDetails(product_number){
    // GET : http://localhost:8081/restful/api/products/{id}
    fetch("http://localhost:8081/s11/api/products/"+product_number)
    .then(response=> response.json())
    .then(function(product){
      let productDetails=document.getElementById("productDetails");
      productDetails.innerHTML="";
      let tmpHtml="<table class='table table-bordered'>";
      tmpHtml+="<tr>";
      tmpHtml+="<td>제품번호</td>";
      tmpHtml+="<td>"+product.product_number+"</td>";
      tmpHtml+="</tr>";
      tmpHtml+="<tr>";
      tmpHtml+="<td>제품이름</td>";
      tmpHtml+="<td>"+product.product_name+"</td>";
      tmpHtml+="</tr>";
      tmpHtml+="<tr>";
      tmpHtml+="<td>재고량</td>";
      tmpHtml+="<td>"+product.inventory+"</td>";
      tmpHtml+="</tr>";
      tmpHtml+="<tr>";
      tmpHtml+="<td>가격</td>";
      tmpHtml+="<td>"+product.price+"</td>";
      tmpHtml+="</tr>";
      tmpHtml+="<tr>";
      tmpHtml+="<td>제조사</td>";
      tmpHtml+="<td>"+product.manufacturer+"</td>";
      tmpHtml+="</tr>";
      tmpHtml+="</table>";

      productDetails.innerHTML=tmpHtml;

     })
    .catch(function(error){
         console.log("error", error);
     });
}