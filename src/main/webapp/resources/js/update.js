function goUpdate(product_number){
    location.href="/restful/update/"+product_number;
}

function goSubmit(product_number){
   let product_name=document.getElementById("product_name").value;
   let inventory=parseInt(document.getElementById("inventory").value);
   let price=parseFloat(document.getElementById("price").value);

   let formData={
       product_number : product_number,
       product_name : product_name,
       inventory : inventory,
       price : price
    };
      // PUT  :  http://localhost:8081/restful/api/products/{id}
     fetch("http://localhost:8081/restful/api/products/"+product_number, {
         method : "PUT",
         headers : {
             "Content-Type" : "application/json;charset=UTF-8"
         },
         body : JSON.stringify(formData)
      })
     .then(function(response){
           if(!response.ok){
               throw new Error("Network response was not ok");
           }
           location.href="/restful/list";
       })
     .catch(function(error){
          console.log("error", error);
       });
}