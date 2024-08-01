function goDel(product_number){
   // DELETE :  http://localhost:8081/restful/api/products/{id}
   let deleteUrl="http://localhost:8081/restful/api/products/"+product_number;
   fetch(deleteUrl, {
         method : "DELETE"
      })
   .then(function(response){
        if(!response.ok){
           throw new Error("Network response was not ok");
        }
        location.href="/restful/list"; // 삭제성공후 리스트 페이지로
      })
   .catch(function(error){
         console.log("error", error);
    });
}