async function goSearch(){
      let keyword=document.getElementById("keyword").value;
      // KEY(X), Data(JSON : String)
      const res1=await fetch("http://localhost:8081/s11/api/products/search",{
              method : "POST",
              headers :  {
                  "Content-Type" : "application/json;charset=UTF-8"
               },
               body : JSON.stringify({"keyword" : keyword})
       });
      if(!res1.ok){
                       throw new Error("Network response was not ok");
      }
      const products=await res1.json();
      // 리스트 출력.....
      resultList(products);
}
function resultList(products){
    let pList="";
    products.forEach((product)=>{
           let pnum=product.product_number;
           pList+=`<tr>`;
           pList+=`<td>${product.product_number}</td>`;
           pList+=`<td><a href="/s10/detail/${pnum}">${product.product_name}</a></td>`;
           pList+=`<td><input id="iv${pnum}" type="number" class="form-control" value="${product.inventory}"/><button class="btn btn-outline-secondary" onclick="goInventory(${pnum})">Update</button></td>`;
           pList+=`<td>${product.price}</td>`;
           pList+=`<td>${product.manufacturer}</td>`;
           pList+=`</tr>`;
      });
      document.getElementById("pList").innerHTML=pList;
}
async function goInventory(pnum){
        // id="iv15"
        let inventory=parseInt(document.getElementById("iv"+pnum).value); // "5"->5
        const res1=await fetch(`http://localhost:8081/s11/api/products/${pnum}/inventory`,{
                      method : "PUT",   // update
                      headers :  {
                          "Content-Type" : "application/json;charset=UTF-8"
                       },
                       body : JSON.stringify({"inventory" : inventory})
               });
              if(!res1.ok){
                               throw new Error("Network response was not ok");
              }
         const res2=await res1.text(); // text(), json()
         alert(res2); // 다이얼로그->Modal(모달)
         location.href="/s11/list";
}

async function restProductListPaging(page,size){ //  1, 10 / 4, 10
   let formData={
       page : page,
       size : size
     };
   const res1=await fetch("http://localhost:8081/s11/api/products/paging", {
       method : "POST",
       headers :  {
                         "Content-Type" : "application/json;charset=UTF-8"
      },
      body : JSON.stringify(formData) // Object->JSON(String)
     });
   if(!res1.ok){
                 throw new Error("Network response was not ok");
   }
    const pm=await res1.json();
    resultList(pm.lists); // 페이징 인경우.... 페이지당 결과 리스트 출력
    // [Prev 1,2,3,4, Next]
    pagingList(pm);
}

function pagingList(pm){
    let pagination=document.querySelector(".pagination");
    let plist="";
    // 이전
    if(pm.prev){
         plist+=`<li class="page-item"><a class="page-link" href="/s11/list?page=${pm.startPage-1}">Prev</a></li>`;
    }
    // 페이지 리스트
     for(let page=pm.startPage;page<=pm.endPage;page++){
          plist+=`<li class="page-item ${pm.cri.page==page ? 'active' : ''}"><a class="page-link" href="/s11/list?page=${page}">${page}</a> </li>`;
     }
     // 다음
     if(pm.next){
              plist+=`<li class="page-item"><a class="page-link" href="/s11/list?page=${pm.endPage+1}">Next</a></li>`;
     }
    document.querySelector(".pagination").innerHTML=plist;
}