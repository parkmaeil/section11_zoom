function goRegister(){
   let product_name = document.getElementById('product_name').value;
   let inventory = parseInt(document.getElementById('inventory').value);
   let price = parseFloat(document.getElementById('price').value);
   let manufacturer = document.getElementById('manufacturer').value;
   // JavaScript Object(JSON)
   let formData={
          "product_name" : product_name,
          "inventory" : inventory,
          "price" : price,
          "manufacturer"  : manufacturer
         };
       // POST : http://localhost:8081/restful/api/products [제품등록하기]
        fetch("http://localhost:8081/restful/api/products", {
              method : "POST",
              headers :{
                  "Content-Type" : "application/json"
                },
               body :  JSON.stringify(formData)
           })
        .then(function(response){
             if(!response.ok){
                 throw new Error("Network response was not ok");
             }
             location.href="/restful/list";  // /restful
          })
        .catch(function(error){
              console.log("error", error);
          });
}