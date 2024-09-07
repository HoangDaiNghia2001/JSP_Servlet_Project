var btnSignup =document.querySelector(".login-form > span");
var btnLogin = document.querySelector(".signup-form > span");
var fromSignup = document.querySelector(".signup-form");
var fromLogin = document.querySelector(".login-form");

console.log(btnSignup)

btnSignup.addEventListener("click",  function(){
    fromSignup.classList.remove("signupHide")
    fromSignup.classList.add("signupActive");

    fromLogin.classList.remove("loginActive");
    fromLogin.classList.add("loginHide");
})

btnLogin.addEventListener("click", function(){
    fromSignup.classList.add("signupHide")
    fromSignup.classList.remove("signupActive");

    fromLogin.classList.add("loginActive");
    fromLogin.classList.remove("loginHide");
})
