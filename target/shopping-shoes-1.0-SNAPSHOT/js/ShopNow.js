var product_item = document.querySelectorAll(".product");
var loadMore = document.querySelector(".load-more-other-product");
function hideBtn(){
    if(product_item.length % 3 != 0)
    {
        loadMore.classList.add("hide");
    }
    else{
        loadMore.classList.remove("hide");
    }
}

console.log(product_item.length);

hideBtn()