

const inputJson = document.getElementById("Json");
const divMascotas = document.getElementById("Mascotas")

function leerJson() {

    const fileReader = new FileReader()

    function miOnLoad(){
        const json = JSON.parse(fileReader.result);
        crearTarjetas(json)
    }

    fileReader.readAsText(inputJson.files[0])

    fileReader.onload = miOnLoad;
 
}
function crearTarjetas(mascotas) {
    let html= '';
    for(const mascota of mascotas){

       html += crearTarjeta(mascota)

    }

    divMascotas.innerHTML = html
    
}

function crearTarjeta(mascota) {
    let html = `
    <div class="card" style="width: 18rem;">
                  <input type="file" id="Json">
                       <img src="..." class="card-img-top" alt="...">
                       <div class="card-body">
                         <h5 class="card-title">${mascota.nombre}</h5>
                         <p class="card-text">${mascota.edad}</p>
                         <a href="#" class="btn btn-primary">Go somewhere</a>
                       </div>
                  
                   <ul class="list-group list-group-flush">
                     <li class="list-group-item">An item</li>
                     <li class="list-group-item">A second item</li>
                     <li class="list-group-item">A third item</li>
                   </ul>
                   <div class="card-body">
                   <a href="#" class="card-link">Tarjeta 1</a>
                   <a href="#" class="card-link">Tarjeta 2</a>
                   </div>
                 </div>`
      return html;
}
inputJson.addEventListener('change',leerJson );
