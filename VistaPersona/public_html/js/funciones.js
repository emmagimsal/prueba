$(function() {

    var TallerAvanzada = {};

    (function(app) {

        app.init = function() {

            app.buscarPersonas();
            app.oyentes();

        };

 


        app.buscarPersonas = function() {

            var url = "http://localhost:9001/api/v1/persona/"; //Esta es la web que usamos en postman (este es getAll()) -->

            $.ajax({ //Esta es la petición ASINCRONA AL SERVIDOR (INFO: https://openclassrooms.com/en/courses/4309491-simplifica-tus-proyectos-con-jquery/4981961-el-metodo-ajax)
                url: url,
                method: 'GET',
                dataType: 'json',
                success: function(data) { //Funcion en caso de exito
                     datoConvertido = JSON.stringify(data); //se pasan los registros de la BD || Convierte un objeto o valor de JavaScript a una cadena de texto JSON, opcionalmente reemplaza valores si se indica una función de reemplazo, o si se especifican las propiedades mediante un array de reemplazo.
                     alert(datoConvertido);
                     app.rellenarTabla(datoConvertido);
                },
                error: function() {
                    alert('error');
                }

            });
        };

        app.rellenarTabla = function(datoConvertido) {
             alert(datoConvertido);
             datoParseado= JSON.parse(datoConvertido); //conversión al formato json. || El método JSON.parse() recibe una cadena JSON y en base a esta cadena construye un objeto JavaScript.
            var linea = "";

            $.each(datoParseado, function(clave, persona) { //for each p/recorrer cada elemento (donde se muestra: clave-valor)
               linea+=  '<tr>' + //fila vacía                //con el + despues de linea concateno cada fila
                        '<td>' + persona.nombre + '</td>' +
                        '<td>' + persona.apellido + '</td>' +
                        '<td>' + persona.dni + '</td>' +
                        '<td>' +
                        '<a class="pull-left editar" data-id_persona="' + persona.id + '"><span class="glyphicon glyphicon-pencil"></span>Editar</a>' + //el tag <a> es una llamada a un elemento, en este caso, la clase pull--- Con esto escondo el id de persona (escondido, pero se encuentra en metadata, o sea es metadata)
                        '<a class="pull-right eliminar" data-id_persona="' + persona.id + '"><span class="glyphicon glyphicon-remove"></span>Eliminar</a>' +
                        '</td>' +
                        '</tr>';
            });

            $("#cuerpoTabla").html(linea); //esta es la llamada que hacemos en el body, y con el metodo html LO INCRUSTAMOS en el body (o sea, carga en el body este código y se ejecuta).
        };





        app.init();

    })(TallerAvanzada);


})();
