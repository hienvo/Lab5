$(document).ready(
				function() {
					$("#submitButton").click(
									function() {
										var id = $("#id").val();
										var message = $("#message").val();

										$.ajax({
													url : "/Lab4/create"															
															+ "?id="
															+ id
															+ "&message="
															+ message,
													method : "POST",
//													dataType : "json",
													contentType : 'application/octet-stream; charset=utf-8',
													success : function(response) {
														$("#helloHeader").html(
																response);
													},
													error : function(response) {
														$("#helloHeader").html(
																response);
													},
												});
									});

				

					$("#getMessageJSON").click(
							function() {
								
								var id2 = $("#id2").val();
								$.ajax({
									type : 'GET',
									url : "/Lab4/idjson"
											+ "?id="
											+ id2,
									success : function(response) {
										$("#helloHeader").html(response);
									},
									error : function(response) {
										$("#helloHeader").html(response);
									}
								});
							});
					
					$("#getMessageXML").click(
							function() {
								
								var id2 = $("#id2").val();
								$.ajax({
									type : 'GET',
									url : "/Lab4/idxml"
											+ "?id="
											+ id2,
									success : function(response) {
										$("#helloHeader").html(response);
									},
									error : function(response) {
										$("#helloHeader").html(response);
									}
								});
							});

					
					$("#getAllMessageButtonJSON").click(
							function() {
								
								$.ajax({
									type : 'GET',
									url : "/Lab4/alljson",
									success : function(response) {
										$("#helloHeader").html(response);
									},
									error : function(response) {
										$("#helloHeader").html(response);
									}
								});
							});
					

					$("#getAllMessageButtonXML").click(
							function() {
								
								$.ajax({
									type : 'GET',
									url : "/Lab4/allxml",
									success : function(response) {
										$("#helloHeader").html(response);
									},
									error : function(response) {
										$("#helloHeader").html(response);
									}
								});
							});
					

		
					$("#getDeleteButton")
							.click(
									function() {
										var id3 = $("#id3").val();
										$.ajax({
													url : "/Lab4/delete"
															+ "?id="
															+ id3,
													method : "POST",
													contentType : 'application/octet-stream; charset=utf-8',
													success : function(response) {
														$("#helloHeader").html(response);
													},
													error : function(response) {
														$("#helloHeader").html(response);
													},
												});
									});
				});