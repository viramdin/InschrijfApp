let inschrijvingen;
let scholen;

populateInschrijvingenTabel();

setTimeout(function() {
    populateScholenSelect();
}, 250);



function populateScholenSelect() {
    const SCHOOL_URL_LIST = "api/school/getAll";
    let schoolSelect = document.getElementById("school");
    schoolSelect.options.length = 0;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText) {
                // handle response here
                scholen = JSON.parse(this.responseText);

                scholen.forEach(item => {
                    //                    console.log(item);
                    var option = document.createElement("option");
                    option.value = item.schoolId;
                    option.text = item.naam;
                    schoolSelect.add(option);
                });

            } else {
                alert("Something went wrong retrieving the data");
            }
        }
    };
    xhttp.open("GET", SCHOOL_URL_LIST, true);
    xhttp.send();
}



function populateInschrijvingenTabel() {
    const INSCHRIJVING_URL_LIST = "api/inschrijving/getAll";

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText) {
                // handle response here
                inschrijvingen = JSON.parse(this.responseText);

                inschrijvingen.forEach(item => {
                    //                                        console.log(item);
                    const html =
                        `
                              <tr>
                                  <td>${item.school.naam}</td>
                                  <td>${item.gegevens.familienaam}</td>
                                  <td>${item.gegevens.naam}</td>
                                  <td>${item.createdDate.dayOfMonth}-${item.createdDate.monthValue}-${item.createdDate.year}</td>
                                  <td>
                                      <button class="btn btn-success" id="btnEdit" onclick="addOrEdit(${item.inschrijvingId})"><i class="fas fa-eye"></i></button>
                                  </td>
                                  <td>
                                      <button class="btn btn-danger" id="btnDelete" onclick="deleteInschrijving(${item.inschrijvingId})"><i class="fas fa-trash"></i></button>
                                  </td>
                              </tr>
                          `;
                    document.getElementById("inschrijvingenTbody").innerHTML += html;

                });
            } else {
                alert("Something went wrong retrieving the data");
            }
        }
    };
    xhttp.open("GET", INSCHRIJVING_URL_LIST, true);
    xhttp.send();
}



function addOrEdit(inschrijvingId) {
    if (inschrijvingId !== undefined) {
        inschrijvingen.forEach(item => {
            if (item.inschrijvingId == inschrijvingId) {
                document.getElementById("inschrijvingId").value = inschrijvingId;
                document.getElementById("school").value = item.school.schoolId;
                document.getElementById("familienaam").value = item.gegevens.familienaam;
                document.getElementById("voornaam").value = item.gegevens.naam;
                document.getElementById("dob").value = new Date(item.gegevens.dob.year + "-" + item.gegevens.dob.monthValue + "-" + item.gegevens.dob.dayOfMonth);
                document.getElementById("idNummer").value = item.gegevens.idNummer;
                document.getElementById("geslacht").value = item.gegevens.geslacht;
                document.getElementById("telefoon").value = item.gegevens.telefoonNr;
                document.getElementById("email").value = item.gegevens.email;
                document.getElementById("divRadio").style.display = "none";
                document.getElementById("btnSave").style.display = "none";
            }
        });
    } else {
        document.getElementById("inschrijvingId").value = "";
        document.getElementById("school").value = "";
        document.getElementById("familienaam").value = "";
        document.getElementById("voornaam").value = "";
        document.getElementById("dob").value = "";
        document.getElementById("idNummer").value = "";
        document.getElementById("geslacht").value = "";
        document.getElementById("telefoon").value = "";
        document.getElementById("email").value = "";
        document.getElementById("divRadio").style.display = "block";
        document.getElementById("btnSave").style.display = "block";
    }
    openModal();
}



function deleteInschrijving(inschrijvingId){
    const INSCHRIJVING_URL_DELETE = "api/inschrijving/delete";
    let dialogBox = confirm(`Ben je zeker dat je de geselecteerde item wilt verwijderen?`);
        if (dialogBox) {
            let xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (xhttp.readyState == 4 && xhttp.status == 200) {
                        alert(this.responseText);
                        location.reload();
                }
            };
            xhttp.open("DELETE", INSCHRIJVING_URL_DELETE, true);
            xhttp.setRequestHeader("Content-Type", "application/json");
            xhttp.send(JSON.stringify(inschrijvingId));
        }
}



var form = document.getElementById('inschrijvingForm');

form.addEventListener('submit', function(e) {
    const INSCHRIJVING_URL_INSERT = "api/inschrijving/insert";
    e.preventDefault();
    let inschrijvingInsert = {
        schoolId: parseInt(document.getElementById('school').value),
        gegevens: {
            familienaam: document.getElementById('familienaam').value,
            naam: document.getElementById('voornaam').value,
            dob: new Date(document.getElementById('dob').value).toJSON(),
            idNummer: document.getElementById('idNummer').value,
            geslacht: document.getElementById('geslacht').value,
            telefoonNr: document.getElementById('telefoon').value,
            email: document.getElementById('email').value
        },
        kosten: parseInt(document.querySelector('input[name = additioneleKosten]:checked').value),
        betalingMethode: parseInt(document.querySelector('input[name = betalingMethode]:checked').value)
    }
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            alert(this.responseText);
            location.reload();
        }
    };
    xhttp.open("POST", INSCHRIJVING_URL_INSERT, true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(inschrijvingInsert));
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