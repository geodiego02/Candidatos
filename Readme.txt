Instrucciones:

1-Se debe crear una base de datos llamada candidatos.
2-Se debe ejecutar la aplicación spring boot con el comando mvn spring-boot:run
en la ruta en donde se encuentra almacenado el proyecto.
3-Se debe insertar los datos de prueba que dejé en el archivo data.sql ubicado en la ruta
src/main/resources
4-Abrir la página localhost:8080 para poder visualizar el proyecto.
5-El test de backend se puede ejecutar navegando a la carpeta src/test/java y tecleando 
el código mvn test en la linea de comandos. Se utilizó junit, mockito y spring test.
6-Para ejecutar la prueba unitaria de frontend se debe tener instalado node.js y npm, 
se debe navegar a la carpeta del proyecto y usar el código npx jest. Considerar tener instalado 
jest ya que esta realiza el test de una de las 3 funciones principales del javascript del front que es 
mostrarCandidatos.