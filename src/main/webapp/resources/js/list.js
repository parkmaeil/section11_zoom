function restProductList(){
  // GET : http://localhost:8081/restful/api/products
  // ajax 통신(비동기전송)
  fetch("http://localhost:8081/restful/api/products")
  .then(function(response){
         console.log(response);
          if(!response.ok){
              throw new Error("Network response was not ok");
          }
          return response.json();
       })
  .then(function(products){
         console.log(products);   // [  {     },{     },{     }  ]
         let productListTable=document.getElementById("productList");
         let tbody=productListTable.querySelector("tbody");
         tbody.innerHTML="";
         products.forEach(function(product){
                 let pnum=product.product_number;
                 let tr=document.createElement("tr"); // <tr>   </tr>
                 tr.innerHTML="<td>"+product.product_number+"</td>"+
                 "<td><a href='/restful/detail/"+pnum+"'>"+product.product_name+"</a></td>"+
                 "<td>"+product.inventory+"</td>"+
                 "<td>"+product.price+"</td>"+
                 "<td>"+product.manufacturer+"</td>";
                 tbody.appendChild(tr);
         });
     })
  .catch(function(error){
       console.log("error", error);
     });
}