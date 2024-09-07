var introduce = document.querySelectorAll(".introduce__member-item-title");
var introduceDescribe = document.querySelectorAll(".introduce__member-item-describe");

introduce.forEach((item) => {
    item.addEventListener("click", e => {
        introduceDescribe.forEach((acc) => {
            if(e.target.nextElementSibling !== acc && acc.classList.contains("show"))
            {
                acc.classList.remove("show");
                introduce.forEach((intro) => intro.classList.remove("active"));
            }
        })

        item.classList.toggle("active");
        
        const describe = item.nextElementSibling;
        describe.classList.toggle("show");
    })
})

window.onclick = (e) => {
    if(!e.target.matches(".introduce__member-item-title")){
        introduce.forEach((item) => item.classList.remove("active"));
        introduceDescribe.forEach((item) => item.classList.remove("show"));
    }
}