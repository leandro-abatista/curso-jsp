/**
 * 
 */

$('.cadastros').click(function(){
	$('.menulateral ul .itensCadastros').toggleClass('mostra');
});

$('.sair').click(function(){
	$('.menulateral ul .itenSair').toggleClass('mostra');
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
$('.cadastros').click(function(){
	$('.menulateral ul .seta1').toggleClass('gira');
});

$('.sair').click(function(){
	$('.menulateral ul .seta7').toggleClass('gira');
});

/**
 * esse bloco executa a ação de fechar o menu, após clicar em qualquer parte da página
 */
const $menulateral = $('.menulateral');
$(document).mouseup(e => {
	if (!$menulateral.is(e.target)
			&& $menulateral.has(e.target).length === 0
	) {
		$menulateral.removeClass('mostra');
	}
});







