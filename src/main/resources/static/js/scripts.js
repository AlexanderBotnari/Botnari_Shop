//upload photo//////////////////////////////////////////////
$(document).ready(() => {
    $("#photo").change(function () {
        const file = this.files[0];
        if (file) {
            let reader = new FileReader();
            reader.onload = function (event) {
                $("#imgPreview")
                    .attr("src", event.target.result);
            };
            reader.readAsDataURL(file);
        }
    });
});
// //CRUD///////////////////////////////////////////////////////
let ID ;

function serializeJSON (form) {
   // Create a new FormData object
   const formData = new FormData(form);
   // Create an object to hold the name/value pairs
   const pairs = {};
   // Add each name/value pair to the object
   for (const [name, value] of formData) {
     pairs[name] = value;
   }
   // Return the JSON string
   return JSON.stringify(pairs, null, 2);
 }

//function LoginUser() {
   //let form = document.getElementById("login-form");
  // let username = document.getElementById("username")
   //let password = document.getElementById("password")
   //let data = {"username":username,"password":password}
  // console.log(`body json :${data.body}`)
   // const URL = `http://localhost:8080/login`
  // fetch(URL, {
    //   method: 'POST',
     //  headers: {
      //   Accept: 'application/json',
      //   'Content-Type': 'application/json'
      // },
      // body: data.body
     // })
      //.then(response => {
      //   return response.json()
     // });
 //}
// function createEntity(){
//    let form = document.getElementById("createForm")
//    let data = serializeJSON(form)
   
//    //console.log(data)
//    const URL = `http://localhost:8888/posts/create`
//    fetch(URL,{
//       method :'POST', 
//       body : data,
//       headers: {
//          'Content-Type': 'application/json'
//        },
//    })
//               .then((res) => {
//                  return res.json()
//               })
//               .then((res) => {
//                let template = 
//                `<div class="alert alert-success d-flex align-items-center" role="alert">
//                <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
//                <div>
//                  Post "${res.data.title}" has been created
//                </div>
//                </div>`

//                let modalBody = document.getElementById("createModalBody")
//                let modalFooter = document.getElementById("createModalFooter")

//                modalBody.innerHTML = template
//                modalFooter.innerHTML = ` `

//                // getEntities("Post")
//                location.reload()
//             })
//               .catch(showError)

// }

// function getEntity(id){
//    const URL = `http://localhost:8888/posts/${id}`
//     fetch(URL)
//               .then((res) => {
//                  return res.json()
//               })
//               .then((res) => {

//                let title = document.getElementById("updateInputTitle")
//                let body = document.getElementById("updateInputBody")

//                title.value = res.data.title
//                body.value = res.data.body

//             })
//               .catch(showError)


// }

// function updateEntity(){
   
//    let form = document.getElementById("updateForm")
//    let data = serializeJSON(form)

//    console.log(data)
//    const URL = `http://localhost:8888/posts/`
//    fetch(URL,{
//       method :'PUT', 
//       body : data,
//       headers: {
//          'Content-Type': 'application/json'
//        },
//    })
//               .then((res) => {
//                  return res.json()
//               })
//               .then((res) => {

//                let template = 
//                `<div class="alert alert-success d-flex align-items-center" role="alert">
//                <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
//                <div>
//                  Post "${res.data.title}" has been updated
//                </div>
//                </div>`

//                let modalBody = document.getElementById("updateModalBody")
//                let modalFooter = document.getElementById("updateModalFooter")

//                modalBody.innerHTML = template
//                modalFooter.innerHTML = ` `

//                location.reload()
//                // getEntities("Post")
//             })
//               .catch(showError)

// }

// function deleteEntity(id){

//    const URL = `http://localhost:8888/posts/`
//    fetch(URL,{
//       method :'DELETE', 
//       body : JSON.stringify({id:id}),
//       headers: {
//          'Content-Type': 'application/json'
//        },
//    })
//               .then((res) => {
//                  return res.json()
//               })
//               .then((res) => {

//                let template = 
//                `<div class="alert alert-success d-flex align-items-center" role="alert">
//                <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
//                <div>
//                  Entity with id "${id}" is deleted from the database 
//                </div>
//                </div>`

//                let modalBody = document.getElementById("deleteModalBody")
//                let modalFooter = document.getElementById("deleteModalFooter")

//                modalBody.innerHTML = template
//                modalFooter.innerHTML = ` `

//                // getEntities("Post")
//                location.reload()
//             })
//               .catch(showError)

// }

// function setId(id){
//  //  console.log("id -------"+id)
//      ID = id
//      getEntity(ID)
// }
// function confirmDelete(){
//  //   console.log("Delete id >>" + ID)
//     deleteEntity(ID)
// }

// function showEntities(response){
//     console.log(response)

//     let tableHead = ``

//     response.data.forEach((entity) => {
//        tableHead = `<tr>`
//         Object.keys(entity).forEach((prop) => {
//            tableHead += `<th>${prop}</td>`
//         })
//         tableHead += `<th>ACTIONS</th>`
//         tableHead += `</tr>`
//     });

//     let tableBody = ``

//     response.data.forEach(entity => {
//         tableBody += `<tr>`
//         Object.keys(entity).forEach(prop => {
//             tableBody += `<td>${entity[prop]}</td>`
//         })
//         tableBody += `<td>
//         <button class="btn btn-info btn-sm"  data-bs-toggle="modal" data-bs-target="#updateModal" onclick="setId(${entity.id})"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
//         <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
//         <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
//         </svg></button>
//         <button class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteModal" onclick="setId(${entity.id})"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
//         <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
//         <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
//         </svg></button>
//         </td>`
    
//         tableBody += `</tr>`

//     });
//     //create visual table
//     let template = `
//                <table class="table table-dark table-striped">
//                   ${tableHead}
//                   ${tableBody}
//                </table>`

//    let contentDiv = document.getElementById("content")
//    contentDiv.innerHTML = template
// }

// function processResponse(response){
//    return response.json()
// }

// function showError(error){
//    console.log(error)
//    let footerDiv = document.getElementById("footer")
//    footerDiv.innerHTML = `ERROR , cannot load data <br> REASON : ${error}`
// }

// function getEntities(entity_type){
//    const URL = `http://localhost:8888/posts/index/${entity_type}`
//    fetch(URL)
//               .then(processResponse)
//               .then(showEntities)
//               .catch(showError)
// }

// getEntities("Post")