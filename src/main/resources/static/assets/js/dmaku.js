
var signUpButton = document.getElementById('signUp')
var signInButton = document.getElementById('signIn')
var container = document.getElementById('dowebok')

signUpButton.addEventListener('click', function () {
    container.classList.add('right-panel-active')
    console.log("111")
})

signInButton.addEventListener('click', function () {
    container.classList.remove('right-panel-active')
    console.log("111")
});
