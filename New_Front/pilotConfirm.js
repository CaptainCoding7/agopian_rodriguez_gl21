function postServerData(url, data, success){

    $.ajax({
		type: 'POST',	
        url: url,
		data: data,
		contentType : 'application/json',
        dataType: "json"
    }).done(success);
}

function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function confirmCalldone(result){

    localStorage.removeItem("confirmAsked");
}

function callDoneBookingInfo(result){


    var confirm_section = document.getElementById("confirm_section");

    var message = document.createElement("p");
    message.innerHTML = "Accept the booking ? An email will be send to the passenger to warn him about your choice.";
    confirm_section.appendChild(message);

    var accBut = document.createElement("button");   
    accBut.innerHTML="Accepter"
    accBut.onclick=function(){
        console.log(bookingId);
        postServerData("ws/booking/accept/" + bookingId, confirmCalldone);
        localStorage.removeItem('confirmAsked');
        document.location.href = "home.html";                                                                                                                                                            
    };
    confirm_section.appendChild(accBut);

    var refBut = document.createElement("button");   
    refBut.innerHTML="Refuser";

    refBut.onclick=function(){
        console.log(bookingId);
        postServerData("ws/booking/refuse/" + bookingId, confirmCalldone);
        localStorage.removeItem('confirmAsked');
        document.location.href = "home.html";                                                                                                                                                            
    };
    confirm_section.appendChild(refBut);

}


function logOut(){
	
	console.log("logout");
	localStorage.removeItem('userID');    
	localStorage.removeItem('isApilot');    
	document.location.href = "home.html";                                                                                                                                                            

}

function $_GET(param) {
	var vars = {};
	window.location.href.replace( location.hash, '' ).replace( 
		/[?&]+([^=&]+)=?([^&]*)?/gi, // regexp
		function( m, key, value ) { // callback
			vars[key] = value !== undefined ? value : '';
		}
	);

	if ( param ) {
		return vars[param] ? vars[param] : null;	
	}
	return vars;
}

var bookingId = $_GET('bookingId');
localStorage.setItem('bookingId', bookingId);
console.log(bookingId)


if(localStorage.getItem('userID')==null){

    localStorage.setItem('confirmAsked', true);
    document.location.href = "Log-in.html";                                                                                                                                                            

}
else{

    getServerData("ws/booking/bookingInfo/" + bookingId, callDoneBookingInfo);

}


