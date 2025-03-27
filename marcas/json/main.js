const apiUrl = 'https://pokeapi.co/api/v2/pokemon?limit=150';
let allPokemon = [];
let currentPage = 1;
const itemsPerPage = 15;

// Función para obtener la lista de Pokémon (Esto es un fetch normal, se suele usar para recuperar archivos JSON desde una API)
async function fetchPokemonList() {
  try {
    const response = await fetch(apiUrl);
    const data = await response.json();
    return data.results;
  } catch (error) {
    console.error('Error al obtener la lista de Pokémon:', error);
  }
}

// Función para obtener los detalles de cada Pokémon
async function fetchPokemonDetails(url) {
  try {
    const response = await fetch(url);
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Error al obtener detalles del Pokémon:', error);
  }
}

// Carga y formatea la información de los Pokémon
async function loadPokemon() {
  const pokemonList = await fetchPokemonList();
  const promises = pokemonList.map(pokemon => fetchPokemonDetails(pokemon.url)); //Esto va metiendo datos uno tras otro, como una array de objetos.
  const details = await Promise.all(promises); //Las promesas son algo que veréis más adelante, pero se usan mucho en JS con su asincronía.
  
  //Cada vez que veais un map, contad con que funciona igual que un foreach. Se acceden a los atributos de cada pokemon parecido con un ".".
  //Funciona parecido a las estructuras de C.
  allPokemon = details.map(p => ({
    id: p.id,
    name: p.name,
    type: p.types.map(t => t.type.name).join(', '),
    ability: p.abilities.length > 0 ? p.abilities[0].ability.name : 'N/A',
    image: p.sprites.front_default
  }));
  
  renderTable();
  renderPagination();
}

// Renderiza la tabla con la información de la página actual
function renderTable() {
  const tableBody = document.querySelector('#pokemon-table tbody');
  tableBody.innerHTML = '';

  // He usado slice para ir partiendo de 15 en 15 los pokemon que se ven. 
  // Solo se cargan dependiendo de la currentPage. Y sabemos que saltan de 15 en 15 gracias a multiplicarlos por itemsPerPage
  const start = (currentPage - 1) * itemsPerPage;
  const end = start + itemsPerPage;
  const paginatedPokemon = allPokemon.slice(start, end);
  
  paginatedPokemon.forEach(pokemon => {
    const tr = document.createElement('tr');
    
    // Columna del número (ID)
    const tdNumber = document.createElement('td');
    tdNumber.textContent = pokemon.id;
    tr.appendChild(tdNumber);
    
    // Columna de la imagen
    const tdImage = document.createElement('td');
    if (pokemon.image) {
      const img = document.createElement('img');
      img.src = pokemon.image;
      img.alt = pokemon.name;
      tdImage.appendChild(img);
    } else {
      tdImage.textContent = 'N/A';
    }
    tr.appendChild(tdImage);
    
    // Columna del nombre
    const tdName = document.createElement('td');
    tdName.textContent = pokemon.name;
    tr.appendChild(tdName);
    
    // Columna del tipo
    const tdType = document.createElement('td');
    tdType.textContent = pokemon.type;
    tr.appendChild(tdType);
    
    // Columna de la habilidad
    const tdAbility = document.createElement('td');
    tdAbility.textContent = pokemon.ability;
    tr.appendChild(tdAbility);
    
    tableBody.appendChild(tr);
  });
}

// Crea la paginación y añade el listener para cambiar de página
function renderPagination() {
  const paginationContainer = document.getElementById('pagination');
  paginationContainer.innerHTML = '';
  
  const totalPages = Math.ceil(allPokemon.length / itemsPerPage);
  
  //La gracia de esto es que se pueden añadir atributos a los elementos que necesitas. 
  for (let i = 1; i <= totalPages; i++) {
    const btn = document.createElement('button');
    btn.textContent = i;
    btn.classList.add('pagination-btn');
    if (i === currentPage) {
      btn.classList.add('active');
    }
    btn.addEventListener('click', () => {
      currentPage = i;
      renderTable();
      renderPagination();
    });
    paginationContainer.appendChild(btn);
  }
}

//Esto no es del todo buena práctica, pero para lo que vamos a hacer, sirve.
document.addEventListener('DOMContentLoaded', loadPokemon);
