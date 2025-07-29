
function showErrors(elementId, message) {
    const errDiv = document.getElementById(elementId);
    if (errDiv) {
        errDiv.textContent = message;
        errDiv.style.display = 'block';
    }
}

function hideErrors(elementId) {
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

const productForm = document.querySelector("#productFormSubmit");

productForm.addEventListener("submit", function(event) {
    let hasClientSideErrors = false;

    const fieldNames = [
        "productName",
        "productPartNumber",
        "manufacturer",
        "productManufacturerNumber",
        "productPrice",
        "productCategory"
    ];

    const fieldErrs = [
        "productNameError",
        "productPartNumberError",
        "manufacturerError",
        "productManufacturerNumberError",
        "productPriceError",
        "productCategoryError"
    ];

    const name = document.getElementById(fieldNames[0]);
    const partNumber = document.getElementById(fieldNames[1]);
    const manufacturer = document.getElementById(fieldNames[2]);
    const manufacturerNumber = document.getElementById(fieldNames[3]);
    const price = document.getElementById(fieldNames[4]);
    const productCategory = document.getElementById(fieldNames[5]);

    const nameErr = "productNameError";
    const partNumberErr = "productPartNumberError";
    const manufacturerErr = "manufacturerError";
    const manufacturerNumberErr = "productManufacturerNumberError";
    const priceErr = "productPriceError";
    const productCategoryErr = "productCategoryError";

    hideErrors(nameErr);
    if (name.value.trim() === '') {
        showErrors(nameErr, "Product name cannot be blank");
        hasClientSideErrors = true;
    } else if (name.value.length > 50) {
        showErrors(nameErr, "Product name cannot exceed 50 characters");
        hasClientSideErrors = true;
    }

    hideErrors(partNumberErr);
    if (partNumber.value.trim() === '') {
        showErrors(partNumberErr, "Part number cannot be blank");
        hasClientSideErrors = true;
    } else if (partNumber.value.length > 50) {
        showErrors(partNumberErr, "Part number cannot exceed 50 characters")
        hasClientSideErrors = true;
    }

    hideErrors(manufacturerErr);
    if (manufacturer.value.trim() === '') {
        showErrors(manufacturerErr, "Manufacturer cannot be blank");
        hasClientSideErrors = true;
    }

    hideErrors(manufacturerNumberErr);
    if (manufacturerNumber.value.trim() === '') {
        showErrors(manufacturerNumberErr, "Manufacturer Part-Number cannot be blank");
        hasClientSideErrors = true;
    } else if (manufacturerNumber.value.length > 50) {
        showErrors(manufacturerNumberErr, "Manufacturer Part-Number cannot exceed 50 characters");
        hasClientSideErrors = true;
    }

    hideErrors(priceErr);
    if (price.value < 0) {
        showErrors(priceErr, "Price cannot be negative");
        hasClientSideErrors = true;
    }

    hideErrors(productCategoryErr);
    if (productCategory.value.trim() === '') {
        showErrors(productCategoryErr, "Product category cannot be blank");
        hasClientSideErrors = true;
    }

    if (hasClientSideErrors) {
        event.preventDefault();
    }

    for (let i = 0; i < fieldNames.length; ++i) {
        clearFormForInput(fieldNames[i], fieldErrs[i]);
    }
})