/**
 * 
 */

$('.cad').click(function(){
	$('.menulateral ul .itens').toggleClass('mostra');
});


/*
 * 
 * abrindo o menu lateral*/

$('.btnAbre').click(function(){
	$('.menulateral').toggleClass('mostra');
});

/**
 * fechando o menu lateral
 * @returns
 */

$('.btnFecha').click(function(){
	$('.menulateral').toggleClass('mostra');
});

/**
 * apos clicar, vira a seta 90 graus
 * @returns
 */
$('.cad').click(function(){
	$('.menulateral ul .seta1').toggleClass('gira');
})


const $menulateral = $('.menulateral');
$(document).mouseup(e => {
	if (!$menulateral.is(e.target)
			&& $menulateral.has(e.target).length === 0
	) {
		$menulateral.removeClass('mostra');
	}
});





