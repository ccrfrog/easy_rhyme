




// �����Ƶ��У��
function add_new_hotel_form_validate(f) {
    console.log(f)
    console.log(f.id)
    var r = {};
    if (f.id === "inputHotelName") {
       // r = check_inputHotelName(f.val()) 
        console.log( $("#inputHotelName") ) 
    } else if (f.id === 'inputHotelAddress') {
    
    } else {
    }
}



// �����Ƶ�->ȷ��
function add_new_hotel() {
    // ����У��
    var name = $("#inputHotelName").val();
    var address = $("#inputHotelAddress").val();
    var phone = $("#inputHotelPhone").val()
    
    // $.post �����ӿ�
    var url = "/qhotel_main/add.json";
    var arg = {
        hotelName:name,
        hotelAddress:address,
        city:null,
        hotelPhone:phone        
    };
   
    $.post(url, arg, function(data, status){
       console.log(data);
       // ֻ�����data.data�ֶ�
       alert(data); 
    });

    cancel();
}



// ��ȡ��ʱ�ر�modal�Ի���
function cancel() {
    $('#add_new_hotel_modal').modal('hide')
}







