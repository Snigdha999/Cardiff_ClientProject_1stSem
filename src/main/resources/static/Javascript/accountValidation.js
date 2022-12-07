// Turn all elements into variables so we can refer to them easily.
let createAccountButton = document.getElementById("createAccountButton"); // The 'Create account' button
let passwordInput = document.getElementById("password"); // The 'Password' field
let repeatPasswordInput = document.getElementById("repeatPassword"); // The 'Repeat password' field
let passwordsDontMatch = document.getElementById("passwordsDontMatch");
let usernameRequired = document.getElementById("usernameRequired");
let usernameInput = document.getElementById("username");
let isSuperUser = document.getElementById("isSuperUser");
let isSuperUserHidden = document.getElementById("hiddenFieldIsSuperUser");

let validUsername = false;
let validRepeatPassword = false;

// Add event listener for when the user types anything on the repeat password field
passwordInput.addEventListener('input', checkMatchingPasswords);
repeatPasswordInput.addEventListener('input', checkMatchingPasswords);
isSuperUser.addEventListener('input', setSuperUserProp);

function checkMatchingPasswords(e)
{

    // If the passwords don't match
    if (passwordInput.value !== repeatPasswordInput.value)
    {
        validRepeatPassword = false;
        passwordsDontMatch.style.display = "block"; // Show the error message
        repeatPasswordInput.style.outline = "2px solid red"; // Show the error message
        checkValidity();
    } else // Otherwise
    {
        validRepeatPassword = true;
        passwordsDontMatch.style.display = "none"; // Hide the error message
        repeatPasswordInput.style.outline = "none"; // Show the error message
        checkValidity();
    }
}

// Add event listener for when the user types anything on the username field
usernameInput.addEventListener('input', function (evt) {
    if (usernameInput.value == "")
    {
        validUsername = false;
        usernameRequired.style.display = "block";
        checkValidity();

    } else {
        validUsername = true;
        usernameRequired.style.display = "none";
        checkValidity();
    }

})

function checkValidity()
{
    if (validUsername && validRepeatPassword == true)
    {
        createAccountButton.style.pointerEvents = "auto"; // Let the user click the button
        createAccountButton.style.opacity = 1; // Set the opacity back to 100%
    }
    else
    {
        createAccountButton.style.pointerEvents = "none"; // Prevent the user from clicking the button
        createAccountButton.style.opacity = 0.5; // Set the opacity to 50%
    }
}

function setSuperUserProp()
{
    if (isSuperUser.checked == true)
    {
        isSuperUserHidden.value = "superUser";
    }
    else
    {
        isSuperUserHidden.value = "user";
    }
}