$(document).ready(function() {
	

$("#submitButton").click(function(){
	var id = $("#id").val();
	var message = $("#message").val();
	var data = {
			id:id,
			message:message
			};
	$.ajax({
		url:"/Lab4/create",
		method:"POST",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType: "json",
		data: data,
		success: function(data,status,xhr){
			$("#helloHeader").html("Success");
			},
		error: function(data,status,xhr){
			$("#helloHeader").html("Error:" +status);
		},	
	});	
});

$("#getMessage").click(function(){
	var id2 = $("#id2").val();
	$.ajax({
		url:"/Lab4/xml/" +id2,
		method:"GET",
		contentType: "text/plain",
		dataType: "xml",
		data: id2,
		success: function(data,status,xhr){
			$("#helloHeader").html(response);
			},
		error: function(data,status,xhr){
			$("#helloHeader").html("Error:" +status);
		},
	});
});
	
	$("#getAllMessageButton").click(function(){
		$.ajax({
			url:"/Lab4/json",
			method:"GET",
			dataType: "json",
			success: function(data,status,xhr){
				$("#helloHeader").html(data);
				},
			error: function(data,status,xhr){
				$("#helloHeader").html("Error:" +status);
			},
		});
	});
		
		
		
$("#getDeleteButton").click(function(){
			var id3 = $("#id3").val();
			var data2 = {
					id:id3,
					};
			$.ajax({
				url:"/Lab4/delete",
				method:"POST",
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				dataType: "json",
				data: data2,
				success: function(data,status,xhr){
					$("#helloHeader").html("success");
					},
				error: function(data,status,xhr){
					$("#helloHeader").html("Error:" +status);
				},	
			});
			
		});	
});

