async function savePerson(registrar) {
    //El fetch se usa para hacer petiones a servicios
    //Rest u otros
    let response = await fetch(URL_BASE + 'person/insertPerson', {
        method: 'POST',
        body: JSON.stringify(registrar),
        headers: {
            "Content-type": "application/json"
        }
    });
    let result = await response.json();
    if (result.id != '') {
        alert(result.message);
        return;
    }
    return result;
}

async function mostrarR() {
    //El fetch se usa para hacer petiones a servicios
    //Rest u otros
    let response = await fetch(URL_BASE + 'person/selectAll', {
        method: 'GET',
        headers: {
            "Content-type": "application/json"
        }
    });
    let result = await response.json();
    return result;
}

async function eliminar(registrar) {
    //El fetch se usa para hacer petiones a servicios
    //Rest u otros
    let response = await fetch(URL_BASE + 'person/delete', {
        method: 'POST',
        body: JSON.stringify(registrar),
        headers: {
            "Content-type": "application/json"
        }
    });
    let result = await response.json();
    if (result.id != '') {
        alert(result.message);
        return;
    }
    return result;
}

async function getById(idPersona) {
    //El fetch se usa para hacer petiones a servicios
    //Rest u otros
    let response = await fetch(URL_BASE + 'person/getById/' + idPersona, {
        method: 'GET',
        headers: {
            "Content-type": "application/json"
        }
    });
    let result = await response.json();
    if (result.id != '') {
        swal(result.message);
        return;
    }
    return result;
}