document.getElementById("submit").addEventListener("click", () =>{
    addData()
})

let addData = async() =>{

    console.log(10);
    let data ={

        address: document.getElementById("address").value,
        phoneNumber: document.getElementById("phone").value,
        education: document.getElementById("educationType").value,
        employeeName: document.getElementById("name").value,
        email: document.getElementById("email").value,
        experience: document.getElementById("experience").value,
        
        

    }
    //console.log(data);


    let url= `http://localhost:8088/add`;
    
    let res = await fetch(url,{
        method : "POST",
        body : JSON.stringify(data),
        headers : {
            "Content-Type" : "application/json"
        },
    });

alert("Task Added Sucessfully");
window.location.href='add.html';









}