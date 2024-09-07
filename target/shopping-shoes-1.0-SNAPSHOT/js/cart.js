var btnEdit = document.getElementById("edit-inf");
var showFillInfor = document.querySelector(".bill-infor");
var modal = document.querySelector(".fill-infor");
var btnClose = document.getElementById("close");

btnEdit.addEventListener("click", function () {
    showFillInfor.classList.add("action")
    modal.style.animation = 'showModal 0.6s linear'
})

btnClose.addEventListener("click", function () {
    setTimeout(() => {
        showFillInfor.classList.remove("action")
    }, 500)
    modal.style.animation = 'hideModal 0.5s linear'
    console.log(btnClose)
})