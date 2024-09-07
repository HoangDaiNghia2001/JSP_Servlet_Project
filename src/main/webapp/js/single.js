var btnCLose = document.querySelector(".modal-header > i");
var btnZoom = document.querySelector(".image-zoom > p");
var showImage = document.querySelector(".showImage");
var modal = document.getElementById("modal");

btnZoom.addEventListener("click", function(){
    showImage.classList.add("action")
    modal.style.animation= 'showModal 0.6s linear'
})

btnCLose.addEventListener("click", function(){
    setTimeout(() => {showImage.classList.remove("action")},500)
    modal.style.animation= 'hideModal 0.5s linear'
    
})

