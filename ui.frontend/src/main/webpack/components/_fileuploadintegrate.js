/*-------------------------------------------------*\
   Javascript sheet for the Component File upload ajax
   
   Table of Contents
   If you conduct a Search on the page, type in the 
   section below that you would like to jump to.

   - Servlet invoking
   
\*-------------------------------------------------*/

/*-------------------------------------------*\
      File upload
\*-------------------------------------------*/
import * as JQuery from "jquery";
const $ = JQuery.default;
window.addEventListener("DOMContentLoaded", () => {
  /*-------------------------------------------*\
       Servlet invoking
\*-------------------------------------------*/
  let fileSuccesfullyUploadedAllAEM = [];
  setTimeout(function () {
    /*-------------------------------------------*\
       File Upload
\*-------------------------------------------*/

    let elemntFile = document.querySelectorAll(".filepond--browser");
    elemntFile.forEach((el) =>
      el.addEventListener("change", function (ev) {
        let url = window.location.href;
        let domain = new URL(url);
        let domainName = domain.origin;
        let formId = document.querySelector(".file-check-upload").id;
        const form = document.querySelector("#" + formId);
        let formDataFile = Object.fromEntries(new FormData(form).entries());
        let formType;
        let emailId = formDataFile.email;
        let firstName = formDataFile.firstname;
        let lastName = formDataFile.lastname;
        let currentPagePath = formDataFile.currentpage;
        let url1;

        if (document.querySelector(".file-check-upload").id == "contactform") {
          formType = "contactus";
          url1 =
            domainName +
            "/content/myproject/servicespath/fileupload.files.json?dir=" +
            formType +
            "&email=" +
            emailId +
            "&firstname=" +
            firstName +
            "&lastname=" +
            lastName +
            "&currentpagepath=" +
            currentPagePath;
        } else if (
          document.querySelector(".file-check-upload").id == "requestform"
        ) {
          formType = "raq";
          let projectName = formDataFile.projectname;
          let applicationType = formDataFile.applicationtype;
          let buildingType = formDataFile.buildingtype;
          let quantity = formDataFile.quantity;
          let uom = formDataFile.uom;
          let message = formDataFile.message;

          url1 =
            domainName +
            "/content/myproject/servicespath/fileupload.files.json?dir=" +
            formType +
            "&email=" +
            emailId +
            "&firstname=" +
            firstName +
            "&lastname=" +
            lastName +
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

        let inptFile = ev.target;
        let formData = new FormData();
        $.each(inptFile.files, function (i, file) {
          formData.append(file.name, file);
        });

        $.ajax({
          url: url1,
          type: "POST",
          data: formData,
          processData: false,
          contentType: false,
          cache: false,
          headers: {
            "X-XSS-Protection": "1; mode=block",
          },
          success: function (data) {
            var localJsonObj =
              typeof data == "string" ? JSON.parse(data) : data;
            fileSuccesfullyUploadedAllAEM.push(...localJsonObj);
            setTimeout(function () {
              removeFile(formType);
            }, 1000);
          },
        });
      })
    );

    /*-------------------------------------------*\
       File Delete
\*-------------------------------------------*/
  }, 1500);

  function removeFile(formType) {
    let fileRemoveElement = document.querySelectorAll(
      ".filepond--action-remove-item"
    );
    fileRemoveElement.forEach((el) =>
      el.addEventListener("click", function (ev) {
        let strRemoveFile = "";

        let fileName = el.parentElement.parentElement.firstChild.innerText;
        let singlefileArray = fileSuccesfullyUploadedAllAEM.filter(
          (x) => x.orgFileName == fileName
        );

        for (let i = 0; i < fileSuccesfullyUploadedAllAEM.length; i++) {
          if (fileName == fileSuccesfullyUploadedAllAEM[i].orgFileName) {
            fileSuccesfullyUploadedAllAEM.splice(i, 1);
          }
        }

        strRemoveFile = "fileName1=" + singlefileArray[0].fileName;

        $.ajax({
          url:
            "/content/myproject/servicespath/filedelete.files.json?dir=" +
            formType +
            "&" +
            strRemoveFile,
          type: "GET",
          processData: false,
          contentType: false,
          cache: false,
          headers: {
            "X-XSS-Protection": "1; mode=block",
          },
        });
      })
    );
  }
});
