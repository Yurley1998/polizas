function addrecord(listRecord){
    let bodyTable = document.getElementById('body_tablePerson');
    bodyTable.innerText = '';
    listRecord.forEach(element => {        
        let fila = document.createElement('tr');

        let idPersona = document.createElement('td');
        idPersona.innerText = element.idPersona;
        fila.appendChild(idPersona);

        let nombre1 = document.createElement('td');
        nombre1.innerText = element.nombre1;
        fila.appendChild(nombre1);

        let nombre2 = document.createElement('td');
        nombre2.innerText = element.nombre2;
        fila.appendChild(nombre2);

        let apellido1 = document.createElement('td');
        apellido1.innerText = element.apellido1;
        fila.appendChild(apellido1); 
        
        let apellido2 = document.createElement('td');
        apellido2.innerText = element.apellido2;
        fila.appendChild(apellido2);

        let numDocumento = document.createElement('td');
        numDocumento.innerText = element.numDocumento;
        fila.appendChild(numDocumento);
        
        let salario = document.createElement('td');
        salario.innerText = element.salario;
        fila.appendChild(salario);

        let profesion = document.createElement('td');
        profesion.innerText = element.profesion;
        fila.appendChild(profesion);
        

        let acctions = document.createElement('td');
        acctions.appendChild(addacctions(element));
        fila.appendChild(acctions);

        bodyTable.appendChild(fila);        
    });
}


function addacctions(element) {
    let div = document.createElement('div');
    div.setAttribute('class', 'actions');

    let button1 = document.createElement('button');
    button1.setAttribute('class', 'eye');
    let icon1 = document.createElement('i');
    icon1.setAttribute('class', 'fa-solid fa-eye');

    button1.appendChild(icon1);

    let button2 = document.createElement('button');
    button2.setAttribute('class', 'edit');
    let icon2 = document.createElement('i');
    icon2.setAttribute('class', 'fa-solid fa-pen-to-square');
    
    button2.appendChild(icon2);

    let button3 = document.createElement('button');
    button3.setAttribute('class', 'delete');
    let icon3 = document.createElement('i');
    icon3.setAttribute('class', 'fa-solid fa-trash');
    
    button3.appendChild(icon3);
    button3.setAttribute("onClick", "eliminarP('"+ element.idPersona +"')");

    div.appendChild(button1);
    div.appendChild(button2);
    div.appendChild(button3);
    return div;
}
