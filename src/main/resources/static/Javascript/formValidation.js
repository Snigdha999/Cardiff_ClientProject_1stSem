document.querySelector("#email")?.addEventListener("blur", validateEmail);
const entryYear = document.querySelector('#entryYear');
const year = document.querySelector('#year');

const reSpaces = /^\S*$/;

const applicationForms = document.querySelectorAll(".application-needs-validation");
const statisticsForms = document.querySelectorAll(".statistics-needs-validation");

entryYear?.addEventListener('blur', validateEntryYear);
year?.addEventListener('blur', validateYear);

Array.from(applicationForms).forEach(form => {
  form.addEventListener(
    "submit",
    event => {
      if (!form.checkValidity() || !validateEmail() || !validateEntryYear()) {
        event.preventDefault();
        event.stopPropagation();
      }
      form.classList.add("was-validated");
    },
    false
  );
});

Array.from(statisticsForms).forEach(form => {
  form.addEventListener(
    "submit",
    event => {
      if (!form.checkValidity() || !validateYear()) {
        event.preventDefault();
        event.stopPropagation();
      }

      form.classList.add("was-validated");
    },
    false
  );
});

//function validateUsername(e) {
//  const username = document.querySelector('#username');
//  if (reSpaces.test(username.value)) {
//    username.classList.remove('is-invalid');
//    username.classList.add('is-valid');
//    return true;
//  } else {
//    username.classList.remove('is-valid');
//
//    username.classList.add('is-invalid');
//    return false;
//  }
//}

function validateEmail(e) {
  const email = document.querySelector("#email");
  const re = /^([a-zA-Z0-9_\-?\.?]){3,}@([a-zA-Z]){3,}\.([a-zA-Z]){2,5}$/;
  const { value } = email;

  if (reSpaces.test(value) && re.test(value) || !value) {
    email.classList.remove("is-invalid");
    email.classList.remove("invalid");
    email.classList.add("is-valid");
    return true;
  } else {
    email.classList.add("is-invalid");
    email.classList.add("invalid");
    email.classList.remove("is-valid");

    return false;
  }
}


function validateEntryYear(e) {
  const re = /^\d{2}\/\d{2}/;
  const { value } = entryYear;

  if (reSpaces.test(value) && re.test(value)) {
    entryYear.classList.remove("is-invalid");
    entryYear.classList.add("is-valid");
    return true;
  } else {
    entryYear.classList.add("is-invalid");
    entryYear.classList.remove("is-valid");
    return false;
  }
}

function validateYear(e) {
  const re = /^\d{2}\/\d{2}/;
  const { value } = year;

  if (reSpaces.test(value) && re.test(value)) {
    year.classList.remove("is-invalid");
    year.classList.remove("invalid");
    year.classList.add("is-valid");
    return true;
  } else {
    year.classList.add("is-invalid");
    year.classList.add("invalid");
    year.classList.remove("is-valid");
    return false;
  }
}

//function validatePassword() {
//  const password = document.querySelector('#password');
//  const re = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})(?=.*[!@#$%^&*])/;
//  if (re.test(password.value) && reSpaces.test(password.value)) {
//    password.classList.remove('is-invalid');
//    password.classList.add('is-valid');
//
//    return true;
//  } else {
//    password.classList.add('is-invalid');
//    password.classList.remove('is-valid');
//
//    return false;
//  }
//}
