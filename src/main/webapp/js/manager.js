//Delete product
var btnDelete = document.querySelectorAll(".delete");
var question = document.querySelectorAll(".question");
var question_item = document.querySelectorAll(".question-item");
var btnClose = document.querySelectorAll(".question-item >button");

for (let i = 0; i < btnDelete.length; i++) {
    btnDelete[i].addEventListener("click", function () {
        question[i].classList.add("show")
        question_item[i].style.animation = 'showModal 0.5s linear'
    });
    btnClose[i].addEventListener("click", function () {
        setTimeout(() => {
            question[i].classList.remove("show")
        }, 200)
        question_item[i].style.animation = 'hideModal 0.5s linear'
    })
}

//Change product
var btnChange = document.querySelectorAll(".change");
var Change = document.querySelectorAll(".change-pro");
var frmChange = document.querySelectorAll(".change-pro > form");
var btnQuit = document.querySelectorAll(".change-pro-action > button:first-child");

for (let i = 0; i < btnDelete.length; i++) {
    btnChange[i].addEventListener("click", function () {
        Change[i].classList.add("show")
        frmChange[i].style.animation = 'showModal 0.5s linear'
    });
    btnQuit[i].addEventListener("click", function () {
        setTimeout(() => {
            Change[i].classList.remove("show")
        }, 500)
        frmChange[i].style.animation = 'hideModal 0.5s linear'
    })
}

//Add new product
var btnAddPro = document.getElementById("add-new-pro");
var AddPro = document.querySelector(".add-pro");
var AddProItem = document.querySelector(".add-pro > form");
var btnCancle = document.querySelector(".add-pro-action>button:first-child");

btnAddPro.addEventListener("click", function () {
    AddPro.classList.add("show")
    AddProItem.style.animation = 'showModal 0.5s linear'
})

btnCancle.addEventListener("click", function () {
    setTimeout(() => {
        AddPro.classList.remove("show")
    }, 300)
    AddProItem.style.animation = 'hideModal 0.3s linear'
})
