/**
 * validar el formulario de inicio
 */

$(function() {


});

function valida(){
		valido = false;
		$('.etiquetas input').each(function(i,val) {
		console.log(val)
			if (val.checked)
			{
				
				valido = true;
			}
		}
		)

		if (valido)
			return true;
		else
			alert("Debe introducir al menos una etiqueta")
		return false;
	}


