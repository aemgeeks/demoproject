/*-------------------------------------------------*\
   Javascript sheet for the All Forms change in country and state
   
   Table of Contents
   If you conduct a Search on the page, type in the 
   section below that you would like to jump to.

   - Javscript dropdown for changing the Country and state
   
\*-------------------------------------------------*/
/*-------------------------------------------*\
  Javscript dropdown for changing the Country and state
\*-------------------------------------------*/

let stateCountries;
window.addEventListener("DOMContentLoaded", () => {
  let stateCountryData;
  let stateCountryDatas = document.querySelector(".stateCountryData");
  if (stateCountryDatas)
    stateCountryData = document.querySelector(".stateCountryData").dataset.api;

  function countryPopulate(results) {
    let select = document.querySelector(".country-selector-tag");

    let options = results
      .map((result) => `<option>${result}</option>`)
      .join("\n");
    select.insertAdjacentHTML("beforeend", options);

    if (document.getElementsByClassName("country-selector-tag-2").length) {
      let select1 = document.querySelector(".country-selector-tag-2");
      let options1 = results
        .map((result) => `<option>${result}</option>`)
        .join("\n");
      select1.insertAdjacentHTML("beforeend", options1);
    }
  }

  window.countryChange = () => {
    let countryElement = document.querySelector(".country-selector-tag");
    let stateElement = document.querySelector(".state-selector-tag");

    let listOfState = [];
    let selectedState;
    let currentCountry =
      countryElement.options[countryElement.selectedIndex].value;
    let item = stateCountries.countries.find(
      (item) => item.name === currentCountry
    );

    for (let i = 0; i < stateCountries.states.length; i++) {
      if (item.id == stateCountries.states[i].country_id) {
        listOfState.push(stateCountries.states[i]);
      }
    }

    for (let i = 0; i < stateElement.length; i++) {
      if (stateElement.options[i].selected === true) {
        selectedState = stateElement.options[i].value;
      }
    }
    stateElement.options.length = 0;
    for (let i = 0; i < listOfState.length; i++) {
      stateElement.options[i] = new Option(listOfState[i].name);
      if (listOfState[i] == selectedState) {
        stateElement.options[i].selected = true;
      }
    }
  };

  window.countryChangeForm = () => {
    let countryElement = document.querySelector(".country-selector-tag-2");
    let stateElement = document.querySelector(".state-selector-tag-2");

    let listOfState1 = [];
    let selectedState;
    let currentCountry =
      countryElement.options[countryElement.selectedIndex].value;
    let item = stateCountries.countries.find(
      (item) => item.name === currentCountry
    );

    for (let i = 0; i < stateCountries.states.length; i++) {
      if (item.id == stateCountries.states[i].country_id) {
        listOfState1.push(stateCountries.states[i]);
      }
    }

    for (let i = 0; i < stateElement.length; i++) {
      if (stateElement.options[i].selected === true) {
        selectedState = stateElement.options[i].value;
      }
    }
    stateElement.options.length = 0;
    for (let i = 0; i < listOfState1.length; i++) {
      stateElement.options[i] = new Option(listOfState1[i].name);
      if (listOfState1[i] == selectedState) {
        stateElement.options[i].selected = true;
      }
    }
  };

  const STANDARD_HEADERS = {
    "Content-Type": "application/json",
    "X-XSS-Protection": "1; mode=block",
    "X-Frame-Options": "directive",
    "X-Content-Type-Options": "nosniff",
    "Content-Security-Policy": "default-src 'self'",
    "Referrer-Policy": "no-referrer",
  };

  if (stateCountryData != null && stateCountryData != undefined) {
    fetch(stateCountryData, {
      headers: STANDARD_HEADERS,
      method: "GET",
      redirect: "follow",
    })
      .then((response) => response.json())
      .then((data) => {
        let countriesArray = [];
        stateCountries = JSON.parse(data.jsonvalue);
        for (let index = 0; index < stateCountries.countries.length; index++) {
          let countries = stateCountries.countries[index].name;
          countriesArray.push(countries);
        }
        countryPopulate(countriesArray);
      })
      .catch((error) => error);
  }
});
