let url= "http://localhost:8088/employeeList";
console.log(10);
displayData();

async function displayData() {
  let res = await fetch(url);
  let data1 = await res.json();

  console.log(data1);
  append(data1);
}

function append(data){
    console.log(data)

    data.forEach(function (el){
        let tr= document.createElement("tr");

        let td1= document.createElement("td");
        td1.innerText= el.employeId;
        let td2= document.createElement("td");
        td2.innerText= el.employeeName;
        let td3= document.createElement("td");
        td3.innerText= el.phoneNumber;
        let td4= document.createElement("td");
        td4.innerText= el.email;
        let td5= document.createElement("td");
        td5.innerText= el.address;
        let td6= document.createElement("td");
        td6.innerText= el.education;
        let td9= document.createElement("td");
        td9.innerText= el.experience;
       
        let td7= document.createElement("td")
        td7.setAttribute("id", "edit");
      td7.innerText = "Edit";
      td7.style.cursor = "pointer";
      td7.style.backgroundColor="#24a0ed";
      td7.addEventListener("click", function () {
        localStorage.setItem('productid',el.employeId);
        window.location.href= 'modify.html';
       
        
      });

        tr.append(td1, td2, td3, td4, td5,td6,td9,td7);
         document.querySelector("tbody").append(tr);
        
    })
}