document.addEventListener('DOMContentLoaded', function () {
    cargarCandidatos(0);
});

function cargarCandidatos(pagina) {
    fetch(`http://localhost:8080/api/candidatos?page=${pagina}&size=6`)
        .then(response => response.json())
        .then(data => {
            mostrarCandidatos(data.content);
            configurarPaginacion(data.totalPages, pagina);
        });
}

function mostrarCandidatos(candidatos) {
    const tbody = document.getElementById('candidatos-table-body');
    tbody.innerHTML = '';
    candidatos.forEach(candidato => {
        tbody.innerHTML += `
            <tr>
                <td>${candidato.id}</td>
                <td>${candidato.email}</td>
                <td>${candidato.name}</td>
                <td>${candidato.surname}</td>
            </tr>
        `;
    });
}

function configurarPaginacion(totalPaginas, paginaActual) {
    const paginacion = document.getElementById('pagination');
    paginacion.innerHTML = '';
    for (let i = 0; i < totalPaginas; i++) {
        paginacion.innerHTML += `
            <li class="page-item ${i === paginaActual ? 'active' : ''}">
                <a class="page-link" href="#" onclick="cargarCandidatos(${i})">${i + 1}</a>
            </li>
        `;
    }
}
