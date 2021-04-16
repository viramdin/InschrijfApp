let scholen;
let distrikten;
let niveaus;
let isUpdate;

populateScholenTabel();

setTimeout(function() {
    populateDistriktSelect();
}, 250);

setTimeout(function() {
    populateNiveauSelect();
}, 500)



function populateDistriktSelect() {
    const DISTRIKT_URL_LIST = "api/district/getAll";
    let distriktSelect = document.getElementById("distrikt");
    distriktSelect.options.length = 0;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText) {
                // handle response here
                distrikten = JSON.parse(this.responseText);

                distrikten.forEach(item => {
                    //                    console.log(item);
                    var option = document.createElement("option");
                    option.value = item.districtId;
                    option.text = item.naam;
                    distriktSelect.add(option);
                });

            } else {
                alert("Something went wrong retrieving the data");
            }
        }
    };
    xhttp.open("GET", DISTRIKT_URL_LIST, true);
    xhttp.send();
}



function populateNiveauSelect() {
    const NIVEAU_URL_LIST = "api/niveau/getAll";
    let niveauSelect = document.getElementById("niveau");
    niveauSelect.options.length = 0;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText) {
                // handle response here
                niveaus = JSON.parse(this.responseText);

                niveaus.forEach(item => {
                    //                    console.log(item);
                    var option = document.createElement("option");
                    option.value = item.niveauId;
                    option.text = item.naam;
                    niveauSelect.add(option);
                });
            } else {
                alert("Something went wrong retrieving the data");
            }
        }
    };
    xhttp.open("GET", NIVEAU_URL_LIST, true);
    xhttp.send();
}



function populateScholenTabel() {
    const SCHOOL_URL_LIST = "api/school/getAll";

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText) {
                // handle response here
                scholen = JSON.parse(this.responseText);

                scholen.forEach(item => {
                    //                    console.log(item);
                    const html =
                        `
                              <tr>
                                  <td>${item.naam}</td>
                                  <td>${item.adres}</td>
                                  <td>${item.district.naam}</td>
                                  <td>${item.omschrijving}</td>
                                  <td>${item.schoolNiveau.naam}</td>
                                  <td>SRD ${item.schoolNiveau.prijs}</td>
                                  <td>
                                      <button class="btn btn-warning" id="btnEdit" onclick="addOrEdit(${item.schoolId})"><i class="fas fa-pencil-alt"></i></button>
                                  </td>
                              </tr>
                          `;
                    document.getElementById("scholenTbody").innerHTML += html;

                });
            } else {
                alert("Something went wrong retrieving the data");
            }
        }
    };
    xhttp.open("GET", SCHOOL_URL_LIST, true);
    xhttp.send();
}



function addOrEdit(schoolId) {
    if (schoolId !== undefined) {
        isUpdate = true;
        scholen.forEach(item => {
            if (item.schoolId == schoolId) {
                document.getElementById("schoolId").value = schoolId;
                document.getElementById("naam").value = item.naam;
                document.getElementById("adres").value = item.adres;
                document.getElementById("distrikt").value = item.district.districtId;
                document.getElementById("omschrijving").innerHTML = item.omschrijving;
                document.getElementById("niveau").value = item.schoolNiveau.niveauId;
                document.getElementById("prijs").value = "SRD " + item.schoolNiveau.prijs;
            }
        });
    } else {
        isUpdate = false;
        document.getElementById("schoolId").value = "";
        document.getElementById("naam").value = "";
        document.getElementById("adres").value = "";
        document.getElementById("distrikt").value = "";
        document.getElementById("omschrijving").innerHTML = "";
        document.getElementById("niveau").value = "";
        document.getElementById("prijs").value = "";
    }
    openModal();
}



var form = document.getElementById('schoolForm');

form.addEventListener('submit', function(e) {
    const SCHOOL_URL_INSERT = "api/school/insert";
    const SCHOOL_URL_UPDATE = "api/school/update";
    e.preventDefault();
    if (isUpdate) {

        let schoolUpdate = {
            schoolId: parseInt(document.getElementById('schoolId').value),
            naam: document.getElementById('naam').value,
            adres: document.getElementById('adres').value,
            district: { districtId: parseInt(document.getElementById('distrikt').value) },
            omschrijving: document.getElementById('omschrijving').value,
            schoolNiveau: { niveauId: parseInt(document.getElementById('niveau').value) }
        }
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                alert(this.responseText);
                location.reload();
            }
        };
        xhttp.open("POST", SCHOOL_URL_UPDATE, true);
        xhttp.setRequestHeader("Content-Type", "application/json");
        xhttp.send(JSON.stringify(schoolUpdate));

    } else {

        let schoolInsert = {
            schoolId: parseInt(document.getElementById('schoolId').value),
            naam: document.getElementById('naam').value,
            adres: document.getElementById('adres').value,
            district: { districtId: parseInt(document.getElementById('distrikt').value) },
            omschrijving: document.getElementById('omschrijving').value,
            schoolNiveau: { niveauId: parseInt(document.getElementById('niveau').value) }
        }
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                alert(this.responseText);
                location.reload();
            }
        };
        xhttp.open("POST", SCHOOL_URL_INSERT, true);
        xhttp.setRequestHeader("Content-Type", "application/json");
        xhttp.send(JSON.stringify(schoolInsert));

    }
});



function openModal() {
    var modal = document.getElementById("myModal");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks on the button, open the modal
    //btn.onclick = function() {
    modal.style.display = "block";
    //}

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}



function changePrice(){
    let niveauSelect = document.getElementById("niveau");
    let niveauId = niveauSelect.value;
    niveaus.forEach(item => {
        if (item.niveauId == niveauId) {
            document.getElementById("prijs").value = "SRD " + item.prijs;
        }
    });
}