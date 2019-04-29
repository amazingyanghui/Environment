// JavaScript Document
function myResizeFn(){
	var swid = document.documentElement.clientWidth ;
	var shei = document.documentElement.clientHeight ;
	var topbgC = $('.head .topbg').width();
	$('.head .topbgL,.head .topbgR').width((swid-topbgC)/2);
	if((swid/shei)<3 && (swid/shei)>1.85){
		$('.bottomBox .talent .table tr td').css('padding','2.5%');
		$('.dateBox').css({'width':'80%','margin':'5% auto 0'});
		$('.street .dateBox').css({'width':'75%','margin':'12% auto 0'});
	}
}
$(function(){
	myResizeFn();
	window.onresize=myResizeFn;
})