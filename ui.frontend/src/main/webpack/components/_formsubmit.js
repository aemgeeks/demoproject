/*-------------------------------------------------*\
   Javascript sheet for the Component form submit For homepage
   
   Table of Contents
   If you conduct a Search on the page, type in the 
   section below that you would like to jump to.

   - Form Submit for all forms
   - Captch Validation
   - Download Zipfile
   - Form data send to service
   - Email send
   
   
\*-------------------------------------------------*/
/*-------------------------------------------*\
       Form Submit for all forms
\*-------------------------------------------*/

window.addEventListener("DOMContentLoaded", () => {
  let pageTypes;
  let formData;
  let assetPathForEmail = "";
  let formSubmitClick = document.querySelectorAll(".form-submit-click");
  if (formSubmitClick) {
    formSubmitClick.forEach((el) =>
      el.addEventListener("click", function () {
        let formId = el.dataset.formsubmitid;

        document.querySelector(formId).onsubmit = (e) => {
          e.preventDefault();
          const form = document.querySelector(formId);
          formData = Object.fromEntries(new FormData(form).entries());
          setTimeout(function () {
            let formValid = "";
            let captchValid = captchValidation();
            formValid = document
              .querySelector(formId)
              .classList.contains("was-validated");

            if (formValid == false && captchValid === true) {
              let form = document.querySelector(formId);
              pageTypes =
                document.getElementById("analyticsData").dataset
                  .getcurrentpagepath;
              let pageTypeLan;
              if (pageTypes.includes("downloads")) {
                pageTypeLan = pageTypes.includes("downloads");
              } else if (pageTypes.includes("descargas")) {
                pageTypeLan = pageTypes.includes("descargas");
              }

              if (formId == "#downloadform" && pageTypeLan) {
                let downloadSucess = downloadZipFile();

                if (downloadSucess) formDataSend(form);
              } else {
                formDataSend(form);
              }
            } else if (!capchValidCondition) {
              document
                .querySelector(".recapatch-error")
                .classList.remove("d-none");
              document
                .querySelector(".recapatch-error")
                .classList.add("d-block");
            }
          }, 1000);
        };
      })
    );
  }

  /*-------------------------------------------*\
       Captch Validation
\*-------------------------------------------*/
  let capchValidCondition = false;
  function captchValidation() {
    let isCaptchaValidated = false;
    let response = grecaptcha.getResponse();
    if (response.length == 0) {
      isCaptchaValidated = false;
      capchValidCondition = false;
      document.querySelector(".recapatch-error").classList.remove("d-none");
      document.querySelector(".recapatch-error").classList.add("d-block");
    } else {
      isCaptchaValidated = true;
      capchValidCondition = true;
      document.querySelector(".recapatch-error").classList.remove("d-block");
      document.querySelector(".recapatch-error").classList.add("d-none");
    }
    return isCaptchaValidated;
  }
  /*-------------------------------------------*\
       Download Zipfile
\*-------------------------------------------*/

  function downloadZipFile() {
    let downloadSucess = false;
    let assetPaths = "";
    let url = window.location.href;
    let domain = new URL(url);
    let domainName = domain.origin;

    let downloadContentsStorage = JSON.parse(
      window.localStorage.getItem("downloadContent_")
    );
    window.localStorage.setItem(
      "downloadContent",
      JSON.stringify(downloadContentsStorage)
    );
    if (
      downloadContentsStorage != null &&
      downloadContentsStorage != undefined
    ) {
      for (let i = 0; i < downloadContentsStorage.length; i++) {
        assetPaths += downloadContentsStorage[i].assetPath + ",";
      }
      assetPaths = assetPaths.slice(0, assetPaths.lastIndexOf(","));
      assetPathForEmail = assetPaths;
      let zipFilePath =
        domainName +
        "/content/myproject/servicespath/zip?multiassetpath=" +
        assetPaths;
      let stateObj = {};
      window.history.replaceState(stateObj, "downloadContentUrl", zipFilePath);
      setTimeout(function () {
        window.location.reload();
        window.history.replaceState(stateObj, "existingUrl", url);
        window.localStorage.removeItem("downloadContent_");
        DownloadContent = [];
        removeDotOnFolder();
      }, 400);

      downloadSucess = true;
    } else {
      window.localStorage.setItem("formstatus", "fail");
      document.querySelector(".addToDownload").click();
      downloadSucess = false;
    }

    return downloadSucess;
  }

  /*-------------------------------------------*\
       Form data send to service
\*-------------------------------------------*/

  function formDataSend(form) {
    window.localStorage.removeItem("formstatus");
    let dateWithTime = DisplayCurrentTime();
    fetch("/content/myproject/servicespath/form.json?currenttimestamp="+dateWithTime,
    {
      method: "POST",
      body: new FormData(form),
    }).then(function (response) {
      if (response.status == 200 || response.status == 202) {
        sendEmail();
        let redirectionData =
          document.querySelector("#stateCountryData").dataset;
        window.localStorage.setItem("formtype", formData.formtype);
        window.localStorage.setItem("formstatus", "success");
        document.querySelector(".response-error").classList.remove("d-block");
        document.querySelector(".response-error").classList.add("d-none");
        setTimeout(function () {
          window.location.href = redirectionData.redirection;
        }, 1200);
      } else {
        window.localStorage.setItem("formstatus", "fail");
        document.querySelector(".response-error").classList.remove("d-none");
        document.querySelector(".response-error").classList.add("d-block");
      }
    }).catch(function () {
      window.localStorage.setItem("formstatus", "fail");
      document.querySelector(".response-error").classList.remove("d-none");
      document.querySelector(".response-error").classList.add("d-block");
    });
  }

  /*-------------------------------------------*\
       Email send
\*-------------------------------------------*/

  function sendEmail() {
    let emailId = formData.email;
    let firstName = formData.firstname;
    let lastName = formData.lastname;
    let formType = formData.formtype;
    let currentPagePath = formData.currentpage;

    let url = window.location.href;
    let domain = new URL(url);
    let domainName = domain.origin;

    let emailPath;
    // Email for Download Form
    if (formType == "download") {
      emailPath =
        domainName +
        "/content/myproject/servicespath/email.emailsend.json?email=" +
        emailId +
        "&firstname=" +
        firstName +
        "&lastname=" +
        lastName +
        "&formtype=" +
        formType +
        "&assets=" +
        assetPathForEmail +
        "&currentpagepath=" +
        currentPagePath;
    }
    // Email for request form
    else if (formType == "requestform") {
      let projectName = formData.projectname;
      let applicationType = formData.applicationtype;
      let buildingType = formData.buildingtype;
      let quantity = formData.quantity;
      let uom = formData.uom;
      let message = formData.message;

      emailPath =
        domainName +
        "/content/myproject/servicespath/email.emailsend.json?email=" +
        emailId +
        "&firstname=" +
        firstName +
        "&lastname=" +
        lastName +
        "&formtype=" +
        formType +
        "&currentpagepath=" +
        currentPagePath +
        "&projectname=" +
        projectName +
        "&applicationtype=" +
        applicationType +
        "&buildingtype=" +
        buildingType +
        "&quantity=" +
        quantity +
        "&uom=" +
        uom +
        "&message=" +
        message;
    }

    // Email for contact,tco and Dramix pro
    else {
      emailPath =
        domainName +
        "/content/myproject/servicespath/email.emailsend.json?email=" +
        emailId +
        "&firstname=" +
        firstName +
        "&lastname=" +
        lastName +
        "&formtype=" +
        formType +
        "&currentpagepath=" +
        currentPagePath;
    }
    let xhr = new XMLHttpRequest();
    xhr.open("GET", emailPath, true);
    xhr.setRequestHeader("Content-type", "application/json; charset=UTF-8");
    xhr.send();
    xhr.onload = function () {
      if (xhr.status === 200) {
        console.log("GET successfully created!");
      }
    };
  }

  function DisplayCurrentTime() {
    const currentDate = new Date();
    const currentDayOfMonth = currentDate.getDate();
    const currentMonth = currentDate.getMonth(); // Be careful! January is 0, not 1
    const currentYear = currentDate.getFullYear();

    const dateString =
      currentDayOfMonth + "-" + (currentMonth + 1) + "-" + currentYear;

    let date = new Date();
    let hours = date.getHours() > 12 ? date.getHours() - 12 : date.getHours();
    let am_pm = date.getHours() >= 12 ? "PM" : "AM";
    hours = hours < 10 ? "0" + hours : hours;
    let minutes =
      date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
    let seconds =
      date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
    time = hours + ":" + minutes + ":" + seconds + " " + am_pm;
    let dateWithTime = dateString + " " + time;
    return dateWithTime;
  }
});
