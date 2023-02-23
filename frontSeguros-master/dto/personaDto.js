class personaDto{

    constructor(idPersona, nombre1, nombre2, apellido1, apellido2, tipoDocumento, numDocumento,
        sexo, email, numTelefono, profesion, estadoCivil, fechaNacimiento, salario){

            this.idPersona =idPersona;
            this.nombre1 = nombre1;
            this.nombre2 = nombre2;
            this.apellido1 = apellido1;
            this.apellido2 = apellido2;
            this.tipoDocumento = tipoDocumento;
            this.numDocumento = numDocumento;
            this.sexo = sexo;
            this.email = email;
            this.numTelefono = numTelefono;
            this.profesion = profesion;
            this.estadoCivil = estadoCivil;
            this.fechaNacimiento = fechaNacimiento;
            this.salario


    }
    setIdPersona(idPersona){
        this.idPersona = idPersona;

    }
    getIdPersona(){
        return this.idPersona;
    }
    setNombre1(nombre1){
        this.nombre1 = nombre1;

    }
    getNombre1(){
        return this.nombre1;
    }
    setNombre2(nombre2){
        this.nombre2 = nombre2;

    }
    getNombre2(){
        return this.nombre2;
    }
    setApellido1(apellido1){
        this.apellido1 = apellido1;

    }
    getApellido1(){
        return this.apellido1;
    }
    setApellido2(apellido2){
        this.apellido2 = apellido2;

    }
    getApellido2(){
        return this.apellido2;
    }
    setTipoDocumento(tipoDocumento){
        this.tipoDocumento = tipoDocumento;

    }
    getTipoDocumento(){
        return this.tipoDocumento;
    }
    setNumDocumento(numDocumento){
        this.numDocumento = numDocumento;

    }
    getNumDocumento(){
        return this.numDocumento;
    }
    setSexo(sexo){
        this.sexo = sexo;

    }
    getSexo(){
        return this.sexo;
    }
    setEmail(email){
        this.email = email;

    }
    getEmail(){
        return this.email;
    }
    setNumTelefono(numTelefono){
        this.numTelefono = numTelefono;
    }
    getNumTelefono(numTelefono){
        return this.numTelefono;
    }
    
    setEstadoCivil(estadoCivil){
        this.estadoCivil = estadoCivil;
    }
    getEstadoCivil(estadoCivil){
        return this.estadoCivil;
    }
    setProfesion(profesion){
        this.profesion = profesion;
    }
    getProfesion(profesion){
        return profesion;
    }
    
    setFechaNacimiento(fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
    getFechaNacimiento(fechaNacimiento){
        return fechaNacimiento;
    }
    setSalario(salario){
        this.salario = salario;
    }
    getSalario(salario){
        return salario;
    }
   
   

}