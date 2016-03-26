$(document).ready(
				function() {
					$("#submitButton").click(
									function() {
										var id = $("#id").val();
										var message = $("#message").val();
										var choice = "5";

										$.ajax({
													url : "/Lab3Servlet/TodoServlet"
															+ "?choice="
															+ choice
															+ "&id="
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

				

					$("#getMessage").click(
							function() {
								var choice = "2";
								var id2 = $("#id2").val();
								$.ajax({
									type : 'GET',
									url : "/Lab3Servlet/TodoServlet"
											+ "?choice=" + choice + "&id="
											+ id2,
									success : function(response) {
										$("#helloHeader").html(response);
									},
									error : function(response) {
										$("#helloHeader").html(response);
									}
								});
							});

					
					$("#getAllMessageButton").click(
							function() {
								var choice = "3";
								$.ajax({
									type : 'GET',
									url : "/Lab3Servlet/TodoServlet"
											+ "?choice=" + choice,
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
										var choice = "4";
										$.ajax({
													url : "/Lab3Servlet/TodoServlet"
															+ "?choice="
															+ choice
															+ "&id="
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