// slider
var slides = document.querySelectorAll(".img-slide");
var btns = document.querySelectorAll(".nav-btn");
var contents = document.querySelectorAll(".slogan");

function slideNav(index) {
    slides.forEach((slide) => {
        slide.classList.remove("active");
    })

    btns.forEach((btn) => {
        btn.classList.remove("active");
    })

    contents.forEach((content) => {
        content.classList.remove("active");
    })

    slides[index].classList.add("active");
    btns[index].classList.add("active");
    contents[index].classList.add("active");

}

btns.forEach((btn, index) => {
    btn.addEventListener('click', function () {
        slideNav(index);
    })
})


// auto slider

function autoSlide() {

    var active = document.getElementsByClassName("active");
    var index = 1;

    function repeater(){
        setTimeout(function () {
            [...active].forEach((item) => {
                item.classList.remove("active");
            })

            slides[index].classList.add("active");
            btns[index].classList.add("active");
            contents[index].classList.add("active");

            index++;

            if(index == slides.length)
            {
                index = 0;
            }
            if(index >= slides.length)
            {
                return;
            }

            repeater();
        }, 5000);
    }

    repeater();
}

autoSlide();




