var btnSeacrh = document.querySelector(".btnSearch");
var boxSearch = document.querySelector(".box-search");
var searchInput = document.querySelector(".box-search__input");
var btnLike = document.querySelector(".btnLike");
var toast = document.querySelector(".toast");

btnSeacrh.addEventListener("click", function () {
    boxSearch.classList.toggle("hide");
    searchInput.focus();
    searchInput.value = "";
})

var rs = 0;

btnLike.addEventListener("click", function () {
    btnLike.classList.toggle("Like");
    if (rs % 2 == 0) {
        createToast("like");
        rs++;
    }
    else if (rs % 2 != 0) {
        createToast("dislike");
        rs++;
    }
})

const toasts = {
    like: {
        icon: '<i class="btnLike fa-solid fa-heart"></i>',
        msg: 'We thank everyone for supporting us.',
    },
    dislike: {
        icon: '<i class="fa-solid fa-heart-crack"></i>',
        msg: 'We sincerely apologize for disappointing you.',
    }
}

function createToast(status) {
    let toast = document.createElement("div");
    toast.className = `toast ${status}`;
    toast.innerHTML = `
    <span>${toasts[status].msg}</span>
    ${toasts[status].icon}
    <span class="toast__coutdown"></span>`

    document.querySelector(".toasts").appendChild(toast);
    setTimeout(() => {
        toast.style.animation = 'toastHide 1s ease forwards'
    }, 2000)

    setTimeout(() => {
        toast.remove()
    }, 3000)
}