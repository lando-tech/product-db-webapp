
function showErrors(elementId, message) {
    const errDiv = document.getElementById(elementId);
    if (errDiv) {
        errDiv.textContent = message;
        errDiv.style.display = 'block';
    }
}

function hideErrors(elementId, message) {
    const errDiv = document.getElementById(elementId);
    if (errDiv) {
        errDiv.textContent = "";
        errDiv.style.display = 'none';
    }
}

function clearFormForInput(elementId, errorElemId) {
    document.getElementById(elementId).addEventListener('input', function() {
        hideErrors(errorElemId);
    })
}


const form = document.querySelector("#userFormSubmit");

form.addEventListener("submit", function(event) {
    let hasClientSideErrors = false;

    const fieldNames = ["userNameField", "firstNameField", "lastNameField", "passwordField"];
    const errFieldNames = ["userNameError", "firstNameError", "lastNameError", "passwordError"];

    const userName = document.getElementById("userNameField");
    const firstName = document.getElementById("firstNameField");
    const lastName = document.getElementById("lastNameField");
    const password = document.getElementById("passwordField");

    const userNameErr = "userNameError";
    const firstNameErr = "firstNameError";
    const lastNameErr = "lastNameError";
    const passwordError = "passwordError";

    hideErrors(userNameErr);
    if (userName.value.trim() === '') {
        showErrors(userNameErr, "Username cannot be blank");
        hasClientSideErrors = true;
    } else if (userName.value.length > 25) {
        showErrors(userNameErr, "Username cannot exceed 25 characters");
        hasClientSideErrors = true;
    }

    hideErrors(firstNameErr);
    if (firstName.value.trim() === '') {
        showErrors(firstNameErr, "First Name cannot be empty")
        hasClientSideErrors = true;
    } else if (firstName.value.length > 25) {
        showErrors(firstNameErr, "First name cannot exceed 25 characters")
        hasClientSideErrors = true;
    }

    hideErrors(lastNameErr);
    if (lastName.value.trim() === '') {
        showErrors(lastNameErr, "Last Name cannot be blank");
        hasClientSideErrors = true;
    } else if (lastName.value.length > 25) {
        showErrors(lastNameErr, "Last Name cannot exceed 25 characters")
        hasClientSideErrors = true;
    }

    hideErrors(passwordError);
    if (password.value.length < 12) {
        showErrors(passwordError, "Password must be greater than 12 characters");
        hasClientSideErrors = true;
    } else if (password.value.length > 32) {
        showErrors(passwordError,"Password cannot exceed 32 characters");
        hasClientSideErrors = true;
    }

    if (hasClientSideErrors) {
        event.preventDefault();
    }

    for (let i = 0; i < fieldNames.length; ++i) {
        clearFormForInput(fieldNames[i], errFieldNames[i]);
    }

})
