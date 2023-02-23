async function guardar(){
    try{
        let registrar = new personaDto();
        let idPersona = document.getElementById('idPersona').value;
        let nombre1 = document.getElementById('nombre1').value;
        let nombre2 = document.getElementById('nombre2').value;
        let apellido1 = document.getElementById('apellido1').value;
        let apellido2 = document.getElementById('apellido2').value;
        let tipoDocumento = document.getElementById('tipoDocumento').value;
        let numDocumento = document.getElementById('numDocumento').value;
        let sexo = document.getElementById('sexo').value;
        let email = document.getElementById('email').value;
        let numTelefono = document.getElementById('numTelefono').value;
        let estadoCivil = document.getElementById('estadoCivil').value;
        let profesion = document.getElementById('profesion').value;
        let fechaNacimiento = document.getElementById('fechaNacimiento').value;
        let salario = document.getElementById('salario').value;

        console.log(idPersona)
        registrar.setIdPersona(idPersona);
        registrar.setNombre1(nombre1);
        registrar.setNombre2(nombre2);
        registrar.setApellido1(apellido1);
        registrar.setApellido2(apellido2);
        registrar.setTipoDocumento(tipoDocumento);
        registrar.setNumDocumento(numDocumento);
        registrar.setSexo(sexo);
        registrar.setEmail(email);
        registrar.setNumTelefono(numTelefono);
        registrar.setEstadoCivil(estadoCivil);
        registrar.setProfesion(profesion);
        registrar.setFechaNacimiento(fechaNacimiento);
        registrar.setSalario(salario);

        var result = await savePerson(registrar)


    }catch(error){
        console.log(error);

    }
}
async function mostrar(){
    try{
        var result = await mostrarR();
        addrecord(result.data)
        console.log(result);

    }catch(error){
        console.log(error);
    }
}
async function eliminarP(idPersona){
    try{
        let registrar = new personaDto();
        registrar.setIdPersona(idPersona)
        var result = await eliminar(registrar)
        var result = await mostrar()
        addrecord(result.data)
    }catch(error){
        console.log(error)
    }

}