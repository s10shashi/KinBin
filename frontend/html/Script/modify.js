let id= localStorage.getItem('productid');
console.log(id);

let url= `http://localhost:8088/employee/${id}`;




displayData();

async function displayData() {
  let res = await fetch(url);
  let data1 = await res.json();

  console.log(data1);
 append(data1);


}

function append(el){
  
        let tr= document.createElement("div");

        let td1= document.createElement("h3");
        td1.innerText= "Task Id : #"+el.employeId;
        let td2= document.createElement("p");
        td2.innerText="Phone Number "+el.phoneNumber

        let td3= document.createElement("p");
        td3.innerText= "Employee Name :"+el.employeeName;

        let td4= document.createElement("p");
        td4.innerText= "Education :"+el.education;

        let td5= document.createElement("p");
        td5.innerText= "Email :"+el.email;

        let td6= document.createElement("p");
        td6.innerText="Address "+el.address

        

       
        tr.append(td1, td3,td2,  td4, td5,td6);
         document.querySelector("#container").append(tr);
        
    
}
/////////////////del task//////////

document.getElementById("btn2").addEventListener("click", () =>{
  deltask()
})

let deltask= async()=> {

let url= `http://localhost:8088/remove?eId=${id}`;
    
let res = await fetch(url,{
    method : "DELETE",
    headers : {
        "Content-Type" : "application/json"
    },
});

alert("task deleted succefully");
window.location.href= 'empList.html';

}
////////////////////////edit task

document.getElementById("btn1").addEventListener("click", () =>{
  editTask()
})

let editTask= async()=> {

  let data={

    phoneNumber:document.getElementById("phone").value,
    email:document.getElementById("mail").value,
   

  }

console.log(data);






let url= `http://localhost:8088/update/${id}`;
    
let res = await fetch(url,{
    method : "PUT",
    body : JSON.stringify(data),
    headers : {
        "Content-Type" : "application/json"
    },
});

alert("task updated succefully");
window.location.href= 'empList.html';

}