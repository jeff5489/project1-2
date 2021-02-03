
let logInButton = document.getElementById("logIn")
logInButton.addEventListener("click", () => {
    //console.log("event listener reached")
    logIn()
})

function logIn(){
    console.log("logIn function reached")

    let username = document.getElementById("username")
    let password = document.getElementById("password")

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            //Step 4.5 - This will execute with a successfully completed request.
            console.log("this.response: " + this.responseText);

            if(this.responseText == "true"){
                // Window.location.href = "employeePage.html"
                // window.location.href = "employeePage.html"
                window.location = "//http://localhost:8080/project1-2/employeePage.html";
            }

        }
        
    }
    let url2 = "http://localhost:8080/project1-2/LogInController?username=john&password=pass"
    let url = "?LogIn?username=" + username + "&password=" + password
			 //http://localhost:8080/project1/OtherServlet
    //Step 3
    xhttp.open("POST", url2, true);

    //Step 4
    xhttp.send();
}