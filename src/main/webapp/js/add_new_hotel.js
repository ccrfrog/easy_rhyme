




// 新增酒店表单校验
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



// 新增酒店->确认
function add_new_hotel() {
    // 参数校验
    var name = $("#inputHotelName").val();
    var address = $("#inputHotelAddress").val();
    var phone = $("#inputHotelPhone").val()
    
    // $.post 新增接口
    var url = "/qhotel_main/add.json";
    var arg = {
        hotelName:name,
        hotelAddress:address,
        city:null,
        hotelPhone:phone        
    };
   
    $.post(url, arg, function(data, status){
       console.log(data);
       // 只需输出data.data字段
       alert(data); 
    });

    cancel();
}



// 点取消时关闭modal对话框
function cancel() {
    $('#add_new_hotel_modal').modal('hide')
}







