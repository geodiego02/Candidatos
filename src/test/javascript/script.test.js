// script.test.js
const { mostrarCandidatos } = require('./script');

// Jest proporciona un documento global por defecto, pero aquí está por claridad
document.body.innerHTML = `
  <table class="table">
    <tbody id="candidatos-table-body"></tbody>
  </table>
`;

test('debe llenar el cuerpo de la tabla con candidatos', () => {
  const candidatosMock = [
    { id: 1, email: 'juan.perez@email.com', name: 'Juan', surname: 'Perez' },
    // ...otros candidatos
  ];

  mostrarCandidatos(candidatosMock);

  const tbody = document.getElementById('candidatos-table-body');
  expect(tbody.children.length).toBe(candidatosMock.length);
});
