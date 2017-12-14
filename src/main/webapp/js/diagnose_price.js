

$(document).ready(function(){
	console.log( "ready!" );
});



function reset() {
	$("#inputHotelSeqs").val('');
	$("#inputWrapperId").val('');
	$("#inputSite").val('');
	$("#inputCheckin").val('');
	$("#inputCheckout").val('');
}


// 诊断报价
function diagnose_price() {
	var hotel_seqs = $("#inputHotelSeqs").val();
	var wrapper_id = $("#inputWrapperId").val();
	var site = $("#inputSite").val();
	var checkin = $("#inputCheckin").val();
	var checkout = $("#inputCheckout").val();
	
	var arg = {
		hotel_seqs : hotel_seqs,
		wrapper_id : wrapper_id,
		site : site,
		checkin : checkin,
		checkout : checkout
	};
	
	var url = "/diagnose_price/do.json";
	
	$.post(url, arg, function(data){
	       $("#output").val('');
	       var r = eval("(" + data + ")");
	       var o = '';
	       for (var i = 0; i < r['list'].length ; i++) {
	    	   var obj = r['list'][i];
	    	   o += obj[0] + ',' + obj[1] + ',' + obj[2] + '\n';
	       }
	       $("#output").val(o);
	       
	}, "json");
	
	
}



