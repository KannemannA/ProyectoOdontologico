const menuAbrirCerrar = document.querySelectorAll(".menuHamburguesa");
const menuModal = document.querySelector("#menuModal");
menuAbrirCerrar.forEach(
    function(item){
        item.addEventListener("click",function(){
            menuModal.classList.toggle("hidden")
        })
    }
);
const formTurnos = document.querySelector("#FormTurnos");
const pacienteTurno = document.querySelector("#FTPaciente");
const odontologoTurno = document.querySelector("#FTOdontologo");

function capturarDatos(){
    const turno =document.querySelector("#datetime");
    const paqueteTurno={
        fechaHoraTTurno: turno.value,
        odontologoTNombre: odontologoTurno.value,
        pacienteTNombre: pacienteTurno.value
    }
    return paqueteTurno
}

function obtenerOdontologo(paqueteTurno){
    let nombre= paqueteTurno.odontologoTNombre
    fetch(`odontologos/buscarn_${nombre}`)
        .then(  response => {
            return response.json();
        })
        .then(  function(respuestaJSON) {
            console.log(respuestaJSON);
        })
}

/*formTurnos.addEventListener('submit', function(evento){
    evento.preventDefault();
    const paqueteTurno=capturarDatos();
    obtenerOdontologo(paqueteTurno);
})*/

odontologoTurno.addEventListener('input',function(e){
    const paqueteTurno=capturarDatos();
    obtenerOdontologo(paqueteTurno);
})

const formPacientes = document.querySelector("#FormPacientes");

formPacientes.addEventListener("submit", (event) => {
  event.preventDefault();
  guardarPaciente();
});

const guardarPaciente = async () => {
  const apellido = document.querySelector('#FPApellido').value;
  const nombre = document.querySelector('#FPNombre').value;
  const dni = document.querySelector('#FPDni').value;
  const direccion = document.querySelector('#FPDireccion').value;
  const localidad = document.querySelector('#FPLocalidad').value;
  const provincia = document.querySelector('#FPProvincia').value;
  const foto = document.querySelector('#FPFoto').files[0];

  const formData = new FormData();
  formData.append('apellido', apellido);
  formData.append('nombre', nombre);
  formData.append('dni', dni);
  formData.append('direccion', direccion);
  formData.append('localidad', localidad);
  formData.append('provincia', provincia);
  formData.append('imagen', foto);

  const response = await fetch('/pacientes/guardar', {
    method: 'POST',
    body: formData
  });

  if (response.ok) {
    console.log('Paciente creado exitosamente');
  } else {
    console.error('Error al crear paciente');
  }
};



